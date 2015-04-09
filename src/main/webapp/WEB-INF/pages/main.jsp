<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="CamelTutorial">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Camel Tutorial</title>

    <link href="<c:url value='/webjars/bootstrap/3.3.4/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/webjars/ng-table/0.3.3/ng-table.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/style.css'/>?_=<%=System.currentTimeMillis() %>" rel="stylesheet" type="text/css"/>

</head>

<body>

<div class="container" ng-controller="MainCtrl" ng-cloak>

    <!-- navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Camel Tutorial</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="<c:url value='/monitoring'/>" target="_blank">JavaMelody</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>
    <!-- /navbar -->

    <div class="row">
        <div class="col-lg-10 col-sm-11">

            <table ng-table="geoipTable" class="table table-striped table-hover table-condensed">
                <tr ng-repeat="v in $data">
                    <td style="width:200px" data-title="'Added'" sortable="'added'">{{ v.added | date:'yyyy-MM-dd HH:mm:ss.sss' }}</td>
                    <td style="width:100px" data-title="'IP'" sortable="'ip'">{{ v.ip }}</td>
                    <td style="width:200px" data-title="'Country'" sortable="'country'">{{v.country }}</td>
                    <td data-title="'City'" sortable="'city'">{{v.city }}</td>
                    <td style="width:100px" data-title="'Service'" sortable="'service'">{{v.service }}</td>
                </tr>
            </table>

        </div>
    </div>

</div>

<script src="<c:url value='/webjars/underscorejs/1.8.2/underscore-min.js'/>"></script>
<script src="<c:url value='/webjars/jquery/1.11.1/jquery.min.js'/>"></script>
<script src="<c:url value='/webjars/bootstrap/3.3.4/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/webjars/angularjs/1.3.15/angular.min.js'/>"></script>
<script src="<c:url value='/webjars/angularjs/1.3.15/angular-resource.min.js'/>"></script>
<script src="<c:url value='/webjars/ng-table/0.3.3/ng-table.min.js'/>"></script>

<script src="<c:url value='/js/app/app.js'/>?_=<%=System.currentTimeMillis() %>"></script>

</body>
</html>
