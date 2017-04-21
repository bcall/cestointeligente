var listActive = 0;
$(function() {
	$.get("../services/allProyAutocomplete?q=", function(data) {
		$("#proySearch").autocomplete({
			source : data,
			select : function(event, ui) {
				window.location = "proyecto?id=" + ui.item.value;
			}
		}).click(function() {
			$(this).autocomplete("search", " ");
		});
	});
	$("#act_item_" + listActive).click();
	if($('#pStat').html().indexOf('ACTIVO') == 0){
		$('#pStat').addClass('alert-success');
	}
	if($('#pStat').html().indexOf('INACTIVO') == 0){
		$('#pStat').addClass('alert-warning');
	}
});
$(".list-group-item").click(function(e) {
	e.preventDefault();
	$("#chart_"+listActive).remove();
	$("#body_"+listActive).hide();
	listActive = $(this).attr('id').split('_')[2];
	canvas = '<canvas id="chart_'+listActive+'" width="550" height="200"></canvas>';
	$("#legend_"+listActive).before(canvas);
	$(".list-group-item.active").toggleClass("active");
	$("#act_item_" + listActive).toggleClass("active");
	$("#body_"+listActive).show();
	$.get("../services/PActGraph?pId="+$("#pId_"+listActive).val()+"&aId="+$("#aId_"+listActive).val(),function(data){
		graph(data);
	});
});

function graph(wsData){
	var color1 = $(".activityLegendColor1").eq(0).css("background-color");
	var color2 = $(".activityLegendColor2").eq(0).css("background-color");
	var color3 = $(".activityLegendColor3").eq(0).css("background-color");

	var items = wsData[0];
	var labels = [];
	var dataIn = [];
	var dataInU = 0;
	var dataUp = [];
	for (var i = 0; i < items.length; i++) {
		labels[i] = items[i].DATE;
		dataIn[i] = items[i].D_IN.toFixed(2);
		dataInU = dataInU + parseFloat(items[i].U_IN.toFixed(2));
		dataUp[i] = items[i].C_IN.toFixed(2);
	}
	$("#ku_"+listActive).text((dataInU/items.length).toFixed(2)+' kg');
	var data = {
	        labels: labels,
	        datasets: [{
	            label: "Arriba",
	            fillColor: getRGBA(color3, 0.2),
	            strokeColor: color3,
	            pointColor: color3,
	            pointStrokeColor: "#fff",
	            pointHighlightFill: "#fff",
	            pointHighlightStroke: color3,
	            data: dataIn
	        }]
	    };
	    var ctx = $("#chart_"+listActive).get(0).getContext("2d");
	    var myLineChart = new Chart(ctx).Line(data);
}

function getRGBA(c,a){
    c = c.replace("rgb(","").replace(")","").split(",");
    r = c[0];
    g = c[1]; 
    b = c[2];
    return 'rgba('+r+','+g+','+b+','+a+')';
}