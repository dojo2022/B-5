package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BackgroundsDAO;
import dao.SchedulesDAO;
import model.Backgrounds;
import model.Schedules;




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
		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String title = request.getParameter("title");
//		String start_time = request.getParameter("start_time");
//		String end_time = request.getParameter("end_time");
//		String stamp_id = request.getParameter("stamp_id");
//		String schedule_memo = request.getParameter("schedule_memo");
//		String place = request.getParameter("place");

		//検索処理を行う
		SchedulesDAO sDao = new SchedulesDAO();
		List<Schedules> cardList = sDao.select(new Schedules());

		//アイテムの全件表示を行う
		//スタンプはbgListスコープに保存
		BackgroundsDAO bDAO = new BackgroundsDAO();
		List<Backgrounds> bgList = bDAO.select(new Backgrounds(0,"","" ,0 ,""));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("bgList", bgList);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

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


	}

}
