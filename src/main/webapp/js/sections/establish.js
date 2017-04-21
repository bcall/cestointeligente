var listActive = 0;
var defaultLatLng = new google.maps.LatLng(estLat, estLong);
var map;
var marker;
var mapOptions = {
	center : defaultLatLng,
	zoom : 15,
	draggable : false,
	disableDefaultUI : true
};
$(function() {
	initialize();
	google.maps.event.addListener(map, 'center_changed', function() {
		map.panTo(defaultLatLng)
	});
	$("#proy_item_" + listActive).toggleClass("active");
	$("#body_" + listActive + ", #footer_" + listActive).show();
	$.get("../services/allEstAutocomplete?q=", function(data) {
		$("#estSearch").autocomplete({
			source : data,
			select : function(event, ui) {
				window.location = "establecimiento?id=" + ui.item.value;
			}
		}).click(function() {
			$(this).autocomplete("search", " ");
		});
	});
});
$(".list-group-item").click(function(e) {
	e.preventDefault();
	nListActive = $(this).attr('id').split('_')[2];
	if (nListActive != listActive) {
		$("#proy_item_" + listActive).toggleClass("active");
		$("#body_" + listActive + ", #footer_" + listActive).hide()
		listActive = nListActive;
		$("#proy_item_" + listActive).toggleClass("active");
		$("#body_" + listActive + ", #footer_" + listActive).show()
	}
});
function getEvolution(id) {
	$('.modProg').show();
	$('#myChart , .legend').hide();
	$('#evoModal').modal();
	
	$.get("../services/evolGraph?id=" + id, function(data) {
		var total = data[0][0].DAYS;
		var days = data[1];
		var totalDays = [];
		var labels = [];
		var dataDays = [];
		var totalBday = (data[0][0].PROY) / 100;
		var graphW = 15 * total;

		for (var i = 0; i < total; i++) {
			labels[i] = i + 1;
			totalDays[i] = (totalBday * (i + 1)).toFixed(2);
			dataDays[i] = 0;
		}
		var totalW = 0;

		for ( var i in days) {
			dataDays[i] = totalW = (parseInt(totalW) + parseInt(days[i].DAY_IN)).toFixed(2);
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
		$("#myChart").attr('width', graphW);
		var ctx = $("#myChart").get(0).getContext("2d");
		var myLineChart = new Chart(ctx).Line(data);
		$('#myChart , .legend').show();
		$('.modProg').hide();
	});
}
function centerOnMap(lat, lng) {
	var pos = new google.maps.LatLng(lat, lng);
	map.setCenter(pos);
	map.setZoom(15);
}

function initialize() {
	map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
	marker = new google.maps.Marker({
		position : defaultLatLng,
		map : map,
		title : "Establecimiento"
	});
}
/*
 * function getEvolution(id) { $.get("../services/evolGraph?id=" + id,
 * function(data) {
 * 
 * var dateF = new Date(data[0][0].DATE_FROM); var dateT = new
 * Date(data[0][0].DATE_TO); var monthF = dateF.getMonth()+1; var monthT =
 * dateT.getMonth()+1; var total = data[0][0].DAYS; var days = data[1]; var
 * totalDays = []; var labels = []; var dataDays = []; var totalBday =
 * (data[0][0].PROY)/100;
 * 
 * var months = []; for (var a = monthF;a <= monthT; a++) { var month=[]; var
 * dataDays = []; var count = 0; for ( var i in days) {
 * if(parseInt(days[i].DATE.split('-')[1]) == a){ var day =
 * days[i].DATE.split('-'); if ((parseInt(day[2]) - 1) != 0) { dataDays[i] =
 * (days[i].INPUT + parseInt(dataDays[i - 1])).toFixed(2); } else {
 * if(parseInt(day[1]) != monthF ){ dataDays[i] =
 * months[count][months[count].length-1]+days[i].INPUT.toFixed(2); }else{
 * dataDays[i] = days[i].INPUT.toFixed(2); } } month.push(dataDays[i]); count++; } }
 * $('.modCharts').append('<canvas id="monthChart_'+a+'" width="450"
 * height="200"></canvas>'); months.push(month); }
 * 
 * for ( var i in days) { if (days[i]) { var day = days[0].DATE.split('-')[2] -
 * 1; if (day != 0) { dataDays[day] = (days[i].INPUT + dataDays[day -
 * 1]).toFixed(2); } else { dataDays[i] = days[i].INPUT.toFixed(2); } } } var
 * data = { labels : labels, datasets : [ { label : "Peso Proyectado", fillColor :
 * "rgba(235, 203, 139,0.2)", strokeColor : "#ebcb8b", pointColor : "#ebcb8b",
 * pointStrokeColor : "#fff", pointHighlightFill : "#fff", pointHighlightStroke :
 * "rgba(235, 203, 139,1)", data : totalDays }, { label : "Peso Alcanzado",
 * fillColor : "rgba(163, 190, 140,0.2)", strokeColor : "#a3be8c", pointColor :
 * "#a3be8c", pointStrokeColor : "#fff", pointHighlightFill : "#fff",
 * pointHighlightStroke : "rgba(163, 190, 140,1)", data : dataDays } ] }; var
 * ctx = $("#myChart").get(0).getContext("2d"); var myLineChart = new
 * Chart(ctx).Line(data); $('#evoModal').modal(); }); }
 */
