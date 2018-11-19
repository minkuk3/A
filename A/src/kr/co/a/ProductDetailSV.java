package kr.co.a;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetailSV
 */
@WebServlet("/productDetail")
public class ProductDetailSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int p_no = Integer.parseInt(request.getParameter("p_no"));
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO vo = dao.getProductDetatil(p_no);
		
		System.out.println("p_no : " + p_no);
		
		request.setAttribute("vo", vo);
		request.setAttribute("template", "productDetail");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int p_no = Integer.parseInt(request.getParameter("p_no"));
		BoardDAO dao = BoardDAO.getInstance();

		String p_name = request.getParameter("p_name");
		System.out.println("p_name : " + p_name);
		
		BoardVO vo = new BoardVO();
		vo.setP_no(p_no);
		vo.setP_name(p_name);
		
		dao.ProductNameUpdate(vo);
		
		response.sendRedirect("productList");
			
		
	}

}
