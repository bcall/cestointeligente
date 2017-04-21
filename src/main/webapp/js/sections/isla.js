var listActive = 0;
$(function() {

	$.get("../compostera/services/indexGraph", function(data) {
		graphNotReci(data);
		graphReci(data);
	});
});
$(".list-group-item").click(function(e) {
	e.preventDefault();
	listActive = $(this).attr('id').split('_')[2];
	$(".list-group-item.active").toggleClass("active");
	$("#est_item_" + listActive).toggleClass("active");
	centerOnMap(markers[listActive]);
});

function graphReci(wsData) {
	var total = wsData[0][0].PROY_TOTAL;
	var days = wsData[1];
	var totalDays = [];
	var labels = [];
	var dataDays = [];
	var daysInMont = new Date(days[0].DATE.split('-')[0], days[0].DATE
			.split('-')[1], 0).getDate();
	var totalBday = total / daysInMont;
	for (var i = 0; i < daysInMont; i++) {
		labels[i] = i+1;
		totalDays[i] = (totalBday * (i+1)).toFixed(2);
		dataDays[i] = 0;
	}
	var totalW = 0;

	for ( var i in days) {
		dataDays[i] = totalW = (parseInt(totalW) + parseInt(days[i].INPUT)).toFixed(2);
	}
	
	var data = {
		labels : labels,
		datasets : [ {
			label : "Peso Proyectado",
			fillColor : "rgba(235, 203, 139,0.2)",
			strokeColor : "#ebcb8b",
			pointColor : "#ebcb8b",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(235, 203, 139,1)",
			data : totalDays
		}, {
			label : "Peso Alcanzado",
			fillColor : "rgba(163, 190, 140,0.2)",
			strokeColor : "#a3be8c",
			pointColor : "#a3be8c",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(163, 190, 140,1)",
			data : dataDays
		} ]
	};
	var ctx = $("#myChart").get(0).getContext("2d");
	var myLineChart = new Chart(ctx).Line(data);
}

function graphNotReci(wsData) {
	var total = wsData[2][0].PROY_TOTAL;
	var days = wsData[3];
	var totalDays = [];
	var labels = [];
	var dataDays = [];
	var daysInMont = new Date(days[0].DATE.split('-')[0], days[0].DATE
			.split('-')[1], 0).getDate();
	var totalBday = total / daysInMont;
	for (var i = 0; i < daysInMont; i++) {
		labels[i] = i+1;
		totalDays[i] = (totalBday * (i+1)).toFixed(2);
		dataDays[i] = 0;
	}
	var totalW = 0;

	for ( var i in days) {
		dataDays[i] = totalW = (parseInt(totalW) + parseInt(days[i].INPUT)).toFixed(2);
	}
	
	var data = {
		labels : labels,
		datasets : [ {
			label : "Peso Proyectado",
			fillColor : "rgba(235, 203, 139,0.2)",
			strokeColor : "#ebcb8b",
			pointColor : "#ebcb8b",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(235, 203, 139,1)",
			data : totalDays
		}, {
			label : "Peso Alcanzado",
			fillColor : "rgba(163, 190, 140,0.2)",
			strokeColor : "#a3be8c",
			pointColor : "#a3be8c",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(163, 190, 140,1)",
			data : dataDays
		} ]
	};
	var ctx = $("#myChart1").get(0).getContext("2d");
	var myLineChart = new Chart(ctx).Line(data);
}