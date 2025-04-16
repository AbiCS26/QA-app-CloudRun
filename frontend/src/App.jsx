import { useState } from "react";
import LoginPage from "./components/LoginPage";
import QuizPage from "./components/QuizPage";

export default function App() {
  const [username, setUsername] = useState(null); // Tracks logged-in user
  const [isLoggedIn, setIsLoggedIn] = useState(false); // Tracks login status

  const handleLogin = (user) => {
    setUsername(user);
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    setUsername(null);
    setIsLoggedIn(false);
  };

  return (
    <div className="app">
      {!isLoggedIn ? (
        <LoginPage onLogin={handleLogin} />
      ) : (
        <QuizPage username={username} onLogout={handleLogout} />
      )}
    </div>
  );
}
