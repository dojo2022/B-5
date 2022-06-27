package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchedulesDAO;
import dao.TodoListsDAO;
import dao.UsersDAO;
import model.Login;
import model.Schedules;
import model.TodoLists;
import model.Users;

/**
 * Servlet implementation class ScheduleAddServlet
 */
@WebServlet("/ScheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("USER_ID") == null) {
		//			response.sendRedirect("/anikare/LoginServlet");
		//			return;
		//		}

		HttpSession session = request.getSession();

		//更新・削除の成功失敗を判別するための枠
		session.setAttribute("res", "get");

		Login mail_session = (Login) session.getAttribute("id");
		String mail = mail_session.getMail();

		//ユーザーの識別
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(mail);

		//セッションスコープに格納したidデータを変数idに代入
//				Login mail_session = (Login)session.getAttribute("id");
//				String mail = mail_session.getMail();
//				UsersDAO uDao = new UsersDAO();
//				List<Users> cardList = uDao.select(new Users("", "", mail, "", 0));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_add.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("USER_ID") == null) {
		//			response.sendRedirect("/anikare/LoginServlet");
		//			return;
		//		}
		//予定の追加
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
		//value

		HttpSession session = request.getSession();
		Login user = (Login) session.getAttribute("id");
		String user_id = user.getUser_id();
//		int point = 0;

		// 登録処理を行う(diary)
		SchedulesDAO sDAO = new SchedulesDAO();
		TodoListsDAO tDAO = new TodoListsDAO();
		if (request.getParameter("submit").equals("スケジュール追加")) {
//			point=100;
			String title = request.getParameter("title");
			String schedule_date = request.getParameter("schedule_date");
			String start_time = request.getParameter("start_time");
			String end_time = request.getParameter("end_time");
			String stamp_id = request.getParameter("stamp_id");

			String schedule_memo = request.getParameter("schedule_memo");
			String place = request.getParameter("place");
			if (sDAO.insert(new Schedules(title, schedule_date, start_time, end_time,
					stamp_id, schedule_memo, place, user_id))) { // 登録成功
				//リクエストスコープに保存
				request.setAttribute("res", "ok");
			} else { // 更新失敗
				request.setAttribute("res", "miss");
			}
		} else {	//todoの追加
//			point = 50;
			//value
//			String checkbox = request.getParameter("checkbox");
			String importance = request.getParameter("importance");
			String task = request.getParameter("task");
			String todo_deadline = request.getParameter("todo_deadline");
			String todo_memo = request.getParameter("todo_memo");

			if (tDAO.insert(new TodoLists(todo_deadline, task, importance, todo_memo, user_id))) { // 登録成功

				//リクエストスコープに保存
				request.setAttribute("res", "ok");
			} else { // 更新失敗
				request.setAttribute("res", "miss");
			}
		}
		//point add
				//SELECT point_value  FROM USERS  where user_id='user_id'を実行するdaoを作成する
				//取得した値に付与するポイント(変数pointの値)をプラスする
				//UPDATE users SET point_value= ポイント付与後の値 を実行するdaoを作成する
//		int point_value= 0;
//		point_value = Integer.parseInt(request.getParameter("point_value"));
//		Login mail_session = (Login)session.getAttribute("id");
//
//
//		point_value = point_value;
//
//		Users userdata = new Users(user_id,point_value);
//		UsersDAO uDao=new UsersDAO();
//
//		boolean result = uDao.updatePoint(userdata);
//		if (result) {
//		//今のuser_idのpoint _valueを取得して変数に入れる
//		//セッションスコープのpoint_valueを上書きするsession.setAttribute(,変数)
//			System.out.println("true");
//
//		}else {
//			System.out.println("false");
//
//		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_add.jsp");
		dispatcher.forward(request, response);
	}

}
