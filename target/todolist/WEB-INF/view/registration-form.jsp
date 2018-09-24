<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>To Do List App - Register form</title>
		
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
			<h2>Register</h2>
	
				<form:form action="${pageContext.request.contextPath}/processRegistrationForm" modelAttribute="todoListUser" method="post">
					<div class="form-group">
				        <div class="col-md-12">
				            <div>	
				            	<c:if test="${registrationError != null}">
									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										${registrationError}
									</div>
								</c:if>			
				            </div>
				        </div>
				    </div>
					<hr>
					<div class="input-group">
						<form:input path="username" placeholder="username" class="form-control"/>
					</div>

					<div class="input-group">
						<form:password path="password" placeholder="password" class="form-control" />
					</div>

					<div class="form-group">						
						<div class="col-md-12 controls">
							<button type="submit" class="btn btn-success">Register now</button>
						</div>
					</div>
				</form:form>
				<div>
					<a href="${pageContext.request.contextPath}/showLoginForm">Sign in</a>
				</div>
		</div>
	</body>
</html>