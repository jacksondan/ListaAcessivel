<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Administrador - Início</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
		    <script type="text/javascript">

		      // Load the Visualization API and the piechart package.
		      google.load('visualization', '1.0', {'packages':['corechart']});

		      // Set a callback to run when the Google Visualization API is loaded.
		      google.setOnLoadCallback(drawChart);

		      // Callback that creates and populates a data table,
		      // instantiates the pie chart, passes in the data and
		      // draws it.
		      	var clientes = parseInt('${listaClientes}');
		        var funcionarios= parseInt('${listaFuncionarios}');
		        var estabelecimentos= parseInt('${listaEstabelecimentos}');
		      
				// contrução do grafio
		      function drawChart() {
		    	   var data = google.visualization.arrayToDataTable([
		    	                                                     ['Usuario', 'Quantidade'],
		    	                                                     ['Total de Clientes', clientes],        
		    	                                                     ['Total de Estabelecimentos', estabelecimentos],
		    	                                                     ['Total de Funcionarios', funcionarios]
		    	                                                   ]);

		    	                                                 

		        // Set chart options
		        var options = {'title':'População do Sistema',
		        	
		                       'width':700,
		                       'height':500,
		                       'chartArea':{left:120,top:80},
		                       'backgroundColor':'#f3f3f3',
		                       'is3D':'true',
		                       'titleTextStyle':{ color: '#5294FF',
		                    	   bold: 'true',
		                    	   fontSize: 22
		                    	   },
		                       is3D: true,
		                       };

		        // Instantiate and draw our chart, passing in some options.
		        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		        chart.draw(data, options);
		      }
		    </script>
		    <link rel="shortcut icon" href="images/logtop.png" />
	</head>
	<body>
		<%@include file="headerAdmin.html" %>

		<%@include file="sidebarAdmin.jsp" %>
		
				<div id="content2">
					<header class="major">		
						<h2>Menu Administrador</h2>
					</header>
					<p style="text-align: center; color: green;">${mensagem}</p>
					<div id="graficos">
					<div id=chart_div></div>
				</div>
				</div>
	
		</body>
</html>		