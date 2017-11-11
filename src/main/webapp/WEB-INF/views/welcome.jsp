<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
            <title>Feel the luxury!</title>
        </head>
        <body>
            <section>
                <div class="jumbotron">
                    <div class="container">
                        <h1> ${appName} </h1>
                        <p> ${tagline} </p>
                    </div>
                </div>
                <div>
                    <a href="<spring:url value="/products/all" />" class="btn btndefault">
                        <span class="glyphicon-hand-left glyphicon"></span> Products
                    </a>
                    <a href="<spring:url value="/users/all" />" class="btn btndefault">
                        <span class="glyphicon-hand-left glyphicon"></span> Users
                    </a>
                    <a href="<spring:url value="/admins/all" />" class="btn btndefault">
                        <span class="glyphicon-hand-left glyphicon"></span> Admins
                    </a>
                    <a href="<spring:url value="/delivery/add" />" class="btn btndefault">
                        <span class="glyphicon-hand-left glyphicon"></span> Insert delivery
                    </a>
                </div>
            </section>
        </body>
    </html>
