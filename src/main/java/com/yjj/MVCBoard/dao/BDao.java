package com.yjj.MVCBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.web.servlet.view.tiles2.SpringBeanPreparerFactory;

import com.yjj.MVCBoard.dto.BDto;
import com.yjj.MVCBoard.util.Constant;

public class BDao {

	
	DataSource dataSource;
	
	JdbcTemplate template;
	

	public BDao() {
		super();
		// TODO Auto-generated constructor stub
		
		this.template = Constant.template;
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<BDto> list() {
		
		
		String query = "select * from mvc_board order by bgroup desc, bstep asc";
		
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper(BDto.class));
		
		
		
		
//		ArrayList<BDto> dtos = new ArrayList<BDto>();
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "select * from mvc_board order by bgroup desc, bstep asc";
//			pstmt = conn.prepareStatement(query);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				
//				int bId = rs.getInt("bid");
//				String bName = rs.getString("bname");
//				String bTitle = rs.getString("btitle");
//				String bContent = rs.getString("bcontent");
//				Timestamp bDate = rs.getTimestamp("bdate");
//				int bHit = rs.getInt("bhit");
//				int bGroup = rs.getInt("bgroup");
//				int bStep = rs.getInt("bstep");
//				int bIndent = rs.getInt("bindent");
//				
//				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//				dtos.add(dto);
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		return dtos; 
	}
	
	
	
