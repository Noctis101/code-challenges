## Challenge #3 — Bug Fixing Challenge
Below are three self-contained bug-fix scenarios. You are only required to solve one.

---

### Java - Strategy Pattern Not Selecting the Expected Implementation

**Context:** A service attempts to dynamically choose and execute a write strategy for different data sinks (e.g., MySQL, CSV). Depending on input, it selects a specific writer implementation and invokes it.

**Observed Behaviour:** In certain cases, the wrong strategy is applied, or an exception occurs during strategy resolution. This results in incorrect output or runtime errors.

**Task:** Analyze why the correct strategy is not being selected or invoked. Refactor or fix the issue while maintaining the ability to support multiple strategies.

---

### TypeScript - Autosave Behavior in React Component Exhibits Unexpected Console Logs

**Context:** A React form component is built with an autosave mechanism that logs or saves input at a fixed interval. The autosave depends on the current input value entered by the user.

**Observed Behaviour:** After using the form for a while or navigating away and back, console logs begin to multiply or display outdated input. In some cases, stopping and restarting the app resolves the issue temporarily.

**Task:** Investigate why the autosave behavior becomes inconsistent over time. Identify the issue and provide a solution that ensures correct and efficient autosave behavior without side effects.

---

### Python - RAM Availability Check Returns Inconsistent Results

**Context:** A function determines if a system has enough available RAM (in MB) to proceed with a task. The logic uses data from a system resource library to evaluate whether memory requirements are met.

**Observed Behaviour:** On some machines, the check passes when it should fail, or fails when it should pass. Results appear inconsistent between different operating systems or environments.

**Task:** Evaluate the memory checking logic and determine why inconsistencies occur. Adjust the function to produce consistent, platform-resilient results.

---

## Submission Instructions
Please see ```challenge-3/bug-fixing-submissions/README.md```
