alert(1);
//模块
var myApp = angular.module('myApp', ['ngRoute']);
//配置路由
myApp.config(['$routeProvider', function ($routeProvider) {
    alert(2);
    $routeProvider
        .when('/', {template: '这是首页页面'})
        .when('/computers', {templateUrl: 'js/myUsers_Form.html'})
        .when('/printers', {templateUrl: 'js/myUsers_List.html'})
        .when('/blabla', {template: '这是其他页面'});
}]);
//控制器
myApp.controller('userCtrl', function ($scope) {
    alert(3);
    $scope.fName = '';
    $scope.lName = '';
    $scope.passw1 = '';
    $scope.passw2 = '';
    $scope.users = [
        {id: 1, fName: 'Hege', lName: "Pege"},
        {id: 2, fName: 'Kim', lName: "Pim"},
        {id: 3, fName: 'Sal', lName: "Smith"},
        {id: 4, fName: 'Jack', lName: "Jones"},
        {id: 5, fName: 'John', lName: "Doe"},
        {id: 6, fName: 'Wang', lName: "Loen"}
    ];
    $scope.edit = true;
    $scope.error = false;
    $scope.incomplete = false;
    $scope.editUser = function (id) {
        if (id == 'new') {
            $scope.edit = true;
            $scope.incomplete = true;
            $scope.fName = '';
            $scope.lName = '';
        } else {
            $scope.edit = false;
            $scope.fName = $scope.users[id - 1].fName;
            $scope.lName = $scope.users[id - 1].lName;
        }
    };

    $scope.$watch('passw1', function () {
        $scope.test();
    });
    $scope.$watch('passw2', function () {
        $scope.test();
    });
    $scope.$watch('fName', function () {
        $scope.test();
    });
    $scope.$watch('lName', function () {
        $scope.test();
    });

    $scope.test = function () {
        if ($scope.passw1 !== $scope.passw2) {
            $scope.error = true;
        } else {
            $scope.error = false;
        }
        $scope.incomplete = false;
        if ($scope.edit && (!$scope.fName.length ||
            !$scope.lName.length ||
            !$scope.passw1.length || !$scope.passw2.length)) {
            $scope.incomplete = true;
        }
    };
})
alert(4);
