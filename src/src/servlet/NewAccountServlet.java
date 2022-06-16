package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Users;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/NewAccountServlet")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 会員登録ページにフォワードする
		HttpSession session = request.getSession();
		session.setAttribute("res", "get");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/new_account.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String mail = request.getParameter("mail");
		String login_pw = request.getParameter("login_pw");

		// 登録処理を行う
		UsersDAO uDao = new UsersDAO();
		if (uDao.insert(new Users( user_name, mail, login_pw))) {	// 登録成功
			System.out.println("true");
			HttpSession session = request.getSession();
			session.setAttribute("res", "ok");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		else {												// 登録失敗
			System.out.println("false");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/js/new_account.js");
//			dispatcher.forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("res", "miss");

		}
		// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/new_account.jsp");
				dispatcher.forward(request, response);

	}

}
