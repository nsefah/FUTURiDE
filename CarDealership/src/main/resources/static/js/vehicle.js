$(document).ready(function () {
    var makeSelection = $("#selectmake");
    var modelSelection = $("#selectmodel");

    var searchText = $("#searchterms");
    var minYearSelection = $("#selectminyear");
    var maxYearSelection = $("#selectmaxyear");
    var minPriceSelection = $("#selectminprice");
    var maxPriceSelection = $("#selectmaxprice");
    var vehicleCard = $("#vehicleCard");

    var baseUrl = 'http://localhost:8080/admin/searchRun/'

    function buildUrl(baseUrl, params) {
        var queryParams = [];
        $.each(params, function (key, value) {
            if (value !== "" && value !== null)
                queryParams.push(key + "=" + value);
        })
        return [baseUrl, queryParams.join("&")].join("?");
    }

    $('#search').click(function (event) {
        vehicleCard.empty();
        event.preventDefault();
        var search = searchText.val();
        var minPrice = minPriceSelection.val();
        var maxPrice = maxPriceSelection.val();
        var minYear = minYearSelection.val();
        var maxYear = maxYearSelection.val();

        $.ajax({
            type: 'GET',
            url: buildUrl(baseUrl, {search: search, minyear: minYear, maxyear: maxYear, minprice: minPrice, maxprice: maxPrice}),
            success: handleSearchResults,
            error: function () {
            }
        })
    });

    $('#searchSales').click(function (event) {

        vehicleCard.empty();
        event.preventDefault();
        var search = searchText.val();

        var minPrice = minPriceSelection.val();
        var maxPrice = maxPriceSelection.val();
        var minYear = minYearSelection.val();
        var maxYear = maxYearSelection.val();

        $.ajax({
            TYPE: 'Get',
            url: buildUrl(baseUrl, {search: search, minyear: minYear, maxyear: maxYear, minprice: minPrice, maxprice: maxPrice}),
            success: handleSearchResultsSales,
            error: function () {
            }
        })
    });

    //search new      
    $('#searchnew').click(function (event) {
        vehicleCard.empty();
        event.preventDefault();
        var search = searchText.val();
        var minPrice = minPriceSelection.val();
        var maxPrice = maxPriceSelection.val();
        var minYear = minYearSelection.val();
        var maxYear = maxYearSelection.val();

        $.ajax({
            type: 'GET',
            url: buildUrl(baseUrl, {search: search, minyear: minYear, maxyear: maxYear, minprice: minPrice, maxprice: maxPrice}),
            success: handleSearchNewResults,
            error: function () {
            }
        })
    });

    //search new      
    $('#searchused').click(function (event) {
        vehicleCard.empty();
        event.preventDefault();
        var search = searchText.val();
        var minPrice = minPriceSelection.val();
        var maxPrice = maxPriceSelection.val();
        var minYear = minYearSelection.val();
        var maxYear = maxYearSelection.val();

        $.ajax({
            type: 'GET',
            url: buildUrl(baseUrl, {search: search, minyear: minYear, maxyear: maxYear, minprice: minPrice, maxprice: maxPrice}),
            success: handleSearchUsedResults,
            error: function () {
            }
        })
    });

    makeSelection.change(function () {
        var makeId = makeSelection.val();

        $.ajax({
            type: 'Get',
            url: 'http://localhost:8080/getModel/' + makeId,
            success: handleGetModels,
            error: function () {}
        });
    });

    function handleGetModels(allModels) {
        modelSelection.html("<option>Select Model</option>");
        $.each(allModels, function (index, vehicleModel) {
            modelSelection.append(renderModelOption(vehicleModel));
        });
    }


    function renderModelOption(vehicleModel) {
        return "<option value='" + vehicleModel.id + "'>" + vehicleModel.model + "</option>";
    }

    function handleSearchResults(searchResults) {
        $.each(searchResults, function (index, vehicle) {
//            if (vehicle.typeId.type === "New") {
//                 //do nothing
//            } else {
            var vehicleDiv = "<div class='col-12 row border border-dark'>"
                vehicleDiv += "<div class='col-4'><div>" + vehicle.year + " " +
                        vehicle.makeId.make + " " + vehicle.modelId.model + "</div>";
                vehicleDiv += "<div><img class='col-12' src='" + vehicle.imagepath + "'></div></div>"
                vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>Body Style: " + vehicle.bodyStyleId.bodystyle + "</div>" +
                        "<div id='details'>Interior: " + vehicle.interiorColorsId.interiorcolor + "</div>" +
                        "<div id='details'>Sales Price: " + vehicle.salesprice + "</div>" +
                        "<div id='details'>Trans: " + vehicle.transmissionId.transmission + "</div>" +
                        "</div>";
                vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>Mileage: " + vehicle.mileage + "</div>" +
                        "<div id='details'>MSRP: $" + vehicle.msrp + "</div>" +
                        "<div id='details'>Color: " + vehicle.exteriorColorId.exteriorcolor + "</div>" +
                        "<div id='details'>Vin # " + vehicle.vinnum + "</div>" +
                        "</div>";
                if (vehicle.isavailable === 0){
                    vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>UNAVAILABLE: SOLD</div>";
                }
            vehicleDiv += "<a type='btn' id='editButton' class='btn btn-primary' href='editvehicle?id=" + vehicle.id + "'>Edit</a>";
            vehicleCard.append(vehicleDiv);
            //}
        })
    }

    function handleSearchResultsSales(searchResults) {
        $.each(searchResults, function (index, vehicle) {
            if (vehicle.isavailable === 0) {

            } else {

                var vehicleDiv = "<div class='col-12 row border border-dark'>"
                vehicleDiv += "<div class='col-4'><div>" + vehicle.year + " " +
                        vehicle.makeId.make + " " + vehicle.modelId.model + "</div>";
                vehicleDiv += "<div><img class='col-12' src='" + vehicle.imagepath + "'></div></div>"
                vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>Body Style: " + vehicle.bodyStyleId.bodystyle + "</div>" +
                        "<div id='details'>Interior: " + vehicle.interiorColorsId.interiorcolor + "</div>" +
                        "<div id='details'>Sales Price: " + vehicle.salesprice + "</div>" +
                        "<div id='details'>Trans: " + vehicle.transmissionId.transmission + "</div>" +
                        "</div>";
                vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>Mileage: " + vehicle.mileage + "</div>" +
                        "<div id='details'>MSRP: $" + vehicle.msrp + "</div>" +
                        "<div id='details'>Color: " + vehicle.exteriorColorId.exteriorcolor + "</div>" +
                        "<div id='details'>Vin # " + vehicle.vinnum + "</div>" +
                        "</div>";
                vehicleDiv += "<a type='btn' id='purchaseButton' class='btn btn-primary' href='purchase?id=" + vehicle.id + "'>Purchase</a>";
                vehicleCard.append(vehicleDiv);

            }
        })
    }

    function handleSearchNewResults(searchResults) {
        $.each(searchResults, function (index, vehicle) {
            if (vehicle.typeId.type === "Used" || vehicle.isavailable === 0) {
                //do nothing
            } else {
                var vehicleDiv = "<div class='col-12 row border border-dark'>"
                vehicleDiv += "<div class='col-4'><div>" + vehicle.year + " " +
                        vehicle.makeId.make + " " + vehicle.modelId.model + "</div>";
                vehicleDiv += "<div><img class='col-12' src='" + vehicle.imagepath + "'></div></div>"
                vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>Body Style: " + vehicle.bodyStyleId.bodystyle + "</div>" +
                        "<div id='details'>Interior: " + vehicle.interiorColorsId.interiorcolor + "</div>" +
                        "<div id='details'>Sales Price: " + vehicle.salesprice + "</div>" +
                        "<div id='details'>Trans: " + vehicle.transmissionId.transmission + "</div>" +
                        "</div>";
                vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>Mileage: " + vehicle.mileage + "</div>" +
                        "<div id='details'>MSRP: $" + vehicle.msrp + "</div>" +
                        "<div id='details'>Color: " + vehicle.exteriorColorId.exteriorcolor + "</div>" +
                        "<div id='details'>Vin # " + vehicle.vinnum + "</div>" +
                        "</div>";
                vehicleDiv += "<a type='btn' id='purchaseButton' class='btn btn-primary' href='/inventory/details?id=" + vehicle.id + "'>Details</a>";
                vehicleCard.append(vehicleDiv);
            }
        })
    }

    function handleSearchUsedResults(searchResults) {
        $.each(searchResults, function (index, vehicle) {
            if (vehicle.typeId.type === "New" || vehicle.isavailable === 0) {
                //do nothing
            } else {
                var vehicleDiv = "<div class='col-12 row border border-dark'>"
                vehicleDiv += "<div class='col-4'><div>" + vehicle.year + " " +
                        vehicle.makeId.make + " " + vehicle.modelId.model + "</div>";
                vehicleDiv += "<div><img class='col-12' src='" + vehicle.imagepath + "'></div></div>"
                vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>Body Style: " + vehicle.bodyStyleId.bodystyle + "</div>" +
                        "<div id='details'>Interior: " + vehicle.interiorColorsId.interiorcolor + "</div>" +
                        "<div id='details'>Sales Price: " + vehicle.salesprice + "</div>" +
                        "<div id='details'>Trans: " + vehicle.transmissionId.transmission + "</div>" +
                        "</div>";
                vehicleDiv += "<div class='col-3'>" +
                        "<div id='details'>Mileage: " + vehicle.mileage + "</div>" +
                        "<div id='details'>MSRP: $" + vehicle.msrp + "</div>" +
                        "<div id='details'>Color: " + vehicle.exteriorColorId.exteriorcolor + "</div>" +
                        "<div id='details'>Vin # " + vehicle.vinnum + "</div>" +
                        "</div>";
               vehicleDiv += "<a type='btn' id='purchaseButton' class='btn btn-primary' href='/inventory/details?id=" + vehicle.id + "'>Details</a>";
                vehicleCard.append(vehicleDiv);
            }
        })
    }

})

