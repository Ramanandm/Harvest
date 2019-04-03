<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style>
<style>

body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #0080ff;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 70%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 10% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}


/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 200px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}

</style>
<div class="modal-content animate" align="center">
	<c:if test="${success}">
		<div class="alert alert-success" role="alert">transaction
			Successful</div>
	</c:if>
	<c:if test="${error}">
		<div class="alert alert-danger" role="alert">${message}</div>
	</c:if>

	<c:if test="${!editmode}">
		<h1 class="title">Category</h1>
		<c:set var="action" value="${cr}/admin/addcategory"></c:set>
	</c:if>
	<c:if test="${editmode}">
		<h1 class="title">Edit Category</h1>
		<c:set var="action" value="${cr}/admin/updatecategory"></c:set>
	</c:if>
	<form:form action="${action}" modelAttribute="catobject">
		<c:if test="${editmode}">
			<form:hidden path="categid"/>
		</c:if>
		<label for="category"><b><font color="red">Category
					name</font></b></label>
		<form:input type="text" placeholder="Enter category name"
			name="categoryname" path="categname"/>
	<label for="categdesc"><b><font color="red">Category
				description</font></b></label>
	<form:input type="text" placeholder="Enter category description"
		name="categorydesc" path="categdesc" />
<button type="submit" class="registerbtn">INSERT</button>
</div>
</form:form>
<div class="modal-content animate">
<table align="center">
	<style>
table, th, td {
	border: 1px solid black;
}
</style>
	<thead>
		<tr>
			</style>
			<th>CATEGORY ID</th>
			<th>CATEGORY NAME</th>
			<th>CATEGORY DESCRIPTION</th>
			<th>EDIT DELIT</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categorylist}" var="cat">
			<tr>
				<td>${cat.categid}</td>
				<td>${cat.categname}</td>
				<td>${cat.categdesc}</td>
				<td class="text-center"><a class='btn btn-info btn-xs'
					href="${cr}/admin/editcategory?categname=${cat.categname}"><span
						class="glyphicon glyphicon-edit"></span> Edit</a> <a
					href="${cr}/admin/deletecategory?categname=${cat.categname}"
					class="btn btn-danger btn-xs"><span
						class="glyphicon glyphicon-remove"></span> Del</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>
