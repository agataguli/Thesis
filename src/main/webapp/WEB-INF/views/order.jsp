<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>order</title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>
        <script type="text/javascript" src="../resources/js/controllers.js"></script>
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
                    <h1>Order</hi>
                </div>
            </div>

        </section>
        <section class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <h3>${order.orderId}</h3>
                        <p>For user with ID: ${order.userId}</p>
                        <p>Status: ${order.status}</p>
                        <p>Date: ${order.date}</p>
                        <p>Gross value: ${order.orderGrossValue}</p>
                        <div></div>
                        <div>
                            <a href="<spring:url value="/order/items/getProductsForOrder/${order.orderId}" />" class="btn btn-warning btn-large">
                                <span class="glyphicon-shopping-product glyphicon"></span> Go to ordered products
                            </a>
                        </div>
                        <div></div>
                        <div>
                            <a href="<spring:url value="/orders/changeStatus/DONE/${order.orderId}" />" class="btn btn-warning btn-large">
                                <span class="glyphicon-shopping-product glyphicon"></span> Change status to DONE
                            </a>
                        </div>
                        <div></div>
                        <div>
                            <a href="<spring:url value="/orders/changeStatus/CANCELLED/${order.orderId}" />" class="btn btn-warning btn-large">
                                <span class="glyphicon-shopping-product glyphicon"></span> Change status to CANCELLED
                            </a>
                        </div>
                        <div></div>
                        <div>
                            <a href="<spring:url value="/users/user?id=${order.userId}" />" class="btn btn-warning btn-large">
                                <span class="glyphicon-shopping-product glyphicon"></span> Go to clients details
                            </a>
                        </div>
                </div>
            </div>
        </section>
    </body>
</html>
</html>