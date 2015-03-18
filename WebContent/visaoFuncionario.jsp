<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Cliente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>${acessoFuncionario.nome} - In�cio </title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		
		   <!--Load the AJAX API-->
		   <script type="text/javascript" src="https://www.google.com/jsapi"></script>
		    <script type="text/javascript">

		      // Load the Visualization API and the piechart package.
		      google.load('visualization', '1.0', {'packages':['corechart']});

		      // Set a callback to run when the Google Visualization API is loaded.
		      google.setOnLoadCallback(drawChart);

		      // Callback that creates and populates a data table,
		      // instantiates the pie chart, passes in the data and
		      // draws it.
		      var solicitadas = parseInt('${listasSolicitadas}');
		        var atendidas = parseInt('${listasAtendidas}');
		      

		      function drawChart() {

		        // Create the data table.
		        var data = new google.visualization.DataTable();
		        
		        data.addColumn('string', 'Topping');
		        data.addColumn('number', 'Slices');
		        data.addRows([
		          ['Listas Solicitadas', solicitadas],
		          ['Listas Atendidas', atendidas],
		          
		        ]);

		        // Set chart options
		        var options = {'title':'Gr�fico de Atividades',
		                       'width':700,
		                       'height':500,
		                       'chartArea':{left:120,top:80},
		                       'backgroundColor':'#f3f3f3',
		                       'is3D':'true',
		                       'titleTextStyle':{ color: '#5294FF',
		                    	   bold: 'true',
		                    	   fontSize: 22
		                    	   }
		                       };

		        // Instantiate and draw our chart, passing in some options.
		        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		        chart.draw(data, options);
		      }
		    </script>
		
	</head>
	<body>
		<%@include file="headerFuncionario.html" %>

		<%@include file="sidebarFuncionario.html" %>
				<div id="content2">
					<header class="major">		
						<h2>Menu Funcion�rio</h2>
					</header>
					<div id="graficos">
					<div id=chart_div></div>
					</div>
				</div>
	
		</body>
</html>			