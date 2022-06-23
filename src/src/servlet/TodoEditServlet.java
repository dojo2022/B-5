//package servlet;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import dao.TodoListsDAO;
//import dao.UsersDAO;
//import model.Login;
//import model.TodoLists;
//import model.Users;
//
///**
// * Servlet implementation class TodoEditServlet
// */
//@WebServlet("/TodoEditServlet")
//public class TodoEditServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		HttpSession session = request.getSession();
//
//		//更新・削除の成功失敗を判別するための枠
//		session.setAttribute("res", "get");
//
//
//		Login mail_session = (Login)session.getAttribute("id");
//		String mail = mail_session.getId();
//
//		//ユーザーの識別
//		UsersDAO uDao = new UsersDAO();
//		List<Users> cardList = uDao.select(mail);
//
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("cardList",cardList);
//
//		TodoListsDAO tDao = new TodoListsDAO();
//		List<TodoLists> TodolistList = tDao.selectMyItem(mail);
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("TodolistList", TodolistList);
//
//
//
//		// 予定・ToDo編集ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//
//		// リクエストパラメータを取得する（クライアント側のフォームから送られてきたデータ）
//
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String todo_deadline = request.getParameter("todo_deadline");
//		String task = request.getParameter("task");
//		String importance = request.getParameter("importance");
//		String todo_memo = request.getParameter("todo_memo");
//		String user_id = request.getParameter("user_id");
//
//		// 更新または削除を行う
//		//DAOを生成し、予定一覧を取得する
//		List<TodoLists> TodolistList = new ArrayList<TodoLists>();
//		TodoLists param = new TodoLists(todo_deadline,"","","");
//		TodoListsDAO tDao = new TodoListsDAO();
//		TodolistList =tDao.selectMyItem(param);
//		request.setAttribute("TodolistList", TodolistList);
//
//		if (request.getParameter("UPDATE").equals("保存")) {
//
//			if (tDao.update(new TodoLists(todo_deadline,task,importance,todo_memo,user_id))) {	// 更新成功
//				//リクエストスコープに保存
//				request.setAttribute("res","ok");
//			}
//			else {												// 更新失敗
//				request.setAttribute("res", "miss");
//			}
//		}else {
//			if (tDao.delete(id)) {	// 削除成功
//				request.setAttribute("res","ok");
//			}
//			else {						// 削除失敗
//				request.setAttribute("res", "smiss");
//			}
//		}
//		// 結果ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
//		dispatcher.forward(request, response);
//	}
//
//}


