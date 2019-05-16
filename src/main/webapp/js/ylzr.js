alert(1);
//模块
var ylzrApp = angular.module('ylzrApp', []);
//配置值
ylzrApp.value('defaultInput', 5);
ylzrApp.constant('testConstant', 10);
//配置方法
ylzrApp.factory('MathFun', function () {
    var factory = {};
    factory.js = function (a, b) {
        return a * b;
    }
    return factory;
});
//配置服务
// ylzrApp.service('JsService', function (MathService) {
//     this.dyjs = function (a, b) {
//         return MathService.js(a, b);
//     };
// });
alert(2);
//控制器
ylzrApp.controller('ylzrCtrl', function ($scope, MathFun, defaultInput, testConstant) {
    alert(3);
    $scope.number = testConstant;
    $scope.result = MathFun.js($scope.number, $scope.number);

    $scope.ksjs = function () {
        $scope.result = MathFun.js($scope.number, $scope.number);
    }
});
alert(4);
