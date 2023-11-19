<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫修正</title>
</head>
<body>
  <jsp:include page="/header.jsp" />
	<div style="text-align: center;">
		<h1>在庫修正</h1>
		<%-- 在庫修正に失敗したときのメッセージ --%>
		<%-- JSTL（JavaServer Pages Standard Tag Library）を使用した場合
		<c:if test="${not empty requestScope.errorMessage}">
	   		<p style="color: red">${requestScope.errorMessage}</p>
		</c:if>
		--%>
		<%-- スクリプトレットを使用した場合 --%>
		<% if (request.getAttribute("errorMessage") != null) { %>
	   		<p style="color: red"><%= request.getAttribute("errorMessage") %></p>
		<% } %>
		<form action="item-stock" method="post">
			<label>入荷:
				<input type="text" name="arrival" required><br>
			</label>
			<label>出荷:
		    	<input type="text" name="shipping"required><br>
			</label>
 		    <input type="hidden" name="itemId" value="${itemId}">
		    <input type="submit" value="在庫修正確定" style="margin-top: 10px;">
		</form>
		<form style="margin-top:20px;" action="item-detail" method="post">
		  <input type="hidden" name="itemId" value="${itemId}">
	      <input type="submit" name="button" value="詳細画面へ">
		</form>
	</div>
</body>
</html>