import java.util.*;

public class SeatReservation {

    public static List<Integer> seatReservation(int n, int k, int[] seats) {
        int currentSlot = 1;
        List<Integer> reservations = new ArrayList<>();
        Deque<Integer> cancellations = new ArrayDeque<>();
        for (int seat : seats) {
            if (seat == 0) {
                if (!cancellations.isEmpty()) {
                    reservations.add(cancellations.pop());  // reuse most recent cancellation
                } else {
                    reservations.add(currentSlot);
                    currentSlot++;
                }
            } else {
                cancellations.push(seat);  // store cancellation (LIFO)
            }
        }
        return reservations;
    }
}

        /* Explanation - {0, 0, 0, 2, 1, 0} - first three(3) 0's is where cancellations is empty add currentSlot reservations = [1,2,3]
        2 and 1 added to cancellations Deque using stack like op push (LIFO) reservations = [1,2,3], cancellations = [1,2]
        last 0 cancellations is not empty, so we add latest cancellation (1) to reservations. reservations = [1,2,3,1], cancellations = [1,2]
        */