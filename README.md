# Q&A Application 📝

This is a full-stack Q&A (Quiz) application built with **React (Vite + Tailwind CSS)** on the frontend and **Spring Boot (Java)** on the backend.

---

## 🧩 Features

- Dynamically fetches quiz questions from the backend.
- Allows users to answer single-choice questions.
- Displays score upon submission.

---

## 📁 Project Structure

```
root/
├── backend/           # Spring Boot app
└── frontend/          # React app (Vite + Tailwind CSS)
```

---

## ✨ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/qa-app.git
cd qa-app
```

---

### 2. Backend Setup (Spring Boot)

#### Prerequisites:
- Java 17+
- Gradle

#### Steps:

```bash
cd backend
./gradlew bootRun
```

> The backend server will run on `http://localhost:8080`.

---

### 3. Frontend Setup (React + Vite + Tailwind)

#### Prerequisites:
- Node.js v16+
- npm

#### Steps:

```bash
cd frontend
npm install
npm run dev
```

> The frontend app will run on `http://localhost:5173`.

---

## 🌐 API Endpoints

- `GET /api/questions` – fetches all quiz questions
- `POST /api/submit` – submits answers and returns the score

---

## ⚙️ CORS Setup

The backend is configured to accept requests from the frontend on `http://localhost:5173` using:

```java
@CrossOrigin(origins = "http://localhost:5173")
```

---

## 📝 Notes

- Do **not** commit the `build/` or `.gradle/` folders from the backend.
- TailwindCSS is used for styling on the frontend.
- Add more questions by modifying the list in `QuestionService.java`.

---

## 📸 Screenshot

![screenshot](https://dummyimage.com/600x400/cccccc/000000&text=Q%26A+App)

---

## 🛠️ Technologies Used

- **Frontend**: React, Vite, Tailwind CSS
- **Backend**: Spring Boot, Java 17
- **Build Tool**: Gradle

---

## 📃 License

MIT License
