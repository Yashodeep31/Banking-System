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
<title>View Station</title>
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
body{
 
     background:url('\images/b.jpg');
  
  
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






</style>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">

    <a href="adminLogin.html" class="logo">
        Admin
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
                    <a class="active" href="#">
                        <i class="fa fa-bank"></i>
                        <span>Police Station</span>
                    </a>
                    <ul class="sub">
						<li><a href="addStation.html">Add Station </a></li>
						<li><a href="ViewStation.jsp">View Station</a></li>
						<li><a href="ViewSpecificStation.jsp">View Specific Station</a></li>
                        <li><a href="DeleteStation.html">Delete Station</a></li>
                    </ul>
                </li>
                <li>
                    <a class="active" href="index.html">
                        <i class="fa fa-edit"></i>
                        <span>View All Spots</span>
                   </a>
                   <ul class="sub">
						<li><a href="generateSpotReport.jsp">Generated Spots Report</a></li>
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
      View Station
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
     
     
     
            <th>ID</th>
            <th>STATION NAME</th>
            <th>ADDRESS</th>
            <th>Contact</th>
            <th>EMAIL</th>
            <th>PASSWORD</th>
            <th>ACTION</th>
            <th style="width:30px;"></th>
   
   </tr>
      
       
       
       
        <%
								
                                Connection con = ConnectDB.connect();
                                try
                                {
								PreparedStatement ps1 = con.prepareStatement("select * from addstation");
								ResultSet rs1 = ps1.executeQuery();
								while(rs1.next())
								{
        %>	
         
          <tr>
                                <td><%=rs1.getInt(1) %> </td>
                                <td><%=rs1.getString(2) %> </td>
                                <td><%=rs1.getString(3)%></td>
                                <td><%=rs1.getString(4) %> </td>
                                <td><%=rs1.getString(5)%> </td>  
                                <td><%=rs1.getString(6)%> </td>  
                                <td><a href="DeleteStation.jsp?id=<%=rs1.getInt("id")%>">Delete</a> </td> 
                                
                                                            
          
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
