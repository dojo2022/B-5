package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BackgroundsDAO;
import dao.CharactersDAO;
import dao.CouponsDAO;
import dao.KakugensDAO;
import model.Backgrounds;
import model.Characters;
import model.Coupons;
import model.Kakugens;

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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/anikare/LoginServlet");
//			return;
//		}
		//アイテムの全件表示を行う
		//背景はbgListスコープに保存
		BackgroundsDAO bDAO = new BackgroundsDAO();
		List<Backgrounds> bgList = bDAO.select(new Backgrounds(0,"","" ,0 ,""));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("bgList", bgList);

		//格言はwordsListスコープに保存
		KakugensDAO kDAO = new KakugensDAO();
		List<Kakugens> wordsList = kDAO.select(new Kakugens(0,"","" ,"","",0 ,""));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("wordsList", wordsList);

		//キャラクターはcharactersスコープに保存
		CharactersDAO cDAO = new CharactersDAO();
		List<Characters> charactersList = cDAO.select(new Characters(0,"","" ,"","",0 ,""));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("charactersList", charactersList);

		//クーポンはcouponsスコープに保存
		CouponsDAO coDAO = new CouponsDAO();
		List<Coupons> couponsList = coDAO.select(new Coupons(0,"","" ,0 ,""));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("couponsList", couponsList);

		//ログインデータがある場合、アイテム交換ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item_change.jsp");
		dispatcher.forward(request, response);

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
		doGet(request, response);
	}

}
