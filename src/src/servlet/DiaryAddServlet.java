package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiariesDAO;
import model.Diaries;


/**
 * Servlet implementation class DiaryAddServlet
 */
@WebServlet("/DiaryAddServlet")
public class DiaryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule_edit.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String diary_date = request.getParameter("diary_date");
		String diary_title = request.getParameter("diary_title");
		String diary_content = request.getParameter("diary_content");


		// 登録処理を行う
		DiariesDAO dDao = new DiariesDAO();
		if (dDao.insert(new Diaries(diary_date,diary_title,diary_content))) {	// 登録成功
			request.setAttribute("result","ok");
		}
		else {												// 登録失敗
			request.setAttribute("result","false");
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}
