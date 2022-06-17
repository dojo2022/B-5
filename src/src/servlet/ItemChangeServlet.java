package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/anikare/LoginServlet");
			return;
		}
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
