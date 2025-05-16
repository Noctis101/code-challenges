/*
T - Time
D - Delay
EnT - Entry Time
ExT - Exam Time
CuWT - Customer Wait Time

Formula
D = T - EnT
CuWT = D + ExT

-----------------------------------------------------------------------------
Case 1 (Stream of Patients)
Test Data :: [[0, 5], [1, 10], [2, 15]]
P1 [0(EnT), 5(ExT)]
T is at 0 
Patient arrived at 0
Patient waited for 0(D) before ExT
Ext is 5, CuWT = 5(ExT)
T is now 5

P2 [1(EnT), 10(ExT)]
T is at 5
Patient arrived at 1 
Patient waited 5(T) - 1(EnT) = 4(D) before ExT
ExT is 10, CuWT = 4(D) + 10(ExT) = 14
T is now 5(T) + 10(ExT) = 15

P3 [2(EnT), 15(ExT)]
T is at 15
Patient arrived at 2
Patient waited 15(T) - 2(Ent) = 13(D) before ExT
ExT is 15, CuWT = 13(D) + 15(ExT) = 28
T is now 15(T) + 15(ExT)

AvgWT = floor((5 + 14 + 28)/3) = 15

-----------------------------------------------------------------------------
Case 2 (No Queue, Time Gap)
Test Data :: [[0, 5], [5, 10], [10, 15], [50,20]]
P1 [0, 5]
T is at 0
Patient arrived at 0
Patient waited for 0(D) before ExT
CuWT = 0(D) + 5(ExT) = 5
T = 0(T) + 5(ExT)

P2 [5, 10]
T is at 5
Patient Arrived at 5
Patient waited for 5(T) - 5(EnT) = 0(D) before ExT
CuWT = 0(D) + 10(ExT) = 10
T = 5(T) + 10(ExT) = 15

P3 [10, 15]
T is at 15
Patient arrived at 10
Patient waited for 15(T) - 10(EnT) = 5(D) before ExT
CuWT = 5(D) + 15(ExT) = 20
T = 15(T) + 15(ExT) = 30

P4 [50, 20]
T is at 30, EnT is 50, set T to 50
Patient Arrived at 50
Patient Waited for 50(T)-50(EnT) = 0(D) before ExT
CuWT = 0(D) + 20(ExT) = 20
T = 50(T) + 20(ExT)

AvgWT = floor((5+10+20+20)/4) = 13

-----------------------------------------------------------------------------
Case 3 (Non-Zero Entry Time)
Test Data = [[2, 5], [5, 10], [10, 15], [20,20], [100,20]]
P1 [2, 5]
T is at 0, EnT is 2, set T to 2
D = 2(T) - 2(EnT) = 0
CuWT = 0(D) + 5(ExT) = 5
T = 2(T) + 5(ExT) = 7

P2 [5, 10]
T is at 7
D = 7(T) - 5(EnT) = 2
CuWT = 2(D) + 10(ExT) = 12
T = 7(T) = 10(ExT) = 17 

P3 [10, 15]
17(T) > 10(EnT)
CuWT = (17(T)-10(EnT)) + 15(ExT) = 22
T = 17(T) + 15(ExT) = 32(T)

P4 [20, 20]
32(T) > 20(EnT)
CuWT = (32(T)-20(EnT)) + 20(ExT) = 32
T = 32(T) + 20(ExT) = 52

P5 [100, 20]
52(T) < 100(EnT), Set T to 100
CuWT = (100(T)-100(EnT)) + 20(ExT) = 20
T = 100(T) + 20(ExT) = 120

AvgWT = floor((5+12+22+32+20)/5) = 18

Case 4 (Arrive at same time)
Test Data = [[2, 5], [2, 5], [2, 10]]
P1 [2, 5]
P2 [2, 5]
P3 [2, 10]
*/

/**
 * 
 * @param {[[entryTime, examTime]]} patients array of patients
 */
function findAvgWaitTime(patients) {
    let time = 0;
    let sum = 0;

    for (let i = 0; i < patients.length; i++) {
        const [entryTime, examTime] = patients[i];

        console.log(`> Patient: EnT(${entryTime}), ExT(${examTime})`);
        //Check time gap case
        if (time < entryTime) {
            time = entryTime;
            console.log(`${time}[T] < ${entryTime}[EnT], set T to ${entryTime}`);
        }

        // D = T - EnT
        // CuWT = D + ExT
        console.log(`CuWT = (${time}[T] - ${entryTime}[EnT]) + ${examTime}[ExT] = ${(time-entryTime)+examTime}`);
        sum += (time - entryTime) + examTime

        time += examTime
    }

    // Round down average waiting time
    return Math.floor(sum / patients.length);
}

export default function main() {
    let patients = []
    //Case 1
    console.log('-------------Case 1--------------');
    patients = [[0, 5], [1, 10], [2, 15]];
    console.log(patients, findAvgWaitTime(patients));

    //Case 2
    console.log('-------------Case 2--------------');
    patients = [[0, 5], [5, 10], [10, 15], [50,20]];
    console.log(patients, findAvgWaitTime(patients));

    //Case 3
    console.log('-------------Case 3--------------');
    patients = [[2, 5], [5, 10], [10, 15], [20,20], [100,20]];
    console.log(patients, findAvgWaitTime(patients));
    
    //Case 4
    console.log('-------------Case 4--------------');
    patients = [[2, 5], [2, 5], [2, 10]];
    console.log(patients, findAvgWaitTime(patients));
    
}

main();