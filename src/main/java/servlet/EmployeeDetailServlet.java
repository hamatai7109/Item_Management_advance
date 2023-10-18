package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/employee-detail")
public class EmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDetailServlet() {
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
		// リクエスト/レスポンスのエンコーディング
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 転送用パスを格納する変数
		String url = null;

		EmployeeDAO employeeDAO = new EmployeeDAO();

		List<EmployeeBean> employees = null;

		// employeeId パラメータを取得
		String employeeIdParam = request.getParameter("employeeId");

		try {
			url = "employee-detail.jsp";

			if (employeeIdParam != null) {

				int employeeId = Integer.parseInt(employeeIdParam);

				// employeeId が存在する場合、メソッドを呼び出す
				employees = employeeDAO.getSelectedEmployees(employeeId);

				request.setAttribute("employees", employees);
			} else {
				request.setAttribute("errorMessage", "該当する従業員データがありません。");
			}

		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "不正な従業員IDです。");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
