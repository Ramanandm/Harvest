<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
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
	width: 90%;
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

	<form:form action="addseller" modelAttribute="sellobject">
		<div class="container">
			<hr>
			<div>
				<label for="seller"><b><font color="red">seller
							name</font></b></label>
				<form:input type="text" placeholder="Enter seller name"
					name="sellername" path="sname" />
			</div>
			<div>
				<label for="seller city"><b><font color="red">seller
							city</font></b></label>
				<form:input type="text" placeholder="Enter seller city"
					name="sellername" path="scity"/>
			</div>
			<div>
				<label for="Email id"><b><font color="red">Email id
						</font></b></label>
				<form:input type="text" placeholder="Enter seller city"
					name="Email id" path="smailid"/>
			</div>
			<div>
				<label for="password"><b><font color="red">password
						</font></b></label>
				<form:input type="password" placeholder="Enter your password"
					name="Email id" path="sellerpassword"/>
			</div>
			
			<div>
				<label for="sdesc"><b><font color="red">seller
							description</font></b></label>
				<form:input type="text" placeholder="Enter category description"
					name="sellerdesc" path="sdesc" />
				<c:if test="${success}">
					<div class="alert alert-success" role="alert">Inserted
						Successfully</div>
				</c:if>
				<c:if test="${error}">
					<div class="alert alert-danger" role="alert">${message}</div>
				</c:if>

			</div>
			<button type="submit" class="registerbtn">SUBMIT</button>
		</div>
	</form:form>
</div>
