public class ElevatorC extends Elevator {
    private int waitTime;
    public ElevatorC(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) 
    {
        super(peopleInside, inUse, additionalWeight, waitingLine); 
        waitTime = waitingLine / 20;
        if (waitTime == 0) waitTime = 1;
    }

    public String displayStatus() {
        String status = "[Elevator C] ---------------STATUS--------------- [Elevator C]";
        status +=    "\n |                     Floor range: 1 - 9                     |";
        status +=    "\n |                   Location: Center West                    |";
        if (inUse) {
            status +="\n |                  Status: Currently in use                  |";
            status +="\n |                  On line: " + waitingLine + "             "; // shows the amount of people waiting on line
            status +="\n |            Approximate wait time: " + (waitingLine / 20) + " minutes ";
        }
        else {
            status +="\n |                       Status: Broken                       |"; // broken or in use, if broken, display reason and approximate time until repair
        }
        status +=    "\n |                   Misc: Music Students                     |";
        status +=    "\n +------------------------------------------------------------+";

        return status;
    }

    public double Score(boolean passing, boolean medicalPass, String client, int currentFloor, int targetFloor, int side, double waitTimeFactor, int waitTime) {
        double score = 0.0;
        if (inUse) {
            if ((client.equals("T") || client.equals("S")) && medicalPass) {
                if ((currentFloor <= 9 && currentFloor >= 1) && (targetFloor <= 9 && targetFloor >= 1)) {
                    double waitPenalty = waitTime * waitTimeFactor;
                    double locationPenalty = locationPenalty(side, 6) * (1 - waitTimeFactor);
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
