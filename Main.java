import java.util.Scanner;
import java.util.ArrayList;
public class Main {

private static boolean passing = false;
private static boolean elevatorPass = false;
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+-----------------------------+ +-----------------------------+ +-----------------------------+ +-----------------------------+");
        System.out.println("|   WELCOME TO THE TECHLIFT   | |   WELCOME TO THE TECHLIFT   | |   WELCOME TO THE TECHLIFT   | |   WELCOME TO THE TECHLIFT   |");
        System.out.println("+-----------------------------+ +-----------------------------+ +-----------------------------+ +-----------------------------+");
        System.out.println("Options:");
        System.out.println("    1. View status of an elevator");
        System.out.println("    2. View elevator suggestions");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        System.out.print("Is it passing period? T/F: ");
        String passingPeriod = scanner.next().toUpperCase();

        if (passingPeriod.equals("T")) passing = true;
        
        int random = randomWaiting("A");
        int random2 = randomWaiting("D");
        Elevator test = new Elevator(randomPeople(), randomStatus(), 0, randomWaiting("test"));
        ElevatorA testA = new ElevatorA(randomPeople(), randomStatus(), 0, random); // random will be the same for A/B 
        ElevatorB testB = new ElevatorB(randomPeople(), randomStatus(), 0, random);
        ElevatorC testC = new ElevatorC(randomPeople(), randomStatus(), 0, randomWaiting("C"));
        ElevatorD testD = new ElevatorD(randomPeople(), randomStatus(), 0, random2); // random will be the same for D/E
        ElevatorE testE = new ElevatorE(randomPeople(), randomStatus(), 0, random2);
        ElevatorF testF = new ElevatorF(randomPeople(), randomStatus(), 0, randomWaiting("F"));
        ElevatorG testG = new ElevatorG(randomPeople(), randomStatus(), 0, randomWaiting("G"));
        ElevatorH testH = new ElevatorH(randomPeople(), randomStatus(), 0, randomWaiting("H"));
        ElevatorI testI = new ElevatorI(randomPeople(), randomStatus(), 0, randomWaiting("I"));
        testF.changeWeightLimit(10000);
        ArrayList<Elevator> testCases = new ArrayList<Elevator>();
        testCases.add(testA); testCases.add(testB); testCases.add(testC); testCases.add(testD); testCases.add(testE); testCases.add(testF); testCases.add(testG); testCases.add(testH); testCases.add(testI); 



        // OPTION 1
        if (option == 1) {
            System.out.println("");
            System.out.println("Select an elevator to view the status of: ");
            System.out.print("----> A B C D E F G H I:  ");
            String elevatorPicker = scanner.next().toUpperCase();
            System.out.println("");
            
            if (elevatorPicker.equals("A")) {
                System.out.println(testA.displayStatus());
            }

            if (elevatorPicker.equals("B")) {
                System.out.println(testB.displayStatus());
            }

            if (elevatorPicker.equals("C")) {
                System.out.println(testC.displayStatus());
            }

            if (elevatorPicker.equals("D")) {
                System.out.println(testD.displayStatus());
            }

            if (elevatorPicker.equals("E")) {
                System.out.println(testE.displayStatus());
            }

            if (elevatorPicker.equals("F")) {
                System.out.println(testF.displayStatus());
            }

            if (elevatorPicker.equals("G")) {
                System.out.println(testG.displayStatus());
            }

            if (elevatorPicker.equals("H")) {
                System.out.println(testH.displayStatus());
            }

            if (elevatorPicker.equals("I")) {
                System.out.println(testI.displayStatus());
            }
            System.exit(1);
        }
        // OPTION 1


        System.out.print("Are you a teacher or student? T/S:  ");
        String client = scanner.next().toUpperCase();

        // floor inputs
        System.out.print("What floor are you currently on? 0-9:  ");
        int currentFloor = scanner.nextInt();
        System.out.print("What floor do you want to get to? 0-9:  ");
        int targetFloor = scanner.nextInt();
        while (currentFloor == targetFloor) { // continue to ask the same two questions until currentFloor does not equal targetFloor
            System.out.print("Please enter a valid floor combination: ");
            System.out.print("What floor are you currently on? 0-9: ");
            currentFloor = scanner.nextInt();
            System.out.print("What floor do you want to get to? 0-9: ");
            targetFloor = scanner.nextInt();
        }

        // medical pass status
        System.out.print("Do you have a medical pass? Y/N: ");
        String pass = scanner.next().toUpperCase();
        if (pass.equals("Y")) {
            test.changePass(true);
            elevatorPass = true;
        }
        
