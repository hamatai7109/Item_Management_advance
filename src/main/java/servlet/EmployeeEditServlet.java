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
import model.dao.LanguageDAO;
import model.dao.SectionDAO;
import model.entity.LanguageBean;
import model.entity.SectionBean;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/employee-edit")
public class EmployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeEditServlet() {
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
		String lastName = request.getParameter("lastName"); // 氏名（姓）
		String firstName = request.getParameter("firstName"); // 氏名（名）
		String gender = request.getParameter("gender"); // 性別
		String birthday = request.getParameter("birthday"); // 生年月日
		String phoneNumber = request.getParameter("phoneNumber"); // 電話番号
		String sectionCode = request.getParameter("sectionCode"); // 部署
		String languageCode = request.getParameter("languageCode"); // 言語
		String hireDate = request.getParameter("hireDate"); // 入社日

		int employeeId = Integer.parseInt(employeeIdParam);

		// 転送用パスを格納する変数
		String url = null;

		EmployeeDAO employeeDAO = new EmployeeDAO();
		SectionDAO sectionDAO = new SectionDAO();
		LanguageDAO languageDAO = new LanguageDAO();

		List<SectionBean> sections = null;
		List<LanguageBean> languages = null;

		try {
			if (employeeIdParam != null && lastName != null && firstName != null && gender != null && birthday != null && phoneNumber != null
					&& sectionCode != null && languageCode != null && hireDate != null) {
				// editEmployeeを呼び出して、データベースで値を更新
				employeeDAO.editEmployee(employeeId, lastName, firstName, gender, birthday, phoneNumber, sectionCode, languageCode, hireDate);
				url = "employee-editSuccess.jsp";
			} else {
				//編集フォームを表示
				sections = sectionDAO.getAllSections();
				languages = languageDAO.getAllLanguages();
				request.setAttribute("sections", sections);
				request.setAttribute("languages", languages);
				request.setAttribute("employeeId", employeeId);
				url = "employee-edit.jsp";
			}

		} catch (RuntimeException | ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			String errorMessage = "従業員編集に失敗しました。もう一度入力してください。";
			url = "employee-edit.jsp";
			//編集フォームを表示
			try {
				sections = sectionDAO.getAllSections();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			try {
				languages = languageDAO.getAllLanguages();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			request.setAttribute("sections", sections);
			request.setAttribute("languages", languages);
			request.setAttribute("employeeId", employeeId);
			request.setAttribute("employeeId", employeeId);
			request.setAttribute("errorMessage", errorMessage);
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
