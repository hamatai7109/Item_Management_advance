package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.StockDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/item-stock")
public class ItemStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public ItemStockServlet() {
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
		String itemIdParam = request.getParameter("itemId"); //商品ID
		String arrivalParam = request.getParameter("arrival"); // 入荷
		String shippingParam = request.getParameter("shipping"); // 出荷

		int itemId = Integer.parseInt(itemIdParam);

		// 転送用パスを格納する変数
		String url = null;

		StockDAO stockDAO = new StockDAO();

		try {
			if (itemIdParam != null && arrivalParam != null && shippingParam != null) {
				int arrival = Integer.parseInt(arrivalParam);
				int shipping = Integer.parseInt(shippingParam);
				// editStockを呼び出して、データベースで値を更新
				stockDAO.ediStock(itemId, arrival, shipping);
				url = "item-list";
			} else {
				//在庫編集フォームを表示
				request.setAttribute("itemId", itemId);
				url = "item-stock.jsp";
			}

		} catch (RuntimeException | ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			String errorMessage = "在庫修正に失敗しました。もう一度入力してください。";
			url = "item-stock.jsp";
			//在庫編集フォームを表示
			request.setAttribute("itemId", itemId);
			request.setAttribute("errorMessage", errorMessage);
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
