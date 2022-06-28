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

import dao.BackgroundItemsDAO;
import dao.CharacterItemsDAO;
import dao.DiariesDAO;
import dao.SchedulesDAO;
import dao.TodoListsDAO;
import dao.UsersDAO;
import model.BackgroundItems;
import model.CharacterItems;
import model.Diaries;
import model.Login;
import model.Schedules;
import model.TodoLists;
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
		String mail = mail_session.getMail();

		//ユーザーの識別
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(mail);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList",cardList);

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

		//日記
		DiariesDAO dDao = new DiariesDAO();
		List<Diaries> diaryList = dDao.selectMyItem(mail);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("diaryList", diaryList);


		//背景アクティブを表示
		BackgroundItemsDAO biDao = new BackgroundItemsDAO();
		List<BackgroundItems> BackgroundActiveList = biDao.selectActive(new BackgroundItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("BackgroundActiveList", BackgroundActiveList);
		//キャラクターアクティブを表示
		CharacterItemsDAO ciDao = new CharacterItemsDAO();
		List<CharacterItems> CharacterActiveList = ciDao.selectActive(new CharacterItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CharacterActiveList", CharacterActiveList);

		// 予定・ToDo編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


// 予定のリクエストパラメータを取得する（クライアント側のフォームから送られてきたデータ）

			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			Login mail_session = (Login)session.getAttribute("id");
			String user_id = mail_session.getUser_id();;


//			HttpSession session = request.getSession();
//			Login user = (Login)session.getAttribute("id");
//			String user_id=user.getUser_id();


			// 更新または削除を行う


			SchedulesDAO sDao = new SchedulesDAO();
			if (request.getParameter("SUBMIT").equals("予定更新")) {
				String title = request.getParameter("title");
				String schedule_date =request.getParameter("schedule_date");
				String start_time = request.getParameter("start_time");
				String end_time = request.getParameter("end_time");
				//int stamp_id = Integer.parseInt(request.getParameter("stamp_id"));
				//intにする。int stamp_id = 0;
				String stamp_id = request.getParameter("stamp_id");
				String schedule_memo = request.getParameter("schedule_memo");
				String place = request.getParameter("place");

				//DAOを生成し、予定一覧を取得する
				/*SchedulesDAO sDao = new SchedulesDAO();*/
				List<Schedules> ScheduleList = new ArrayList<Schedules>();
				Schedules param = new Schedules("",schedule_date,"","","","","");

				ScheduleList=sDao.selectMyItem(param);
//				HttpSession session = request.getSession();
				request.setAttribute("ScheduleList", ScheduleList);


				if (sDao.update(new Schedules(title,schedule_date,start_time,end_time,
						stamp_id,schedule_memo,place, user_id))) {	// 更新成功
					//リクエストスコープに保存
					request.setAttribute("res","ok");
				}
				else {			// 更新失敗
					request.setAttribute("res", "miss");
				}
			}else if (request.getParameter("SUBMIT").equals("予定削除")) {

				if (sDao.delete(user_id)) {		// 削除成功
					request.setAttribute("res","sok");
				}
				else {						// 削除失敗
					request.setAttribute("res", "smiss");
				}
			}

// TODOのリクエストパラメータを取得する（クライアント側のフォームから送られてきたデータ）





			// 更新または削除を行う
TodoListsDAO tDao = new TodoListsDAO();
			if (request.getParameter("SUBMIT").equals("タスク更新")) {
				/*String id = request.getParameter("id");*/
				String todo_deadline = request.getParameter("todo_deadline");
				String task = request.getParameter("task");
				String importance = request.getParameter("importance");
				String todo_memo = request.getParameter("todo_memo");

				//DAOを生成し、予定一覧を取得する
				List<TodoLists> TodolistList = new ArrayList<TodoLists>();
				TodoLists parameter = new TodoLists(todo_deadline,"","","");

				TodolistList =tDao.selectMyItem(parameter);
				request.setAttribute("TodolistList", TodolistList);

				if (tDao.update(new TodoLists(todo_deadline,task,importance,todo_memo,user_id))) {	// 更新成功
					//リクエストスコープに保存
					request.setAttribute("res","ok");
				}
				else {												// 更新失敗
					request.setAttribute("res", "miss");
				}
			}else if (request.getParameter("SUBMIT").equals("タスク削除"))  {
				if (tDao.delete(user_id)) {	// 削除成功
					request.setAttribute("res","sok");
				}
				else {						// 削除失敗
					request.setAttribute("res", "smiss");
				}
			}


// 記録のリクエストパラメータを取得する（クライアント側のフォームから送られてきたデータ）






			DiariesDAO dDao = new DiariesDAO();


				// 登録または更新または削除を行う
			if(request.getParameter("SUBMIT").equals("記録登録")){
				String diary_date = request.getParameter("diary_date");
				String diary_title = request.getParameter("diary_title");
				String diary_content = request.getParameter("diary_content");

				if (dDao.insert(new Diaries(diary_date,diary_title,diary_content, user_id))) { // 登録成功
					//リクエストスコープに保存
					int point_value= 0;
					point_value = Integer.parseInt(request.getParameter("point_value"));

					/*UsersDAO uDao = new UsersDAO();*/
					point_value = point_value+2;

					Users userdata = new Users(user_id,point_value);
					UsersDAO uDao=new UsersDAO();

					boolean result = uDao.updatePoint(userdata);
					if (result) {
						//今のuser_idのpoint _valueを取得して変数に入れる
						//セッションスコープのpoint_valueを上書きするsession.setAttribute(,変数)
						System.out.println("true");
						request.setAttribute("res", "tok");

					}else {
						System.out.println("false");

					}


				} else { // 更新失敗
					request.setAttribute("res", "tmiss");
				}
			}else if (request.getParameter("SUBMIT").equals("記録更新")) {
				String diary_date = request.getParameter("diary_date");
				String diary_title = request.getParameter("diary_title");
				String diary_content = request.getParameter("diary_content");
				//DAOを生成し、予定一覧を取得する
				List<Diaries> DiaryList = new ArrayList<Diaries>();
				Diaries para = new Diaries(diary_date,"","");

				DiaryList =dDao.selectMyItem(para);
				request.setAttribute("DiaryList", DiaryList);

				if (dDao.update(new Diaries(diary_date,diary_title,diary_content,user_id))) {	// 更新成功
					//リクエストスコープに保存


					request.setAttribute("res","ok");
				}
				else {												// 更新失敗
					request.setAttribute("res", "miss");
				}
			}else if (request.getParameter("SUBMIT").equals("記録削除")) {
				if (dDao.delete(user_id)) {	// 削除成功
					request.setAttribute("res","sok");
				}
				else {						// 削除失敗
					request.setAttribute("res", "smiss");
				}
			}


			String mail = mail_session.getMail();

			//背景アクティブを表示
			BackgroundItemsDAO biDao = new BackgroundItemsDAO();
			List<BackgroundItems> BackgroundActiveList = biDao.selectActive(new BackgroundItems(mail));
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("BackgroundActiveList", BackgroundActiveList);

			//キャラクターアクティブを表示
			CharacterItemsDAO ciDao = new CharacterItemsDAO();
			List<CharacterItems> CharacterActiveList = ciDao.selectActive(new CharacterItems(mail));
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("CharacterActiveList", CharacterActiveList);

			//sessionスコープ再取得
			//セッションスコープに格納したidデータを変数idに代入

			UsersDAO uDao = new UsersDAO();
			List<Users> cardList = uDao.select(new Users("", "", mail, "", 0));
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
			dispatcher.forward(request, response);
		}
	}


