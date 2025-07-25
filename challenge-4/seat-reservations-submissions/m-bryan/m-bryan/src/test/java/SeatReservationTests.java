import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatReservationTests {

    @Test
    @DisplayName("Test Case 1: Basic reservations and cancellations")
    void testBasicCase() {
        int N = 5;
        int K = 6;
        int[] seat = {0, 0, 0, 2, 1, 0};
        List<Integer> result = SeatReservation.seatReservation(N, K, seat);
        assertThat(result).containsExactly(1, 2, 3, 1);
    }

    @Test
    @DisplayName("Test Case 2: Reuse of cancelled seats")
    void testReuseCancelled() {
        int N = 3;
        int K = 5;
        int[] seat = {0, 0, 0, 2, 0};
        List<Integer> result = SeatReservation.seatReservation(N, K, seat);
        assertThat(result).containsExactly(1, 2, 3, 2);
    }

    @Test
    @DisplayName("Test Case 3: Multiple cancels and reuses")
    void testMultipleCancels() {
        int N = 4;
        int K = 8;
        int[] seat = {0, 0, 0, 2, 0, 0, 1, 0};
        List<Integer> result = SeatReservation.seatReservation(N, K, seat);
        assertThat(result).containsExactly(1, 2, 3, 2, 4, 1);
    }

    @Test
    @DisplayName("Test Case 4: Only reservations")
    void testOnlyReservations() {
        int N = 10;
        int K = 10;
        int[] seat = new int[10];
        List<Integer> result = SeatReservation.seatReservation(N, K, seat);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    @DisplayName("Test Case 5: Stress test with max N and K")
    void testStressCase() {
        int N = 100000;
        int K = 100000;
        int[] seat = new int[K];
        for (int i = 0; i < K; i++) {
            seat[i] = 0;
        }
        List<Integer> result = SeatReservation.seatReservation(N, K, seat);
        assertThat(result.size()).isEqualTo(100000);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(99999)).isEqualTo(100000);
    }
}