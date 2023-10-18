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
@WebServlet("/employee-list")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeListServlet() {
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

		// searchWord パラメータを取得
		String searchWord = request.getParameter("searchWord");

		try {
			if (searchWord != null) {
				// searchWord が指定されている場合、検索メソッドを呼び出す
				employees = employeeDAO.getSearchedEmployees(searchWord);

				// 検索結果がnullの場合、エラーメッセージをセット
				if (employees.size() == 0) {
					request.setAttribute("errorMessage", "該当する検索結果がありません。");
				}
			} else {
				// searchWord が指定されていない場合、全従業員を取得するメソッドを呼び出す
				employees = employeeDAO.getAllEmployees();
			}

			url = "employee-list.jsp";
			request.setAttribute("employees", employees);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