        System.out.println("Sides of the building: ");
        System.out.println("1: NorthEast");
        System.out.println("2: NorthWest");
        System.out.println("3: SouthEast");
        System.out.println("4: SouthWest");
        System.out.println("5: CenterEast");
        System.out.println("6: CenterWest");
        System.out.print("What side of the building are you currently on?:  ");
        int side = scanner.nextInt();
        testA.changeSide(side); testB.changeSide(side); testC.changeSide(side); testD.changeSide(side); testE.changeSide(side); testF.changeSide(side); testG.changeSide(side); testH.changeSide(side); testI.changeSide(side); // changes the user side for all the subclasses

        System.out.println("What is your wait time factor? This number should be between 0 and 1");
        System.out.println("Location proximity factor will be 1 minus the wait time factor");
        System.out.print("Wait Time Factor(0-1):  ");
        double waitTimeFactor = scanner.nextDouble();
        System.out.println("");
        System.out.println(".........................................................................................................RECOMMENDED ELEVATOR");
        System.out.println("");
        //ELEVATORS A/B
        double scoreA = 0.0;
        double scoreB = 0.0;
        if (testA.canUseElevator(150) && testB.canUseElevator(150)) {
            int placeholderAB = (random / 30) + 1; // fix timing
            scoreA = testA.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, placeholderAB);
            scoreB = testB.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, placeholderAB);
        }
        else if (testA.canUseElevator(150)) {
            int placeholderA = (random / 20) + 2; // fix timing
            scoreA = testA.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, placeholderA);
            scoreB = testB.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, 100);
        }
        else if (testB.canUseElevator(150)) {
            int placeholderB = (random / 20) + 2; // fix timing
            scoreB = testB.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, placeholderB);
            scoreA = testA.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, 100);
        }
        // ELEVATORS D/E
        double scoreD = 0.0;
        double scoreE = 0.0;
        if (testD.canUseElevator(150) && testE.canUseElevator(150)) {
            int placeholderDE = (random / 30) + 1; // fix timing
            scoreD = testD.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, placeholderDE);
            scoreE = testE.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, placeholderDE);
        }
        else if (testD.canUseElevator(150)) {
            int placeholderD = (random / 20) + 2; // fix timing
            scoreD = testD.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, placeholderD);
            scoreE = testE.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, 100);
        }
        else if (testE.canUseElevator(150)) {
            int placeholderE = (random / 20) + 2; // fix timing
            scoreE = testB.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, placeholderE);
            scoreD = testA.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, 100);
        }
        
        // UNPAIRED ELEVATORS
        double scoreC = testC.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, testC.getWaitTime());
        double scoreF = testF.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, testF.getWaitTime());
        double scoreG = testG.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, testG.getWaitTime());
        double scoreH = testH.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, testH.getWaitTime());
        double scoreI = testI.Score(passing, elevatorPass, client, currentFloor, targetFloor, side, waitTimeFactor, testI.getWaitTime());
        ArrayList<Double> scores = new ArrayList<Double>();
        scores.add(scoreA); scores.add(scoreB); scores.add(scoreC); scores.add(scoreD); scores.add(scoreE); scores.add(scoreF); scores.add(scoreG); scores.add(scoreH); scores.add(scoreI);

        if (client.equals("T")) { // TEACHER CLIENT
           if (passing && test.getPass()) { // passing + has pass
            System.out.println("Staff may not use the following elevators during passing: A B D E");
            // suggestion //
            System.out.println("Suggested elevator(s): ");
            System.out.println(findBiggest3(scoreF, scoreG, scoreH)); // prints score
            System.out.println(identifyBiggest3(scores, scoreF, scoreG, scoreH)); // identifies the best elevator
            System.out.println(displayBiggest3(scores, scoreF, scoreG, scoreH, testCases));
            System.out.println("------------------------------------------------------------------------------------------------------ APPLICABLE ELEVATORS");
            // all statuses
            System.out.println(testF.displayStatus());
            System.out.println(testG.displayStatus());
            System.out.println(testH.displayStatus());
           } 

           else if (passing) { // passing + no pass (removes elevator H)
            System.out.println("Staff may not use the following elevators during passing: A B D E");
            System.out.println("Looks like you have to take the stairs...");
           } 

           else if (test.getPass()) { // not passing + has pass
            // suggestion //
            System.out.println("Suggested elevator(s): ");
            System.out.println(findBiggest7(scoreA, scoreB, scoreD, scoreE, scoreF, scoreG, scoreH)); // prints score
            System.out.println(identifyBiggest7(scores, scoreA, scoreB, scoreD, scoreE, scoreF, scoreG, scoreH)); // identifies the best elevator
            System.out.println(displayBiggest7(scores, scoreA, scoreB, scoreD, scoreE, scoreF, scoreG, scoreH, testCases));
            System.out.println("------------------------------------------------------------------------------------------------------ APPLICABLE ELEVATORS");
            // all statuses
            System.out.println(testA.displayStatus());
            System.out.println(testB.displayStatus());
            if (testA.canUseElevator(150) && testB.canUseElevator(150)) {
                int placeholderAB = (random / 30) + 1; // fix timing
                System.out.println("");
                System.out.println("Approximate wait time: " +  placeholderAB);
                System.out.println("");
            }
            else if (testA.canUseElevator(150)) {
                int placeholderA = (random / 20) + 2; // fix timing
                System.out.println("");
                System.out.println("Approximate wait time: " +  placeholderA);
                System.out.println("");
            }
            else if (testB.canUseElevator(150)) {
                int placeholderB = (random / 20) + 2; // fix timing
                System.out.println("");
                System.out.println("Approximate wait time: " +  placeholderB);
                System.out.println("");
            }
            System.out.println(testD.displayStatus());
            System.out.println(testE.displayStatus());
            if (testD.canUseElevator(150) && testE.canUseElevator(150)) {
                int placeholderDE = (random / 30) + 1; // fix timing
                System.out.println("");
                System.out.println("Approximate wait time for elevators D & E: " +  placeholderDE);
                System.out.println("");
            }
            else if (testD.canUseElevator(150)) {
                int placeholderD = (random / 20) + 2; // fix timing
                System.out.println("");
                System.out.println("Approximate wait time for elevator D: " +  placeholderD);
                System.out.println("");
            }
            else if (testE.canUseElevator(150)) {
                int placeholderE = (random / 20) + 2; // fix timing
                System.out.println("");
                System.out.println("Approximate wait time for elevator E: " +  placeholderE);
                System.out.println("");
            }
            System.out.println(testF.displayStatus());
            System.out.println(testG.displayStatus());
            System.out.println(testH.displayStatus());
           }

            else if (passing == false) { // not passing + no pass
                // suggestion //
                System.out.println("Suggested elevator(s): ");
                System.out.println(findBiggest4(scoreA, scoreB, scoreD, scoreE)); // prints score
                System.out.println(identifyBiggest4(scores, scoreA, scoreB, scoreD, scoreE)); // identifies the best elevator
                System.out.println(displayBiggest4(scores, scoreA, scoreB, scoreD, scoreE, testCases));
                System.out.println("------------------------------------------------------------------------------------------------------ APPLICABLE ELEVATORS");
                // all statuses
                System.out.println(testA.displayStatus());
                System.out.println(testB.displayStatus());
                if (testA.canUseElevator(150) && testB.canUseElevator(150)) {
                    int placeholderAB = (random / 30) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time: " +  placeholderAB);
                    System.out.println("");
                }
                else if (testA.canUseElevator(150)) {
                    int placeholderA = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time: " +  placeholderA);
                    System.out.println("");
                }
                else if (testB.canUseElevator(150)) {
                    int placeholderB = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time: " +  placeholderB);
                    System.out.println("");
                }
                System.out.println(testD.displayStatus());
                System.out.println(testE.displayStatus());
                if (testD.canUseElevator(150) && testE.canUseElevator(150)) {
                    int placeholderDE = (random / 30) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevators D & E: " +  placeholderDE);
                    System.out.println("");
                }
                else if (testD.canUseElevator(150)) {
                    int placeholderD = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator D: " +  placeholderD);
                    System.out.println("");
                }
                else if (testE.canUseElevator(150)) {
                    int placeholderE = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator E: " +  placeholderE);
                    System.out.println("");
                }
            }
        }

        if (client.equals("S")) { // STUDENT CLIENT
            if (passing && test.getPass() || passing == false && test.getPass()) { // passing + has pass = A B D E F G  ------> OR not passing + has pass
                // suggestion //
                System.out.println("Suggested elevator(s): ");
                System.out.println(findBiggest6(scoreA, scoreB, scoreD, scoreE, scoreF, scoreG)); // prints score
                System.out.println(identifyBiggest6(scores, scoreA, scoreB, scoreD, scoreE, scoreF, scoreG)); // identifies the best elevator
                System.out.println(displayBiggest6(scores, scoreA, scoreB, scoreD, scoreE, scoreF, scoreG, testCases));
                System.out.println("------------------------------------------------------------------------------------------------------ APPLICABLE ELEVATORS");
                // all statuses
                System.out.println(testA.displayStatus());
                System.out.println(testB.displayStatus());
                if (testA.canUseElevator(150) && testB.canUseElevator(150)) {
                    int placeholderAB = (random / 30) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevators A or B: " +  placeholderAB);
                    System.out.println("");
                }
                else if (testA.canUseElevator(150)) {
                    int placeholderA = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator A: " +  placeholderA);
                    System.out.println("");
                }
                else if (testB.canUseElevator(150)) {
                    int placeholderB = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator B: " +  placeholderB);
                    System.out.println("");
                }
                System.out.println(testD.displayStatus());
                System.out.println(testE.displayStatus());
                if (testD.canUseElevator(150) && testE.canUseElevator(150)) {
                    int placeholderDE = (random / 30) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevators A or B: " +  placeholderDE);
                    System.out.println("");
                }
                else if (testD.canUseElevator(150)) {
                    int placeholderD = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator A: " +  placeholderD);
                    System.out.println("");
                }
                else if (testE.canUseElevator(150)) {
                    int placeholderE = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator B: " +  placeholderE);
                    System.out.println("");
                }
                System.out.println(testF.displayStatus());
                System.out.println(testG.displayStatus());
           } 

           else if (passing && test.getPass() == false || passing == false && test.getPass() == false) { // passing + no pass = A B D E     OR--------> not passing + no pass
                System.out.println("Students may only use elevators F & G for medical reasons");
                // suggestion //
                System.out.println("Suggested elevator(s): ");
                System.out.println(findBiggest4(scoreA, scoreB, scoreD, scoreE)); // prints score
                System.out.println(identifyBiggest4(scores, scoreA, scoreB, scoreD, scoreE)); // identifies the best elevator
                System.out.println(displayBiggest4(scores, scoreA, scoreB, scoreD, scoreE, testCases));
                System.out.println("------------------------------------------------------------------------------------------------------ APPLICABLE ELEVATORS");
                // all statuses
                System.out.println(testA.displayStatus());
                System.out.println(testB.displayStatus());
                if (testA.canUseElevator(150) && testB.canUseElevator(150)) {
                    int placeholderAB = (random / 30) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevators A or B: " +  placeholderAB);
                    System.out.println("");
                }
                else if (testA.canUseElevator(150)) {
                    int placeholderA = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator A: " +  placeholderA);
                    System.out.println("");
                }
                else if (testB.canUseElevator(150)) {
                    int placeholderB = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator B: " +  placeholderB);
                    System.out.println("");
                }
                System.out.println(testD.displayStatus());
                System.out.println(testE.displayStatus());
                if (testD.canUseElevator(150) && testE.canUseElevator(150)) {
                    int placeholderDE = (random / 30) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevators D or E: " +  placeholderDE);
                    System.out.println("");
                }
                else if (testD.canUseElevator(150)) {
                    int placeholderD = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator D: " +  placeholderD);
                    System.out.println("");
                }
                else if (testE.canUseElevator(150)) {
                    int placeholderE = (random / 20) + 1; // fix timing
                    System.out.println("");
                    System.out.println("Approximate wait time for elevator E: " +  placeholderE);
                    System.out.println("");
                }
           }
        }




}


