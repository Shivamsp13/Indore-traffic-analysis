package com.indore.traffic;

import com.indore.traffic.Model.TrafficZone;
import com.indore.traffic.Model.TrafficReport;
import com.indore.traffic.Repository.TrafficRepository;
import com.indore.traffic.Repository.TrafficReportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(TrafficRepository zoneRepo, TrafficReportRepository reportRepo) {
        return args -> {

            // ✅ Only insert if DB is empty
            if(zoneRepo.count() == 0){

                zoneRepo.save(new TrafficZone("Vijay Nagar", "Vijay Nagar Indore", "6-9 PM", "Commercial congestion"));
                zoneRepo.save(new TrafficZone("Palasia", "Palasia Indore", "5-8 PM", "Office rush"));
                zoneRepo.save(new TrafficZone("Rajwada", "Rajwada Indore", "4-9 PM", "Market crowd"));
                zoneRepo.save(new TrafficZone("Bhawarkuan", "Bhawarkuan Indore", "8-11 AM", "Student traffic"));
            }

            if(reportRepo.count() == 0){

                reportRepo.save(new TrafficReport("Vijay Nagar", "High", "Heavy jam near square"));
                reportRepo.save(new TrafficReport("Vijay Nagar", "Medium", "Slow moving traffic"));
                reportRepo.save(new TrafficReport("Palasia", "High", "Office rush congestion"));
                reportRepo.save(new TrafficReport("Rajwada", "Medium", "Market crowd"));
                reportRepo.save(new TrafficReport("Bhawarkuan", "Low", "Normal flow"));
            }
        };
    }
}