package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchedulesDAO;
import dao.UsersDAO;
import model.Login;
import model.Schedules;
import model.Users;

/**
 * Servlet implementation class ScheduleEditServlet
 */
@WebServlet("/ScheduleEditServlet")
public class ScheduleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();

		//更新・削除の成功失敗を判別するための枠
		session.setAttribute("res", "get");


		Login mail_session = (Login)session.getAttribute("id");
		String mail = mail_session.getId();

		//ユーザーの識別
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(mail);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList",cardList);

		SchedulesDAO sDao = new SchedulesDAO();
		List<Schedules> ScheduleList = sDao.selectMyItem(mail);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("ScheduleList", ScheduleList);

		// 予定・ToDo編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	// リクエストパラメータを取得する（クライアント側のフォームから送られてきたデータ）

			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String schedule_date =request.getParameter("schedule_date");
			String start_time = request.getParameter("start_time");
			String end_time = request.getParameter("end_time");
			String stamp_id = request.getParameter("stamp_id");
			String schedule_memo = request.getParameter("schedule_memo");
			String place = request.getParameter("place");
			String user_id = request.getParameter("user_id");


			// 更新または削除を行う
			//DAOを生成し、予定一覧を取得する
			/*SchedulesDAO sDao = new SchedulesDAO();*/
			List<Schedules> ScheduleList = new ArrayList<Schedules>();
			Schedules param = new Schedules("",schedule_date,"","","","","");
			SchedulesDAO sDao = new SchedulesDAO();
			ScheduleList=sDao.selectMyItem(param);
//			HttpSession session = request.getSession();
			request.setAttribute("ScheduleList", ScheduleList);



			if (request.getParameter("UPDATE").equals("保存")) {

				if (sDao.update(new Schedules(title,start_time,end_time,
						stamp_id,schedule_memo,place,user_id))) {	// 更新成功
					//リクエストスコープに保存
					request.setAttribute("res","ok");
				}
				else {			// 更新失敗
					request.setAttribute("res", "miss");
				}
			}else {
				if (sDao.delete(id)) {	// 削除成功
					request.setAttribute("res","sok");
				}
				else {						// 削除失敗
					request.setAttribute("res", "smiss");
				}
			}
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
			dispatcher.forward(request, response);
		}
}

