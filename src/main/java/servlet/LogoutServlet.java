package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.UserBean;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");

		String url = "logout.jsp"; // 転送用パスを格納する変数

		String userName = user.getUserId();

		//ログアウトメッセージの作成
		String logoutMessage = userName + "さん" + "　" + "ログアウトしました。";

		//セッションを無効化
		session.invalidate();

		request.setAttribute("logoutMessage", logoutMessage);

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
