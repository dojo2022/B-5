package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import dao.VisitsDAO;
import model.Login;
import model.Schedules;
import model.TodoLists;
import model.Users;
import model.Visits;




/**
 * Servlet implementation class ToppageServlet
 */
@WebServlet("/ToppageServlet")
public class ToppageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//				HttpSession session = request.getSession();
//				if (session.getAttribute("id") == null) {
//					response.sendRedirect("/anikare/LoginServlet");
//					return;
//				}

		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String title = request.getParameter("title");
//		String start_time = request.getParameter("start_time");
//		String end_time = request.getParameter("end_time");
//		String stamp_id = request.getParameter("stamp_id");
//		String schedule_memo = request.getParameter("schedule_memo");
//		String place = request.getParameter("place");

		//検索処理を行う
//		SchedulesDAO sDao = new SchedulesDAO();
//		List<Schedules> ScheduleList = sDao.selectMyItem(mail);
//
//		//アイテムの全件表示を行う
//		//スタンプはbgListスコープに保存
//		BackgroundsDAO bDAO = new BackgroundsDAO();
//		List<Backgrounds> bgList = bDAO.select(new Backgrounds(0,"","" ,0 ,""));
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("bgList", bgList);
//
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("cardList", cardList);
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		Login mail_session = (Login)session.getAttribute("id");
		String mail = mail_session.getMail();
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(new Users("", "", mail, "", 0));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		String user_id=mail_session.getUser_id();
		VisitsDAO vDao = new VisitsDAO();
		vDao.insert(new Visits(user_id));
		//visits tableに追加user_id,timestamp
		//String user_id=mail_session.getUser_id()
		//--insert into visits (user_id) values (String user_id);
		//を実行するdaoを作成


		//予定
		SchedulesDAO sDao = new SchedulesDAO();
		List<Schedules> ScheduleList = sDao.selectMyItem(mail);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("ScheduleList", ScheduleList);

		//Todo
		TodoListsDAO tDao = new TodoListsDAO();
		List<TodoLists> TodolistList = tDao.selectMyItem(mail);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("TodolistList", TodolistList);

		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//				HttpSession session = request.getSession();
//				if (session.getAttribute("id") == null) {
//					response.sendRedirect("/anikare/LoginServlet");
//					return;
//				}

			//現在の日付を取得

			LocalDate todaysDate = LocalDate.now();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String todaysDateString = todaysDate.format(dateTimeFormatter);
//			session.setAttribute("Date", todaysDate);
			//visitsテーブルのvisit_dataに今日と同じ日付があるかどうか検索

			//visit_dataに今日の日付が無かったらログインボーナスを与える
			//今日はじめての訪問化確認する
			//select count(*) from visits where visit_date like 'todaysDate'+'%'
			//上の結果が1ならばログインボーナス処理
			//2以上ならばページ遷移
			/*Login mail_session = (Login)session.getAttribute("id");*/
			/*String mail = mail_session.getMail();*/
			/*UsersDAO uDao = new UsersDAO();
			List<Users> cardList = uDao.select(new Users("", "", mail, "", 0));
			request.setAttribute("cardList", cardList);*/
			/*String user_id=mail_session.getUser_id();*/
			VisitsDAO vDao = new VisitsDAO();

			//セッションスコープに格納したidデータを変数idに代入
			/*Login mail_session = (Login)session.getAttribute("id");
			String mail = mail_session.getMail();
			UsersDAO uDao = new UsersDAO();
			List<Users> cardList = uDao.select(new Users("", "", mail, "", 0));
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);
			*/
		boolean re=	vDao.isVisitsOK(todaysDateString);
			if(re){

				int point_value= 0;
				point_value = Integer.parseInt(request.getParameter("point_value"));
				HttpSession session = request.getSession();
				Login mail_session = (Login)session.getAttribute("id");
				String user_id = mail_session.getUser_id();
				/*UsersDAO uDao = new UsersDAO();*/
				point_value = point_value+1;

				Users userdata = new Users(user_id,point_value);
				UsersDAO uDao=new UsersDAO();

				boolean result = uDao.updatePoint(userdata);
				if (result) {
				//今のuser_idのpoint _valueを取得して変数に入れる
				//セッションスコープのpoint_valueを上書きするsession.setAttribute(,変数)
					System.out.println("true");

				}else {
					System.out.println("false");

				}
			}
			else {
				System.out.println("1>");
			}
			// トップページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
			dispatcher.forward(request, response);
	}

}




