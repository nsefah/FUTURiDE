/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.controller;

import com.sg.CarDealership.dto.Make;
import com.sg.CarDealership.dto.Special;
import com.sg.CarDealership.dto.Vehicle;
import com.sg.CarDealership.dto.VehicleModel;
import com.sg.CarDealership.dto.VehicleParts.BodyStyle;
import com.sg.CarDealership.dto.VehicleParts.ExteriorColor;
import com.sg.CarDealership.dto.VehicleParts.InteriorColor;
import com.sg.CarDealership.dto.VehicleParts.Transmission;
import com.sg.CarDealership.dto.VehicleParts.Type;
import com.sg.CarDealership.service.CarDealershipServiceLayer;
import com.sg.CarDealership.service.MakeModelServiceLayer;
import com.sg.CarDealership.service.SpecialServiceLayer;
import com.sg.CarDealership.service.VehicleServiceLayer;
import java.io.File;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author apprentice
 */
@Controller
public class VehicleController {

    @Autowired
    VehicleServiceLayer service;
    @Autowired
    CarDealershipServiceLayer partsService;
    @Autowired
    MakeModelServiceLayer makeModelService;
    @Autowired
    SpecialServiceLayer specialService;

    Set<ConstraintViolation<Vehicle>> violations = new HashSet<>();
    
    @GetMapping("home/home")
    public String generateIndex(Model model){
        List<Special> allSpecials = specialService.getAllSpecials();
        model.addAttribute("allSpecials", allSpecials);
        
        List<Vehicle> vehicles = service.getAllVehicles();
         List<Vehicle> featuredVehicles = new ArrayList<>();
        
        for (Vehicle vehicle : vehicles){
            if (vehicle.getIsfeatured() == 1 && featuredVehicles.size() < 3){
                featuredVehicles.add(vehicle);
            }
        }

        model.addAttribute("featuredVehicles", featuredVehicles);

        return "home/home";
    }
    @GetMapping("home/social")
    public String generateSocial(Model model){
        return "home/social";
    }

    //admin/addvehicle
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("admin/addvehicle")
    public String addNewVehicle(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        List<Vehicle> vehicles = service.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        List<Make> makes = makeModelService.getAllMakes();
        model.addAttribute("makes", makes);
        List<VehicleModel> models = makeModelService.getAllModels();
        model.addAttribute("models", models);
        List<Type> types = partsService.getAllTypes();
        model.addAttribute("types", types);
        List<ExteriorColor> excos = partsService.getAllExteriorColors();
        model.addAttribute("excos", excos);
        List<BodyStyle> styles = partsService.getAllBodyStyles();
        model.addAttribute("styles", styles);
        List<Transmission> trans = partsService.getAllTransmissions();
        model.addAttribute("trans", trans);
        List<InteriorColor> incos = partsService.getAllInteriorColors();
        model.addAttribute("incos", incos);

        return "admin/addvehicle";
    }

    @PostMapping("admin/addvehicle")
    public String addVehicle(Vehicle vehicle, HttpServletRequest request,
            RedirectAttributes model,
            @RequestParam("picture") MultipartFile picture) {
        vehicle.setIsavailable(1);
        vehicle.setImagepath("placeholder");
        service.addVehicle(vehicle);

        int vehicleId = vehicle.getId();
        File pictureSave = service.savePicture(picture);
        Path picturePath = Paths.get(pictureSave.getPath());
        String fileExtension = service.getFileExtension(pictureSave);
        String vehiclePic = service.moveSavedPicture(picturePath, vehicleId, fileExtension);
        vehicle.setImagepath(vehiclePic);
        service.updateVehicle(vehicle);

        return "redirect:search";
    }

    @GetMapping("vehicles")
    public String displayVehicles(Model model) {
        List<Vehicle> vehicles = service.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }

    //admin/search
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("admin/search")
    public String displaySearch(Model model) {
        return "admin/search";
    }

