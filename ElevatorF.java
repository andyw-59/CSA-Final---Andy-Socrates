public class ElevatorF extends Elevator {
    private int waitTime;
    public ElevatorF(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) {
        super(peopleInside, inUse, additionalWeight, waitingLine); 
        waitTime = waitingLine / 20;
        if (waitTime == 0) waitTime = 1;
    }

    public String displayStatus() {
        String status = "[Elevator F] ---------------STATUS--------------- [Elevator F]";
        status +=    "\n |                     Floor range: 0 - 7                     |";
        status +=    "\n |                    Location: Southeast                     |";
        if (inUse) {
            status +="\n |                  Status: Currently in use                  |";
            status +="\n |                  On line: " + waitingLine + "             "; // shows the amount of people waiting on line
            status +="\n |               Approximate wait time: " + (waitingLine / 20) + " minutes ";
        }
        else {
            status +="\n |                       Status: Broken                       |"; // broken or in use, if broken, display reason and approximate time until repair
        }
        status +=    "\n | Misc: Pass required-Staff/Medical/Students-Local elevator  |  ";
        status +=    "\n +------------------------------------------------------------+";

        return status;
    }

    public double Score(boolean passing, boolean medicalPass, String client, int currentFloor, int targetFloor, int side, double waitTimeFactor, int waitTime) {
        double score = 0.0;
        if (inUse) {
            if (client.equals("T") || (client.equals("S") && medicalPass)) {
                if ((currentFloor <= 7 && currentFloor >= 0) && (targetFloor <= 7 && targetFloor >= 0)) {
                    double waitPenalty = waitTime * waitTimeFactor;
                    double locationPenalty = locationPenalty(side, 3) * (1 - waitTimeFactor);
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
