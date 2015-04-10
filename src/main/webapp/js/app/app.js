'use strict';
angular.module('CamelTutorial', ['ngTable', 'ngResource'])
    .controller('MainCtrl', function ($scope, $resource, ngTableParams) {
        $scope.total = 0;

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

                $resource('gateway/data/geoip?_=:timestamp', {timestamp: +new Date})
                    .get(qryParams, function (data) {
                        $scope.isLoading = false;
                        if (!data.success) {
                            $defer.reject();
                        } else {
                            $scope.total = data.total;
                            params.total(data.total);
                            $defer.resolve(data.records);
                        }
                    });
            }
        });

    });
