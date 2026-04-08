# 🚦 Traffic Congestion Analysis & Awareness System

A Spring Boot-based web application designed to analyze traffic congestion in Indore and provide insights using user-generated data, visualization, and smart analytics.

---

## 📌 Project Overview

This project focuses on understanding and visualizing traffic congestion using a combination of:

* 📊 Data analysis
* 🗺️ Map-based visualization
* 👥 User-generated traffic reports
* 💡 Smart recommendations

It aims to promote awareness and assist in better urban mobility planning.

---

## 🚀 Features

### 🗺️ Traffic Map

* View congestion across multiple locations
* Google Maps integration
* Severity-based visualization

### 🚦 Advanced Map (🔥 Highlight Feature)

* Google Maps JavaScript API
* Live traffic layer
* Colored markers (Low / Moderate / Severe)
* Filter markers by severity

### 📊 Dashboard

* Total zones & reports
* Most congested area detection
* Traffic level distribution (Chart.js)

### 🚨 Traffic Reporting System

* Users can report traffic conditions
* Levels: Low, Medium, High
* Timestamp-based tracking

### 🔍 Search & Filter

* Search reports by location
* Filter by traffic level

### 💬 Suggestions System

* Users can provide feedback & solutions

### 🧠 Analysis Page

* Insights and learnings from other cities
* Suggested improvements for Indore

---

## 🧠 How It Works

1. Users submit traffic reports

2. System assigns scores:

   * High = 3
   * Medium = 2
   * Low = 1

3. Total score determines severity:

   * 0–3 → Low
   * 4–7 → Moderate
   * 8+ → Severe

4. Results are visualized using:

   * Maps
   * Dashboard
   * Charts

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot
* **Frontend:** Thymeleaf + Bootstrap
* **Database:** H2 / JPA
* **Maps:** Google Maps API
* **Charts:** Chart.js

---

## 📷 Screenshots (Add later)

* Home Page
* Dashboard
* Map View
* Advanced Map

---

## ⚙️ Setup Instructions

```bash
# Clone the repository
git clone https://github.com/your-username/traffic-analysis.git

# Navigate to project
cd traffic-analysis

# Run application
./mvnw spring-boot:run
```

Then open:

```
http://localhost:8080
```

---

## ⚠️ Note

* Replace Google Maps API key before running
* Do not expose API keys in public repositories

---

## 🎯 Future Improvements

* Real-time traffic APIs integration
* Route optimization
* Machine learning prediction
* User authentication system

---

## 👨‍💻 Author

**Shivam Pandey**

---
