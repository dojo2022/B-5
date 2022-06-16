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
import model.Res;
import model.Users;
/**
 * Servlet implementation class PasswordResetServlet
 */
@WebServlet("/PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パスワード再設定用ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/password_reset.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		UsersDAO uDao = new UsersDAO();
		//検索処理を行う
/*		List<Users> cardList = uDao.select(new Users( mail));
*/
		if (uDao.isMailOK(new Users(mail))) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("res", new Res("ok"));

			//フォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/password_reset.jsp");
			dispatcher.forward(request, response);
/*			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/simpleBC/MenuServlet");
*/		}
		else {									// ログイン失敗
			HttpSession session = request.getSession();
			session.setAttribute("res", new Res("miss"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/password_reset.jsp");
			dispatcher.forward(request, response);
		}
	}
//		//リクエストスコープに保存
//		request.setAttribute("cardList", cardList);
//





	}


