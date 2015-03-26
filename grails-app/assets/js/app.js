/**
 * Created by manifest on 3/19/15.
 */
var app = angular.module('Blog', ['ui.router', 'angularModalService']);


app.controller('PostsController', ['$scope', '$http', 'ModalSerice', function ($scope, $http, ModalService) {
    $scope.searchOrContent = true
    $http.get('post')
        .success(function (data) {
            $scope.posts = data;
        })
        .error(function () {
            alert('problem getting posts');
        });

    $scope.search = function (query) {
        var c = JSON.stringify(query);
        $http({
            method: "get",
            url: 'post/search',
            params: {query: query}
        }).success(function (data) {
            $scope.searchOrContent=false
            var d = data;
            $scope.posts = data
        }).error(function () {
            alert("there's a problem with the search")
        })

    }


}]);


app.controller('PostController', function ($scope, $stateParams, $http) {


    var url = 'post/' + $stateParams.postId;
    $http.get(url)
        .success(function (data) {
            $scope.post = data;
            alert('hello world')
        })
        .error(function () {
            alert('there was a problem getting the post')
        });

    $http.get(url + '/comments')
        .success(function (data) {
            $scope.comments = data;
        })
        .error();


    $scope.addComment = function (comment) {

        var c = JSON.stringify(comment);

        $http.post(url + '/comments', c)
            .success(function (data) {
                $scope.comments.unshift(data)

            }).error(function (e) {
                console.log(e.toString() + ' : this error occured')
            })


    }
});

app.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('blog', {
            url: '/blog/:postId/:slug',
            templateUrl: 'blog.html',
            controller: 'PostController'
        })
        .state('search', {
            url: '/search',
            templateUrl: 'search.html',
            controller: 'PostController'
        })
        .state('home', {
            url: '/',
            templateUrl: 'content.html',
            controller: 'PostsController'
        });

    $urlRouterProvider.otherwise('/');
});