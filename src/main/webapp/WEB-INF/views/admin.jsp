<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>admin admin details</title>
    </head>
    <body>
    <section>
                <p>
                    <a href="<spring:url value="/" />" class="btn btndefault">
                        <span class="glyphicon-hand-left glyphicon"></span> Back to home page
                    </a>
                </p>
                </section>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Admin user</hi>
                </div>
            </div>
        </section>
        <section class="container">
            <div class="row">
                <div class="col-md-5">
                    <h3>Id: ${admin.adminId}</h3>
                    <h4>Available: ${admin.active}</h4>
                    <p><strong>Name: </strong>${admin.name} ${admin.surname}</p>
                    <p><strong>Login: </strong>${admin.login}</p>
                    <p><strong>Contact data: </strong></p>
                    <p>${admin.email}</p>
                    <p>${admin.phoneNumber}</p>
                    </p>
                </div>
            </div>
        </section>
    </body>
</html>