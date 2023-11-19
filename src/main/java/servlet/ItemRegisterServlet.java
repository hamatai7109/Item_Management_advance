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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/item-register")
public class ItemRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public ItemRegisterServlet() {
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
		String itemName = request.getParameter("itemName"); // 商品名
		String makerName = request.getParameter("makerName"); // メーカー名
		String priceParam = request.getParameter("price"); // 価格(Param)

		String url = null; // 転送用パスを格納する変数

		ItemDAO itemDao = new ItemDAO(); // itemDAOクラスをインスタンス化
		MakerDAO makerDao = new MakerDAO(); // itemDAOクラスをインスタンス化

		List<MakerBean> makers = null;

		try {
			if (itemName != null && makerName != null && priceParam != null) {
				int price = Integer.parseInt(priceParam);//価格(int)

				// addItemを呼び出して、データベースに値を追加
				itemDao.addItem(itemName, makerName, price);
				url = "item-list";

			} else {
				//商品登録フォームを表示
				makers = makerDao.getAllMakers();
				request.setAttribute("makers", makers);
				url = "item-register.jsp";
			}
		} catch (RuntimeException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			String errorMessage = "商品登録に失敗しました。もう一度入力してください。";
			try {
				makers = makerDao.getAllMakers();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			url = "item-register.jsp";
			request.setAttribute("makers", makers);
			request.setAttribute("errorMessage", errorMessage);
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
