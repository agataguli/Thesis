<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>
        <script type="text/javascript" src="../resources/js/controllers.js"></script>
        <title>products</title>
    </head>
    <body>
    <section>
            <p>
                <a href="<spring:url value="/" />" class="btn btndefault">
                    <span class="glyphicon-hand-left glyphicon"></span> Back
                </a>
            </p>
            <p>
                <a href="<spring:url value="/products/add" />" class="btn btndefault">
                    <span class="glyphicon-hand-right glyphicon"></span> Short adding products
                </a>
            </p>
            </section>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>PRODUCTS</hi>
                </div>
            </div>
        </section>

        <section class="container">
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${product.category}</h3>
                                <h4>${product.name}</h4>
                                <p>${product.description}</p>
                                <p>available: ${product.available}</p>
                                <p>
                                    <a href=" <spring:url value="/products/product?id=${product.productId}" /> " class="btn btn-primary">
                                    <span class="glyphicon-info-sign glyphicon"/></span> Details
                                    </a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </body>
</html>