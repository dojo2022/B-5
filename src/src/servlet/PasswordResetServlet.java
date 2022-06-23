package servlet;

import java.io.IOException;
import java.util.Random;

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
 * Servlet implementation class PasswordResetServlet
 */
@WebServlet("/PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パスワード再設定用ページにフォワードする
		HttpSession session = request.getSession();
		session.setAttribute("res", "get");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/password_reset.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("Mail");
		UsersDAO uDao = new UsersDAO();

		if (uDao.isMailOK(new Users(mail))) {	// メール一致

			//passwordを生成してString型newpassに代入



			int min_val = 1000;
	        int max_val = 10000;
	        Random rand = new Random();
	        int randomNum = min_val + rand.nextInt((max_val - min_val) + 1);
	        Integer i = Integer.valueOf(randomNum);

	        int min = 1000;
	        int max = 10000;
	        Random rando = new Random();
	        int randoNum = min + rando.nextInt((max - min) + 1);
	        Integer n = Integer.valueOf(randoNum);
	        String newpass ="p" + i.toString()+ "w"+n.toString() + "r";


			/*String newpass = "125446842134546";*/




			request.setAttribute("pas", newpass);
			//uDaoにupdate文を追加。mailで検索。passの値をnewpassに更新する
			if(uDao.updatePassword(new Users(mail,newpass))) {

			HttpSession session = request.getSession();
			session.setAttribute("res", "ok");

			}else {
				HttpSession session = request.getSession();
				session.setAttribute("res", "update_mis");
			}

		}
		else {									// ログイン失敗
			HttpSession session = request.getSession();
			session.setAttribute("res", "miss");


		}
		// パスワード再設定ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/password_reset.jsp");
		dispatcher.forward(request, response);


	}
//		//リクエストスコープに保存
//		request.setAttribute("cardList", cardList);
//
		//パスワードを受け取り、上書きする





	}


