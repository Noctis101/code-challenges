const solution = require('./solution');

describe('Tests for Wellness Centre solution', () => {
  test('1. Single patient', () => {
    expect(solution(1, [[0, 5]])).toBe(5);
  });

  test('2. Two patients, second waits', () => {
    expect(solution(2, [[0, 3], [1, 2]])).toBe(3);
  });

  test('3. Two patients, no waiting', () => {
    expect(solution(2, [[0, 2], [3, 2]])).toBe(2);
  });

  test('4. Multiple patients with same arrival', () => {
    expect(solution(3, [[1, 3], [1, 2], [1, 1]])).toBe(3);
  });

  test('5. Idle psychiatrist', () => {
    expect(solution(3, [[0, 1], [5, 3], [10, 2]])).toBe(2);
  });

  test('6. Early crowd, long wait', () => {
    expect(solution(4, [[0, 5], [0, 5], [0, 5], [0, 5]])).toBe(12);
  });

  test('7. Delayed arrivals, spaced out', () => {
    expect(solution(3, [[0, 2], [10, 2], [20, 2]])).toBe(2);
  });

  test('8. Gradual overlap', () => {
    expect(solution(3, [[0, 2], [1, 2], [2, 2]])).toBe(3);
  });

  test('9. High values, large exam times', () => {
    expect(solution(2, [[100000000, 500000000], [600000000, 400000000]])).toBe(450000000);
  });

  test('10. Maximum values stress test (small N)', () => {
    expect(solution(1, [[1000000000, 1000000000]])).toBe(1000000000);
  });
});