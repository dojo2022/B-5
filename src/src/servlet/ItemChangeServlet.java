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
		List<Kakugens> wordsList = kDAO.select(new Kakugens(0,"","",0 ,""));
		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("wordsList", wordsList);
		// 検索結果をセッションスコープに格納する
		session.setAttribute("wordsList", wordsList);

		//キャラクターはcharactersスコープに保存
		CharactersDAO cDAO = new CharactersDAO();
		List<Characters> charactersList = cDAO.select(new Characters(0,"","" ,"","",0 ,""));
		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("charactersList", charactersList);
		// 検索結果をセッションスコープに格納する
		session.setAttribute("charactersList", charactersList);

		//クーポンはcouponsスコープに保存
		CouponsDAO coDAO = new CouponsDAO();
		List<Coupons> couponsList = coDAO.select(new Coupons(0,"","" ,0 ,""));
		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("couponsList", couponsList);
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

	//交換したいアイテムを押下時、jsで確認ポップを表示
	//アイテムを押下した後どのように動作？
	//pointsからkakugensDBのkakugen_pointを引く
	//交換したいアイテム押下→jsで交換の確認を表示→はいを押下→持っているポイントで交換できるかを条件分岐（足りない場合は処理を中止）
	//→足りた場合はpointsのテーブルからkakugensデータ内の消費ポイント分を引く
	//→引いた値をユーザに対応する部分に戻す→kakugensテーブルをgenre検索→ヒットしたデータのkakugen_idをスコープに保存
	//→スコープに保存したkakugen_idをkakugen_itemsテーブルに追加→jsで交換しましたのウィンドウを表示
	//→修了（処理の途中でエラーが出た場合はロールバック）
	//別データテーブル間の計算
	//kakugensDBのgenreでDB内を検索
	//見つけたデータをスコープに保存する
	//ヒットしたデータのkakugen_idをkakugen_itemsDB内に追加
	//スコープに格納した値を
	//交換が成功した際成功の旨をjsで表示

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
				//insert文を使って自分のポイントを
				//1.今交換しようとしたアイテムのポイントを抽出（select）
				//2.自分のポイントに1の値のマイナスをinsert
				//登録処理を行う
				//壁紙
				BackgroundItemsDAO bDAO = new BackgroundItemsDAO();
				if (bDAO.insert(new BackgroundItems(user_id, background_id))) {	// 登録成功
					System.out.println("true");
				}
				else {												// 登録失敗
					System.out.println("false");
				}
				point_value = point_value - background;
				UsersDAO uDAO = new UsersDAO();
				if (uDAO.updatePoint(new Users(point_value, user_id))) {
					System.out.println("true");
				} else {
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
				//insert文を使って自分のポイントを
				//1.今交換しようとしたアイテムのポイントを抽出（select）
				//2.自分のポイントに1の値のマイナスをinsert
				//格言
				KakugenItemsDAO kDAO = new KakugenItemsDAO();
				if (kDAO.insert(new KakugenItems(user_id, genre_name))) {	// 登録成功
					System.out.println("true");
				} else {												// 登録失敗
					System.out.println("false");
				}
				session.setAttribute("res", "ok");
				//				request.setAttribute("result", "ok");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
				dispatcher.forward(request, response);

			}else {
				//ポイントが不足のとき
				session.setAttribute("res", "fail");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
				dispatcher.forward(request, response);
			}
		}
		//		//ポイントチェックをする
		//キャラクター
		if(character != 0 ) {
			//backgroundのポイント照合
			//自分の現在のポイント合計と交換しようとするポイント
			if(character <= point_value) {
				//ポイントが足りたとき
				//insert文を使って自分のポイントを
				//1.今交換しようとしたアイテムのポイントを抽出（select）
				//2.自分のポイントに1の値のマイナスをinsert
				//キャラ
				CharacterItemsDAO cDAO = new CharacterItemsDAO();
				if (cDAO.insert(new CharacterItems(user_id, character_id))) {	// 登録成功
					System.out.println("true");
				}
				else {												// 登録失敗
					System.out.println("false");
				}

				session.setAttribute("res", "ok");
				//				request.setAttribute("result", "ok");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
				dispatcher.forward(request, response);
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
				//insert文を使って自分のポイントを
				//1.今交換しようとしたアイテムのポイントを抽出（select）
				//2.自分のポイントに1の値のマイナスをinsert
				//クーポン
				CouponItemsDAO ciDAO = new CouponItemsDAO();
				if (ciDAO.insert(new CouponItems(user_id, coupon_id))) {	// 登録成功
					System.out.println("true");
				}
				else {												// 登録失敗
					System.out.println("false");
				}

				session.setAttribute("res", "ok");
				//				request.setAttribute("result", "ok");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
				dispatcher.forward(request, response);

			}else {
				//ポイントが不足のとき

				session.setAttribute("res", "fail");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
				dispatcher.forward(request, response);
			}


		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
		dispatcher.forward(request, response);
	}
}

