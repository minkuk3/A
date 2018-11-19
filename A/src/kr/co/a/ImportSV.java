package kr.co.a;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImportSV
 */
@WebServlet("/import")
public class ImportSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardVO> list = dao.getImportList();
		
		request.setAttribute("list", list);
		request.setAttribute("template", "import");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		/* i_no, p_no, i_cnt */
		
		int p_no = Integer.parseInt(request.getParameter("p_no"));
		int i_cnt = Integer.parseInt(request.getParameter("i_cnt"));
		
		System.out.println("p_no : " + p_no);
		System.out.println("i_cnt : " + i_cnt);
		
		BoardVO vo = new BoardVO();
		
		vo.setI_cnt(i_cnt);
		vo.setP_no(p_no);
		
		dao.importInsert(vo);
		
		dao.importUpdate(vo);
		
		response.sendRedirect("importList");
		
	}

}
