<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>    
<%@ page import="model.entity.ItemBean" %>		
<%-- スクリプトレットを使用した場合 --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧画面</title>
</head>
<body>
  <jsp:include page="/header.jsp" />
	<div style="text-align : center; padding-top: 50px;">
		<h1>商品一覧画面</h1>
		
		<form style="margin-top:20px;" action="item-register" method="post">
	    	<input type="submit" value="商品登録">
		</form>		
		<%-- JSTL（JavaServer Pages Standard Tag Library）を使用した場合
		<c:if test="${not empty requestScope.errorMessage}">
	    	<p style="color: red">${requestScope.errorMessage}</p>
		</c:if>
		--%>
		<%-- スクリプトレットを使用した場合 --%>
		<% if (request.getAttribute("errorMessage") != null) { %>
	   		<p style="color: red"><%= request.getAttribute("errorMessage") %></p>
		<% } %>		
		<form style="margin-top:20px; display: flex; gap: 10px; justify-content:center;"  action="item-list" method="post">
			<input type="text" name="searchWord" required>
			<input type="submit" value="検索">
		</form>
		
		<table border="1" style="margin: 10px auto 0px auto;">
		<tr>
          <th>商品ID</th>
          <th>商品名</th>
          <th>メーカ</th>
          <th>価格(万円)</th>
        </tr>
        <%
		    List<ItemBean> items = (List<ItemBean>) request.getAttribute("items");
		    for (ItemBean item : items) {
		%>
		    <tr>
		        <td><%= item.getItemId() %></td>
		        <td><%= item.getItemName() %></td>
		        <td><%= item.getMakerName() %></td>
		        <td><%= item.getPrice() %></td>
		        <td>
		            <form action="item-detail" method="post">
		                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
		                <input type="submit" value="詳細">
		            </form>
		        </td>
		    </tr>
		<%
		    }
		%>
		<%-- スクリプトレットを使用した場合 
        <c:forEach var="item" items="${items}">
	        <tr>
	          <td>${item.getItemId()}</td>
	          <td>${item.getItemName()}</td>
	          <td>${item.getMakerName()}</td>
	          <td>${item.getPrice()}</td>
	          <td>
		          <form action="item-detail" method="post">
		          	<input type="hidden" name="itemId" value="${item.getItemId()}">
		          	<input type="submit"value="詳細">
		          </form>
	          </td>
	        </tr>
        </c:forEach>
        --%>
		</table>
	</div>
</body>
</html>

