package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
	}


	// リクエストパラメータを取得する（クライアント側のフォームから送られてきたデータ）

//			request.setCharacterEncoding("UTF-8");
//			String bg_image = request.getParameter("bg_image");
//			String id = request.getParameter("id");
//			String user_id = request.getParameter("user_id");
//			String point_value = request.getParameter("point_value");
//			String character_image = request.getParameter("character_image");
//			String title = request.getParameter("title");
//			String start_time = request.getParameter("start_time");
//			String end_time = request.getParameter("end_time");
//			String schedule_memo = request.getParameter("schedule_memo");
//			String place = request.getParameter("place");
//			String stamp_id = request.getParameter("stamp_id");
//			String stamp_image = request.getParameter("stamp_image");
//			☆一体どうすればいいの～～～！？！？

}
	//背景のデータをBackgroundsDAOからとってきて表示
	//ポイントのデータをPointsDAOからとってきて表示
	//キャラクターのデータをCharactersDAOからとってきて表示
	//予定のデータをSchedulesDAOからとってきて表示・変更
	//予定のスタンプをStampsDAOからとってきて表示・変更
	//ToDoのデータをTodoListsDAOからとってきて表示・変更
	//日記のデータをDiariesDAOに登録・変更・削除
	//
