package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.LanguageDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/language-register")
public class LanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public LanguageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String languageCode = request.getParameter("languageCode"); // 言語コード
		String languageName = request.getParameter("languageName"); // 言語名

		String url = null; // 転送用パスを格納する変数

		LanguageDAO dao = new LanguageDAO(); // LanguageDAOクラスをインスタンス化

		try {
			// addLanguageを呼び出して、データベースに値を追加
			dao.addLanguage(languageCode, languageName);

			url = "languageSuccess.jsp";
			response.sendRedirect(url);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("languageErr.jsp");
		}
	}
}
