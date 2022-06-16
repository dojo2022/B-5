package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.Users;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String mail= request.getParameter("mail");
		String login_pw = request.getParameter("login_pw");

		// ログイン処理を行う
		UsersDAO uDao = new UsersDAO();
		if (uDao.isLoginOK(new Users(mail, login_pw ))) {	// ログイン成功 これ以降がいまいちわかっていない
//			// セッションスコープにIDを格納する
//		    HttpSession session = request.getSession();
//			session.setAttribute("id", new LoginUser(mail));
////			 メニューサーブレットにリダイレクトする
			response.sendRedirect("/anikare/ToppageServlet");
			System.out.println("true");
		}
//		else {									// ログイン失敗
//			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
//			request.setAttribute("result",
//			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/simpleBC/LoginServlet"));
//
//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//		dispatcher.forward(request, response);

//		}
	}

}

