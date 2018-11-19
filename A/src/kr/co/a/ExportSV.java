package kr.co.a;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/export")
public class ExportSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardVO> list = dao.getExportList();
		
		request.setAttribute("list", list);
		request.setAttribute("template", "export");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO dao = BoardDAO.getInstance();
		
		int p_no = Integer.parseInt(request.getParameter("p_no"));
		int e_cnt = Integer.parseInt(request.getParameter("e_cnt"));
		
		System.out.println("p_no : " + p_no);
		System.out.println("e_cnt : " + e_cnt);
		
		BoardVO vo = new BoardVO();
		
		vo.setP_no(p_no);
		vo.setE_cnt(e_cnt);
		
		dao.exportInsert(vo);
		
		dao.exportUpdate(vo);
		
		response.sendRedirect("export");
		
		
		
		
		
	}

}
