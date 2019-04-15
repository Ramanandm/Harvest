<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>harvest basket</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div style="min-height: 700px;">
		<c:if test="${sliderPage}">
			<jsp:include page="slider.jsp" />
		</c:if>

		<c:if test="${contactusPage}">
			<jsp:include page="contactus.jsp" />
		</c:if>


		<c:if test="${aboutusPage}">
			<jsp:include page="aboutus.jsp" />
		</c:if>
		<c:if test="${loginPage}">
			<jsp:include page="login.jsp" />
		</c:if>
		<c:if test="${registerPage}">
			<jsp:include page="register.jsp" />
		</c:if>
		<c:if test="${categoryPage}">
			<jsp:include page="category.jsp" />
		</c:if>
		<c:if test="${sellerPage}">
			<jsp:include page="seller.jsp" />
		</c:if>
		<c:if test="${productPage}">
			<jsp:include page="product.jsp"/>
		</c:if>
		<c:if test="${viewproductPage}">
			<jsp:include page="viewproduct.jsp"/>
		</c:if>
		<c:if test="${oneproductpage}">
			<jsp:include page="oneproduct.jsp"/>
		</c:if>
		<c:if test="${addtocartPage}">
			<jsp:include page="addtocart.jsp"/>
		</c:if>
		<c:if test="${addressPage}">
			<jsp:include page="address.jsp"/>
		</c:if>
		<c:if test="${orderPage}">
			<jsp:include page="order.jsp"/>
		</c:if>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>