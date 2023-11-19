<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品編集フォーム</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<div style="text-align: center;">
	<h1>商品編集フォーム</h1>
	<%-- 商品編集に失敗したときのメッセージ --%>
	<c:if test="${not empty requestScope.errorMessage}">
	    <p style="color: red">${requestScope.errorMessage}</p>
	</c:if>
	<form action="item-edit" method="post" style="display: flex; flex-direction: column; gap: 10px;">
		<div>
			<label>商品名:
				<input type="text" name="itemName" required>	
			</label>
		</div>
		<div>
			<label>メーカー:
				<select name="makerCode" required>
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
		    <input type="hidden" name="itemId" value="${itemId}">
			<input type="submit" value="商品編集確定">
		</div>
	</form>	
	<form style="margin-top:20px;" action="item-detail" method="post">
      <input type="hidden" name="itemId" value="${itemId}">
      <input type="submit" name="button" value="詳細画面へもどる">
	</form>
</div>
</body>
</html>