## Challenge #1 - 10/04/2025
Consider this scenario:

A wellness centre has only one psychiatrist. There is an array of patients[i] = [arrival[i], time[i]]
​
- arrival: is the arrival time of the [i]th patient. The arrival times are sorted in non-decreasing order.

- time: is the time needed to examine the [i]th patient. When a patient arrives, they give their symptoms to the pyschiatrist, and the pyschiatrist starts examining them once he is idle. The patient waits till the pyschiatrist finishes examining them. The pyschiatrist examines patients in the order they were given in the input.

Return the average waiting time of all patients. Return the answer rounded down to the nearest integer less than or equal to the
answer.

## Notes

- ⁠The pyschiatrist examines only one patient at a time.
- ⁠The waiting time includes the time they spent with the pyschiatrist.

## Function Description

Create a function that takes the following 2 parameters and returns the solution:

- ⁠N: Represents the number of patients

- patient: Represents the entry time and examining time for each patient

## Input format for custom testing

Note: Use this input format to test against custom input.

- The first line contains N denoting the number of patients.

- ⁠The next N lines contain two (2) integers each, containing the entry time and examining time for each patient.

## Output format

Print a single integer, representing the rounded average waiting time.

## Constraints

- 1 <= N <= 10^5
- 1 <= arrival[i], time[i] <= 10^9
