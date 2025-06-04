public class ElevatorE extends Elevator {

    public ElevatorE(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) {
        super(peopleInside, inUse, additionalWeight, waitingLine); 
    }

    public String displayStatus() {
        String status = "Elevator E --------------------------";
        status += "\n Floor range: Without pass(1/7) or With pass(0 - 7)";
        if (inUse) {
            status += "\n Status: Currently in use";
            status += "\n On line: " + waitingLine; // shows the amount of people waiting on line
        }
        else {
            status += "\n Status: Broken"; // broken or in use, if broken, display reason and approximate time until repair
        }
        status += "\n Misc: General Use";

        return status;
    }
}

