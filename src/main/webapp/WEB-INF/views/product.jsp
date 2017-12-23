<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>product</title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>
        <script type="text/javascript" src="../resources/js/controllers.js"></script>
    </head>
    <body>
    <section>
                <p>
                    <a href="<spring:url value="/" />" class="btn btndefault">
                        <span class="glyphicon-hand-left glyphicon"></span> Back
                    </a>
                </p>
                </section>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Product</hi>
                </div>
            </div>

        </section>
        <section class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <h3>${product.brand}</h3>
                    <h2>${product.name}</h2>
                    <p><strong>description: </strong>${product.description}</p>
                    <p><strong>available: </strong>${product.available}</p>
                    <p><strong>category: </strong>${product.category}</p>
                    <h3><strong>quantity: </strong>${product.quantity}</h3>
                    <a href="<spring:url value="/products/changeAvailability?id=${product.productId}" />" class="btn btn-warning btn-large">
                        <span class="glyphicon-shopping-productt glyphicon"></span> Change availability
                    </a>
                </div>
            </div>
        </section>
    </body>
</html>