/**
 * Created by manifest on 3/19/15.
 */
var app = angular.module('Blog', ['ui.router']);

app.controller('PostsController', ['$scope', '$http', function ($scope, $http) {
    $scope.hello = 'world';
    $scope.posts = [];
    //var host = '/Manifest-blog';
    $http.get('post.json')
        .success(function (data) {
            $scope.posts = data;
        })
        .error(function () {
            alert('problem getting posts');
        })
}]);

app.controller('PostController', function ($scope, $stateParams, $http) {
    $scope.post = [];
    console.log($stateParams.postId);
    var url = 'post/' + $stateParams.postId;
    $http.get(url + '.json')
        .success(function(data) {
            $scope.post = data;
        })
        .error(function(){
            alert('there was a problem getting the post')
        });

    $http.get(url+'/comments.json')
        .success(function(data){
            $scope.comments = data;
        })
        .error()
});

app.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('blog', {
            url: '/blog/:postId',
            templateUrl: 'blog.html',
            controller: 'PostController'
        })
        .state('home', {
            url: '/',
            templateUrl: 'content.html',
            controller: 'PostsController'
        });

    $urlRouterProvider.otherwise('/');
});