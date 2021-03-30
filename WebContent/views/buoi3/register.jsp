<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>PT15307-UD</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">PT15307-UD</a>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Home</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<div>
		<form
			method="POST"
			action="/PT15307UD/register"
			class="col-6 offset-3">
			<div class="mb-3">
			    <label for="email" class="form-label">Email</label>
			    <input type="email" class="form-control" id="email" name="email"/>
		  	</div>
			<div class="mb-3">
			    <label for="name" class="form-label">Name</label>
			    <input type="text" class="form-control" id="name" name="name" />
		  	</div>
			<div class="mb-3">
			    <label for="number" class="form-label">Number</label>
			    <input type="number" class="form-control" id="number" name="number" />
		  	</div>
			<div class="mb-3">
			    <label for="password" class="form-label">Password</label>
			    <input type="password" class="form-control" id="password" name="password" />
		  	</div>
			<div class="mb-3">
			    <label for="gender" class="form-label">Gender</label>
			  	<select class="form-select" id="gender" name="gender">
				  	<option selected disabled>Giới tính</option>
				  	<option value="1">Nam</option>
				  	<option value="0">Nữ</option>
				</select>
		  	</div>
			<div class="form-check mt-2">
			  	<input class="form-check-input" type="checkbox" value="" checked>
			  	<label class="form-check-label" for="gender">
			    	Nhận thông báo
			  	</label>
			</div>
		  	<button type="submit" class="btn btn-primary mt-3">Submit</button>
		</form>
	</div>
</body>
</html>