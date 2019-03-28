<style>
#navbar {
	overflow: hidden;
	background-color: #f1f1f1;
	padding: 10px 10px;
	transition: 0.4s;
	position: fixed;
	width: 100%;
	top: 0;
	z-index: 99;
}

#navbar a {
	float: left;
	color: black;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 18px;
	line-height: 10px;
	border-radius: 4px;
}

#navbar #logo {
	font-size: 35px;
	font-weight: bold;
	transition: 0.4s;
}

#navbar a:hover {
	background-color: #ddd;
	color: black;
}

#navbar a.active {
	background-color: dodgerblue;
	color: white;
}

#navbar-right {
	float: right;
}

@media screen and (max-width: 580px) {
	#navbar {
		padding: 10px 10px !important;
	}
	#navbar a {
		float: none;
		display: block;
		text-align: left;
	}
	#navbar-right {
		float: none;
	}
}
</style>
<div id="navbar">
	<a href="#default" id="logo">Harvest basket</a>
	<div id="navbar-left">
		<a href="home"><i class="fa fa-fw fa-home"></i> Home</a> <a
			href="aboutus"><i class="fa fa-fw fa-search"></i> About</a> <a
			href="contactus"><i class="fa fa-fw fa-envelope"></i> Contact</a> <a
			href="category"><i class="glyphicon glyphicon-shopping-cart"></i>
			Category</a> <a
			href="product"><i class="glyphicon glyphicon-shopping-cart"></i>
			product</a>
            
		<ul class="navbar-nav navbar-right">
			<li><a href="register"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</div>

</div>
<script>
	window.onscroll = function() {
		scrollFunction()
	};

	function scrollFunction() {
		if (document.body.scrollTop > 80
				|| document.documentElement.scrollTop > 80) {
			document.getElementById("navbar").style.padding = "3px 10px";
			document.getElementById("logo").style.fontSize = "25px";
		} else {
			document.getElementById("navbar").style.padding = "20px 10px";
			document.getElementById("logo").style.fontSize = "35px";
		}
	}
</script>

