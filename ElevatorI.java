public class ElevatorI extends Elevator {
    
    public ElevatorI(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) 
    {
        super(peopleInside, inUse, additionalWeight, waitingLine); 
    }

    public String displayStatus() {
        String status = "Elevator I --------------------------";
        status += "\n Floor range: 0 - 3";
        status += "\n Location: Next to GYM 1";
        status += "\n Status: Used only by custodial staff";
        status += "\n Misc: Not accessible to students/teachers";
        return status;
    }
}
