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
import model.Schedules;



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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("USER_ID") == null) {
//			response.sendRedirect("/anikare/LoginServlet");
//			return;
//		}

		HttpSession session = request.getSession();

		//更新・削除の成功失敗を判別するための枠
		session.setAttribute("res", "get");

		// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_add.jsp");
				dispatcher.forward(request, response);
			}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("USER_ID") == null) {
//			response.sendRedirect("/anikare/LoginServlet");
//			return;
//		}

		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String title = request.getParameter("title");
				String schedule_date = request.getParameter("schedule_date");
				String start_time = request.getParameter("start_time");
				String end_time = request.getParameter("end_time");
				String stamp_id = request.getParameter("stamp_id");
				String schedule_memo = request.getParameter("schedule_memo");
				String place = request.getParameter("place");
				
				// 登録処理を行う
				SchedulesDAO sDAO = new SchedulesDAO();
				if (sDAO.insert(new Schedules(title,schedule_date, start_time,end_time,
						stamp_id,schedule_memo,place,user_id))) {	// 登録成功
						//リクエストスコープに保存
						request.setAttribute("res","ok");
					}
					else {			// 更新失敗
						request.setAttribute("res", "miss");
					}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_add.jsp");
				dispatcher.forward(request, response);
			}

}
