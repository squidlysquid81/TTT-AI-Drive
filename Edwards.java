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
}
