public class Main {

    public static int solution(int numberOfPatients, int[][] patients) {
        int count = 0;
        for (int index = 0; index < numberOfPatients; index++) {
            // If it is not the first patient and their arrival time is the same as the patient before then add that patient wait time to the current
            if (index > 0 && patients[index - 1][0] == patients[index][0]) {
                patients[index][1] = patients[index][1] + patients[index - 1][1];
            } else if (index > 0 && didPreviousOverStay(index, patients)) {
                // This condition is going to push back the current patient time to see the doctor and increase their wait time
                int previousPatientArrivalTime = patients[index - 1][0];
                int previousPatientWaitTime = patients[index - 1][1];
                int currentPatientsArrivalTime = patients[index][0];
                int currentPatientsWaitTime = patients[index][1];

                patients[index][0] = previousPatientWaitTime + previousPatientArrivalTime;
                patients[index][1] = (previousPatientWaitTime - currentPatientsArrivalTime) + currentPatientsWaitTime;
            }
            count = count + patients[index][1];

        }
        return count / numberOfPatients;
    }

    /**
     * This method check is the previous patient wait time over stepped in to another start time
     * @param currentPatient this is the index of the current patient
     * @param patients this is the array of patients
     * @return boolean
     * */
    private static boolean didPreviousOverStay(int currentPatient, int[][] patients) {
        int tempCurrentStartTime = patients[currentPatient][0];
        int tempPreviousEndTime = patients[currentPatient - 1][1];
        int tempPreviousArrivalTime = patients[currentPatient - 1][0];
        return tempCurrentStartTime < tempPreviousEndTime + tempPreviousArrivalTime;
    }

    public static void main(String[] args) {
        System.out.println("Use the unit tests to verify your solution.");
    }
}