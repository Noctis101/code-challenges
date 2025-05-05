package main.java.org.codechallenges;

public class Main {

    public static int solution(int N, int[][] patient) {
        /*
         * N = number of patients
         *
         * p/patient = 2D array of patients
         *
         * p[i][0] = arrival time of a patient
         * p[i][1] = time taken by a patient
         *
         * s = start time of the next patient
         *
         * awt = average waiting time
         * twt = total waiting time
         *
         * s = max(s, p[i][0]) + p[i][1]
         *
         * awt = (∑ (s - p[i][0])) / N
         *           i=0 to N-1
         */

        int s = 0;
        int twt = 0;

        for (int i = 0; i < N; i++) {
            s = Math.max(s, patient[i][0]) + patient[i][1];
            twt += s - patient[i][0];
        }

        return twt / N;
    }

}
