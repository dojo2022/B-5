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

import dao.BackgroundItemsDAO;
import dao.CharacterItemsDAO;
import dao.CouponItemsDAO;
import dao.KakugenItemsDAO;
import dao.UsersDAO;
import model.BackgroundItems;
import model.CharacterItems;
import model.CouponItems;
import model.KakugenItems;
import model.Login;
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

		//セッションスコープに格納したidデータを変数idに代入
		HttpSession session = request.getSession();
		Login mail_session = (Login)session.getAttribute("id");
		String mail = mail_session.getId();
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(new Users( "", "", mail, ""));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		BackgroundItemsDAO biDao = new BackgroundItemsDAO();
		List<BackgroundItems> backgroundItemsList = biDao.selectMyItem(new BackgroundItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("backgroundItemsList", backgroundItemsList);

		CharacterItemsDAO ciDao = new CharacterItemsDAO();
		List<CharacterItems> CharacterItemsList = ciDao.selectMyItem(new CharacterItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CharacterItemsList", CharacterItemsList);

		CouponItemsDAO coiDao = new CouponItemsDAO();
		List<CouponItems> CouponItemsList = coiDao.selectMyItem(new CouponItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CouponItemsList", CouponItemsList);

		KakugenItemsDAO kiDao = new KakugenItemsDAO();
		List<KakugenItems> KakugenItemsList = kiDao.selectMyItem(new KakugenItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("KakugenItemsList", KakugenItemsList);

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
		//セッションスコープに格納したidデータを変数idに代入
		HttpSession session = request.getSession();
		Login mail_session = (Login)session.getAttribute("id");

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("new_name");
		String mail = mail_session.getId();
		String new_pw = request.getParameter("new_pw");
		String bg_name = request.getParameter("bg_name");

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

		BackgroundItemsDAO biDao = new BackgroundItemsDAO();
		//if (request.getParameter("SUBMIT").equals("壁紙の変更")) {
			if (biDao.activate(new BackgroundItems(mail, mail, bg_name))) {   // 登録成功
				System.out.println("activate=true");
			}
			else {												// 登録失敗
				System.out.println("activate=false");
			}
		//}
		//else {												// 登録失敗
		//	System.out.println("activate=false");
		//}
		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
		dispatcher.forward(request, response);
	}

}
