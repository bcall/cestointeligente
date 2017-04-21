$(function() {
	$.get("../services/allCompAutocomplete?q=",function(data){
    	$( "#compSearch" ).autocomplete({
    		source: data,
    		select: function( event, ui ) {
    			event.preventDefault();
    			window.location = "compostera?id="+ui.item.value;
    		}
    	}).click(function(){
    		$( this ).autocomplete( "search"," ");
    	});
    });
});