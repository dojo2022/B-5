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
import model.Users;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/simpleBC/LoginServlet");
		//			return;
		//		}
		HttpSession session = request.getSession();
		//セッションスコープに格納したidデータを変数idに代入
		session.getAttribute("mail");
		String mail = "${mail}";
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(new Users(1, "", "", "", ""));
		/*//		List<Users> cardList = uDao.select(new Users(, "", "", "mail", ""));
		 */
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		// 個人ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/simpleBC/LoginServlet");
		//			return;
		//		}
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("new_name");
		String mail = "c";
		String now_pw = request.getParameter("now_pw");
		String new_pw = request.getParameter("new_pw");

		// 更新処理を行う
		UsersDAO uDao = new UsersDAO();
		if (uDao.updateName(new Users( user_name, mail))) {	// 登録成功
			System.out.println("true");
		}
		else {												// 登録失敗
			System.out.println("false");
		}
		//PWの更新
		if (uDao.updatePassword(new Users(mail, new_pw))) {	// 登録成功
			System.out.println("true");
		}
		else {												// 登録失敗
			System.out.println("false");
		}
		// 個人ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}

}
