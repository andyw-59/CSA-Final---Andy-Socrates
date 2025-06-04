public class ElevatorF extends Elevator {
    public ElevatorF(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) {
        super(peopleInside, inUse, additionalWeight, waitingLine); 
    }

    public String displayStatus() {
        String status = "Elevator F --------------------------";
        status += "\n Floor range: 0 - 7";
        if (inUse) {
            status += "\n Status: Currently in use";
            status += "\n On line: " + waitingLine; // shows the amount of people waiting on line
            status += "\n Approximate wait time: " + (waitingLine / 20) + " minutes";
        }
        else {
            status += "\n Status: Broken"; // broken or in use, if broken, display reason and approximate time until repair
        }
        status += "\n Misc: No pass needed -- Staff/Medical";

        return status;
    }
}