    @GetMapping("admin/searchRun")
    @ResponseBody
    public List<Vehicle> searchVehicle(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Integer minyear,
            @RequestParam(required = false) Integer maxyear,
            @RequestParam(required = false) BigDecimal minprice,
            @RequestParam(required = false) BigDecimal maxprice) {

        search = (search == null) ? "" : search;
        int minYear = (minyear == null) ? 1999 : minyear;
        int maxYear = (maxyear == null) ? 9999 : maxyear;
        BigDecimal minPrice = (minprice == null) ? BigDecimal.ZERO : minprice;
        BigDecimal maxPrice = (maxprice == null) ? BigDecimal.TEN.pow(1000) : maxprice;
        List<Vehicle> vehicleList = service.findBySearch(search, minYear,
                maxYear, minPrice, maxPrice);
        return vehicleList;
    }

    //inventory/new
    @GetMapping("inventory/new")
    public String displayNewInventory(Model model) {
        return "inventory/new";
    }

    @PostMapping("inventory/newRun")
    @ResponseBody
    public List<Vehicle> displaySearchNewInventory(@RequestParam(required = false) String search,
            @RequestParam(required = false) Integer minyear,
            @RequestParam(required = false) Integer maxyear,
            @RequestParam(required = false) BigDecimal minprice,
            @RequestParam(required = false) BigDecimal maxprice) {
        search = (search == null) ? "" : search;
        int minYear = (minyear == null) ? 1999 : minyear;
        int maxYear = (maxyear == null) ? 9999 : maxyear;
        BigDecimal minPrice = (minprice == null) ? BigDecimal.ZERO : minprice;
        BigDecimal maxPrice = (maxprice == null) ? BigDecimal.TEN.pow(1000) : maxprice;
        List<Vehicle> vehicleList = service.findBySearch(search, minYear,
                maxYear, minPrice, maxPrice);
        return vehicleList;

    }

    //inventory/used
    @GetMapping("inventory/used")
    public String displayUsedInventory(Model model) {
        return "inventory/used";
    }

    @PostMapping("inventory/usedRun")
    @ResponseBody
    public List<Vehicle> displaySearchUsedInventory(@RequestParam(required = false) String search,
            @RequestParam(required = false) Integer minyear,
            @RequestParam(required = false) Integer maxyear,
            @RequestParam(required = false) BigDecimal minprice,
            @RequestParam(required = false) BigDecimal maxprice) {
        search = (search == null) ? "" : search;
        int minYear = (minyear == null) ? 1999 : minyear;
        int maxYear = (maxyear == null) ? 9999 : maxyear;
        BigDecimal minPrice = (minprice == null) ? BigDecimal.ZERO : minprice;
        BigDecimal maxPrice = (maxprice == null) ? BigDecimal.TEN.pow(1000) : maxprice;
        List<Vehicle> vehicleList = service.findBySearch(search, minYear,
                maxYear, minPrice, maxPrice);
        return vehicleList;

    }
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("sales/index")
    public String displaySearchIdx(Model model) {
        return "sales/index";
    }

    @GetMapping("sales/indexRun")
    @ResponseBody
    public List<Vehicle> searchVehicleIdx(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Integer minyear,
            @RequestParam(required = false) Integer maxyear,
            @RequestParam(required = false) BigDecimal minprice,
            @RequestParam(required = false) BigDecimal maxprice) {

        search = (search == null) ? "" : search;
        int minYear = (minyear == null) ? 1999 : minyear;
        int maxYear = (maxyear == null) ? 9999 : maxyear;
        BigDecimal minPrice = (minprice == null) ? BigDecimal.ZERO : minprice;
        BigDecimal maxPrice = (maxprice == null) ? BigDecimal.TEN.pow(1000) : maxprice;
        List<Vehicle> vehicleList = service.findBySearch(search, minYear,
                maxYear, minPrice, maxPrice);
        return vehicleList;
    }

    @GetMapping("inventory/details")
    public String detailVehicle(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = service.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "inventory/details";
    }

    //vehicle/deletevehicle
    @GetMapping("deletevehicle")
    public String deleteVehicle(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteVehicleById(id);
        return "redirect:adminvehicles";
    }

