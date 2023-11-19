<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.entity.MakerBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録フォーム</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<div style="text-align: center;">
	<h1>商品登録フォーム</h1>
	<%-- 商品登録に失敗したときのメッセージ --%>
	<c:if test="${not empty requestScope.errorMessage}">
	    <p style="color: red">${requestScope.errorMessage}</p>
	</c:if>
	<form action="item-register" method="post" style="display: flex; flex-direction: column; gap: 10px;">
		<div>
			<label>商品名:
				<input type="text" name="itemName" required>	
			</label>
		</div>
		<div>
			<label>メーカー:
				<select name="makerName" required>
					<c:forEach var="maker" items="${makers}">
					    <option value="<c:out value="${maker.getMakerCode()}" />"><c:out value="${maker.getMakerName()}" /></option>
					</c:forEach>
				</select>
			</label>
		</div>
		<div>
			<label>価格(万円):
				<input type="text" name="price" required>	
			</label>
		</div>
		<div>
			<input type="submit" value="商品登録確定">
		</div>
	</form>
	<form style="margin-top:50px;" action="/item-list" method="post">
      <input type="submit" name="button" value="商品一覧へもどる">
	</form>
</div>
</body>
</html>