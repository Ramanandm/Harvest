<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style>
.thumbnail {
	height: 200;
	width: 350;
	color: #15cdc7;
}

.label {
	display: block;
	width: 320px;
	word-break: break-all;
	background-color: #15cdc7;
	font-color:#6C3483;
}

.btn {
	background-color: #15cdc7;
	color:#6C3483;
}

.list-group {
	margin: 90px ;
	float: left;
	padding-top: 20px;
}

.lead {
	margin: 30%;
	left: 0;
	right: 0;
	padding-top: 30%;
}
.img-responsive
{
height: 80;
width: 80;
}
</style>
<div class="row">
<!-- side nav bar -->
	<div class="col-md-2 col-sm-2 col-xs-12">
		<div class="list-group">
			<a href="${cr}/viewproduct" class="list-group-item">All Category</a>
			<c:forEach items="${categelist}" var="c">
				<a class="list-group-item"
					href="${cr}/selectbycat?catid=${c.categid}">${c.categname}</a>
			</c:forEach>
		</div>
	</div>
<!-- product grid -->
	<div class="col-md-10 col-sm-2 col-xs-12">
		<c:forEach var="l" items="${productlist}">
			<div class="col-sm-4 col-md-4">
				<div class="thumbnail">
					<h4 class="text-center">
						<span class="label " style="word-wrap: break-word;">${l.productname}</span>
					</h4>
					<img src="${cr}/resources/productimages/${l.productid}.jpeg"class="img-responsive">
					<div class="caption">
						<div class="row">
							<div class="col-md-6">
								<h4 class="text-center">&#8377 ${l.productprice} /-</h4>
							</div>
							<div class="col-md-6">
								<a href="${cr}/oneproduct?productid=${l.productid}" class="btn"><span
									class="glyphicon glyphicon-info-sign"></span> Info</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>