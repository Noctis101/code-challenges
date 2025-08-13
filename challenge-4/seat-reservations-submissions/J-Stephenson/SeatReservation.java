import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class SeatReservation {

    public static List<Integer> seatReservation(int N, int K, int[] seat) {
        List<Integer> res = new ArrayList<>();
        TreeSet<Integer> cancellations = new TreeSet<>();
        int seatCounter = 1;

        for (int seatNum : seat) {
            if (seatNum == 0) {
                if (!cancellations.isEmpty()) {
                    res.add(cancellations.first() < seatCounter ? cancellations.pollFirst() : seatCounter);
                }
                else {
                    res.add(seatCounter);
                    seatCounter++;
                }
            }
            else {
                cancellations.add(seatNum);
            }
        };

        return res;
    }

}
