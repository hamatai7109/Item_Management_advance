<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
	<div style="text-align : center; padding-top: 50px;">
		<h1>商品詳細</h1>
	    <c:if test="${not empty requestScope.errorMessage}">
	        <p style="color: red">${requestScope.errorMessage}</p>
	    </c:if>
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
	        <c:forEach var="item" items="${items}">
	        <tr>
	          <td>${item.getItemId()}</td>
	          <td>${item.getItemName()}</td>
	          <td>${item.getMakerName()}</td>
	          <td>${item.getPrice()}</td>
	          <td>${item.getStock()}</td>
	          <td>${item.getInsertDatetime()}</td>
	          <td>${item.getUpdateDatetime()}</td>	          
	          <td>
		          <form action="item-stock" method="post">
        		    <input type="hidden" name="itemId" value="${item.getItemId()}">
		          	<input type="submit"value="在庫修正">
		          </form>
	          </td>
	          <td>
		          <form action="item-edit" method="post">
        		    <input type="hidden" name="itemId" value="${item.getItemId()}">
		          	<input type="submit"value="商品修正">
		          </form>
	          </td>
	          <td>
		          <form action="item-delete" method="post">
       		        <input type="hidden" name="itemId" value="${item.getItemId()}">
		          	<input type="submit"value="商品削除">
		          </form>
	          </td>
	        </tr>
        </c:forEach>
		</table>
		<form style="margin-top:20px;" action="item-list" method="post">
		    <input type="submit" value="商品一覧へもどる">
		</form>	
	</div>
</body>
</html>

