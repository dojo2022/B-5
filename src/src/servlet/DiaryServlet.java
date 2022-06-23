package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DiariesDAO;
import dao.UsersDAO;
import model.Diaries;
import model.Login;
import model.Users;


/**
 * Servlet implementation class DiaryServlet
 */
@WebServlet("/DiaryServlet")
public class DiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/WEB-INF/jsp/login.jsp");
			return;
		}*/
		HttpSession session = request.getSession();
		Login mail_session = (Login)session.getAttribute("id");
		String mail = mail_session.getMail();

		UsersDAO uDao = new UsersDAO();
		List<Users> cardList = uDao.select(mail);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList",cardList);

		DiariesDAO dDao = new DiariesDAO();
		List<Diaries> diaryList = dDao.selectMyItem(mail);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("diaryList", diaryList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/diary.jsp");
		dispatcher.forward(request, response);
	}


		/*DiariesDAO dDao = new DiariesDAO();
		List<Diaries> cardList = dDao.select(new Diaries("","","",""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/diary.jsp");
		dispatcher.forward(request, response);

		}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		String title = request.getParameter("title");

		//Diarys
		List<Diaries> diaryList = new ArrayList<Diaries>();
		Diaries param = new Diaries("",date,title,"");
		DiariesDAO dDao = new DiariesDAO();
		diaryList=dDao.selectMyItem(param);
//		HttpSession session = request.getSession();
		request.setAttribute("diaryList", diaryList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
		dispatcher.forward(request, response);





	}

}


