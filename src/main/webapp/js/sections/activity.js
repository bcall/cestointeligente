$(function() {
	$.get("../services/allActAutocomplete?q=", function(data) {
		$("#actSearch").autocomplete({
			source : data,
			select : function(e, ui) {
				e.preventDefault();
				$(this).val(ui.item.label);
				window.location = "actividades?id=" + ui.item.value;
			}
		}).click(function() {
			$(this).autocomplete("search","a");
		});
	});
});

