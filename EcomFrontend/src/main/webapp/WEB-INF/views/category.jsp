<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
style>body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Full-width input fields */
input[type=text], input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
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

.container {
	padding: 50px;
}

span.psw {
	float: right;
	padding-top: 16px;
}
/* Modal Content/Box */
.modal-content {
	font: italic bold 20px/30px Georgia, serif;
	background-color: #fefefe;
	margin: 10% auto 5% auto;
	border: 1px solid #888;
	width: 90%;
}

.modall-content {
	background-color: #fefefe;
	margin: 5% auto 5% auto;
	border: 1px solid #888;
	width: 90%;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
<div class="modal-content animate">

	<form:form action="addcategory" modelAttribute="catobject">
		<div class="container">
			<hr>
			<div>
				<label for="category"><b><font color="red">Category
							name</font></b></label>
				<form:input type="text" placeholder="Enter category name"
					name="categoryname" path="categname" />
			</div>
			<div>
				<label for="categdesc"><b><font color="red">Category
							description</font></b></label>
				<form:input type="text" placeholder="Enter category description"
					name="categorydesc" path="categdesc" />
				<c:if test="${success}">
					<div class="alert alert-success" role="alert">Inserted
						Successfully</div>
				</c:if>
				<c:if test="${error}">
					<div class="alert alert-danger" role="alert">${message}</div>
				</c:if>

			</div>
			<button type="submit" class="registerbtn">INSERT</button>
		</div>
	</form:form>
</div>
<div class="modall-content">
	<table align="center">
		<thead>
			<tr>
			   <style>    font: italic bold 100px/100px Georgia, serif;</style>
		 
				<th>CATEGORY ID</th>
				<th>CATEGORY NAME</th>
				<th>CATEGORY DESCRIPTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categorylist}" var="cat">
				<tr>
					<td>${cat.categid}</td>
					<td>${cat.categname}</td>
					<td>${cat.categdesc}</td>
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="#" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
