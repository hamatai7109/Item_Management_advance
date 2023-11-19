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

import model.dao.ItemDAO;
import model.entity.ItemBean;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/item-detail")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemDetailServlet() {
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

		// itemId パラメータを取得
		String itemIdParam = request.getParameter("itemId");

		// 転送用パスを格納する変数
		String url = null;

		ItemDAO itemDAO = new ItemDAO();

		List<ItemBean> items = null;

		try {
			url = "item-detail.jsp";

			if (itemIdParam != null) {

				int itemId = Integer.parseInt(itemIdParam);

				// itemId が存在する場合、メソッドを呼び出す
				items = itemDAO.getSelectedItems(itemId);

				request.setAttribute("items", items);
			} else {
				request.setAttribute("errorMessage", "該当する商品データがありません。");
			}

		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "不正な商品IDです。");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
