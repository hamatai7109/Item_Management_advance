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
<title>商品削除確認画面</title>
</head>
<body>  
<jsp:include page="/header.jsp" />
	<div style="text-align : center; padding-top: 50px;">
		    <%-- JSTL（JavaServer Pages Standard Tag Library）を使用した場合
			<c:if test="${not empty requestScope.errorMessage}">
		    	<p style="color: red">${requestScope.errorMessage}</p>
			</c:if>
			<c:forEach var="item" items="${items}">
            	<h1>${item.getItemName()}を本当に削除してもよろしいですか？ </h1>
        	</c:forEach>
			--%>
			<%-- スクリプトレットを使用した場合 --%>
			<% if (request.getAttribute("errorMessage") != null) { %>
		   		<p style="color: red"><%= request.getAttribute("errorMessage") %></p>
			<% } %>
			<%
			    List<ItemBean> items = (List<ItemBean>) request.getAttribute("items");
			    for (ItemBean item : items) {
			%>
			    <h1><%= item.getItemName() %>を本当に削除してもよろしいですか？ </h1>
			<%
			    }
			%>
		<table border="1" style="margin: 10px auto 0px auto;">
			<tr>
	          <th>商品ID</th>
	          <th>商品名</th>
	          <th>メーカー</th>
	          <th>価格(万円)</th>
	          <th>在庫数</th>
	          <th>登録日</th>
	          <th>更新日</th>
	        </tr>
	        <%
			    for (ItemBean item : items) {
			%>
			    <tr>
			        <td><%= item.getItemId() %></td>
			        <td><%= item.getItemName() %></td>
			        <td><%= item.getMakerName() %></td>
			        <td><%= item.getPrice() %></td>
			        <td><%= item.getStock() %></td>
			        <td><%= item.getInsertDatetime() %></td>
			        <td><%= item.getUpdateDatetime() %></td>
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
		          <td>${item.getStock()}</td>
		          <td>${item.getInsertDatetime()}</td>		          
		   	      <td>${item.getUpdateDatetime()}</td>
		        </tr>
        	</c:forEach>
        	--%>
		</table>
		<form style="margin-top:20px;" action="item-detail" method="post">
	      <input type="hidden" name="itemId" value="${itemId}">
	      <input type="submit" name="button" value="商品詳細へ戻る">
		</form>
		<form style="margin-top:20px;" action="item-delete" method="post">
      		<input type="hidden" name="itemDeleteCofirm" value="true">	
	        <input type="hidden" name="itemId" value="${itemId}">
		    <input type="submit" value="商品削除確定">
		</form>	
	</div>
</body>
</html>