    //admin/editvehicle
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("admin/editvehicle")
    public String editVehicle(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = service.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        List<Make> makes = makeModelService.getAllMakes();
        model.addAttribute("makes", makes);
        List<VehicleModel> models = makeModelService.getAllModels();
        model.addAttribute("models", models);
        List<Type> types = partsService.getAllTypes();
        model.addAttribute("types", types);
        List<ExteriorColor> excos = partsService.getAllExteriorColors();
        model.addAttribute("excos", excos);
        List<BodyStyle> styles = partsService.getAllBodyStyles();
        model.addAttribute("styles", styles);
        List<Transmission> trans = partsService.getAllTransmissions();
        model.addAttribute("trans", trans);
        List<InteriorColor> incos = partsService.getAllInteriorColors();
        model.addAttribute("incos", incos);

        return "admin/editvehicle";
    }
    
//    
//    @GetMapping("getModel/{makeid}")
//    @ResponseBody
//    public List<VehicleModel> getModel(@PathVariable int makeid) {
//        Make make = makeModelService.getMakeById(makeid);
//        return make.getModels();
//    }


    @PostMapping("admin/editvehicle")
    public String performEditVehicle(Vehicle vehicle, HttpServletRequest request,
            RedirectAttributes model,
            @RequestParam("picture") MultipartFile picture) {
        int id = Integer.parseInt(request.getParameter("id"));
        //Vehicle vehicle = service.getVehicleById(id);
//         String featured = request.getParameter("isFeatured");
//                int isFeatured = (featured == null) ? 0 : 1;
//        vehicle.setIsfeatured(isFeatured);
        System.out.println("Set vehicle!");

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(vehicle);

        if (!violations.isEmpty()) {
            model.addAttribute("errors", violations);
            return "admin/addvehicle";
        }
        System.out.println("Passed");
        
        int vehicleId = vehicle.getId();
        File pictureSave = service.savePicture(picture);
        Path picturePath = Paths.get(pictureSave.getPath());
        String fileExtension = service.getFileExtension(pictureSave);
        String vehiclePic = service.moveSavedPicture(picturePath, vehicleId, fileExtension);
        vehicle.setImagepath(vehiclePic);

        service.updateVehicle(vehicle);

        return "admin/search";
//        //get values from page (chosen))
//        int make = Integer.parseInt(request.getParameter("make"));
//        int model = Integer.parseInt(request.getParameter("model"));
//        int type = Integer.parseInt(request.getParameter("type"));
//        int exco = Integer.parseInt(request.getParameter("exteriorColor"));
//        int body = Integer.parseInt(request.getParameter("bodyStyle"));
//        int transmission = Integer.parseInt(request.getParameter("transmission"));
//        int inco = Integer.parseInt(request.getParameter("interiorColor"));
//        //get values from page (generated)
//        String year = request.getParameter("year");
//        int mileage = Integer.parseInt(request.getParameter("mileage"));
//        String vinNum = request.getParameter("vinNum");
//        double MSRP = Double.parseDouble(request.getParameter("MSRP"));
//        double salesPrice = Double.parseDouble(request.getParameter("salesPrice"));
//        String description = request.getParameter("description");
//        //Set new values
//        vehicle.setMakeId(makeModelService.getMakeById(make));
//        vehicle.setModelId(makeModelService.getModelById(model));
//        vehicle.setTypeId(partsService.getTypeById(type));
//        vehicle.setExteriorColorId(partsService.getExteriorColorById(exco));
//        vehicle.setBodyStyleId(partsService.getBodyStyleById(body));
//        vehicle.setTransmissionId(partsService.getTransmissionById(transmission));
//        vehicle.setInteriorColorsId(partsService.getInteriorColorById(inco));
//        vehicle.setYear(year);
//        vehicle.setMileage(mileage);
//        vehicle.setVinnum(vinNum);
//        vehicle.setMSRP(MSRP);
//        vehicle.setSalesprice(salesPrice);
//        vehicle.setDescription(description);
//        vehicle.setIsfeatured(0);
//        vehicle.setIsavailable(1);

    }
}
