public class Elevator 
{
    private int weightLimit = 6000;
    protected boolean inUse;
    private int currentWeight;
    private int peopleInside;
    protected int waitingLine;
    protected int waitTime; // used to determine the approximate wait time but dividing waitingLine into increments of 20 people
    private boolean elevatorPass;
    private int userSide; // will be instantiated in the main class through the changeSide method

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

    public void changeSide(int userSide) {
        this.userSide = userSide; 
    }




    public String displayStatus() {
        String status = "Elevator " + "test" + "--------------------------";
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



    public int locationPenalty(int userSide, int elevatorSide) {
    if (userSide == elevatorSide) return 0;
    
    // adjacent 
    if ((userSide == 2) && (elevatorSide == 6) || (userSide == 2) && (elevatorSide == 1) ||
        (userSide == 6) && (elevatorSide == 2) || (userSide == 6) && (elevatorSide == 4) || (userSide == 6) && (elevatorSide == 5) ||
        (userSide == 4) && (elevatorSide == 6) || (userSide == 4) && (elevatorSide == 3) || 
        (userSide == 3) && (elevatorSide == 4) || (userSide == 3) && (elevatorSide == 5) ||
        (userSide == 5) && (elevatorSide == 6) || (userSide == 5) && (elevatorSide == 3) || (userSide == 5) && (elevatorSide == 1) ||
        (userSide == 1) && (elevatorSide == 5) || (userSide == 1) && (elevatorSide == 2)) {
            return 8; 
    }

    // near adjacent/diagonal
    if ((userSide == 2) && (elevatorSide == 4) || (userSide == 2) && (elevatorSide == 5) ||
        (userSide == 6) && (elevatorSide == 3) || (userSide == 6) && (elevatorSide == 1) ||
        (userSide == 4) && (elevatorSide == 2) || (userSide == 4) && (elevatorSide == 5) ||
        (userSide == 3) && (elevatorSide == 1) || (userSide == 3) && (elevatorSide == 6) ||
        (userSide == 5) && (elevatorSide == 4) || (userSide == 5) && (elevatorSide == 2) ||
        (userSide == 1) && (elevatorSide == 3) || (userSide == 1) && (elevatorSide == 6)) {
            return 12;
    }

    // opposite
    if ((userSide == 2) && (elevatorSide == 3) ||
        (userSide == 4) && (elevatorSide == 1) ||
        (userSide == 3) && (elevatorSide == 2) ||
        (userSide == 1) && (elevatorSide == 4)) {
            return 18;
    }
    return 0; // placeholder
}

    
}
