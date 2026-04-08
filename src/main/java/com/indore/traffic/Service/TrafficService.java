package com.indore.traffic.Service;

import com.indore.traffic.Model.Location;
import com.indore.traffic.Model.Suggestion;
import com.indore.traffic.Model.TrafficReport;
import com.indore.traffic.Model.TrafficZone;
import com.indore.traffic.Repository.LocationRepository;
import com.indore.traffic.Repository.SuggestionRepository;
import com.indore.traffic.Repository.TrafficReportRepository;
import com.indore.traffic.Repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrafficService {

    @Autowired
    private TrafficRepository trafficRepository;

    @Autowired
    private SuggestionRepository suggestionRepository;

    @Autowired
    private TrafficReportRepository trafficReportRepository;

    @Autowired
    private LocationRepository locationRepository;

    // ================= ZONES =================
    public List<TrafficZone> getAllZones() {
        return trafficRepository.findAll();
    }

    public void saveZone(TrafficZone zone) {
        trafficRepository.save(zone);
    }

    // ================= REPORTS =================
    public List<TrafficReport> getAllReports() {
        return trafficReportRepository.findAll();
    }

    public void saveReport(TrafficReport report) {
        trafficReportRepository.save(report);
    }

    // ================= SEVERITY LOGIC =================
    public int getScoreForLevel(String level) {
        if(level.equalsIgnoreCase("High")) return 3;
        if(level.equalsIgnoreCase("Medium")) return 2;
        return 1;
    }

    public Map<String,Integer> getSeverityScoreByLocation() {

        List<TrafficReport> reports = trafficReportRepository.findAll();
        Map<String,Integer> scoreMap = new HashMap<>();

        for(TrafficReport r : reports) {
            int score = getScoreForLevel(r.getLevel());
            scoreMap.put(r.getLocation(),
                    scoreMap.getOrDefault(r.getLocation(), 0) + score);
        }

        return scoreMap;
    }

    public String getSeverityLabel(int score) {
        if(score >= 8) return "Severe";
        if(score >= 4) return "Moderate";
        return "Low";
    }

    // 🔥 UPDATED METHOD (VERY IMPORTANT)
    public Map<String,String> getSeveritySummary() {

        Map<String,Integer> scoreMap = getSeverityScoreByLocation();
        Map<String,String> result = new HashMap<>();

        List<Location> locations = locationRepository.findAll();

        for(Location loc : locations){

            String name = loc.getName();
            int score = scoreMap.getOrDefault(name, 0);

            // ✅ ALWAYS assign severity
            result.put(name, getSeverityLabel(score) + " (" + score + " score)");
        }

        return result;
    }

    // ================= ANALYTICS =================
    public long getTotalReports(){
        return trafficReportRepository.count();
    }

    public long getTotalZones(){
        return trafficRepository.count();
    }

    public String getMostCongestedArea(){

        Map<String,Integer> scoreMap = getSeverityScoreByLocation();

        String maxLocation="None";
        int maxScore=0;

        for(String loc:scoreMap.keySet()){
            int score=scoreMap.get(loc);

            if(score>maxScore){
                maxScore=score;
                maxLocation=loc;
            }
        }

        return maxLocation+" ("+maxScore+" score)";
    }

    public String getPeakTrafficTime(){
        return "Evening (5 PM - 9 PM)";
    }

    // ================= SEARCH & FILTER =================
    public List<TrafficReport> searchByLocation(String location){
        return trafficReportRepository
                .findByLocationContainingIgnoreCase(location);
    }

    public List<TrafficReport> filterByLevel(String level){
        return trafficReportRepository
                .findByLevelIgnoreCase(level);
    }

    // ================= SUGGESTIONS =================
    public void saveSuggestion(Suggestion suggestion){
        suggestionRepository.save(suggestion);
    }

    public List<Suggestion> getAllSuggestions(){
        return suggestionRepository.findAll();
    }

    // ================= EXTRA ANALYTICS =================
    public Map<String, Long> getReportCountByLocation(){

        List<TrafficReport> reports = trafficReportRepository.findAll();
        Map<String, Long> countMap = new HashMap<>();

        for(TrafficReport r : reports){
            countMap.put(r.getLocation(),
                    countMap.getOrDefault(r.getLocation(), 0L) + 1);
        }

        return countMap;
    }

    public Map<String, Integer> getLevelDistribution(){

        List<TrafficReport> reports = trafficReportRepository.findAll();
        Map<String, Integer> map = new HashMap<>();

        for(TrafficReport r : reports){
            String level = r.getLevel();
            map.put(level, map.getOrDefault(level, 0) + 1);
        }

        return map;
    }
}