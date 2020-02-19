package sec02.brd01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private DataSource dataFactory;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookupLink("aaa");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectAllArticles(){
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		try {
			con = dataFactory.getConnection();
			String query = "select level, articleNO, parentNO, "
					+ " title, content, id, writeDate from t_board"
					+ " start with parentNO=0 connect by "
					+ " prior articleNO=parentNO "
					+ " order siblings by articleNO desc";
			// 쿼리가 + 로 이어져있을경우 ' '공백을 시작으로하면 안심
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");

				ArticleVO article = new ArticleVO();
				
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				
				articlesList.add(article);
			}
			con.close();
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return articlesList;
	}

	public void insertNewArticle(ArticleVO article) {
		try {
			int articleNO = getNewArticleNum();
			article.setArticleNO(articleNO);
			int parentNO = article.getParentNO();
			String title = article.getTitle();
			String content = article.getContent();
			String imageFileName = article.getImageFileName();
			String id = article.getId();
			
			con = dataFactory.getConnection();
			String query = "insert into t_board values(?,?,?,?,?,sysdate,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, articleNO);
			ps.setInt(2, parentNO);
			ps.setString(3, title);
			ps.setString(4, content);
			ps.setString(5, imageFileName);
			ps.setString(6, id);
			ps.executeUpdate();
			
			con.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getNewArticleNum() {
		int result = 0;
		try {
			con = dataFactory.getConnection();
			String query = "select max(articleNO) from t_board";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = (rs.getInt(1)+1);
				// 안되면 여기 return 으로
			}
			con.close();
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArticleVO selectArticle(int articleNumber) {
		ArticleVO article = new ArticleVO();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_board where articleNO=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, articleNumber);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			int articleNO = rs.getInt("articleNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = rs.getString("imageFileName");
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");
			
			article.setArticleNO(articleNO);
			article.setParentNO(parentNO);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);
			
			con.close();
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return article;
	}

	public void updateArticle(ArticleVO article) {
		int articleNO = article.getArticleNO();
		String title = article.getTitle();
		String content = article.getContent();
		String imageFileName = article.getImageFileName();
		try {
			con = dataFactory.getConnection();
			String query = "update t_board set title=?, content=?";
			
			if(imageFileName!=null && imageFileName.length()!=0) {
				query += ",imageFileName=? ";
			}
			query += " where articleNO=?";
			
			ps = con.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			if(imageFileName!=null && imageFileName.length()!=0) {
				ps.setString(3, imageFileName);
				ps.setInt(4, articleNO);
			}else {
				ps.setInt(3, articleNO);
			}
			
			ps.executeUpdate();
			con.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
