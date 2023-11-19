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
import model.dao.MakerDAO;
import model.entity.MakerBean;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/item-edit")
public class ItemEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemEditServlet() {
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
		String itemIdParam = request.getParameter("itemId"); //商品ID
		String itemName = request.getParameter("itemName"); // 商品名
		String makerCode = request.getParameter("makerCode"); // メーカーCD
		String priceParam = request.getParameter("price"); // 価格

		int itemId = Integer.parseInt(itemIdParam);

		// 転送用パスを格納する変数
		String url = null;

		ItemDAO itemDAO = new ItemDAO();
		MakerDAO makerDAO = new MakerDAO();

		List<MakerBean> makers = null;

		try {
			if (itemIdParam != null && itemName != null && makerCode != null && priceParam != null) {
				int price = Integer.parseInt(priceParam);
				// editItemを呼び出して、データベースで値を更新
				itemDAO.editItem(itemId, itemName, makerCode, price);
				url = "item-list";
			} else {
				//商品編集フォームを表示
				makers = makerDAO.getAllMakers();
				request.setAttribute("makers", makers);
				request.setAttribute("itemId", itemId);
				url = "item-edit.jsp";
			}

		} catch (RuntimeException | ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			String errorMessage = "商品編集に失敗しました。もう一度入力してください。";
			url = "item-edit.jsp";
			//商品編集フォームを表示
			try {
				makers = makerDAO.getAllMakers();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			request.setAttribute("makers", makers);
			request.setAttribute("itemId", itemId);
			request.setAttribute("errorMessage", errorMessage);
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
