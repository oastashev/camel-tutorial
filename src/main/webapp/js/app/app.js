'use strict';
angular.module('CamelTutorial', ['ngTable', 'ngResource'])
    .factory('gateway', ['$resource', function ($resource) {
        var timestamp = function () {
            return +new Date;
        };
        return {
            geoip: $resource('gateway/data/geoip?_=:timestamp', {timestamp: timestamp})
        }
    }])
    .controller('MainCtrl', function ($scope, ngTableParams, gateway) {

        $scope.geoipTable = new ngTableParams({page: 1, count: 20}, {
            total: 1,
            counts: [],
            getData: function ($defer, params) {
                $scope.isLoading = true;

                var qryParams = _.extend(
                    {
                        pageSize: params.count(),
                        page: params.page()
                    }
                    , _.map(params.sorting(), function (v, k) {
                        return {
                            sortColumn: k,
                            sortOrder: v
                        }
                    })[0]
                );

                gateway.geoip.get(qryParams, function (data) {
                    $scope.isLoading = false;
                    if (!data.success) {
                        $defer.reject();
                    } else {
                        params.total(data.total);
                        $defer.resolve(data.records);
                    }
                });
            }
        });

    });
