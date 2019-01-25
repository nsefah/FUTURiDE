$(document).ready(function () {
    //USED INVENTORY SEARCH
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
            if (vehicle.typeId.type === "Used") {
                 //do nothing
            } else {
                var vehicleDiv = "<div>" + vehicle.year + " " + vehicle.makeId.make + " " + vehicle.modelId.model + "</div>";
                vehicleDiv += "<div class='fa fa-car' id='carImage'></div>";
                vehicleDiv += "<div>Body Style: " + vehicle.bodyStyleId.bodystyle + "</div>";
                vehicleDiv += "<div>Interior: " + vehicle.interiorColorsId.interiorcolor + "</div>";
                vehicleDiv += "<div>Sales Price : $" + vehicle.salesprice + "</div>";
                vehicleDiv += "<div>Trans: " + vehicle.transmissionId.transmission + "</div>";
                vehicleDiv += "<div>Mileage: " + vehicle.mileage + "</div>";
                vehicleDiv += "<div>MSRP : $" + vehicle.msrp + "</div>";
                vehicleDiv += "<div>Color: " + vehicle.exteriorColorId.exteriorcolor + "</div>";
                vehicleDiv += "<div>Vin #: " + vehicle.vinnum + "</div>";
                vehicleDiv += "<a type='btn' id='editButton' class='btn btn-primary' href='editvehicle?id=" + vehicle.id + "'>Edit</a>";
                vehicleCard.append(vehicleDiv);
            }
        })
    }

    function handleSearchResultsSales(searchResults) {
        $.each(searchResults, function (index, vehicle) {
            var vehicleDiv = "<div>" + vehicle.year + " " + vehicle.makeId.make + " " + vehicle.modelId.model + "</div>";
            vehicleDiv += "<div class='fa fa-car' id='carImage'></div>";
            vehicleDiv += "<div>Body Style: " + vehicle.bodyStyleId.bodystyle + "</div>";
            vehicleDiv += "<div>Interior: " + vehicle.interiorColorsId.interiorcolor + "</div>";
            vehicleDiv += "<div>Sales Price : $" + vehicle.salesPrice + "</div>";
            vehicleDiv += "<div>Trans: " + vehicle.transmissionId.transmission + "</div>";
            vehicleDiv += "<div>Mileage: " + vehicle.mileage + "</div>";
            vehicleDiv += "<div>MSRP : $" + vehicle.msrp + "</div>";
            vehicleDiv += "<div>Color: " + vehicle.exteriorColorId.exteriorcolor + "</div>";
            vehicleDiv += "<div>Vin #: " + vehicle.vinnum + "</div>";
            vehicleDiv += "<a type='btn' id='purchaseButton' class='btn btn-primary' href='purchase?id=" + vehicle.id + "'>Purchase</a>";
            vehicleCard.append(vehicleDiv);
        })
    }

})


