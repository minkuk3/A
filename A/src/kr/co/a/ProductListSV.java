package kr.co.a;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/productList")
public class ProductListSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.getProductList();
		
		request.setAttribute("list", list);
		request.setAttribute("template", "productList");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
