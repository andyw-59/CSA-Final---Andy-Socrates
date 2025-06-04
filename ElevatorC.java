public class ElevatorC extends Elevator 
{
    public ElevatorC(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) 
    {
        super(peopleInside, inUse, additionalWeight, waitingLine); 
    }

    public String displayStatus() {
        String status = "Elevator C --------------------------";
        status += "\n Floor range: 1 - 9";
        status += "\n Location: Center West";
        if (inUse) {
            status += "\n Status: Currently in use";
            status += "\n On line: " + waitingLine; // shows the amount of people waiting on line
            status += "\n Approximate wait time: " + (waitingLine / 20) + " minutes";
        }
        else {
            status += "\n Status: Broken"; // broken or in use, if broken, display reason and approximate time until repair
        }
        status += "\n Misc: Music students";

        return status;
    }
}
