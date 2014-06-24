window.onload = function() {

    var percList = document.getElementsByClassName("perc");
    var countryList = document.getElementsByClassName("country");
    var myData = [];
    var myCountries = [];

//    var data = [ 11975, 5871 ,8916 ] 

    for (i = 0; i < percList.length; i++) {
        myData[i] = parseFloat(percList[i].innerHTML);
    }
    for (i = 0; i < countryList.length; i++) {
        myCountries[i] = countryList[i].innerHTML;
    }
    var data = myData;

    var w = 700,
            h = 700,
            r = Math.min(w, h) / 2,
            labelr = r + 30, // radius for label anchor
            color = d3.scale.category20(),
            pie = d3.layout.pie(),
            arc = d3.svg.arc().innerRadius(0).outerRadius(r);

    var vis = d3.select("#myid")
            .append("svg:svg")
            .data([data])
            .attr("width", w + 200)
            .attr("height", h + 100);

    var arcs = vis.selectAll("g.arc")
            .data(pie.value(function(d) {
                return  d
            }))
            .enter().append("svg:g")
            .attr("class", "arc")
            .attr("transform", "translate(" + (r + 30) + "," + r + ")");

    arcs.append("svg:path")
            .attr("fill", function(d, i) {
                return color(i);
            })
            .attr("d", arc);


    var pom = 0;
    arcs.append("svg:text")
            .attr("transform", function(d) {
                var c = arc.centroid(d),
                        x = c[0],
                        y = c[1],
                        // pythagorean theorem for hypotenuse
                        h = Math.sqrt(x * x + y * y);
                return "translate(" + (x / h * labelr) + ',' +
                        (y / h * labelr) + ")";
            })
            .attr("dy", ".35em")
            .attr("text-anchor", function(d) {
                // are we past the center?
                return (d.endAngle + d.startAngle) / 2 > Math.PI ?
                        "end" : "start";
            })
            .text(function(d, i) {
                return myCountries[pom++] + " - " + d.value.toFixed(2);
            });
};


//
//window.onload = function() {
//    var percList = document.getElementsByClassName("perc");
//    var countryList = document.getElementsByClassName("country");
//
//    var myData = [];
//    var myCountries = [];
//    //<![CDATA[
//    for (i = 0; i < percList.length; i++) {
//        myData[i] = parseFloat(percList[i].innerHTML);
//    }
//    for (i = 0; i < countryList.length; i++) {
//        myCountries[i] = countryList[i].innerHTML;
//    }
//    //]]>
//    console.log(myCountries);
//    var data = myData;
//    var r = 500;
//    var color = d3.scale.ordinal()
//            .range(["red", "blue", "orange", "green", "yellow", "purple", "pink", "brown"]);
//    var canvas = d3.select("#span").append("svg")
//            .attr("width", 1000)
//            .attr("height", 1000);
//    var group = canvas.append("g")
//            .attr("transform", "translate(500, 500)");
//    var arc = d3.svg.arc()
//            .innerRadius(0)
//            .outerRadius(r);
//    var pie = d3.layout.pie()
//            .value(function(d) {
//                return d;
//            });
//    var arcs = group.selectAll(".arc")
//            .data(pie(data))
//            .enter()
//            .append("g")
//            .attr("class", "arc");
//
//    arcs.append("path")
//            .attr("d", arc)
//            .attr('fill', function(d) {
//                return color(d.data);
//            });
//
//    var pom = 0;
//    arcs.append('text')
//            .attr('transform', function(d) {
//                return 'translate(' + arc.centroid(d) + ')';
//            })
//            .attr('text-anchor', 'middle')
//            .attr('font-size', '1em')
//            .text(function(d) {
//
//                return myCountries[pom++] + " - " + d.data + "%";
//            });
//};
