//模块
var ngApp = angular.module('myApp', []);
//服务
ngApp.service('myService1', function () {
    this.sx1 = '{name: 123, age: 12}';
});
//控制器
ngApp.controller('myCtll', function ($scope, $rootScope, $location, myService1, $http) {
    $scope.carname = "liuhailong";
    $scope.names = [{name: 'zhangsan', country: '12'}, {name: 'lisi', country: '18'}, {
        name: 'wangwu',
        country: '223'
    }];
    $scope.carname = $location.absUrl();
    $scope.carname = myService1.sx1;
    $http.post("ag/testJson").success(function (response) {
        $scope.namess = angular.fromJson(response.jsonStr);
    });
    $scope.master = {firstName: 'John', lastName: 'Doe'};
    $scope.reset = function () {
        $scope.user = angular.copy($scope.master);
    };
    $scope.reset();
});

function liShow(t) {
    alert(t.innerHTML);
}