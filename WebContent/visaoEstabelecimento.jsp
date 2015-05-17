<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${acessoEstabelecimento.nome_juridico} - Início </title>
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
		      var solicitadas = parseInt('${listasSolicitadas}');
		        var atendidas = parseInt('${listasAtendidas}');
		      
				// contrução do grafio
		      function drawChart() {
		    	   var data = google.visualization.arrayToDataTable([
		    	                                                     ['Atividade', 'Quantidade'],
		    	                                                     ['Listas Solicitadas', solicitadas],
		    	                                                    
		    	                                                     ['Listas Atendidas' , atendidas]
		    	                                                   ]);

		    	                                                   var options = {
		    	                                                     title: 'Gráfico de Atividades',    
		    	                                                     is3D: true,
		    	                                                     
		    	                                                   };

		        // Set chart options
		        var options = {'title':'Gráfico de Atividades',
		                       'width':700,
		                       'height':500,
		                       'chartArea':{left:120,top:80},
		                       'backgroundColor':'#f3f3f3',
		                       'is3D':'true',
		                       'titleTextStyle':{ color: '#5294FF',
		                    	   bold: 'true',
		                    	   fontSize: 22
		                    	   },
		                       
		                       };

		        // Instantiate and draw our chart, passing in some options.
		        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		        chart.draw(data, options);
		      }
		    </script>
		    <link rel="shortcut icon" href="images/logtop.png" />
	</head>
	<body>
		<%@include file="headerEstabelecimento.html" %>

		<%@include file="sidebarEstabelecimento.jsp" %>
		
				<div id="content2">
					<header class="major">		
						<h2>Menu - Estabelecimento</h2>
					</header>
					<p style="text-align: center; color: green;">${mensagem}</p>
					<div id="graficos">
					<div id="chart_div"></div>
					</div>
				</div>
	
		</body>
</html>			