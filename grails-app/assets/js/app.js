/**
 * Created by manifest on 3/19/15.
 */
var app = angular.module('Blog', ['ui.router', 'angularModalService']);

app.controller("ModalController", function ($scope, close, $http) {
    $scope.dismissModal = function (result) {
        close(result, 200);
    }
    $scope.saveNewPost = function () {
        var url = "post";
        var data = $scope.post;
        $http.post(url, data)
            .success(function(data){
                close(data)
            })
    }
});

app.constroller("LoginController", function($http){
    $scope.loggedIn = false;

    $scope.doLogin = function(data) {
        var url = "api/login";

        $http.post(url, data)
            .success(function(){
                $scope.loggedIn = true
            })
    };
})

app.controller('PostsController', ['$scope', '$http', 'ModalService', function ($scope, $http, ModalService) {
    $scope.loggedIn = false;

    $scope.doLogin = function(data) {
        var url = "api/login";

        $http.post(url, data)
            .success(function(){
                $scope.loggedIn = true
            })
    };

    $http.get('post')
        .success(function (data) {
            $scope.posts = data;
        })
        .error(function () {
            alert('problem getting posts');
        });

    $scope.addPost = function () {
        ModalService.showModal({
            templateUrl: "addBlog.html",
            controller: "ModalController"
        }).then(function (modal) {
            //it's a bootstrap element, use 'modal' to show it
            modal.element.modal();
            modal.close.then(function (data) {
                $scope.posts.unshift(data);

            });

        })


    };


    $scope.search = function (query) {
        var c = JSON.stringify(query);
        $http({
            method: "get",
            url: 'post/search',
            params: {query: query}
        }).success(function (data) {
            $scope.searchOrContent = false
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

app.directive('content')

app.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('blog', {
            url: '/blog/:postId/:slug',
            templateUrl: 'blog.html',
            controller: 'PostController'
        });


    $urlRouterProvider.otherwise('/');
});