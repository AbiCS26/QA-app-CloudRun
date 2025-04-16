import { useEffect, useState } from "react";

export default function QuizPage({ username, onLogout }) {
  const [questions, setQuestions] = useState([]);
  const [answers, setAnswers] = useState({});
  const [score, setScore] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/api/questions")
      .then((res) => res.json())
      .then(setQuestions);
  }, []);

  const handleChange = (questionId, option) => {
    setAnswers((prev) => ({ ...prev, [questionId]: option }));
  };

  const handleSubmit = () => {
    fetch("http://localhost:8080/api/submit", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(answers),
    })
      .then((res) => res.json())
      .then((data) => setScore(data.score));
  };

  return (
    <div className="p-8 max-w-2xl mx-auto">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-3xl font-bold">Q&A Application</h1>
        <button
          onClick={onLogout}
          className="bg-gray-300 hover:bg-gray-400 text-gray-800 px-4 py-1 rounded"
        >
          Log Out
        </button>
      </div>
      <p className="mb-4 text-lg font-medium">Hello, {username}!</p>
      {questions.map((q) => (
        <div key={q.id} className="mb-6">
          <p className="font-medium text-lg mb-2">{q.text}</p>
          {q.options.map((opt) => (
            <label key={opt} className="block cursor-pointer">
              <input
                type="radio"
                name={q.id}
                value={opt}
                checked={answers[q.id] === opt}
                onChange={() => handleChange(q.id, opt)}
                className="mr-2"
              />
              {opt}
            </label>
          ))}
        </div>
      ))}
      <button
        onClick={handleSubmit}
        className="bg-blue-600 hover:bg-blue-700 text-white px-6 py-2 rounded"
      >
        Submit
      </button>
      {score !== null && (
        <p className="mt-4 text-xl font-semibold">Your score: {score}</p>
      )}
    </div>
  );
}
