package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public LoginServlet() {
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
		String id = request.getParameter("id"); // ユーザID
		String password = request.getParameter("password"); // パスワード

		String url = "login.jsp"; // 転送用パスを格納する変数

		UserDAO dao = new UserDAO(); // UserDAOクラスをインスタンス化

		// try-catchで例外処理
		try {
			// UserDAOクラスのcheckLoginメソッドを呼び出してユーザ情報を取得
			UserBean user = dao.checkLogin(id, password);

			// idとpasswordがデータベースに登録されていた場合
			if (user != null) {
				url = "menu.jsp"; // メニュー画面のパス

				// セッションオブジェクト取得し、セッションスコープに値をセット
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				// idとpasswordがデータベースに登録されていなかった場合
			} else {

			}

			// 例外キャッチ
		} catch (ClassNotFoundException | SQLException e) {
			url = "err.jsp"; // エラーページのパス
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
