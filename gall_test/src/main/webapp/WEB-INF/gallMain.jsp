<%@page import="gall.User"%>
<%@page import="gall.UserDao"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Random"%>
<%@page import="gall.PostDao"%>
<%@page import="gall.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Random random = new Random();

	int idx = Integer.parseInt(request.getParameter("idx"));
	GallList gall = GallListDao.getInstance().selectOne(idx);
	String post = request.getParameter("post");
	
	ArrayList<String> vList = (ArrayList)session.getAttribute("visitList");
	if (vList == null) {
		vList = new ArrayList<String>();
		vList.add(gall.getName());
		session.setAttribute("visitList", vList);
	}
	else {
		if (vList.contains(gall.getName()))
			vList.remove(gall.getName());
		
		vList.add(gall.getName());
	}
	
	List<Post> list = null;
	if(idx == 1)
		list = PostDao.getInstance().selectBest();
	else if(post == null)
		list = PostDao.getInstance().selectAll(idx);
	else if(post.equals("reco"))
		list = PostDao.getInstance().selectReco(idx);
%>
<%!
	boolean exists(int n[], int num) {
	    for (int i = 0; i < n.length; i++) {
	        if(n[i] == num)
	            return true;
	    }
	    return false;
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	main {
		margin: 20px auto 0;
		width: 950px;
	}
	main:after {
		clear: both;
	    display: block;
	    visibility: hidden;
	    content: "";
	}
	
	section {width: 660px; float: left;}
	aside {
		float: right;
		width: 270px;
	}
	h2 a {color: #d2af8a}
	
	table {width: 100%; text-align: center; border-bottom: 1px solid #d2af8a; border-spacing: 0; font-size: 13px;
	border-collapse: collapse;}
	table span {font-size: 11px; color: #999;}
	table img {height: 13px; margin-right: 10px;}
	
	th {border-bottom: 1px solid #d2af8a; border-top: 2px solid #d2af8a; height: 37px;}
	td {height: 25px; vertical-align: middle; border-top: 1px solid gainsboro;}
	td[align=left] a:last-of-type {color: #999;}
	
	#w {cursor: pointer;}
	
	#mid button {width: 82px; height: 32px; background: #d2af8a; color: white; border: 1px solid #d2af8a; margin: 15px 0 5px;
	font-weight: bold; border-radius: 2px; cursor: pointer;}
	#mid button:hover {border-color: #d2af8a;}
	#mid .white {background: white; color: black; border: 1px solid #ccc;}
	#mid .right div {border: 1px solid #d2af8a; font-size: 13px; color: #d2af8a; font-weight: bold; padding: 0 5px; cursor: pointer;}
	#mid img {width: 13px;}
	#mid > .right {margin-top: 27px;}
	#mid select {margin-right: 2px;}
	
	#bot button {width: 82px; height: 35px; background: #d2af8a; color: white; border: 1px solid #d2af8a; border-bottom-width: 3px;
	margin-top: 10px; margin-bottom: 40px; font-weight: bold; border-radius: 2px; cursor: pointer;}	
	#bot #ns {background: white; color: #d2af8a;}	
	#header {padding-bottom: 20px;}
	
	#issue_box ul {float: left; width: 300px;}
	#issue_box li,#issue_box p {margin-bottom: 5px;}
	#issue_box img {width: 150px; border: 1px solid #d2af8a; margin: 0 10px;}
	
	#intro_box img {height: 100px;}
	#intro_box p {margin-left: 12px; float: left;}
	#intro_box > div:first-child {
		width: 56%;
		float: left;
	}
	#intro_box > div:last-child > div {
		line-height: 22px;
	}
	#intro_box:after {
		clear: both;
		display: block;
	    visibility: hidden;
	    content: "";
    }
    #intro_box strong {
    	width: 73px;
    	display: inline-block;
    }
    #intro_box strong:before {
	    content: "";
	    display: inline-block;
	    width: 2px;
	    height: 2px;
	    background: #333;
	    margin: 0 7px 0 1px;
	    vertical-align: 4px;
    }
	
	#login {border: 1px solid #d2af8a; width: 270px;}
	#login img {height: 13px;}
	#login p {padding: 10px 20px;}
	#login p a {color: #d2af8a; font-weight: bold; font-size: 14px;}
	#login p a:hover {text-decoration: none;}
	#login div {background: #f3f3f3; padding: 10px; text-align: center;}
	#login div a {font-size: 12px; font-weight: bold;}
	#login button {width: 65px; height: 25px; background: #d2af8a; color: white; border: none; border: 1px solid #d2af8a;
	margin-left: 10px; cursor: pointer; font-weight: bold; float: right;}
	
	#report {
		margin-top: 5px;
	    text-decoration: underline;
	    background: none;
	    border: none;
	}
	
	#no_img {
		width: 156px;
		height: 104px;
		background: rgb(240, 240, 240);
		position: relative;
	}
	#null {
		position: absolute;
		left: 30px;
	}
	
	.inline {display: inline-block;}
	.top_box {border-top: 2px solid #d2af8a; border-bottom: 1px solid gainsboro; padding: 20px; font-size: 13px;}
</style>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
<script>
	let sub = document.getElementsByTagName("#intro_box span")
	if(sub.value == "없음")
		sub.style.color = "#999"
</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<main>
		<section>
			<div id=header>
				<h2><a href=gallMain.jsp?idx=<%=idx%>><%=gall.getName() %></a></h2>
			</div>
				<%
					if(gall.getType().equals("minor")) {
						User admin = UserDao.getInstance().select(gall.getAdmin());
						String sub = "없음";
						User sub_admin;
						if(gall.getSub_admin() != null) {
							sub_admin = UserDao.getInstance().select(gall.getSub_admin());
							sub = sub_admin.getNick();
						}
						%>
						<div id=intro_box class=top_box>
							<div>
								<%
									if(gall.getImage() == null) {
										%><div id=no_img><img src="image/no-pictures.png" id=null></div><%
									}
									else {
										%><img src="image/<%=gall.getImage() %>" class=left><%
									}
								%>
								<p><%=gall.getDesc() %>
							</div>
							<div>
								<div><strong>매니저</strong><%=admin.getNick() %>(<%=gall.getAdmin() %>)</div>
								<div><strong>부매니저</strong><span><%=sub %></span><%if(!sub.equals("없음")) {%>(<%=gall.getSub_admin() %>)<%}%></div>
								<div><strong>개설일</strong><%=gall.getDate() %></div>
								<div><button id=report class=main_color>갤러리 관리 내역</button></div>
							</div>
						</div>
						<%
					}
					else if (list.size() >= 6) {
					%><div id=issue_box class=top_box>
						<ul><%
						int n[] = new int[5];
			        	int num = 0;
				        for(int i = 0; i<n.length; i++) {
				            do {
				            	num = random.nextInt(list.size());
				            }while(exists(n,num));
				            n[i] = num;
				        }
						for (int i = 0; i < n.length; i++) {
							%><li>
								<a href=result.jsp?idx=<%=list.get(n[i]).getIdx() %>><%=list.get(n[i]).getTitle() %></a>
								<span class=right><%=list.get(n[i]).getWriter() %></span>
							</li><%
						}
						num = random.nextInt(list.size());
						
						%></ul>
						<div>
							<a href=result.jsp?idx=<%=list.get(num).getIdx() %>><img src=image/image12.jpg align=top></a>
							<div class=inline>
								<p><a href=result.jsp?idx=<%=list.get(num).getIdx() %>><b><%=list.get(num).getTitle() %></b></a>
								<p><a href=result.jsp?idx=<%=list.get(num).getIdx() %>><%=list.get(num).getContent() %></a>
								<p><b>작성자</b> : <%=list.get(num).getWriter() %>
							</div>
						</div>
					</div><%
					}
				%>
			<div id=mid>
				<%
					if (post == null) {
						%>
						<button onclick="location.href='gallMain.jsp?idx=<%=idx%>'">전체글</button>
						<button class=white onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=reco'">추천글</button>
						<button class=white onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=notice'">공지</button>
						<%
					}
					else if (post.equals("reco")) {
						%>
						<button class=white onclick="location.href='gallMain.jsp?idx=<%=idx%>'">전체글</button>
						<button onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=reco'">추천글</button>
						<button class=white onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=notice'">공지</button>
						<%
					}
					else if (post.equals("notice")) {
						%>
						<button class=white onclick="location.href='gallMain.jsp?idx=<%=idx%>'">전체글</button>
						<button class=white onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=reco'">추천글</button>
						<button onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=notice'">공지</button>
						<%
					}
				%>
				<div class=right>
					<div class=right onclick="location.href='write.jsp?idx=<%=idx%>'">
						<img src=image/pencil2.png>글쓰기
					</div>
					<select class=right>
						<option>30개
						<option selected="selected">50개
						<option>100개
					</select>
				</div>
			</div>
			<table>
				<thead>
					<tr>
						<th width=50px>번호
						<th>제목
						<th width=100px>글쓴이
						<th width=80px>작성일
						<th width=50px>조회
						<th width=50px>추천
					</tr>
				</thead>
				<tbody>
				<%
					for(int i = list.size()-1; i >= 0; i--) {
						Boolean isFixed = UserDao.getInstance().isFixed(list.get(i).getMember_id());
						String date;
						if (!list.get(i).getDate().substring(0,4).equals(String.valueOf(LocalDate.now().getYear())))
							date = list.get(i).getDate().substring(2,4)+"."+list.get(i).getDate().substring(5,7)+"."
								+list.get(i).getDate().substring(8,10);
						else if (!list.get(i).getDate().substring(0,10).equals(LocalDate.now().toString()))
							date = list.get(i).getDate().substring(5,7)+"."+list.get(i).getDate().substring(8,10);
						else
							date = list.get(i).getDate().substring(11,16);
						%><tr>
							<td><%=i+1 %>
							<td align=left>
								<a href="result.jsp?idx=<%= idx %>&p_idx=<%=list.get(i).getIdx() %>">
								<img src=image/chat.png><%=list.get(i).getTitle() %></a>
								<a href="result.jsp?idx=<%= idx %>&p_idx=<%=list.get(i).getIdx() %>#reply">[<%=list.get(i).getReplyNum() %>]</a>
							<td id=w><%=list.get(i).getWriter() %>
								<%
									if(list.get(i).getMember_id() == null) {
										String ipAddress = request.getRemoteAddr();
										if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
										    InetAddress inetAddress = InetAddress.getLocalHost();
										    ipAddress = inetAddress.getHostAddress();
										}
										%><span>(<%=ipAddress.substring(0,7)%>)</span><%
									}
									else if(isFixed) {%><a href=#><img src=image/fix_nik.gif></a><%}
									else if(!isFixed) {%><a href=#><img src=image/nik.gif></a><%}
								%>
							<td><%=date %>
							<td><%=list.get(i).getHits() %>
							<td><%=list.get(i).getRecommend() %>
						<%
					}
				%>
				</tbody>
			</table>
			<div id=bot>
				<%
					if (post == null) {
						%>
						<button onclick="location.href='gallMain.jsp?idx=<%=idx%>'">전체글</button>
						<button id=ns onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=reco'">추천글</button>
						<%
					}
					else if (post.equals("reco")) {
						%>
						<button id=ns onclick="location.href='gallMain.jsp?idx=<%=idx%>'">전체글</button>
						<button onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=reco'">추천글</button>
						<%
					}
					else if (post.equals("notice")) {
						%>
						<button id=ns onclick="location.href='gallMain.jsp?idx=<%=idx%>'">전체글</button>
						<button id=ns onclick="location.href='gallMain.jsp?idx=<%=idx%>&post=reco'">추천글</button>
						<%
					}
				%>
				<button class=right onclick="location.href='write.jsp?idx=<%=idx%>'">글쓰기</button>
			</div>
		</section>
		<aside>
			<div id=login>
				<%
					if (session.getAttribute("code") == null) {
						%>
						<p><a href=loginForm.jsp?url=<%= request.getRequestURL()+"?"+request.getQueryString() %>>로그인해 주세요.</a>
						<div>
							<a href=#>MY갤로그</a> &nbsp;|&nbsp;
							<a href=#>즐겨찾기</a> &nbsp;|&nbsp;
							<a href=#><img src=image/bell.png> 알림</a>
						</div>
						<%
					}
					else {
						%>
						<p><a href=#><b><%=session.getAttribute("nick") %></b>님<img src=image/right-arrow3.png></a>
						<button onclick="location.href='logout.jsp?url=<%= request.getRequestURL()+"?"+request.getQueryString() %>'">로그아웃</button>
						<div>
							<a href=#>MY갤로그</a> |
							<a href=#>즐겨찾기</a> |
							<a href=#>운영/가입</a> |
							<a href=#><img src=image/bell.png> 알림</a>
						</div>
						<%
					}
				%>
			</div>
		</aside>
	</main>
</body>
</html>