public static boolean randomStatus() { // generates a random elevator status
   double num = Math.floor(Math.random() * 10) + 1;
   if (num <= 2) return false;
   return true;
}

public static int randomPeople() { // generates a random amount of people in the elevator
    int num = (int) (Math.random() * 10);
    if (passing) {
        while (num  <= 10) {
            num = (int) (Math.random() * 20);
        }
    }
    return num;
}

public static int randomWaiting(String elevator) { // generates a random amount of people on line
    int num = 0;
    num = (int) (Math.floor(Math.random() * 10) + 1); // random# 1-10 inclusive
    if (passing && (elevator.equals("A") || elevator.equals("B") || elevator.equals("D") || elevator.equals("E"))) {
        num = (int) (Math.floor(Math.random() * (120 - 35 + 1) + 35)); // random# 35-120 inclusive
    }
    else if (passing) {
        num = (int) (Math.random() * 11) + 10; // random# 10-20 inclusive
    }
    return num;
}

public static double findBiggest3(double score1, double score2, double score3) {
    double[] scores = {score1, score2, score3};
    double biggest = scores[0];
    for (int i = 1; i < scores.length; i++) {
        if (scores[i] > biggest) biggest = scores[i];
    }
    return biggest;
}
public static double findBiggest4(double score1, double score2, double score3, double score4) {
    double[] scores = {score1, score2, score3, score4};
    double biggest = scores[0];
    for (int i = 1; i < scores.length; i++) {
        if (scores[i] > biggest) biggest = scores[i];
    }
    return biggest;
}
public static double findBiggest6(double score1, double score2, double score3, double score4, double score5, double score6) {
    double[] scores = {score1, score2, score3, score4, score5, score6};
    double biggest = scores[0];
    for (int i = 1; i < scores.length; i++) {
        if (scores[i] > biggest) biggest = scores[i];
    }
    return biggest;
}
public static double findBiggest7(double score1, double score2, double score3, double score4, double score5, double score6, double score7) {
    double[] scores = {score1, score2, score3, score4, score5, score6, score7};
    double biggest = scores[0];
    for (int i = 1; i < scores.length; i++) {
        if (scores[i] > biggest) biggest = scores[i];
    }
    return biggest;
}

