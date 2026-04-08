# 🚦 Indore Traffic Congestion Analysis & Awareness System

A Spring Boot-based web application designed specifically to analyze traffic congestion in **Indore, Madhya Pradesh**, and provide insights using user-generated data, map visualization, and smart analytics.

---

## 📌 Project Overview

Indore is one of India’s fastest-growing cities, facing increasing traffic congestion due to rapid urbanization.

This project focuses on:

* 📍 Identifying congestion hotspots in Indore
* 📊 Analyzing traffic patterns using user reports
* 🗺️ Visualizing traffic conditions using maps
* 💡 Providing awareness and improvement suggestions

---

## 🚀 Features

### 🗺️ Indore Traffic Map

* View congestion across major areas like:

  * Vijay Nagar
  * Palasia
  * Rajwada
  * Bhawarkuan
* Google Maps integration
* Severity-based visualization

---

### 🚦 Advanced Map (🔥 Highlight Feature)

* Google Maps JavaScript API
* Live traffic layer (real-time traffic colors)
* Colored markers based on congestion:

  * 🔴 Severe
  * 🟡 Moderate
  * 🟢 Low
* Filter markers by severity

---

### 📊 Dashboard

* Total traffic zones in Indore
* Total reports submitted
* Most congested area detection
* Traffic level distribution (Chart.js)

---

### 🚨 Traffic Reporting System

* Users can report traffic in Indore
* Levels:

  * Low
  * Medium
  * High
* Timestamp-based tracking

---

### 🔍 Search & Filter

* Search reports by Indore locations
* Filter based on traffic level

---

### 💬 Suggestions System

* Users can submit ideas to improve traffic in Indore

---

### 🧠 Analysis Page

* Insights on Indore traffic patterns
* Comparison with cities like Bangalore & Delhi
* Suggested improvements for better traffic management

---

## 🧠 How It Works

1. Users submit traffic reports for Indore locations

2. System assigns scores:

   * High = 3
   * Medium = 2
   * Low = 1

3. Total score determines congestion severity:

   * 0–3 → Low
   * 4–7 → Moderate
   * 8+ → Severe

4. Results are visualized through:

   * 📍 Maps
   * 📊 Dashboard
   * 📈 Charts

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot
* **Frontend:** Thymeleaf + Bootstrap
* **Database:** H2 / JPA
* **Maps:** Google Maps API
* **Charts:** Chart.js

---

## 📷 Screenshots (Add later)

* Home Page (Indore Zones)
* Dashboard
* Traffic Map
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

* Integration with real-time traffic APIs
* Route optimization for Indore roads
* Machine learning-based congestion prediction
* User authentication system

---

## 👨‍💻 Author

**Shivam Pandey**

---

## ⭐ If you like this project

Give it a star ⭐ on GitHub!
