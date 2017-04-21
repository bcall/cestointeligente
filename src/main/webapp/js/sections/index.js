var listActive = 0;
$(function() {

	$.get("services/indexGraph", function(data) {
		graphDiaria(data);
		graphAumulado(data);

	});
});

$(".list-group-item").click(function(e) {
	e.preventDefault();
	listActive = $(this).attr('id').split('_')[2];
	$(".list-group-item.active").toggleClass("active");
	$("#est_item_" + listActive).toggleClass("active");
	centerOnMap(markers[listActive]);
});

function graphDiaria(wsData) {
	var total = wsData[0][0].PROY_TOTAL;
	var daysRec = wsData[1];
	var daysNoRec = wsData[3];
	var totalDays = [];
	var labels = [];
	var dataDaysRec = [];
	var dataDaysNoRec = [];
	var daysInMontRec;
	if (daysRec && daysRec[0])
	    daysInMontRec = new Date(daysRec[0].DATE.split('-')[0], daysRec[0].DATE
			.split('-')[1], 0).getDate();
	
	var daysInMontNoRec;
	if (daysNoRec && daysNoRec[3])
	    daysInMontNoRec = new Date(daysNoRec[3].DATE.split('-')[0],
			daysNoRec[0].DATE.split('-')[1], 0).getDate();
	var daysInMont =  daysInMontNoRec ? daysInMontNoRec : daysInMontRec;
	var totalBday = total / daysInMont;
	//TODO add label byday replace i by day of date.
	for (var i = 0; i < daysInMont; i++) {
		labels[i] = i + 1;
		dataDaysRec[i] = 0;
		dataDaysNoRec[i] = 0;
	}
	var totalW = 0;

	for ( var i in daysRec) {
		dataDaysRec[i] = (parseInt(daysRec[i].INPUT)).toFixed(2);
	}

	for ( var i in daysNoRec) {
		dataDaysNoRec[i] = (parseInt(daysNoRec[i].INPUT)).toFixed(2);
	}

	var data = {
		labels : labels,
		datasets : [ {
			label : "Rec",
			fillColor : "rgba(235, 203, 139,0.2)",
			strokeColor : "#ebcb8b",
			pointColor : "#ebcb8b",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(235, 203, 139,1)",
			data : dataDaysRec
		}, {
			label : "NoRec",
			fillColor : "rgba(163, 190, 140,0.2)",
			strokeColor : "#a3be8c",
			pointColor : "#a3be8c",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(163, 190, 140,1)",
			data : dataDaysNoRec
		} ]
	};
	var ctx = $("#myChartDiario").get(0).getContext("2d");
	var myLineChart = new Chart(ctx).Line(data);
}


function graphAumulado(wsData) {
	var total = wsData[0][0].PROY_TOTAL;
	var daysRec = wsData[1];
	var daysNoRec = wsData[3];
	var totalDays = [];
	var labels = [];
	var dataDaysRec = [];
	var dataDaysNoRec = [];
	var daysInMontRec;
	if (daysRec && daysRec[0]) {
	    daysInMontRec = new Date(daysRec[0].DATE.split('-')[0], daysRec[0].DATE
			.split('-')[1], 0).getDate();
	}  
	 
	var daysInMontNoRec;
	if (daysNoRec && daysNoRec[3]) {
	    daysInMontNoRec = new Date(daysNoRec[3].DATE.split('-')[0],
			daysNoRec[0].DATE.split('-')[1], 0).getDate();
	}   
	
	var daysInMont = daysInMontRec ? daysInMontRec : daysNoRec;
	var totalBday = total / daysInMont;
	for (var i = 0; i < daysInMont; i++) {
		labels[i] = i + 1;
		dataDaysRec[i] = 0;
		dataDaysNoRec[i] = 0;
	}
	var totalW = 0;
	var totalWNR = 0;
	for ( var i in daysRec) {
		dataDaysRec[i] = totalW = (parseInt(totalW) +
		 parseInt(daysRec[i].INPUT)).toFixed(2);	
		}

	for ( var i in daysNoRec) {
		 dataDaysNoRec[i] = totalWNR = (parseInt(totalWNR) +
		 parseInt(daysNoRec[i].INPUT)).toFixed(2);		
	}

	var data = {
		labels : labels,
		datasets : [ {
			label : "Rec",
			fillColor : "rgba(235, 203, 139,0.2)",
			strokeColor : "#ebcb8b",
			pointColor : "#ebcb8b",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(235, 203, 139,1)",
			data : dataDaysRec
		}, {
			label : "NoRec",
			fillColor : "rgba(163, 190, 140,0.2)",
			strokeColor : "#a3be8c",
			pointColor : "#a3be8c",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(163, 190, 140,1)",
			data : dataDaysNoRec
		} ]
	};
	var ctx = $("#myChartAcumulado").get(0).getContext("2d");
	var myLineChart = new Chart(ctx).Line(data);
}
