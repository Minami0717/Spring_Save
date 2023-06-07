package gall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
	private static PostDao instance;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String driver = "org.mariadb.jdbc.Driver";
	String user = "root";
	String pass = "1111";
	String dbURL = "jdbc:mariadb://localhost:3306/gall";
	
	private PostDao() {
		try {
			Class.forName(driver);
			System.out.println("MySQL driver search success...");
			
			conn = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("MySQL connect success...\n");
		}
		catch (ClassNotFoundException e) {
			System.out.println("MySQL Error");
		}
		catch (SQLException e) {
			System.out.println("MySQL Fail\n" + e);
		}
	}
	
	public static PostDao getInstance() {
		if (instance == null)
			instance = new PostDao();
		return instance;
	}
	
	public List<Post> selectAll(int idx) {
		List<Post> list = new ArrayList<Post>();
		
		try {
			if (idx == 0)
				pstmt = conn.prepareStatement("SELECT * FROM post");
			else {
				pstmt = conn.prepareStatement("SELECT * FROM post where gall_idx=?");
				pstmt.setInt(1, idx);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Post post = new Post();
				post.setIdx(rs.getInt("idx"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setWriter(rs.getString("writer"));
				post.setDate(rs.getString("date"));
				post.setHits(rs.getInt("hits"));
				post.setRecommend(rs.getInt("recommend"));
				post.setDecommend(rs.getInt("decommend"));
				post.setPw(rs.getString("pw"));
				post.setMember_id(rs.getString("member_id"));
				post.setReplyNum(rs.getInt("replyNum"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Post> selectReco(int idx) {
		List<Post> list = new ArrayList<Post>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM post where gall_idx=? and recommend >= 10");
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Post post = new Post();
				post.setIdx(rs.getInt("idx"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setWriter(rs.getString("writer"));
				post.setDate(rs.getString("date"));
				post.setHits(rs.getInt("hits"));
				post.setRecommend(rs.getInt("recommend"));
				post.setDecommend(rs.getInt("decommend"));
				post.setPw(rs.getString("pw"));
				post.setMember_id(rs.getString("member_id"));
				post.setReplyNum(rs.getInt("replyNum"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Post> selectBest() {
		List<Post> list = new ArrayList<Post>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM post where recommend >= 10");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Post post = new Post();
				post.setIdx(rs.getInt("idx"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setWriter(rs.getString("writer"));
				post.setDate(rs.getString("date"));
				post.setHits(rs.getInt("hits"));
				post.setRecommend(rs.getInt("recommend"));
				post.setDecommend(rs.getInt("decommend"));
				post.setPw(rs.getString("pw"));
				post.setMember_id(rs.getString("member_id"));
				post.setReplyNum(rs.getInt("replyNum"));
				post.setGall_idx(rs.getInt("gall_idx"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Post select(Integer idx) {
		Post post = new Post();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM post where idx=?");
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				post.setIdx(rs.getInt("idx"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setWriter(rs.getString("writer"));
				post.setDate(rs.getString("date"));
				post.setHits(rs.getInt("hits"));
				post.setRecommend(rs.getInt("recommend"));
				post.setDecommend(rs.getInt("decommend"));
				post.setReplyNum(rs.getInt("replyNum"));
				post.setMember_id(rs.getString("member_id"));
				post.setPw(rs.getString("pw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}
	
	public int updateReply(Integer idx) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("update post set replyNum=replyNum+1 where idx=?");
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateReco(Integer idx) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("update post set recommend=recommend+1 where idx=?");
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateDeco(Integer idx) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("update post set decommend=decommend+1 where idx=?");
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insert(Post post) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("insert into post(title,content,writer,date,pw,gall_idx,member_id) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setString(3, post.getWriter());
			pstmt.setString(4, post.getDate());
			pstmt.setString(5, post.getPw());
			pstmt.setInt(6, post.getGall_idx());
			pstmt.setString(7, post.getMember_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(Post post) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("update post set hits = ? where idx = ?");
			pstmt.setInt(1, post.getHits());
			pstmt.setInt(2, post.getIdx());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String getPw(int p_idx) {
		String pw = null;
		try {
			pstmt = conn.prepareStatement("SELECT pw FROM post where idx=?");
			pstmt.setInt(1, p_idx);
			rs = pstmt.executeQuery();
			if (rs.next())
				pw = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pw;
	}
	
	public int modify(Post post) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("update post set title = ?,content = ?,writer = ?,pw = ? where idx = ?");
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setString(3, post.getWriter());
			pstmt.setString(4, post.getPw());
			pstmt.setInt(5, post.getIdx());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(int idx) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("delete from post where idx = ?");
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