public static String identifyBiggest3(ArrayList<Double> scores, double score1, double score2, double score3) {
    double biggest = findBiggest3(score1, score2, score3);
    int location = scores.indexOf(biggest);
    String[] prompts = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    for (int i = 0; i < 9; i++) {
        if (location == i) return ("RECOMMENDED ELEVATOR: " + prompts[i]);
    }
    return "";
}
public static String identifyBiggest4(ArrayList<Double> scores, double score1, double score2, double score3, double score4) {
    double biggest = findBiggest4(score1, score2, score3, score4);
    int location = scores.indexOf(biggest);
    String[] prompts = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    for (int i = 0; i < 9; i++) {
        if (location == i) return ("RECOMMENDED ELEVATOR: " + prompts[i]);
    }
    return "";
}
public static String identifyBiggest6(ArrayList<Double> scores, double score1, double score2, double score3, double score4, double score5, double score6) {
    double biggest = findBiggest6(score1, score2, score3, score4, score5, score6);
    int location = scores.indexOf(biggest);
    String[] prompts = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    for (int i = 0; i < 9; i++) {
        if (location == i) return ("RECOMMENDED ELEVATOR: " + prompts[i]);
    }
    return "";
}
public static String identifyBiggest7(ArrayList<Double> scores, double score1, double score2, double score3, double score4, double score5, double score6, double score7) {
    double biggest = findBiggest7(score1, score2, score3, score4, score5, score6, score7);
    int location = scores.indexOf(biggest);
    String[] prompts = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    for (int i = 0; i < 9; i++) {
        if (location == i) return ("RECOMMENDED ELEVATOR: " + prompts[i]);
    }
    return "";
}

