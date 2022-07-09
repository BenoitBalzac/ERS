<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Web.Login.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body class = "container">
<div class = "display-1">Login</div>
<hr/>

<div class="row">
    <div class="col-6">
        <div class="card">
            <div class="card-header">Login Form</div>
            <div class="card-body">
                <form action="Login" method="post">
                    <div>
                    <!--<label class="form-label">Username</label>
                        <input name="username" class="form-control"/>-->
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" class="form-control"/>
                    </div>
                    <div>
                   <!-- <label class="form-label">Password</label>
                        <input name="password" class="form-control" type="password"/>  -->
                        <label for="password">Password</label>
                        <input type="text" id="password" name="password" class="form-control" type="password"/>
                    </div>
                    <br/>
                     <%-- <%@include file="Login.jsp" %>--%>
                   
                    <a href="login-request?id=<%=Web.Login.Authorize("username","password")%>"> </a>
                    
                    <button type = "button" onclick=class="btn btn-primary">Sign-In</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>