$(function(){
    $('#selectCityName').change(function () {
        var cityName = $('#selectCityName').val();
        var url = '/report/cityName/' + cityName;
        window.location.href = url;
    })
});