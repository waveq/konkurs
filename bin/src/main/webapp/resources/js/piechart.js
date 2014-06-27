$(window).load(function() {
    var data = [];
    
    var percList = document.getElementsByClassName("perc");
    var countryList = document.getElementsByClassName("country");
    var myData = [];
    var myCountries = [];

    for (var i = 0; i < percList.length; i++) {
        myData[i] = parseFloat(percList[i].innerHTML);
    }
    for (i = 0; i < countryList.length; i++) {
        myCountries[i] = countryList[i].innerHTML;
    }

    for(i = 0; i< myData.length; i++) {
        data.push({index: i+1, name: myCountries[i] + " - " + myData[i] + "%", value: myData[i]})
    }
    
    $(function() {
        ay.pie_chart('pie-a', data, {
            percentage: false
        });
    });
});