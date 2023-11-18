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
@WebServlet("/employee-delete")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDeleteServlet() {
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

		// リクエストパラメータの取得
		String employeeIdParam = request.getParameter("employeeId"); // 従業員ID
		String employeeDeleteCofirm = request.getParameter("employeeDeleteCofirm"); // 削除確認OK
		int employeeId = Integer.parseInt(employeeIdParam);

		// 転送用パスを格納する変数
		String url = null;

		EmployeeDAO employeeDAO = new EmployeeDAO();

		List<EmployeeBean> employees = null;

		try {
			if (employeeDeleteCofirm != null) {
				// deleteEmployeeを呼び出して、データベースから削除
				employeeDAO.deleteEmployee(employeeId);
				url = "employee-deleteSuccess.jsp";
			} else {
				//削除確認画面を表示
				employees = employeeDAO.getSelectedEmployees(employeeId);
				request.setAttribute("employees", employees);
				request.setAttribute("employeeId", employeeId);
				url = "employee-delete.jsp";
			}

		} catch (RuntimeException | ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			String errorMessage = "従業員削除に失敗しました。";
			url = "employee-delete.jsp";

			//削除確認画面を表示
			try {
				employees = employeeDAO.getSelectedEmployees(employeeId);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			request.setAttribute("employees", employees);
			request.setAttribute("employeeId", employeeId);
			request.setAttribute("errorMessage", errorMessage);
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
