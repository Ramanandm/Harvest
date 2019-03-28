<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

.modal-content {
	background-color: #fefefe;
	margin: 10% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<h3>Product Adding form</h3>
	<div class="modal-content">
	<c:if test="${success}">
		<div class="alert alert-success" role="alert">transaction
			Successful</div>
	</c:if>
	<c:if test="${error}">
		<div class="alert alert-danger" role="alert">${message}</div>
	</c:if>
	<c:if test="${!editmode}">
		<h1 class="title">Product</h1>
		<c:set var="action" value="addproduct"></c:set>
	</c:if>
	<c:if test="${editmode}">
		<h1 class="title">Edit Product</h1>
		<c:set var="action" value="updateproduct"></c:set>
	</c:if>
	
		<form:form action="${action}" modelAttribute="proobject">
			<label for="name">product Name</label>
			<form:input type="text" id="pname" name="productname"
				placeholder="Product name.." path="productname" />

			<label for="Price">product Price</label>
			<form:input type="text" id="pname" name="name"
				placeholder="Product price.." path="productprice" />


			<label for="subject">Product details</label>
			<form:textarea id="subject" name="subject"
				placeholder="Write something.." style="height:100px"
				path="productdec" />

			<label for="stock">Avalable stock</label>
			<form:input type="text" id="lname" name="lastname"
				placeholder="Avalable stock.." path="productstock" />

			<label for="category">category</label>
			<form:select class="form-control" path="productcategory.categid">
				<c:forEach items="${categelist}" var="cat">
					<form:option value="${cat.categid}">${cat.categname}</form:option>
				</c:forEach>
			</form:select>
			<label for="Seller">Seller name</label>
			<form:select class="form-control" path="productseller.sid">
				<c:forEach items="${selllist}" var="sell">
					<form:option value="${sell.sid}">${sell.sname}</form:option>
				</c:forEach>
			</form:select>			
			<input type="submit" value="Submit">
		</form:form>
	</div>
	<div class="modal-content">
		<table align="center">
			<style>
table, th, td {
	border: 1px solid black;
}
</style>
			<thead>
				<tr>
					<th>PRODUCT ID</th>
					<th>PRODUCT NAME</th>
					<th>PRODUCT PRICE</th>
					<th>PRODUCT DESCRIPTION</th>
					<th>PRODUCT STOCK</th>
					<th>PRODUCT CATEGORY</th>
					<th>PRODUCT SELLER</th>
					<th>edit delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productlist}" var="pro">
					<tr>
						<td>${pro.productid}</td>
						<td>${pro.productname}</td>
						<td>${pro.productprice}</td>
						<td>${pro.productdec}</td>
						<td>${pro.productstock}</td>
						<td>${pro.productcategory.categname}</td>
						<td>${pro.productseller.sname}</td>
						<td class="text-center"><a class='btn btn-info btn-xs'
					href="editproduct?productid=${pro.productid}"><span
						class="glyphicon glyphicon-edit"></span> Edit</a> <a
					href="deleteproduct?productid=${pro.productid}"
					class="btn btn-danger btn-xs"><span
						class="glyphicon glyphicon-remove"></span> Del</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>