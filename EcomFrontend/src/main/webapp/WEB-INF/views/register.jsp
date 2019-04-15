<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style>
.colorgraph {
	height: 5px;
	border-top: 0;
	background: #c4e17f;
	border-radius: 5px;
	background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
}

.modal-content {
	font: italic bold 20px/30px Georgia, serif;
	background-color: #fefefe;
	margin: 10% auto 5% auto;
	border: 1px solid #888;
	width: 90%;
}
</style>
<div class="modal-content">
	<div class="row" style="margin-top: 70px">

		<form:form action="adduser" modelAttribute="userobject">

			<div
				class="col-xs-12 col-sm-8  col-sm-offset-2 col-md-offset-3">
				<fieldset>
					<h2>Sign Up</h2>
					<hr class="colorgraph">

					<div class="form-group">
						Name:
						<form:input type="text" name="Name" id="name"
							class="form-control input-lg" placeholder="Enter your Name"
							path="cname" />
						<form:errors path="cname" cssStyle="color:Red"></form:errors>

					</div>
					<div class="form-group">
						phno:
						<form:input type="text" name="Name" id="name"
							class="form-control input-lg" placeholder="Enter your Name"
							path="cphno" />
						<form:errors path="cphno" cssStyle="color:Red"></form:errors>

					</div>
					<div class="form-group">
						Email:
						<form:input type="text" name="email" id="email"
							class="form-control input-lg" placeholder="Email Address"
							path="emailid" />
						<form:errors path="emailid" cssStyle="color:Red"></form:errors>
					</div>
					<div class="form-group">
						Password:
						<form:input type="password" name="password" id="password"
							class="form-control input-lg" placeholder="Password"
							path="password" />
						<form:errors path="password" cssStyle="color:Red"></form:errors>
					</div>
					<c:if test="${Success}">
						<div class="alert alert-success">
							<strong>Success!</strong> Your account is successfully created...
						</div>
					</c:if>
					<c:if test="${Error1}">
						<div class="alert alert-danger">
							<strong>Danger!</strong> Contact your administrator...
						</div>
					</c:if>
					<c:if test="${Error2}">
						<div class="alert alert-warning">
							<strong>Warning</strong> User already exists...
						</div>
					</c:if>
					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<button type="submit" class="registerbtn">SUBMIT</button>
						</div>
		</form:form>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<a href="${cr}/sellerregister" class="btn btn-lg btn-primary btn-block">SELLER
				REGISTER</a>
			</fieldset>