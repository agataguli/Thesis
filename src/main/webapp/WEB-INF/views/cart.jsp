<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
        <script type="text/javascript" src="/visageapp/resources/js/controllers.js"></script>
        <title>Cart Example</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>Products in the cart</p>
                </div>
            </div>
        </section>
        <section class="container" ng-app="cartApp">
            <div ng-controller="cartCtrl" nginit="initCartId('${cartId}')">
                <div>
                    <a class="btn btn-danger pull-left" ng-click="clearCart()">
                        <span class="glyphicon glyphicon-remove-sign"></span> Clear Cart!
                    </a>
                    <a href="#" class="btn btn-success pull-right">
                        <span class="glyphicon glyphicon-shopping-cart"></span> Buy it!
                    </a>
                </div>
                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Per item</th>
                        <th>Items numer</th>
                        <th>Gross value [PL]</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat="item in cart.cartItems">
                        <td>{{item.product.productId}}-{{item.product.name}}</td>
                        <td>{{item.product.grossValue}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalMultipliedItemGrossValue}}</td>
                        <td>
                            <a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                                <span class="glaphicon glaphicon-remove"></span>Remove
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Total [PL]</th>
                        <th>{{cart.totalCartItemsGrossValue}}</th>
                        <th></th>
                    </tr>
                </table>
                <a href="<spring:url value="/products/all" />" class="btn btndefault">
                    <span class="glyphicon-hand-left glyphicon"></span> back to products
                </a>
            </div>
        </section>
    </body>
</html>