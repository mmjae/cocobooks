package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import bean.NovelList;
import dao.BestListDao;

public class BestFreeWebNovel {
	
	HttpServletRequest request;
	HttpServletResponse response;
	public BestFreeWebNovel(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward freeWeblist() {
		Forward fw= new Forward();
		BestListDao bDao= new BestListDao();
		List<NovelList> freeList=bDao.freeList();
		if(freeList!=null&&freeList.size()!=0) {
			request.setAttribute("list", makeHtml(freeList));
			fw.setPath("bestFreeNovel.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}

	private String makeHtml(List<NovelList> freeList) {
		StringBuilder sb= new StringBuilder();
		sb.append("<div class='onetot'>");
		sb.append("<div class='oneImg'><img src='image/g.JPG'></div>");
		sb.append("<div class='one'><a href='noveldetail?novelNum="+freeList.get(0).getNum()+"'>"+freeList.get(0).getTitle()+"</a></div>");
		sb.append("<div class='oneViewBox'>");
		sb.append("<div class='oneViewTxt'>총 조회수 -</div><div class='oneViewNum'>"+freeList.get(0).getTotalView()+"</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div class='twoAndthree'>");
		sb.append("<div class='twotot'>");
		sb.append("<div class='twoImg'><img src='image/s.JPG'></div>");
		sb.append("<div class='two'><a href='noveldetail?novelNum="+freeList.get(1).getNum()+"'>"+freeList.get(1).getTitle()+"</a></div>");
		sb.append("<div class='twoViewBox'>");
		sb.append("<div class='twoViewTxt'>총 조회수 -</div><div class='twoViewNum'>"+freeList.get(1).getTotalView()+"</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div class='threetot'>");
		sb.append("<div class='threeImg'><img src='image/b.JPG'></div>");
		sb.append("<div class='three'><a href='noveldetail?novelNum="+freeList.get(2).getNum()+"'>"+freeList.get(2).getTitle()+"</a></div>");
		sb.append("<div class='threeBox'>");
		sb.append("<div class='threeViewTxt'>총 조회수 -</div><div class='threeViewNum'>"+freeList.get(2).getTotalView()+"</div>");
		sb.append("</div>");
		sb.append("</div>");	
		sb.append("</div>");
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>작품 번호</td>");
		sb.append("<td>작품 제목</td>");
		sb.append("<td>작가 </td>");
		sb.append("<td>총 조회수</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>작품 번호</td>");
		sb.append("<td>작품 제목</td>");
		sb.append("<td>작가 </td>");
		sb.append("<td>총 조회수</td>");
		sb.append("</tr>");
		for(int i=3;i<freeList.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+freeList.get(i).getNum()+"</td>");
			sb.append("<td><a href='noveldetail?novelNum="+freeList.get(i).getNum()+"'>"+freeList.get(i).getTitle()+"</a></td>");
			sb.append("<td>"+freeList.get(i).getId()+"</td>");
			sb.append("<td>"+freeList.get(i).getTotalView()+"</td>");
			sb.append("</tr>");
		}
		sb.append("<table>");
		return sb.toString();
	}

}
