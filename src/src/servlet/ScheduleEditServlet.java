package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SchedulesDAO;
import model.Schedules;

/**
 * Servlet implementation class ScheduleEditServlet
 */
@WebServlet("/ScheduleEditServlet")
public class ScheduleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//				HttpSession session = request.getSession();
//				if (session.getAttribute("id") == null) {
//					response.sendRedirect("/anikare/LoginServlet");
//					return;
//				}

		// 予定・ToDo編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//				HttpSession session = request.getSession();
//				if (session.getAttribute("id") == null) {
//					response.sendRedirect("/anikare/LoginServlet");
//					return;
//				}



	// リクエストパラメータを取得する（クライアント側のフォームから送られてきたデータ）

			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String start_time = request.getParameter("start_time");
			String end_time = request.getParameter("end_time");
			String schedule_memo = request.getParameter("schedule_memo");
			String place = request.getParameter("place");
			String stamp_id = request.getParameter("stamp_id");
//			String stamp_image = request.getParameter("stamp_image");
//			String todo_deadline = request.getParameter("todo_deadline");
//			String task = request.getParameter("task");
//			String importance = request.getParameter("importance");
//			String todo_memo = request.getParameter("todo_memo");

			//☆一体どうすればいいの～～！？！？

			// 更新または削除を行う
			SchedulesDAO sDao = new SchedulesDAO();

			if (request.getParameter("UPDATE").equals("保存")) {
				//下がString型定義されていない理由を解明する6/17橋間
				if (sDao.update(new Schedules(id,title,start_time,end_time,schedule_memo,place,stamp_id))) {	// 更新成功
					//リクエストスコープに保存
					request.setAttribute(); 	//()内、”属性名”とインスタンスを設定する6/17橋間
				}
				else {												// 更新失敗
					request.setAttribute();		//()内、”属性名”とインスタンスを設定する6/17橋間
				}



				//ToDoListのデータを更新した時（モデルが別だからやはり分けるべきだよな…？）（どこに書くのが正解？）6/17


				//日記のページを更新した時6/17




			}else {
				if (sDao.delete(id)) {	// 削除成功
					request.setAttribute();		//()内、”属性名”とインスタンスを設定する6/17橋間
				}
				else {						// 削除失敗
					request.setAttribute();		//()内、”属性名”とインスタンスを設定する6/17橋間
				}
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
			dispatcher.forward(request, response);
		}
}

