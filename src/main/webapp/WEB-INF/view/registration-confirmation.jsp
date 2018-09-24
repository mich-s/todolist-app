<html>
	<head>
		<title>Registration confirmation</title>
		
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		
		<style type="text/css">
			.container {
				text-align: center;
				width:400px;
			}
			#homePageContainer {
				margin-top: 100px;
			}
			.btn {
				width: 200px;
			}
		</style>
	</head>
	
	<body>
		<div class="container" id="homePageContainer">
			<h2>User registered successfully!</h2>
			<div id="back">
				<a href="${pageContext.request.contextPath}/showLoginForm" class="btn btn-default" role="button">Login with new user</a>
			</div>
		</div>
	</body>
</html>