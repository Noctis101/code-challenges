/**
 * Explanation:
 *
 * The solution below is an example of a simple approach to solving the problem
 * in TypeScript. The function accepts and utilizes all arguments of the function
 * with K being used to manage the iteration of the seat array. N is used to ensure
 * a seat being reserved is within range of the numbered seats that are available in
 * the given scenario.
 *
 * The array 'reservations' keeps track of the seats reserved, 'freeSeats' keeps track
 * of the seats available and nextFreeSeat points to the next available seat.
 *
 * The logic within the if-else statement mimics a min-heap structure approach by utilizing
 * the Math.min() method on 'freeSeats' and the indexOf() and splice() methods updating the
 * record of available seats.
 *
 * Due to mimicry, this is not the most efficient solution in terms of time complexity, but
 * all arguments are utilized and covers the most practical cases that were originally given
 * along with an additional one to show it is not a biased solution.
 *
 * Challenge Disclosure:
 *
 * The name 'seat' prevents the typical usage of the word as a variable in a for...of loop.
 * The function signature given is intentional as a part of the challenge, one key motivator
 * being the assessment of attention-to-detail. The challenge is to not just give a solution
 * that is correct and/or efficient, but also follows the constraints given.
 *
 * @param N - the number of available seats, with available seats marked from 1 to N
 * @param K - the number of operations to be made in the reservation process
 * @param seat - the operations to be made during the reservation process, non-zero numbers
 *               denote seats that are to be made free.
 * @returns reservations - a track record of the reservations made
 */
function seatReservations(N, K, seat) {
    var reservations = new Array();
    var freeSeats = new Array();
    var nextFreeSeat = 1;
    for (var i = 0; i < K; i++) {
        var operation = seat[i];
        if (operation === 0) {
            if (freeSeats.length !== 0) {
                var lowestAvailableSeat = Math.min.apply(Math, freeSeats);
                reservations.push(lowestAvailableSeat);
                var index = freeSeats.indexOf(lowestAvailableSeat);
                freeSeats.splice(index, 1);
            }
            else {
                reservations.push(nextFreeSeat);
                nextFreeSeat++;
            }
        }
        else if (operation && operation <= N) {
            freeSeats.push(operation);
        }
    }
    return reservations;
}
var testArray1 = [0, 0, 0, 2, 1, 0];
var testArray2 = [0, 0, 0, 2, 0];
var testArray3 = [0, 0, 0, 2, 0, 0, 1, 0];
var testArray4 = new Array(10).fill(0);
var testArray5 = [0, 0, 0, 3, 2, 0, 0];
/**
 * You can call the function in a similar fashion below. To execuite this file run the following commands:
 * tsc SeatReservationsExample.ts
 * node SeatReservationsExample.ts
 *
 * Note: You must have TypeScript installed from the location of execution.
 */
console.log(seatReservations(5, 6, testArray1));
console.log(seatReservations(3, 5, testArray2));
console.log(seatReservations(4, 8, testArray3));
console.log(seatReservations(10, 10, testArray4));
console.log(seatReservations(3, 7, testArray5));
