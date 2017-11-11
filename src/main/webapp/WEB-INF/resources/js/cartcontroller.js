//Angular cart module
var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl', function ($scope, $http) {
    $scope.refreshCart = function(cartId) {
        $http.get('/cart/'+$scope.cartId).success(function(data) {
            $scope.cart = data;
        });
    };

    $scope.clearCart = function() {
        $http.delete('/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };


    $scope.initCartId = function(cartId) {
        $scope.cartId=cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function(productId) {
        $http.put('/add/'+productId).success(function(data) {
        $scope.refreshCart($http.get('/cart/get/cartId'));
        alert("Product added to the cart");
        });
    };

    $scope.removeFromCart = function(productId) {
        $http.put('/cart/remove/'+productId).success(function(data) {
            $scope.refreshCart($http.get('/cart/get/cartId'));
        });
    };
});