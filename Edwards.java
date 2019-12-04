package ttt;
//@author edwardsdw
public class Edwards  {
    private int type;
    private String name;
    
    private static int[][] winConditions = new int[8][3];
    private boolean[] possibleWins;
    private boolean[] possibleLosses;
    
    public Edwards()  {
        type = -1;
        name = "Edwards";
    }
    public String getName()  {
        return name;
    }
    public int getType()  {
        return type;
    }
    public void callX(boolean yes)  {
        if (yes)
            type = 1;
        else
            type = 0;
    }
    public void reset()  {
        for (int x = 0; x < 9; x++)
            winConditions[x / 3][x % 3] = x;
        for (int x = 0; x < 3; x++)  {
            winConditions[x + 3][0] = x;
            winConditions[x + 3][1] = x + 3;
            winConditions[x + 3][2] = x + 6;
        }
        for (int x = 0; x < 9; x += 4)
            winConditions[7][x / 4] = x;
        for (int x = 2; x < 7; x += 2)
            winConditions[8][(x / 2) - 1] = x;
        //-----
        possibleWins = new boolean[8];
        for (int x = 0; x < 8; x++)
            possibleWins[x] = true;
        //-----
        possibleLosses = new boolean[8];
        for (int x = 0; x < 8; x++)
            possibleLosses[x] = true;
    }
    public int firstPlay()  {
        return 4;
    }
    public int play()  {
        //...
    }
    private boolean winningMove(int[] returnAttempt, boolean self)  {  //REDOING THE searchWin METHOD
        int countMy = 0;
        int countFree = 0;
        Board.copy();
        int subType = -1;
        if (self)
            subType = type;
        else  {
            if (type == 1)
                subType = 0;
            else
                subType = 1;
        }
        int loopControl = 0;
        boolean found = false;
        while (found && loopControl < winConditions.length)  {
            countMy = 0;
            countFree = 0;
            for (int y = 0; y < 2; y++)  {
                if (workspace[winConditions[loopControl][y]] == subType)
                    countMy++;
                if (workspace[winConditions[loopControl][y]] == -1)
                    countFree;
            }
            //INCOMPLETE -- still have to do stuff dependant on how many self-claimed/non-claimed spaces are in the section of the workspace
            loopControl++;
        }
    }
    private int determineClaim(int[] attempt)  {  //Takes in a win condition to attempt for and returns which space to take
        
    }
}
