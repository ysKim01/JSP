package sec02.brd01;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "D:\\jsp_workspace\\article_image";
	BoardService boardService;
	ArticleVO articleVO;
	
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nextPage = null;
		HttpSession session;
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		articleVO = new ArticleVO();
		
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			if(action==null || action.equals("/listArticles.do")) {
				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");
				int section = Integer.parseInt(((_section==null)?"1":_section));
				int pageNum = Integer.parseInt(((_pageNum==null)?"1":_pageNum));
				
				Map<String,Integer> pagingMap = new HashMap<String, Integer>();
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				Map articlesMap = boardService.listArticles(pagingMap);
				articlesMap.put("section", section);
				articlesMap.put("pageNum", pageNum);
				calSectionPage(articlesMap);
				System.out.println("start : " + articlesMap.get("secStart"));
				System.out.println("end : " + articlesMap.get("secEnd"));
				
				request.setAttribute("articlesMap", articlesMap);
				nextPage = "/board01/listArticles.jsp";
			}
			else if(action.equals("/articleForm.do")){
				nextPage = "/board01/articleForm.jsp";
			}
			else if(action.equals("/addArticle.do")){
				int articleNO = 0;
				Map<String, String> articleMap = upload(request,response);
				
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				articleVO.setParentNO(0);
				articleVO.setId("Hong");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				articleNO = boardService.addArticle(articleVO);
				
				if(imageFileName!=null && imageFileName.length()!=0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO+"\\temp\\"+imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>alert('새 글을 추가했습니다.');"
						+"location.href='"+request.getContextPath()+"/board/listArticles.do';"
						+ "</script>");
				return;
			}
			else if(action.equals("/viewArticle.do")){
				String articleNO = request.getParameter("articleNO");
				articleVO = boardService.viewArticle(Integer.parseInt(articleNO));
				request.setAttribute("article", articleVO);
				nextPage = "/board01/viewArticle.jsp";
			}
			else if(action.equals("/modArticle.do")){
				Map<String, String> articleMap = upload(request, response);
				int articleNO = Integer.parseInt(articleMap.get("articleNO"));
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				articleVO.setArticleNO(articleNO);
				articleVO.setParentNO(0);
				articleVO.setId("Hong");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.modArticle(articleVO);
				
				if(imageFileName!=null && imageFileName.length()!=0) {
					String originalFileName = articleMap.get("originalFileName");
					File srcFile = new File(ARTICLE_IMAGE_REPO+"\\temp\\"+imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					
					File oldFile = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO+"\\"+originalFileName);
					oldFile.delete();
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>alert('글을 수정했습니다.');"
						+"location.href='"+request.getContextPath()
						+"/board/viewArticle.do?articleNO="+ articleNO +"';</script>");
				return;
			}
			else if(action.equals("/removeArticle.do")){
				int articleNO = Integer.parseInt(request.getParameter("articleNO"));
				List<Integer> articleNOList = boardService.removeArticle(articleNO);
				for(int articleNumber : articleNOList) {
					 File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNumber);
					 if(imgDir.exists()) {
						 FileUtils.deleteDirectory(imgDir);
					 }
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>alert('글을 삭제했습니다.');"
						+"location.href='"+request.getContextPath()
						+"/board/listArticles.do';</script>");
				return;
			}
			else if(action.equals("/replyForm.do")){
				int parentNO = Integer.parseInt(request.getParameter("parentNO"));
				session = request.getSession();
				session.setAttribute("parentNO", parentNO);
				nextPage = "/board01/replyForm.jsp";
			}
			else if(action.equals("/addReply.do")){
				session = request.getSession();
				int parentNO = (Integer)session.getAttribute("parentNO");
				session.removeAttribute("parentNO");
				Map<String, String> articleMap = upload(request,response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				articleVO.setParentNO(parentNO);
				articleVO.setId("Lee");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				int articleNO = boardService.addReply(articleVO);
				
				if(imageFileName!=null && imageFileName.length()!=0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO+"\\temp\\"+imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>alert('답글을 추가했습니다.');"
						+"location.href='"+request.getContextPath()
						+"/board/viewArticle.do?articleNO="+ articleNO +"';</script>");
				return;
			}
			else {
				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");
				int section = Integer.parseInt(((_section==null)?"1":_section));
				int pageNum = Integer.parseInt(((_pageNum==null)?"1":_pageNum));
				
				Map<String,Integer> pagingMap = new HashMap<String, Integer>();
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				
				Map articlesMap = boardService.listArticles(pagingMap);
				articlesMap.put("section", section);
				articlesMap.put("pageNum", pageNum);
				calSectionPage(articlesMap);
				
				request.setAttribute("articlesMap", articlesMap);
				nextPage = "/board01/listArticles.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void calSectionPage(Map articlesMap) {
		int section = (int)articlesMap.get("section");
		int totArticles = (int)articlesMap.get("totArticles");
		
		int maxPage = (totArticles/10) + ((totArticles%10)!=0?1:0);
		int secStart = (section-1)*10 +1;
		int secEnd = ((section*10)>(maxPage))?maxPage:(section*10);
		
		articlesMap.put("maxPage", maxPage);
		articlesMap.put("secStart", secStart);
		articlesMap.put("secEnd", secEnd);
	}

	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024); // 1MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for(int i=0;i<items.size();i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) { // 파일 외의 form데이터 일 경우
					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				}else {	// 파일 데이터 일 경우
					System.out.println("파라미터명 : " + fileItem.getFieldName());
					System.out.println("파일명 : " + fileItem.getName());
					System.out.println("파일 크기 : " + fileItem.getSize() + "Bytes");
					if(fileItem.getSize()>0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						System.out.println("파일명 : " + fileName);
						articleMap.put(fileItem.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath+"\\temp\\"+fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return articleMap;
	}
}









