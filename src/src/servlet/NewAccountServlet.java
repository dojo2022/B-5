package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/NewAccountServlet")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 会員登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/new_account.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String mail = request.getParameter("mail");
		String login_pw = request.getParameter("login_pw");

		// 登録処理を行う
		UsersDAO uDao = new UsersDAO();
		if (uDao.insert(new Users(id,user_id, user_name, mail, login_pw))) {	// 登録成功
			request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/anikare/ToppageServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/anikare/ToppageServlet"));
		}
	}

}
