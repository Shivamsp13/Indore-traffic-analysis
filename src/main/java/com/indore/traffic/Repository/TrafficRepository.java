package com.indore.traffic.Repository;

import com.indore.traffic.Model.TrafficZone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficRepository extends JpaRepository<TrafficZone, Long> {
}