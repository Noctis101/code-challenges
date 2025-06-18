import React, { useState, useEffect, useRef } from 'react';

export default function SubmissionForm() {
  const [input, setInput] = useState("");
  const inputRef = useRef(input);

  useEffect(() => {
    inputRef.current = input;
  }, [input]);

  useEffect(() => {
    const interval = setInterval(() => {
      console.log("Autosaving form input:", inputRef.current);
    }, 3000);

    return () => clearInterval(interval);
  }, []);

  return (
    <form>
      <input value={input} onChange={e => setInput(e.target.value)} />
    </form>
  );
}