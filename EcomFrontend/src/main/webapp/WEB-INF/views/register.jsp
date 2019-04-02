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
<form:form action="adduser" modelAttribute="userobject">
	<div class="modal-content">
		<div class="row" style="margin-top: 70px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<fieldset>
					<h2>Sign Up</h2>
					<hr class="colorgraph">

					<div class="form-group">
						Name:
						<form: input type="Name" name="Name" id="name"
							class="form-control input-lg" placeholder="Enter your Name"
							path="cname" />
					</div>
					<div class="form-group">
						Email:
						<form: input type="email" name="email" id="email"
							class="form-control input-lg" placeholder="Email Address"
							path="emailid" />
					</div>
					<div class="form-group">
						Password:
						<form: input type="password" name="password" id="password"
							class="form-control input-lg" placeholder="Password"
							path="password" />
					</div>
					<c:if test="${success}">
						<div class="alert alert-success" role="alert">Inserted
							Successfully</div>
					</c:if>
					<c:if test="${error}">
						<div class="alert alert-danger" role="alert">${message}</div>
					</c:if>

					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<button type="submit" class="registerbtn">SUBMIT</button>
						</div>
</form:form>
<div class="col-xs-6 col-sm-6 col-md-6">
	<a href="seller" class="btn btn-lg btn-primary btn-block">SELLER
		REGISTER</a>
	</fieldset>
	<script>
		$(function() {
			$('.button-checkbox')
					.each(
							function() {
								var $widget = $(this), $button = $widget
										.find('button'), $checkbox = $widget
										.find('input:checkbox'), color = $button
										.data('color'), settings = {
									on : {
										icon : 'glyphicon glyphicon-check'
									},
									off : {
										icon : 'glyphicon glyphicon-unchecked'
									}
								};

								$button.on('click', function() {
									$checkbox.prop('checked', !$checkbox
											.is(':checked'));
									$checkbox.triggerHandler('change');
									updateDisplay();
								});

								$checkbox.on('change', function() {
									updateDisplay();
								});

								function updateDisplay() {
									var isChecked = $checkbox.is(':checked');
									// Set the button's state
									$button.data('state', (isChecked) ? "on"
											: "off");

									// Set the button's icon
									$button
											.find('.state-icon')
											.removeClass()
											.addClass(
													'state-icon '
															+ settings[$button
																	.data('state')].icon);

									// Update the button's color
									if (isChecked) {
										$button.removeClass('btn-default')
												.addClass(
														'btn-' + color
																+ ' active');
									} else {
										$button.removeClass(
												'btn-' + color + ' active')
												.addClass('btn-default');
									}
								}
								function init() {
									updateDisplay();
									// Inject the icon if applicable
									if ($button.find('.state-icon').length == 0) {
										$button.prepend('<i class="state-icon '
												+ settings[$button
														.data('state')].icon
												+ '"></i> ');
									}
								}
								init();
							});
		});
	</script>