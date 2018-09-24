<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>To Do List App - Login form</title>
		
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
			.input-group {
				margin-bottom: 25px;
			}
			.btn {
				width: 200px;
			}
			
		</style>
	</head>
	<body>
	
		<div class="container" id="homePageContainer">
			<h1>To Do List App</h1>
			<h4 class="text-muted">Get your tasks done</h4>
	
				<form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
					<div class="form-group">
				        <div class="col-md-12">
				            <div>				
								<c:if test="${param.error != null}">
									<div class="alert alert-danger <!-- col-xs-offset-1 --> col-sm-12">
										Invalid username or/and password.
									</div>
								</c:if>
			
								<c:if test="${param.logout != null}">
									<div class="alert alert-success  col-sm-12">
										You have been logged out.
									</div>
								</c:if>
				            </div>
				        </div>
				    </div>
					<hr>
					<div class="input-group">
						<input type="text" name="username" placeholder="username" class="form-control">
					</div>

					<div class="input-group">
						<input type="password" name="password" placeholder="password" class="form-control" >
					</div>

					<div class="form-group">						
						<div class="col-md-12 controls">
							<button type="submit" class="btn btn-success">Login</button>
						</div>
					</div>
		
					<input type="hidden"
						   name="${_csrf.parameterName}"
						   value="${_csrf.token}" />
				</form>
				<div>
					<a href="${pageContext.request.contextPath}/showRegistrationForm" 
					 id="registerButton">Register New User</a>
				</div>
		</div>
	</body>
</html>