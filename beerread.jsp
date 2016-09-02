<%@page import="com.beerzoo.DAOBeer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	 <%@ page import ="com.beerzoo.*" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Beer Zoo - List of Beers</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">
</head>
<body background="http://www.pixelstalk.net/wp-content/uploads/2016/06/Solid-colour-wallpaper-color-desktop-fr-wallpaper-solid-blue-desktop-colour-color.jpg">
<nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand"><span class="glyphicon glyphicon-grain"
                    aria-hidden="true"></span>The Beer Zoo</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse"
                id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                        data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false"> Navigation <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="beerread.jsp">Read</a></li>
                            <li><a href="write.html">Add</a></li>
                            <li><a href="updateBeer.html">Update</a></li>
                            <li><a href="beerDelete.html">Delete</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="https://www.beeradvocate.com/beer/101/""
                                target="_blank">Learn about beer!</a></li>
                        </ul></li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                </ul>
                </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <div class="panel panel-primary" align="center">
        <!-- Default panel contents -->
        <div class="panel-heading bg-success" align="left">
            <h2>The Beer Inventory Table</h2>
        </div>
    </div>
	<table class="table table-striped table-bordered" style="width: 75%" background = "https://loftgathering.files.wordpress.com/2015/09/2560x1600-light-gray-solid-color-background.jpg"
		align="center">
		<tr>
			<th>Beer ID</th>
			<th>Name</th>
			<th>Country of Origin</th>
			<th>Style</th>
			<th>Alcohol by Volume</th>
		</tr>
			<%DAOBeer.readFromDB(); %>
							<% 
							
							Beer readToJSP = new Beer();
							
							for (int i=0; i < DAOBeer.ourBeer.size(); i++) { 
							
								readToJSP = DAOBeer.ourBeer.get(i);
										
								%>
							<tr>
								<td><%= readToJSP.getBeerID()%></td>
								<td><%= readToJSP.getName()%></td>
								<td><%= readToJSP.getCountryOfOrigin()%></td>
								<td><%= readToJSP.getStyle()%></td>
								<td><%= readToJSP.getAbv()%></td>
							</tr>
							<% } %>
							<% DAOBeer.ourBeer.clear(); %>
	</table>
</body>
</html>

