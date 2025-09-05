## Challenge #4 — Problem Solving Challenge
Below is a problem solving scenario. You may solve it in any of the following languages:

- TypeScript/JavaScript
- Java
- Python
- C#

---

# Seat Reservation System Challenge

## Scenario

A movie theatre has **N seats**, numbered from **1 to N**. You're tasked with implementing a **seat reservation system** that performs **K operations**, each of which:

1. Reserves the **smallest-numbered unreserved seat**, or
2. Cancels a reservation for a specific seat.

After each reservation (not cancellation), the system must return the **seat number** that was reserved.

---

## Objective

Implement a function that processes the operations efficiently and returns the list of reserved seat numbers in the order they were made.

---

## Input Format

* `N` → Integer: Number of seats (1-indexed, from 1 to N)
* `K` → Integer: Number of operations
* `seat` → Integer array of size K

    * If `seat[i] == 0`, reserve the **smallest available** seat
    * If `seat[i] > 0`, cancel the reservation for seat number `seat[i]`

### Example:

```
N = 5
K = 6
seat = [0, 0, 0, 2, 1, 0]
```

### Output:

```
[1, 2, 3, 1]
```
---

## Output Format

Print an array containing the reserved seat numbers in order.
Only include seat numbers that were actually reserved (i.e., ignore cancellations).

---

## Constraints

* `1 < N < 10^5`
* `1 < K < 10^5`
* `0 <= seat[i] <= N`
* Each reservation guarantees an unreserved seat is available.
* Each cancellation guarantees that the seat was reserved.

---

## Example Function Signature

In Java:

```
public static List<Integer> seatReservation(int N, int K, int[] seat)
```

---


## Submission Instructions
Please see ```challenge-4/seat-reservations-submissions/README.md```
