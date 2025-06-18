package org.codechallenges;

import java.util.Arrays;
/**
 * Code Challenge - Wellness Centre Patient Walk-in's
 * <p>
 * Modify this Main class with your own solution and run the unit tests to verify the average waiting time.
 */
public class Main {

    public static int solution(int N, int[][] patient) {
        int nextFreeTime = 0;
        int cumulativeTimeWaited = 0;
        for (int i = 0; i < N; i++) {
            //Doctor is Free:
            if ( patient[i][0] >= nextFreeTime) {
                nextFreeTime = patient[i][0];
            }
            int endTime = nextFreeTime + patient[i][1];
            int patientWaitTime = endTime - patient[i][0];
            nextFreeTime = endTime;
            cumulativeTimeWaited += patientWaitTime;

            // For debugging:
            System.out.println("Patient " + Arrays.toString(patient[i]) +
                    " - Arrival time: " + patient[i][0] +
                    " - Time needed: " + patient[i][1] +
                    " - Waiting time: " + patientWaitTime +
                    ", Next free time: " + nextFreeTime);
            patientWaitTime = 0;
        }

        System.out.println("Cumulative Waiting Time: " + cumulativeTimeWaited);
        System.out.println("Average Waiting Time: ");
        return (int) (cumulativeTimeWaited / N);
    }

}