	public void write(final String bname, final String btitle, final String bcontent) {
		
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				
				String query = "INSERT INTO mvc_board(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) VALUES (MVC_BOARD_SEQ.nextval, ?, ?, ?, 0, MVC_BOARD_SEQ.currval, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);	

				return pstmt;
			}
		});
		
		
		
		
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "INSERT INTO mvc_board(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) VALUES (MVC_BOARD_SEQ.nextval, ?, ?, ?, 0, MVC_BOARD_SEQ.currval, 0, 0)";
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setString(1, bname);
//			pstmt.setString(2, btitle);
//			pstmt.setString(3, bcontent);
//			
//			pstmt.executeUpdate(); // 데이터 삽입에 성공하면 1반환
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
	}
	
	
	
	
	public BDto content_view(String cid) {
		
		uphit(cid);// 조회수 계산 함수
		
		String query = "select * from mvc_board where bid= "+ cid ;
		
		
		return template.queryForObject(query, new BeanPropertyRowMapper(BDto.class));
		
		
//		BDto dto = null;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "select * from mvc_board where bid=?";
//			pstmt = conn.prepareStatement(query);
//			
//			//pstmt.setInt(1, Integer.parseInt(cid)); // bid 필드값이 number인경우
//			pstmt.setString(1, cid);
//			
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				
//				int bId = rs.getInt("bid");
//				String bName = rs.getString("bname");
//				String bTitle = rs.getString("btitle");
//				String bContent = rs.getString("bcontent");
//				Timestamp bDate = rs.getTimestamp("bdate");
//				int bHit = rs.getInt("bhit");
//				int bGroup = rs.getInt("bgroup");
//				int bStep = rs.getInt("bstep");
//				int bIndent = rs.getInt("bindent");
//				
//				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//				
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		return dto;
	}
	
	
	public void modify(final String bid, final String bname, final String btitle, final String bcontent) {
		
		String query = "UPDATE mvc_board SET bname=?, btitle=?, bcontent=? WHERE bid=?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, bname);
				ps.setString(2, btitle);
				ps.setString(3, bcontent);
				ps.setString(4, bid);
				
				
				
			}
		});
		
		
		
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "UPDATE mvc_board SET bname=?, btitle=?, bcontent=? WHERE bid=?";
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setString(1, bname);
//			pstmt.setString(2, btitle);
//			pstmt.setString(3, bcontent);
//			pstmt.setString(4, bid);
//			
//			
//			pstmt.executeUpdate(); // 데이터 삽입에 성공하면 1반환
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
	}
	
	
	public void delete(final String bid) {
		
		String query = "DELETE FROM  mvc_board WHERE bid=?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bid);
			}
		});
		
		
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "DELETE FROM  mvc_board WHERE bid=?";
//			pstmt = conn.prepareStatement(query);
//			
//			
//			pstmt.setString(1, bid);
//			
//			
//			pstmt.executeUpdate(); // 데이터 삽입에 성공하면 1반환
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
	}
	
	
	
	public void uphit(final String bid) {
		
		
		String query = "UPDATE mvc_board SET bhit=bhit+1 WHERE bid=?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, bid);
			}
		});
		
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "UPDATE mvc_board SET bhit=bhit+1 WHERE bid=?";
//			pstmt = conn.prepareStatement(query);
//
//			pstmt.setString(1, bid);
//			
//			
//			pstmt.executeUpdate(); // 데이터 삽입에 성공하면 1반환
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
	}

	
	
	
	public BDto reply_view(String cid) {
		// TODO Auto-generated method stub
		
		String query = "select * from mvc_board where bid= "+ cid ;
		
		return template.queryForObject(query, new BeanPropertyRowMapper(BDto.class));
		
		
		
//		BDto dto = null;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "select * from mvc_board where bid=?";
//			pstmt = conn.prepareStatement(query);
//			
//			//pstmt.setInt(1, Integer.parseInt(cid)); // bid 필드값이 number인경우
//			pstmt.setString(1, cid);
//			
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				
//				int bId = rs.getInt("bid");
//				String bName = rs.getString("bname");
//				String bTitle = rs.getString("btitle");
//				String bContent = rs.getString("bcontent");
//				Timestamp bDate = rs.getTimestamp("bdate");
//				int bHit = rs.getInt("bhit");
//				int bGroup = rs.getInt("bgroup");
//				int bStep = rs.getInt("bstep");
//				int bIndent = rs.getInt("bindent");
//				
//				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//				
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		return dto;
	}

	public void reply(final String bid, final String bname, final String btitle, final String bcontent, final String bgroup, final String bstep, final String bindent) {
		// TODO Auto-generated method stub
		
		
		replay_sort(bgroup, bstep);
		
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				
				String query = "INSERT INTO mvc_board(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) VALUES (MVC_BOARD_SEQ.nextval, ?, ?, ?, 0, ?, ?, ?)";
		
				PreparedStatement pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				
				pstmt.setInt(4, Integer.parseInt(bgroup));
				pstmt.setInt(5, Integer.parseInt(bstep)+1);
				pstmt.setInt(6, Integer.parseInt(bindent)+1);
				
				return pstmt;
			}
		});
		
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "INSERT INTO mvc_board(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) VALUES (MVC_BOARD_SEQ.nextval, ?, ?, ?, 0, ?, ?, ?)";
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setString(1, bname);
//			pstmt.setString(2, btitle);
//			pstmt.setString(3, bcontent);
//			
//			pstmt.setInt(4, Integer.parseInt(bgroup));
//			pstmt.setInt(5, Integer.parseInt(bstep)+1);
//			pstmt.setInt(6, Integer.parseInt(bindent)+1);
//			
//			pstmt.executeUpdate(); // 데이터 삽입에 성공하면 1반환
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	
	public void replay_sort(final String cgroup, final String cstep) {
		
		String query = "UPDATE mvc_board SET bstep=bstep+1 WHERE bgroup=? and bstep>?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, cgroup);
				ps.setString(2, cstep);
			}
		});
		
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		
//		try {
//			
//			conn = dataSource.getConnection();
//			String query = "UPDATE mvc_board SET bstep=bstep+1 WHERE bgroup=? and bstep>?";
//			pstmt = conn.prepareStatement(query);
//
//			pstmt.setString(1, cgroup);
//			pstmt.setString(2, cstep);
//			
//			
//			pstmt.executeUpdate(); // 데이터 삽입에 성공하면 1반환
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
