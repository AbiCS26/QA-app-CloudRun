import { useState } from 'react';

export default function LoginPage({ onLogin }) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const handleLogin = async () => {
    const trimmedUsername = username.trim();
    const trimmedPassword = password.trim();
  
    if (!trimmedUsername || !trimmedPassword) {
      setErrorMessage("Username and password cannot be empty!");
      return;
    }
  
    try {
      const response = await fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username: trimmedUsername, password: trimmedPassword }),
      });
  
      if (!response.ok) {
        // Server is reachable but login failed (e.g., 401 Unauthorized)
        setErrorMessage("Invalid username or password.");
        return;
      }
  
      onLogin(trimmedUsername); // Successful login
    } catch (error) {
      // This block catches actual network errors like ECONNREFUSED
      console.error("Login failed due to network error:", error);
      setErrorMessage("Unable to connect to the server. Please try again later.");
    }
  };
  
  

  return (
    <div className="flex flex-col items-center justify-center h-screen">
      <h1 className="text-2xl font-bold mb-4">Login</h1>
      <input
        className="border px-4 py-2 mb-2 rounded"
        type="text"
        placeholder="Enter username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        className="border px-4 py-2 mb-2 rounded"
        type="password"
        placeholder="Enter password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      {errorMessage && <p className="text-red-500 text-sm">{errorMessage}</p>}
      <button
        className="bg-blue-500 text-white px-4 py-2 rounded mt-4"
        onClick={handleLogin}
      >
        Start Quiz
      </button>
    </div>
  );
}
