package ttt;
//@author edwardsdw
public class Edwards {
    private int type;
    private String name;
    
    private static final int[][] winConditions = new int[8][3];
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
        int takeSpace;
        Board.copy();
        int[] attemptFor = new int[3];
        if (winningMove(attemptFor, true) || winningMove(attemptFor, false))  {
            for (int x = 0; x < attemptFor.length; x++)  {
                if (Board.workspace[attemptFor[x]] == -1)
                    takeSpace = attemptFor[x];
            }
        }
        else if (setUp(attemptFor, true))  {
            
        }
        return takeSpace;
    }
    private boolean setUp(int[] returnAttempt, boolean self)  {  //Discovers if the determined player can set up a win for the next turn
        boolean found = false;
        int subType;
        int oppType;
        if (self)
            subType = type;
        else  {
            if (type == 1)
                subType = 0;
            else
                subType = 1;
        }
        if (subType == 1)
            oppType = 0;
        else
            oppType = 1;
        
        return found;
    }
    private boolean winningMove(int[] returnAttempt, boolean self)  {  //REDOING THE searchWin METHOD
        int countMy;
        int subType;
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
            for (int y = 0; y < 2; y++)  {
                if (Board.workspace[winConditions[loopControl][y]] == subType)
                    countMy++;
            }
            if (countMy == 2 && !blocked(winConditions[loopControl], true))  {
                found = true;
                returnAttempt = winConditions[loopControl];
            }
            loopControl++;
        }
        return found;
    }
    private boolean blocked(int[] attempt, boolean self)  {
        boolean output = false;
        int subType;
        int oppType;
        if (self)
            subType = type;
        else  {
            if (type == 1)
                subType = 0;
            else
                subType = 1;
        }
        if (subType == 1)
            oppType = 0;
        else
            oppType = 1;
        for (int place = 0; place < attempt.length; place++)  {
            if (Board.workspace[attempt[place]] == oppType)
                output = true;
        }
        return output;
    }
}