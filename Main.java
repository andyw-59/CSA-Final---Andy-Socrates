import java.util.Scanner;
public class Main {

private static boolean passing = false;
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Elevator Monitor ===================================================");
        System.out.println("Select an option: ");
        System.out.println("1. View status of an elevator");
        System.out.println("2. View elevator suggestions");
        int option = scanner.nextInt();

        System.out.println("Is it passing period? T/F");
        String passingPeriod = scanner.next();

        if (passingPeriod.equals("T")) passing = true;
        
        int random = randomWaiting();
        int random2 = randomWaiting();
        Elevator test = new Elevator(randomPeople(), randomStatus(), 0, randomWaiting());
        ElevatorA testA = new ElevatorA(randomPeople(), randomStatus(), 0, random); // random will be the same for A/B 
        ElevatorB testB = new ElevatorB(randomPeople(), randomStatus(), 0, random);
        ElevatorC testC = new ElevatorC(randomPeople(), randomStatus(), 0, randomWaiting());
        ElevatorD testD = new ElevatorD(randomPeople(), randomStatus(), 0, random2);
        ElevatorE testE = new ElevatorE(randomPeople(), randomStatus(), 0, random2);
        ElevatorF testF = new ElevatorF(randomPeople(), randomStatus(), 0, randomWaiting());
        ElevatorG testG = new ElevatorG(randomPeople(), randomStatus(), 0, randomWaiting());
        ElevatorH testH = new ElevatorH(randomPeople(), randomStatus(), 0, randomWaiting());
        ElevatorI testI = new ElevatorI(randomPeople(), randomStatus(), 0, randomWaiting());
        testF.changeWeightLimit(10000);

        if (option == 1) {
            System.out.println("Select an elevator to view the status of: ");
            System.out.println("----> A B C D E F G H I ");
            String elevatorPicker = scanner.next();

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


        System.out.println("Are you a teacher or student? T/S");
        String client = scanner.next();

        // floor inputs
        System.out.println("What floor are you currently on? 0-9");
        int currentFloor = scanner.nextInt();
        System.out.println("What floor do you want to get to? 0-9");
        int targetFloor = scanner.nextInt();
        if (currentFloor == targetFloor) { // if currentFloor = targetFloor, program stops runnning
            System.out.println("Cannot use elevator to go to the current floor. Exiting program...");
            System.exit(1);
        }

        // medical pass status
        System.out.println("Do you have an medical pass? Y/N");
        String pass = scanner.next();
        if (pass.equals("Y")) {
            test.changePass(true);
        }
        
        System.out.println("What side of the building are you currently on? NE / SE / SW / NW");
        String side = scanner.next();

        if (client.equals("T")) { // TEACHER CLIENT
           if (passing && test.getPass()) { // passing + has pass
            System.out.println("Staff may not use the following elevators during passing: A B D E");
            System.out.println(testF.displayStatus());
            System.out.println(testG.displayStatus());
            System.out.println(testH.displayStatus());
           } 
           else if (passing) { // passing + no pass (removes elevator H)
            System.out.println("Staff may not use the following elevators during passing: A B D E");
            System.out.println(testF.displayStatus());
            System.out.println(testG.displayStatus());
           } 
           else if (passing == false && test.getPass()) { // not passing + has pass
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

            System.out.println(testF.displayStatus());
            System.out.println(testG.displayStatus());
            System.out.println(testH.displayStatus());
           }

            else if (passing == false) { // not passing + no pass
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
                System.out.println(testF.displayStatus());
                System.out.println(testG.displayStatus());

            }
        }

        if (client.equals("S")) { // STUDENT CLIENT

            if (passing && test.getPass() || passing == false && test.getPass()) { // passing + has pass = A B D E F G  ------> OR not passing + has pass
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

public static boolean randomStatus() {
   double num = Math.floor(Math.random() * 10) + 1;
   if (num <= 2) return false;
   return true;
}

public static int randomPeople() {
    int num = (int) (Math.random() * 14);
    if (passing) {
        while (num < 15) {
            num = (int) (Math.random() * 30);
        }
    }
    return num;
}

public static int randomWaiting() {
    int num = 0;
    num = (int) (Math.floor(Math.random() * 10) + 1);
    if (passing) {
        num = (int) (Math.floor(Math.random() * 91) + 10); // random number 10 - 100 inclusive
        // possibly make it increase with more time passed during passing period
    }
    return num;
}



}
