/**
 * Created by manifest on 3/19/15.
 */
var app = angular.module('Blog', ['ui.router', 'angularModalService']);

//Controllers
app.controller("LoginController", function ($scope, $http, userInfoService, $window) {
    var store = this;
    store.info = userInfoService;

    $scope.loggedIn = store.info.loggedIn;

    $scope.doLogin = function (data) {
        var url = "api/login";

        $http.post(url, data)
            .success(function (data) {
                store.info.username = data.username;
                $window.sessionStorage.token = data.access_token;

                store.info.loggedIn = true;

                $scope.loggedIn = store.info.loggedIn;

                $scope.message = 'Welcome'
            })
            .error(function () {
                delete $window.sessionStorage.token;

                $scope.message = 'Error: Invalid user or password'
            })
    };

    $scope.doLogout = function () {
        $http.get('api/logout')
            .success(function () {
                $scope.login = false;
                delete $window.sessionStorage.token;
            })
    }

});

app.controller("PostModalController", function ($scope, close, $http, userInfoService) {
    $scope.dismissModal = function (result) {
        close(result);
    };
    $scope.saveNewPost = function () {
        var url = "post";
        var data = $scope.post;
        var uname = userInfoService.username;
        data.author = uname ? uname : "Anonymous";
        $http.post(url, data)
            .success(function (data) {
                close(data)
            })
    }
});

app.controller('PostsController', ['$scope', '$http', 'ModalService', 'userInfoService', function ($scope, $http, ModalService, userInfoService) {



    $scope.loggedIn = userInfoService.loggedIn;

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
            controller: "PostModalController"
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
            $scope.posts = data
        }).error(function () {
            alert("there's a problem with the search")
        })

    }


}]);

app.controller("CommentModalController", function ($scope, close) {
    $scope.dismissModal = function (result) {
        close(result);
    };
    $scope.saveNewComment = function () {
        var data = $scope.comment;
        /*var url = "comment";
         $http.post(url, data)
         .success(function(data){
         close(data)
         })*/
        close(data)
    }
});

app.controller('PostController', function ($scope, $stateParams, $http, ModalService, userInfoService) {

    $scope.loggedIn = userInfoService.loggedIn;

    var url = 'post/' + $stateParams.postId;
    $http.get(url)
        .success(function (data) {
            $scope.post = data;
        })
        .error(function () {
            alert('there was a problem getting the post')
        });

    $http.get(url + '/comments')
        .success(function (data) {
            $scope.comments = data;
        })
        .error();


    $scope.saveComment = function (comment) {

        var c = JSON.stringify(comment);

        $http.post(url + '/comments', c)
            .success(function (data) {
                $scope.comments.unshift(data)

            }).error(function (e) {
                console.log(e.toString() + ' : this error occured')
            })


    };

    $scope.addComment = function () {
        ModalService.showModal({
            templateUrl: "addComment.html",
            controller: "CommentModalController"
        }).then(function (modal) {
            //it's a bootstrap element, use 'modal' to show it
            modal.element.modal();
            modal.close.then(function (data) {
                $scope.saveComment(data);
            });
        })
    };
});

// Application Config
app.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('blog', {
            url: '/blog/:postId/:slug',
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

// Application Services and Providers
app.service('userInfoService', function () {
    userInfo = this;

    userInfo.username = "";
    //userInfo.token = $window.sessionStorage.token? $window.sessionStorage.token : "";
    userInfo.loggedIn = false

});

app.factory('authInterceptor', function ($rootScope, $q, $window) {
    return {
        request: function (config) {
            config.headers = config.headers || {};
            if ($window.sessionStorage.token) {
                config.headers.Authorization = 'Bearer' + $window.sessionStorage.token
            }
            return config;
        },
        response: function (response) {
            if (response.status === 401) {
                //handle response
            }
            return (response || $q.when(response))
        }
    }
});

/*app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor')
});*/