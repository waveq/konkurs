$(window).load(function() {
	var data = $('.chart').data('languages');

	$(function() {
		ay.pie_chart('pie-a', data, {
			percentage : false
		});
	});
});