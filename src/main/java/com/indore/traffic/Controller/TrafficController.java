package com.indore.traffic.Controller;

import com.indore.traffic.Model.Suggestion;
import com.indore.traffic.Model.TrafficReport;
import com.indore.traffic.Model.TrafficZone;
import com.indore.traffic.Repository.LocationRepository;
import com.indore.traffic.Service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrafficController {

    @Autowired
    private TrafficService service;

    @Autowired
    private LocationRepository locationRepository;

    // 🏠 Home Page - Show all zones
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("zones", service.getAllZones());
        return "home";
    }

    // ➕ Add Zone Form
    @GetMapping("/add")
    public String addZoneForm(Model model) {
        model.addAttribute("zone", new TrafficZone());
        return "add-zone";
    }

    // 💾 Save Zone
    @PostMapping("/save")
    public String saveZone(@ModelAttribute TrafficZone zone) {
        service.saveZone(zone);
        return "redirect:/";
    }

    // 🚨 Show Report Form
    @GetMapping("/report")
    public String reportForm(Model model) {
        model.addAttribute("report", new TrafficReport());
        return "report";
    }

    // 💾 Save Report
    @PostMapping("/report/save")
    public String saveReport(@ModelAttribute TrafficReport report) {
        service.saveReport(report);
        return "redirect:/reports";
    }

    // 📊 View All Reports
    @GetMapping("/reports")
    public String viewReports(Model model) {
        model.addAttribute("reports", service.getAllReports());
        return "reports";
    }

    // 🚦 Severity Summary
    @GetMapping("/summary")
    public String summary(Model model) {
        model.addAttribute("summary", service.getSeveritySummary());
        return "summary";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        model.addAttribute("totalReports", service.getTotalReports());
        model.addAttribute("totalZones", service.getTotalZones());
        model.addAttribute("mostCongested", service.getMostCongestedArea());
        model.addAttribute("peakTime", service.getPeakTrafficTime());

        model.addAttribute("levelData", service.getLevelDistribution());

        return "dashboard";
    }
    // 🔍 Search by location
    @GetMapping("/search")
    public String search(@RequestParam String location, Model model){

        model.addAttribute("reports", service.searchByLocation(location));

        return "reports";
    }

    // 🎯 Filter by level
    @GetMapping("/filter")
    public String filter(@RequestParam String level, Model model){

        model.addAttribute("reports", service.filterByLevel(level));

        return "reports";
    }

    // 💬 Suggestion form
    @GetMapping("/suggest")
    public String suggestForm(Model model){
        model.addAttribute("suggestion", new Suggestion());
        return "suggest";
    }

    // 💾 Save suggestion
    @PostMapping("/suggest/save")
    public String saveSuggestion(@ModelAttribute Suggestion suggestion){
        service.saveSuggestion(suggestion);
        return "redirect:/suggestions";
    }

    // 📋 View suggestions
    @GetMapping("/suggestions")
    public String viewSuggestions(Model model){
        model.addAttribute("suggestions", service.getAllSuggestions());
        return "suggestions";
    }

    @GetMapping("/analysis")
    public String analysis(Model model){

        model.addAttribute("totalReports", service.getTotalReports());
        model.addAttribute("mostCongested", service.getMostCongestedArea());
        model.addAttribute("peakTime", service.getPeakTrafficTime());
        model.addAttribute("levelData", service.getLevelDistribution());
        model.addAttribute("countMap", service.getReportCountByLocation());

        return "analysis";
    }

    @GetMapping("/map")
    public String mapView(Model model){

        model.addAttribute("summary", service.getSeveritySummary());
        model.addAttribute("reports", service.getAllReports());
        model.addAttribute("countMap", service.getReportCountByLocation());

        return "map";
    }

    @GetMapping("/map-advanced")
    public String advancedMap(Model model){

        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("summary", service.getSeveritySummary());

        return "map-advanced";
    }
}

