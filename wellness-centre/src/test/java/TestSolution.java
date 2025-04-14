import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.codechallenges.Main.solution;

public class TestSolution {

    @DisplayName("Tests for Wellness Centre solution")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @Nested
    class SolutionTests {

        @Test
        @Order(1)
        @DisplayName("1. Single patient")
        void singlePatient() {
            int[][] patient = {{0, 5}};
            assertThat(solution(1, patient)).isEqualTo(5);
        }

        @Test
        @Order(2)
        @DisplayName("2. Two patients, second waits")
        void twoPatientsWithWaiting() {
            int[][] patient = {{0, 3}, {1, 2}};
            assertThat(solution(2, patient)).isEqualTo(3);
        }

        @Test
        @Order(3)
        @DisplayName("3. Two patients, no waiting")
        void twoPatientsNoWaiting() {
            int[][] patient = {{0, 2}, {3, 2}};
            assertThat(solution(2, patient)).isEqualTo(2);
        }

        @Test
        @Order(4)
        @DisplayName("4. Multiple patients with same arrival")
        void sameArrival() {
            int[][] patient = {{1, 3}, {1, 2}, {1, 1}};
            assertThat(solution(3, patient)).isEqualTo(3);
        }

        @Test
        @Order(5)
        @DisplayName("5. Idle psychiatrist")
        void psychiatristIdleBetweenPatients() {
            int[][] patient = {{0, 1}, {5, 3}, {10, 2}};
            assertThat(solution(3, patient)).isEqualTo(2);
        }

        @Test
        @Order(6)
        @DisplayName("6. Early crowd, long wait")
        void earlyCrowd() {
            int[][] patient = {{0, 5}, {0, 5}, {0, 5}, {0, 5}};
            assertThat(solution(4, patient)).isEqualTo(12);
        }

        @Test
        @Order(7)
        @DisplayName("7. Delayed arrivals, spaced out")
        void spacedArrivals() {
            int[][] patient = {{0, 2}, {10, 2}, {20, 2}};
            assertThat(solution(3, patient)).isEqualTo(2);
        }

        @Test
        @Order(8)
        @DisplayName("8. Gradual overlap")
        void gradualOverlap() {
            int[][] patient = {{0, 2}, {1, 2}, {2, 2}};
            assertThat(solution(3, patient)).isEqualTo(3);
        }

        @Test
        @Order(9)
        @DisplayName("9. High values, large exam times")
        void highExamTimes() {
            int[][] patient = {{100000000, 500000000}, {600000000, 400000000}};
            assertThat(solution(2, patient)).isEqualTo(450_000_000);
        }

        @Test
        @Order(10)
        @DisplayName("10. Maximum values stress test (small N)")
        void maxValues() {
            int[][] patient = {{1_000_000_000, 1_000_000_000}};
            assertThat(solution(1, patient)).isEqualTo(1_000_000_000);
        }
    }

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @Nested
    class StressTest {

        @Test
        @Order(11)
        @DisplayName("Stress test with 100,000 patients")
        void largeInputTest() {
            int N = 100_000;
            int currentArrival = 0;
            int[][] patient = new int[N][2];
            Random random = new Random(42);

            for (int i = 0; i < N; i++) {
                currentArrival += random.nextInt(3);
                int examTime = random.nextInt(900) + 100;
                patient[i][0] = currentArrival;
                patient[i][1] = examTime;
            }

            assertThatCode(() -> {
                int avgWait = solution(N, patient);
                System.out.println("Average wait time (stress test): " + avgWait);
            }).doesNotThrowAnyException();
        }
    }
}
