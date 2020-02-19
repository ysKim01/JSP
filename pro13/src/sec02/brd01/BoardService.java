package sec02.brd01;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}

	public int addArticle(ArticleVO articleVO) {
		boardDAO.insertNewArticle(articleVO);
		return articleVO.getArticleNO();
	}

	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article = new ArticleVO(); 
		article = boardDAO.selectArticle(articleNO);
		return article;
	}

	public void modArticle(ArticleVO articleVO) {
		boardDAO.updateArticle(articleVO);		
	}
}
