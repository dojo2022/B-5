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
		String mail = mail_session.getMail();
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(new Users( "", "", mail, "", 0));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		//背景アクティブを表示
		BackgroundItemsDAO biDao = new BackgroundItemsDAO();
		List<BackgroundItems> BackgroundActiveList = biDao.selectActive(new BackgroundItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("BackgroundActiveList", BackgroundActiveList);

		//格言アクティブを表示
		KakugenItemsDAO kiDao = new KakugenItemsDAO();
		List<KakugenItems> KakugenActiveList = kiDao.selectActive(new KakugenItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("KakugenActiveList", KakugenActiveList);


		//キャラクターアクティブを表示
		CharacterItemsDAO ciDao = new CharacterItemsDAO();
		List<CharacterItems> CharacterActiveList = ciDao.selectActive(new CharacterItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CharacterActiveList", CharacterActiveList);



		//背景所持一覧
		List<BackgroundItems> backgroundItemsList = biDao.selectMyItem(new BackgroundItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("backgroundItemsList", backgroundItemsList);

		//格言所持一覧

		List<KakugenItems> KakugenItemsList = kiDao.selectMyItem(new KakugenItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("KakugenItemsList", KakugenItemsList);

		//キャラクター所持一覧
		List<CharacterItems> CharacterItemsList = ciDao.selectMyItem(new CharacterItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CharacterItemsList", CharacterItemsList);

		//クーポン所持一覧
		CouponItemsDAO coiDao = new CouponItemsDAO();
		List<CouponItems> CouponItemsList = coiDao.selectMyItem(new CouponItems(mail));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CouponItemsList", CouponItemsList);



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
		String namechange = "";
		namechange =request.getParameter("namechange");
		String passchange = "";
		passchange = request.getParameter("passchange");
		String bgchange = "";
		bgchange = request.getParameter("bgchange");
		String kakugenchange = "";
		kakugenchange = request.getParameter("kakugenchange");
		String characterchange = "";
		characterchange = request.getParameter("characterchange");
		String user_name = request.getParameter("new_name");
		String mail = mail_session.getMail();
		String new_pw = request.getParameter("new_pw");
		String bg_name = request.getParameter("bg_name");
		String kakugen_name = request.getParameter("kakugen_name");
		String character_name = request.getParameter("character_name");


		//名前の変更処理
		if(namechange != null) {
			//名前の変更のdaoの処理
			UsersDAO uDao = new UsersDAO();
			if (uDao.updateName(new Users( user_name, mail))) {	// 登録成功
				System.out.println("true");
			}
			else {												// 登録失敗
				System.out.println("false");
			}
		}

		//パスワードの変更処理
		if(passchange != null) {
			//パスワードの変更のdaoの処理
			UsersDAO uDao = new UsersDAO();
			if (uDao.updatePassword(new Users(mail, new_pw))) {	// 登録成功
				System.out.println("true");
			}
			else {												// 登録失敗
				System.out.println("false");
			}
		}

		//壁紙の変更処理
		if(bgchange != null) {
			BackgroundItemsDAO biDao = new BackgroundItemsDAO();

			if (biDao.activate(new BackgroundItems(mail, mail, bg_name))) {   // 登録成功
				System.out.println("activate=true");
			}
			else {												// 登録失敗
				System.out.println("activate=false");
			}
		}

		//格言の変更処理
		if(kakugenchange != null) {
			KakugenItemsDAO kiDao = new KakugenItemsDAO();

			if (kiDao.activate(new KakugenItems(mail, mail, kakugen_name))) {   // 登録成功
				System.out.println("activate=true");
			}
			else {												// 登録失敗
				System.out.println("activate=false");
			}
		}

		//キャラクターの変更
		if(characterchange != null) {
			CharacterItemsDAO ciDao = new CharacterItemsDAO();

			if (ciDao.activate(new CharacterItems(mail, mail, character_name))) {   // 登録成功
				System.out.println("activate=true");
			}
			else {												// 登録失敗
				System.out.println("activate=false");
			}
		}



		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
		dispatcher.forward(request, response);
	}

}
