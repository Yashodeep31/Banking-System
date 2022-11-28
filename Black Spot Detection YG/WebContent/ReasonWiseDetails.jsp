<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="com.blackspotdetection.data.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<html>
<head>
<title>View City Wise Report</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
</head>
<style>
<!--
body {
        background:url('\images/po.jpg');
    }
.brand a{
font-size:25px;

}
table{
border-collapse:collapse;
border-spacing:0;
width:100%;
border:2px solid #ddd;
margin-top:50px;
margin-left:20px;
}
th,td{
    text-align:left;
    border:1px;
    padding:20px;
    }
.    
-->
</style>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">

    <a href="LoginStationView.html" class="logo">
         POLICE STATION
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->

<div class="nav notify-row" id="top_menu">
    <!--  notification start -->
    <ul class="nav top-menu">
        <!-- settings start -->
        <li class="dropdown">
           
            <ul class="dropdown-menu extended tasks-bar">
                <li>
                   
                </li>
                <li>
                    <a href="#">
                        
                    </a>
                </li>
                <li>
                    <a href="#">
                       
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="task-info clearfix">
                            
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                       
                    </a>
                </li>

                <li class="external">
                   
                </li>
            </ul>
        </li>
        <!-- settings end -->
        <!-- inbox dropdown start-->
        <li id="header_inbox_bar" class="dropdown">
           
            <ul class="dropdown-menu extended inbox">
                <li>
                   
                </li>
                <li>
                    <a href="#">
                        
                    </a>
                </li>
               
                <li>
                    
                </li>
                <li>
                   
                </li>
            </ul>
        </li>
        <!-- inbox dropdown end -->
        <!-- notification dropdown start-->
        <li id="header_notification_bar" class="dropdown">
           
           
        </li>
        <!-- notification dropdown end -->
    </ul>
    <!--  notification end -->
</div>
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
       
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside>
   <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="LoginStationView.html">
                        <i class="fa fa-bank"></i>
                        <span>Login</span>
                    </a>
                    <ul class="sub">
						<li><a href="AddBlackSpot.jsp">Add Black Spot </a></li>
						<li><a href="ViewSpot.jsp">View Black Spot</a></li>
                        <li><a href="DeleteSpotAdmin.html">Delete Black Spot</a></li>
                    </ul>
                </li>
                <li>
                    <a class="active" href="index.html">
                        <i class="fa fa-edit"></i>
                        <span>Generate Black Spot Report</span>
                   </a>
                   <ul class="sub">
						<li><a href="ZoneWise.jsp">Zone Wise Report</a></li>
						<li><a href="ReasonWise.jsp">Reason Wise Spots Report</a></li>
						<li><a href="CityWise.jsp">City Wise Spots Report</a></li>
						
                   </ul>
                </li>
               
                
                
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
  <div class="panel panel-default">
    <div class="panel-heading">
      View Reason Wise Report
    </div>
   
      <div class="col-sm-4">
      </div>
      <div class="col-sm-3">
        <div class="input-group">
         
        </div>
      </div>
    </div>
    <div class="table-responsive">
     
     <div style ="overflow-x:auto;">   
                            <center><table>
                              
							
								<tr>
								  <th>Id</th>
								  <th>LATITUDE</th>
								  <th>LONGITUDE</th>
								  <th>LOCATION</th>
								  <th>ADDRESS</th>
								  <th>REASON</th>
								  <th>LEVEL</th>
								  <th>CITY</th>
								  <th>TYPE</th>
								  <th>Action</th>
								</tr>
                              <%
								Connection con = ConnectDB.connect();
                                String type =request.getParameter("type");
                                try
                                {
								PreparedStatement ps1 = con.prepareStatement("select * from addspot where type=?");
								ps1.setString(1,type);
								ResultSet rs1 = ps1.executeQuery();
								while(rs1.next())
								{
                              %>	
                                <tr>
                                <td><%=rs1.getInt(1) %> </td>
                                <td><%=rs1.getInt(2) %> </td>
                                <td><%=rs1.getInt(3) %> </td>
                                <td><%=rs1.getString(4) %> </td>
                                <td><%=rs1.getString(5)%></td>
                                <td><%=rs1.getString(6) %> </td>
                                <td><%=rs1.getInt(7)%> </td>  
                                <td><%=rs1.getString(8)%> </td>  
                                 <td><%=rs1.getString(9)%> </td>  
                                <td><a href="DeleteStationReason.jsp?id=<%=rs1.getInt("id")%>">Delete</a> </td> 
                                
                                                            
       
                               
										
           <%
								}
						}
                        catch(Exception e)
                        {
                        	e.printStackTrace();
                        }

           %>
				 </table></center>
                 </div>				
   
     
    </div>
    <footer class="panel-footer">
      
    </footer>
  </div>
</div>
</section>
 <!-- footer -->
		  <div class="footer">
			<div class="wthree-copyright">
			  <p>All rights reserved | Design by Yashodeep Patil</p>
			</div>
		  </div>
  <!-- / footer -->
</section>

<!--main content end-->
</section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>
