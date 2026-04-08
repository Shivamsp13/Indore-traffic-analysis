package com.indore.traffic.Repository;

import java.util.List;
import com.indore.traffic.Model.TrafficReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficReportRepository extends JpaRepository<TrafficReport, Long> {
    List<TrafficReport> findByLocationContainingIgnoreCase(String location);
    List<TrafficReport> findByLevelIgnoreCase(String level);
}