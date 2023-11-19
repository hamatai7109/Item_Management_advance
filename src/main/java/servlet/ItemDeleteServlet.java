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
@WebServlet("/item-delete")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemDeleteServlet() {
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
		String itemIdParam = request.getParameter("itemId"); // 商品ID
		String itemDeleteCofirm = request.getParameter("itemDeleteCofirm"); // 削除確認OK
		int itemId = Integer.parseInt(itemIdParam);

		// 転送用パスを格納する変数
		String url = null;

		ItemDAO itemDAO = new ItemDAO();

		List<ItemBean> items = null;

		try {
			if (itemDeleteCofirm != null) {
				// deleteItemを呼び出して、データベースから削除
				itemDAO.deleteItem(itemId);
				url = "item-list";
			} else {
				//削除確認画面を表示
				items = itemDAO.getSelectedItems(itemId);
				request.setAttribute("items", items);
				request.setAttribute("itemId", itemId);
				url = "item-delete.jsp";
			}

		} catch (RuntimeException | ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			String errorMessage = "商品削除に失敗しました。";
			url = "item-delete.jsp";

			//削除確認画面を表示
			try {
				items = itemDAO.getSelectedItems(itemId);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			request.setAttribute("items", items);
			request.setAttribute("itemId", itemId);
			request.setAttribute("errorMessage", errorMessage);
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
