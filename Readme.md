# NutriScan AI 🥗📸

NutriScan AI is a modern Android application that scans food product nutrition labels using the device camera and analyzes their health impact using AI-driven logic. The app provides color-coded health scores, percentage-based safety indicators, and clear bullet-point recommendations to help users make better dietary choices.

---

 <p align="center">
  <img src="post5.2.jpeg" width="200"/>
  <img src="post5.3.jpeg" width="200"/>
    <img src="post7.2.jpeg" width="200"/>
  <img src="post7.3.jpeg" width="200"/>
</p

## 🚀 Features

- 📸 **Scan Nutrition Labels** using CameraX
- 🔍 **OCR Text Recognition** with Google ML Kit
- 🧠 **AI-Powered Health Analysis**
- 📊 **Color-Coded Health Score**
  - 🟢 Safe
  - 🟡 Moderate
  - 🔴 Dangerous
- 📝 **Bullet-Point Health Impact Explanation**
- 🎨 **Modern UI** built with Jetpack Compose (Material 3)
- 🧱 **Clean MVVM Architecture**

---

## 🏗️ Tech Stack

| Layer | Technology |
|-----|-----------|
| Language | Kotlin |
| UI | Jetpack Compose (Material 3) |
| Architecture | MVVM |
| Camera | CameraX |
| OCR | Google ML Kit |
| Dependency Injection | Hilt |
| State Management | StateFlow |
| Navigation | Navigation Compose |
| Min SDK | 24 |

---

## 📱 App Flow

1. User opens the app  
2. Taps **Scan Food Label**  
3. Camera opens and scans the back of a food product  
4. Nutrition values are extracted using OCR  
5. AI analyzes the data  
6. App displays:
   - Health score percentage
   - Color-coded safety level
   - Bullet-point health impact on the body

---

## 🎯 Health Score Logic

| Score Range | Status | Color |
|-----------|-------|-------|
| 70–100% | Safe | 🟢 Green |
| 40–69% | Moderate | 🟡 Yellow |
| 0–39% | Dangerous | 🔴 Red |


---

## 🔐 Privacy

- No images are stored
- OCR processing is done locally
- User data is never shared

---

## 🛣️ Roadmap

- [ ] Barcode scanning support  
- [ ] Personalized health profiles  
- [ ] Daily nutrition tracking  
- [ ] Cloud-based AI recommendations  

---

## 👨‍💻 Author

**Aman Tiwari**  
Android Developer | Kotlin | MVVM | AI-Driven Apps  

📌 Open to freelance and full-time Android opportunities

---

## ⭐ If you like this project

Give it a star ⭐ and feel free to fork or contribute!
