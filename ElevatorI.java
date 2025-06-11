public class ElevatorI extends Elevator {
    private int waitTime;
    public ElevatorI(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) 
    {
        super(peopleInside, inUse, additionalWeight, waitingLine); 
        waitTime = waitingLine / 20;
        if (waitTime == 0) waitTime = 1;
    }

    public String displayStatus() {
        String status = "[Elevator I] ---------------STATUS--------------- [Elevator I]";
        status +=    "\n |                     Floor range: 0 - 3                     |";
        status +=    "\n |                   Location: Next to GYM 1                  |";
        if (true) {
            status +="\n |             Status: Used only by custodial staff           |";
        }
        status +=    "\n |           Misc: Not accessible to students/teachers        |  ";
        status +=    "\n +------------------------------------------------------------+";

        return status;
    }

    public double Score(boolean passing, boolean medicalPass, String client, int currentFloor, int targetFloor, int side, double waitTimeFactor, int waitTime) {
        double score = 0.0;
        if (inUse) {
            if ((client.equals("Custodian"))) {
                if ((currentFloor <= 9 && currentFloor >= 1) && (targetFloor <= 9 && targetFloor >= 1)) {
                    double waitPenalty = waitTime * waitTimeFactor;
                    double locationPenalty = locationPenalty(side, 4) * (1 - waitTimeFactor);
                    score = 100 - waitPenalty - locationPenalty;
                }
            }
        }   
        return score;
    }

    public int getWaitTime() {
        return waitTime;
    }
}
