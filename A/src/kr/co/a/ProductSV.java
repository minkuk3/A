package kr.co.a;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductSV
 */
@WebServlet("/product")
public class ProductSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("template", "product");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		String p_name = request.getParameter("p_name");
		 
		System.out.println("p_name : " + p_name);
		
		BoardVO vo = new BoardVO();
		vo.setP_name(p_name);
		
		dao.productInsert(vo);
		
		response.sendRedirect("product");
		
		
		
		
	}

}
