package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.SchedulesDAO;
import dao.TodoListsDAO;
import dao.StampsDAO;

import model.Schedules;
import model.TodoLists;
import model.Stamps;

/**
 * Servlet implementation class ScheduleEditServlet
 */
@WebServlet("/ScheduleEditServlet")
public class ScheduleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/simpleBC/LoginServlet");
					return;
				}
		// 予定・ToDo編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WebContent/WEB-INF/jsp/schedule_edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/anikare/LoginServlet");
					return;
				}



	// リクエストパラメータを取得する（クライアント側のフォームから送られてきたデータ）

			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String start_time = request.getParameter("start_time");
			String end_time = request.getParameter("end_time");
			String schedule_memo = request.getParameter("schedule_memo");
			String place = request.getParameter("place");
			String stamp_id = request.getParameter("stamp_id");
			String stamp_image = request.getParameter("stamp_image");
			String todo_deadline = request.getParameter("todo_deadline");
			String task = request.getParameter("task");
			String importance = request.getParameter("importance");
			String todo_memo = request.getParameter("todo_memo");


			//☆一体どうすればいいの～～～！？！？

			// 更新または削除を行う★項目増やす
			SchedulesDAO bDao = new SchedulesDAO();
			if (request.getParameter("SUBMIT").equals("更新")) {
				if (bDao.update(new Schedules(title,start_time, end_time,
						stamp_id,schedule_memo,place) {	// 更新成功
					request.setAttribute("result",
					new Result("更新成功！", "レコードを更新しました。", "/simpleBC/MenuServlet");
				}
				else {												// 更新失敗
					request.setAttribute("result",
					new Result("更新失敗！", "レコードを更新できませんでした。", "/simpleBC/MenuServlet"));
				}
			}else {
				if (bDao.delete(id)) {	// 削除成功
					request.setAttribute("result",
					new Result("削除成功！", "レコードを削除しました。", "/simpleBC/MenuServlet"));
				}
				else {						// 削除失敗
					request.setAttribute("result",
					new Result("削除失敗！", "レコードを削除できませんでした。", "/simpleBC/MenuServlet"));
				}
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
}
	//背景のデータをBackgroundsDAOからとってきて表示
	//ポイントのデータをPointsDAOからとってきて表示
	//キャラクターのデータをCharactersDAOからとってきて表示
	//予定のデータをSchedulesDAOからとってきて表示・変更
	//予定のスタンプをStampsDAOからとってきて表示・変更
	//ToDoのデータをTodoListsDAOからとってきて表示・変更
	//日記のデータをDiariesDAOに登録・変更・削除
	//
