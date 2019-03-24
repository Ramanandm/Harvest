<style>
{
	font-family: Arial, Helvetica, sans-serif;
}

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
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 10% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
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
</head>

<form class="modal-content animate" action="/action_page.php">
	<div class="container">
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
