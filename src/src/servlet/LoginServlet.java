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

import dao.UsersDAO;
import model.Login;
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

		HttpSession session = request.getSession();
		session.setAttribute("res", "get");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String mail= request.getParameter("mail");
		String pw = request.getParameter("login_pw");
		int point_value =  0;

		// ログイン処理を行う
		UsersDAO uDao = new UsersDAO();
		if (uDao.isLoginOK(new Users(mail, pw ))) {	// ログイン成功
			// セッションスコープにアドレスを格納する
			HttpSession session = request.getSession();
			//userテーブルから今回のmailと一致するuser_id,mail,passwordを抽出する
			 List<Users> idList =uDao.select(mail);
			//抽出結果をセッションスコープに格納
			session.setAttribute("id", new Login(mail,pw,idList.get(0).getUser_id(),point_value));
			//トップページのサーブレットにリダイレクトする
			response.sendRedirect("/anikare/ToppageServlet");

		}
		else {									// ログイン失敗
			// セッションスコープに値を格納
			HttpSession session = request.getSession();
			session.setAttribute("res", "fail");

			// 	ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);

		}
	}

}

