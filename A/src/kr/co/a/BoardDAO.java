package kr.co.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	public static BoardDAO dao;

	public BoardDAO() {
	}

	public static BoardDAO getInstance() {

		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public void productInsert(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			String sql = " insert into I_PRODUCT " + " (p_no, p_name) "
					+ " VALUES "
					+ " ((SELECT nvl(max(p_no),0)+1 from I_PRODUCT), ?) ";

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getP_name());

			ps.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, null);
		}
	}

	public List<BoardVO> getImportList() {

		List<BoardVO> list = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String sql = " SELECT " + " p_no, p_name " + " FROM I_PRODUCT ";

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setP_no(rs.getInt("p_no"));
				vo.setP_name(rs.getString("p_name"));

				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, rs);
		}

		return list;

	}

	// 입고
	public void importInsert(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			String sql = " insert into I_import "
					+ " (i_no, p_no, i_cnt) "
					+ " VALUES "
					+ " ( (select nvl(max(i_no),0)+1 as i_no from i_import), ?, ?) ";

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getP_no());
			ps.setInt(2, vo.getI_cnt());

			ps.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, null);
		}
	}

	public void importUpdate(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			String sql = " UPDATE I_PRODUCT " + " SET p_cnt = p_cnt + ? "
					+ " where p_no = ? ";

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getI_cnt());
			ps.setInt(2, vo.getP_no());

			ps.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, null);
		}
	}

	// 출고
	public List<BoardVO> getExportList() {

		List<BoardVO> list = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String sql = " SELECT " + " p_no, p_name " + " FROM I_PRODUCT ";

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setP_no(rs.getInt("p_no"));
				vo.setP_name(rs.getString("p_name"));

				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, rs);
		}

		return list;

	}

	public void exportInsert(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			String sql = " insert into I_export "
					+ " (e_no, p_no, e_cnt) "
					+ " VALUES "
					+ " ( (select nvl(max(e_no),0)+1 as e_no from i_export), ?, ?) ";

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getP_no());
			ps.setInt(2, vo.getE_cnt());

			ps.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, null);
		}
	}

	public void exportUpdate(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			String sql = " UPDATE I_PRODUCT " + " SET p_cnt = p_cnt - ? "
					+ " where p_no = ? ";

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getE_cnt());
			ps.setInt(2, vo.getP_no());

			ps.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, null);
		}
	}

	public List<BoardVO> getProductList() {

		List<BoardVO> list = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			
			String sql = " SELECT "
					+ " p_no, p_name, p_cnt, to_char(p_regdate,'YYYY-MM-DD') as p_regdate "
					+ " FROM I_PRODUCT ";
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setP_no(rs.getInt("p_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_cnt(rs.getInt("p_cnt"));
				vo.setP_regdate(rs.getString("p_regdate"));
			
				list.add(vo);
	
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, rs);
		}

		return list;

	}
	
	public BoardVO getProductDetatil(int p_no){
		
		BoardVO vo = new BoardVO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT "
					+ " p_no, p_name, p_cnt, to_char(p_regdate, 'YYYY-MM-DD') as p_regdate "
					+ " FROM I_PRODUCT "
					+ " where P_NO = ? ";
			
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p_no);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				vo.setP_no(rs.getInt("p_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_cnt(rs.getInt("p_cnt"));
				vo.setP_regdate(rs.getString("p_regdate"));
			
			}
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.close(con, ps, rs);
		}
		return vo;
		
	}
	
	public void ProductNameUpdate(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			String sql = " UPDATE I_PRODUCT " + " SET p_name = ? "
					+ " where p_no = ? ";

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getP_name());
			ps.setInt(2, vo.getP_no());

			ps.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, null);
		}
	}
	
	public List<BoardVO> importList(){
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT "
					+ " i.i_no, p.p_name, i.I_CNT, i.I_DATE "
					+ " FROM I_PRODUCT p "
					+ " left join I_IMPORT i "
					+ " ON p.p_no = i.p_no "
					+ " GROUP BY i.i_no, p.p_name, i.I_CNT, i.I_DATE "
					+ " ORDER by i.I_NO desc";
			
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setI_no(rs.getInt("i_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setI_cnt(rs.getInt("i_cnt"));
				vo.setI_date(rs.getString("i_date"));
				
				list.add(vo);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.close(con, ps, rs);
		}
		return list;
		
	}
	
	public List<BoardVO> exportList(){
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT "
					+ " e.E_NO, p.P_NAME, e.E_CNT, e.E_DATE "
					+ " FROM I_PRODUCT p left join I_EXPORT e on p.P_NO = e.P_NO "
					+ " ORDER by e_no desc ";
   
			
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setE_no(rs.getInt("e_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setE_cnt(rs.getInt("e_cnt"));
				vo.setE_date(rs.getString("e_date"));
			
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.close(con, ps, rs);
		}
		return list;
		
	}
	
	

}
