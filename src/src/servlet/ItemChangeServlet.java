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
import dao.BackgroundsDAO;
import dao.CharacterItemsDAO;
import dao.CharactersDAO;
import dao.CouponItemsDAO;
import dao.CouponsDAO;
import dao.KakugenItemsDAO;
import dao.KakugensDAO;
import dao.UsersDAO;
import model.BackgroundItems;
import model.Backgrounds;
import model.CharacterItems;
import model.Characters;
import model.CouponItems;
import model.Coupons;
import model.KakugenItems;
import model.Kakugens;
import model.Login;
import model.Users;

/**
 * Servlet implementation class ItemChangeServelet
 */
@WebServlet("/ItemChangeServlet")
public class ItemChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/anikare/LoginServlet");
			return;
		}

		//セッションスコープに格納したidデータを変数idに代入
		Login mail_session = (Login)session.getAttribute("id");
		String mail = mail_session.getMail();
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(new Users("", "", mail, "", 0));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

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

		//アイテムの全件表示を行う
		//全部セッションスコープに書き換える
		//背景はbgListスコープに保存,
		BackgroundsDAO bDAO = new BackgroundsDAO();
		List<Backgrounds> bgList = bDAO.select(new Backgrounds(0,"","" ,0 ,""));
		// 検索結果をリクエストスコープに格納する
		//		request.setAttribute("bgList", bgList);
		// 検索結果をセッションスコープに格納する
		session.setAttribute("bgList", bgList);

		//格言はwordsListスコープに保存
		KakugensDAO kDAO = new KakugensDAO();
		List<Kakugens> wordsList = kDAO.select(new Kakugens(0,"","",0,""));
		// 検索結果をセッションスコープに格納する
		session.setAttribute("wordsList", wordsList);
		//キャラクターはcharactersスコープに保存
		CharactersDAO cDAO = new CharactersDAO();
		List<Characters> charactersList = cDAO.select(new Characters(0,"","" ,"","",0 ,""));
		// 検索結果をセッションスコープに格納する
		session.setAttribute("charactersList", charactersList);
		//クーポンはcouponsスコープに保存
		CouponsDAO coDAO = new CouponsDAO();
		List<Coupons> couponsList = coDAO.select(new Coupons(0,"","" ,0 ,""));
		// 検索結果をセッションスコープに格納する
		session.setAttribute("couponsList", couponsList);
		//ログインデータがある場合、アイテム交換ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
		dispatcher.forward(request, response);
		session.setAttribute("res", "get");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//ポイントチェック
		//リクエストパラメ―タを取得する
		//交換に必要なポイント数
		int background = 0;
		if (request.getParameter("background") != null) {
			background =Integer.parseInt(request.getParameter("background"));
		}
		int kakugen = 0;
		if (request.getParameter("kakugen") != null) {
			kakugen =Integer.parseInt(request.getParameter("kakugen"));
		}
		int character = 0;
		if (request.getParameter("character") != null) {
			character =Integer.parseInt(request.getParameter("character"));
		}
		int coupon = 0;
		if (request.getParameter("coupon") != null) {
			coupon =Integer.parseInt(request.getParameter("coupon"));
		}
		//それぞれアイテムに追加するデータ
		String background_id ="";
		if (request.getParameter("background_id") != null) {
			background_id = request.getParameter("background_id");
		}
		String genre_name ="";
		if (request.getParameter("genre_name") != null) {
			genre_name = request.getParameter("genre_name");
		}
		String character_id = "";
		if (request.getParameter("character_id") != null) {
			character_id = request.getParameter("character_id");
		}
		String coupon_id = "";
		if (request.getParameter("coupon_id") != null) {
			coupon_id = request.getParameter("coupon_id");
		}
		//ユーザとそのユーザが持っているポイントデータ
		int point_value= 0;
		point_value = Integer.parseInt(request.getParameter("point_value"));
		HttpSession session = request.getSession();
		Login mail_session = (Login)session.getAttribute("id");
		String user_id = mail_session.getUser_id();
		//		//ポイントチェックをする


		//壁紙
		if(background != 0 ) {
			//backgroundのポイント照合
			//自分の現在のポイント合計と交換しようとするポイント
			if(background <= point_value) {
				//ポイントが足りたとき
				point_value = point_value-background;

				Users userdata = new Users(user_id,point_value);
				UsersDAO uDao=new UsersDAO();

				boolean result = uDao.updatePoint(userdata);
				if (result) {
					//今のuser_idのpoint _valueを取得して変数に入れる
					//セッションスコープのpoint_valueを上書きするsession.setAttribute(,変数)
					System.out.println("true");

				}else {
					System.out.println("false");

				}
				//登録処理を行う
				//壁紙
				BackgroundItemsDAO bDAO = new BackgroundItemsDAO();
				if (bDAO.insert(new BackgroundItems(user_id, background_id))) {	// 登録成功
					System.out.println("true");
				}
				else {												// 登録失敗
					System.out.println("false");
				}
				//背景はbgListスコープに保存,
				BackgroundsDAO b2DAO = new BackgroundsDAO();
				List<Backgrounds> bgList = b2DAO.select(new Backgrounds(0,"","" ,0 ,""));
				// 検索結果をリクエストスコープに格納する
				//				request.setAttribute("bgList", bgList);
				// 検索結果をセッションスコープに格納する
				session.setAttribute("bgList", bgList);
				session.setAttribute("res", "ok");
			}else {
				//ポイントが不足のとき

				session.setAttribute("res", "fail");
			}
		}
		//		//ポイントチェックをする
		//格言
		if(kakugen != 0 ) {
			//backgroundのポイント照合
			//自分の現在のポイント合計と交換しようとするポイント
			if(kakugen <= point_value) {
				//ポイントが足りたとき
				point_value = point_value-kakugen;

				Users userdata = new Users(user_id,point_value);
				UsersDAO uDao=new UsersDAO();

				boolean result = uDao.updatePoint(userdata);
				if (result) {
					//今のuser_idのpoint _valueを取得して変数に入れる
					//セッションスコープのpoint_valueを上書きするsession.setAttribute(,変数)
					System.out.println("true");

				}else {
					System.out.println("false");

				}
				//格言
				KakugenItemsDAO kDAO = new KakugenItemsDAO();
				if (kDAO.insert(new KakugenItems(user_id, genre_name))) {	// 登録成功
					System.out.println("true");
				} else {												// 登録失敗
					System.out.println("false");
				}
				//格言はwordsListスコープに保存
				KakugensDAO k2DAO = new KakugensDAO();
				List<Kakugens> wordsList = k2DAO.select(new Kakugens(0,"","",0,""));
				// 検索結果をセッションスコープに格納する
				session.setAttribute("wordsList", wordsList);

				session.setAttribute("res", "ok");
			}else {
				//ポイントが不足のとき
				session.setAttribute("res", "fail");
			}
		}
		//		//ポイントチェックをする
		//キャラクター
		if(character != 0 ) {
			//backgroundのポイント照合
			//自分の現在のポイント合計と交換しようとするポイント
			if(character <= point_value) {
				//ポイントが足りたとき
				point_value = point_value-character;

				Users userdata = new Users(user_id,point_value);
				UsersDAO uDao=new UsersDAO();

				boolean result = uDao.updatePoint(userdata);
				if (result) {
					//今のuser_idのpoint _valueを取得して変数に入れる
					//セッションスコープのpoint_valueを上書きするsession.setAttribute(,変数)
					System.out.println("true");

				}else {
					System.out.println("false");

				}
				//キャラ
				CharacterItemsDAO cDAO = new CharacterItemsDAO();
				if (cDAO.insert(new CharacterItems(user_id, character_id))) {	// 登録成功
					System.out.println("true");
				}
				else {												// 登録失敗
					System.out.println("false");
				}
				//キャラクターはcharactersスコープに保存
				CharactersDAO c2DAO = new CharactersDAO();
				List<Characters> charactersList = c2DAO.select(new Characters(0,"","" ,"","",0 ,""));
				// 検索結果をセッションスコープに格納する
				session.setAttribute("charactersList", charactersList);

				session.setAttribute("res", "ok");
			}else {
				//ポイントが不足のとき
				session.setAttribute("res", "fail");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
				dispatcher.forward(request, response);
			}
		}
		//		//ポイントチェックをする
		//クーポン
		if(coupon != 0 ) {
			//backgroundのポイント照合
			//自分の現在のポイント合計と交換しようとするポイント
			if(coupon <= point_value) {
				//ポイントが足りたとき
				point_value = point_value-coupon;
				Users userdata = new Users(user_id,point_value);
				UsersDAO uDao=new UsersDAO();
				boolean result = uDao.updatePoint(userdata);
				if (result) {
					//今のuser_idのpoint _valueを取得して変数に入れる
					//セッションスコープのpoint_valueを上書きするsession.setAttribute(,変数)
					System.out.println("true");
				}else {
					System.out.println("false");
				}
				//クーポン
				CouponItemsDAO ciDAO = new CouponItemsDAO();
				if (ciDAO.insert(new CouponItems(user_id, coupon_id))) {	// 登録成功
					System.out.println("true");
				}
				else {												// 登録失敗
					System.out.println("false");
				}
				//クーポンはcouponsスコープに保存
				CouponsDAO ci2DAO = new CouponsDAO();
				List<Coupons> couponsList = ci2DAO.select(new Coupons(0,"","" ,0 ,""));
				// 検索結果をセッションスコープに格納する
				session.setAttribute("couponsList", couponsList);

				session.setAttribute("res", "ok");
			}else {
				//ポイントが不足のとき
				session.setAttribute("res", "fail");
			}
		}
		//sessionスコープ再取得
		//セッションスコープに格納したidデータを変数idに代入
		mail_session = (Login)session.getAttribute("id");
		String mail = mail_session.getMail();
		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(new Users("", "", mail, "", 0));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

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


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
		dispatcher.forward(request, response);
	}
}

