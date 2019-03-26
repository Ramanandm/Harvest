<style>
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
.modal-content {
	font: italic bold 20px/30px Georgia, serif;
	background-color: #fefefe;
	margin: 10% auto 5% auto;
	border: 1px solid #888;
	width: 90%;
}
</style>
</head>
<div class="modal-content">
	<div class="container">
 <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
	
		<h1>CONTACT US</h1>
<div class="mapouter"><div class="gmap_canvas"><iframe width="715" height="279" id="gmap_canvas" src="https://maps.google.com/maps?q=NIIT%20Coimbatore%20One%20Centre%2C%20Gandhipuram%2C%20Coimbatore%2C%20Tamil%20Nadu&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>Werbung: <a href="https://www.pureblack.de">Pure Black GmbH</a></div><style>.mapouter{position:relative;text-align:right;height:279px;width:715px;}.gmap_canvas {overflow:hidden;background:none!important;height:279px;width:715px;}</style></div>		
		<p>Please fill in this form to cotactus.</p>
		<hr>
		<label for="name"><b>Name</b></label> <input type="text"
			placeholder="Enter your name" name="Name" required> <label>
			
		<label for="email"><b>Phone number</b></label> <input type="text"
			placeholder="Enter your number" name="Number" required> <label>
			
		<label for="Ph no"><b>Email Id</b></label> <input type="text"
		placeholder="Enter Ph no" name="email id" required> <label>
		
		<label for="subject">Subject</label>
    <textarea id="subject" name="subject" placeholder="Write something.." style="height:100px" ></textarea>
		
			
		</label>

		<p>
			By creating an account you agree to our <a href="#"
				style="color: dodgerblue">Terms & Privacy</a>.
		</p>

		<div class="clearfix">
			<button type="button"
				onclick="document.getElementById('id01').style.display='none'"
				class="cancelbtn">Cancel</button>
			<button type="submit" class="signupbtn">Sumbit</button>
		</div>
	</div>
</form>
</div>
<script>
$(function(){
    $('.button-checkbox').each(function(){
		var $widget = $(this),
			$button = $widget.find('button'),
			$checkbox = $widget.find('input:checkbox'),
			color = $button.data('color'),
			settings = {
					on: {
						icon: 'glyphicon glyphicon-check'
					},
					off: {
						icon: 'glyphicon glyphicon-unchecked'
					}
			};

		$button.on('click', function () {
			$checkbox.prop('checked', !$checkbox.is(':checked'));
			$checkbox.triggerHandler('change');
			updateDisplay();
		});

		$checkbox.on('change', function () {
			updateDisplay();
		});

		function updateDisplay() {
			var isChecked = $checkbox.is(':checked');
			// Set the button's state
			$button.data('state', (isChecked) ? "on" : "off");

			// Set the button's icon
			$button.find('.state-icon')
				.removeClass()
				.addClass('state-icon ' + settings[$button.data('state')].icon);

			// Update the button's color
			if (isChecked) {
				$button
					.removeClass('btn-default')
					.addClass('btn-' + color + ' active');
			}
			else
			{
				$button
					.removeClass('btn-' + color + ' active')
					.addClass('btn-default');
			}
		}
		function init() {
			updateDisplay();
			// Inject the icon if applicable
			if ($button.find('.state-icon').length == 0) {
				$button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
			}
		}
		init();
	});
});
</script>
