public class ElevatorA extends Elevator {
    public ElevatorA(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) {
        super(peopleInside, inUse, additionalWeight, waitingLine); 
    }

    public String displayStatus() {
        String status = "[Elevator A] ---------------STATUS--------------- [Elevator A]";
        status +=    "\n |     Floor range: Without pass(1/7) or With pass(0 - 8)     |";
        status +=    "\n |                   Location: Northwest                      |";
        if (inUse) {
            status +="\n |                  Status: Currently in use                  |";
            status +="\n |                  On line: " + waitingLine + "             "; // shows the amount of people waiting on line
        }
        else {
            status +="\n |                       Status: Broken                       |"; // broken or in use, if broken, display reason and approximate time until repair
        }
        status +=    "\n |                     Misc: General Use                      |";
        status +=    "\n +------------------------------------------------------------+";

        return status;
    }

    public double Score(boolean passing, boolean medicalPass, String client, int currentFloor, int targetFloor, int side, double waitTimeFactor, int waitTime) {
        double score = 0.0; // default score
        double waitPenalty = waitTime * waitTimeFactor;
        double locationPenalty = locationPenalty(side, 2) * (1 - waitTimeFactor);
        double score2 = 100 - waitPenalty - locationPenalty; // score if elevator is working and conditions are fulfilled
        if (inUse) {
            if (passing) {
                if (client.equals("S")) {
                    if (medicalPass) { 
                        if ((currentFloor <= 8 && currentFloor >= 0) && (targetFloor <= 8 && targetFloor >= 0)) {
                            return score2;
                        }
                    }
                    if (currentFloor == 1 && targetFloor == 7) { // student w/o medical pass
                        return score2;
                    }
                }
            }
            // not passing peirod
            else if (client.equals("S")) {
                if (medicalPass) {
                    if ((currentFloor <= 8 && currentFloor >= 0) && (targetFloor <= 8 && targetFloor >= 0)) {
                        return score2;
                    }
                }
                if (currentFloor == 1 && targetFloor == 7) { // student w/o medical pass
                    return score2;
                }
            }
            else if (client.equals("T") && passing == false) {
                if (medicalPass) {
                    if ((currentFloor <= 8 && currentFloor >= 0) && (targetFloor <= 8 && targetFloor >= 0)) {
                        return score2;
                    }
                }
                if (currentFloor == 1 && targetFloor == 7) { // staff w/o medical pass
                    return score2;
                }
            }

        }   
        return score;
    }

    





}