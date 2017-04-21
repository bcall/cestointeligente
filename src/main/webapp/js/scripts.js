$(function(){
	$('[rel=tooltip]').tooltip() 
	window.setInterval ( "updateNav()", 15000 );
	$('#dropMes').click(function(){
		$('#notMes').hide();
	});
	$('#dropAle').click(function(){
		$('#notAle').hide();
	});
})
function updateNav(){
	$.get("../../cestointeligente/services/navAlerts",function(data){
		$('#alerts').html(data[2]);
		$('#messages').html(data[3]);
		if(data[1].indexOf("Y") !=-1){
			$('#notAle').show();
		}
		if(data[0].indexOf("Y") !=-1){
			$('#notMes').show();
		}
	});
}

// Closes the sidebar menu
$("#menu-close , #overlay").click(function(e) {
    e.preventDefault();
    $("#overlay").toggle();
    $("#sidebar-wrapper").toggleClass("active");
});

// Opens the sidebar menu
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#overlay").toggle();
    $("#sidebar-wrapper").toggleClass("active");
});
// section animation
$('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });