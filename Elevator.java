public class Elevator 
{
    private int weightLimit = 6000;
    protected boolean inUse;
    private int currentWeight;
    private int peopleInside;
    protected int waitingLine;
    protected int waitTime; // used to determine the approximate wait time but dividing waitingLine into increments of 20 people
    private boolean elevatorPass;

    public Elevator(int peopleInside, boolean inUse, int additionalWeight, int waitingLine) 
    {
        this.peopleInside = peopleInside;
        this.currentWeight = this.peopleInside * 150 + additionalWeight;
        this.waitingLine = waitingLine;
        waitTime = waitingLine / 20;
        this.inUse = inUse;
        this.elevatorPass = false;
    }

    // pass status
    public void changePass(boolean hasPass) 
    {
        elevatorPass = hasPass;
    }
    public boolean getPass() {
        return elevatorPass;
    }

    // weight limit
    public void changeWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }
    public int getWeightLimit() 
    {
        return weightLimit;
    }
    public int getCurrentWeight() 
    {
        return currentWeight;
    }


    public boolean canUseElevator(int userWeight) 
    {
        if (inUse && userWeight + currentWeight <= weightLimit) return true;
        return false;
    }




    public String displayStatus(String elevatorName) {
        String status = "Elevator " + elevatorName + "--------------------------";
        status += "\n Floor range: 1 - 7 ";
        if (inUse) {
            status += "\n Status: Currently in use";
            status += "\n On line: " + waitingLine; // shows the amount of people waiting on line
        }
        else {
            status += "\n Status: Broken"; // broken or in use, if broken, display reason and approximate time until repair
        }
        status += "\n ================================";
        return status;
    }

    
}