public static String displayBiggest3(ArrayList<Double> scores, double score1, double score2, double score3, ArrayList<Elevator> elevatorList) {
    double biggest = findBiggest3(score1, score2, score3);
    int location = scores.indexOf(biggest);
    for (int i = 0; i < 9; i++) {
        if (location == i) return elevatorList.get(i).displayStatus();
    }
    return "";
}
public static String displayBiggest4(ArrayList<Double> scores, double score1, double score2, double score3, double score4, ArrayList<Elevator> elevatorList) {
    double biggest = findBiggest4(score1, score2, score3, score4);
    int location = scores.indexOf(biggest);
    for (int i = 0; i < 9; i++) {
        if (location == i) return elevatorList.get(i).displayStatus();
    }
    return "";
}
public static String displayBiggest6(ArrayList<Double> scores, double score1, double score2, double score3, double score4, double score5, double score6, ArrayList<Elevator> elevatorList) {
    double biggest = findBiggest6(score1, score2, score3, score4, score5, score6);
    int location = scores.indexOf(biggest);
    for (int i = 0; i < 9; i++) {
        if (location == i) return elevatorList.get(i).displayStatus();
    }
    return "";
}
public static String displayBiggest7(ArrayList<Double> scores, double score1, double score2, double score3, double score4, double score5, double score6, double score7, ArrayList<Elevator> elevatorList) {
    double biggest = findBiggest7(score1, score2, score3, score4, score5, score6, score7);
    int location = scores.indexOf(biggest);
    for (int i = 0; i < 9; i++) {
        if (location == i) return elevatorList.get(i).displayStatus();
    }
    return "";
}

}
