package ttt;

//Author: Mr. Murray
public class Board 
{
    public static int[] workspace = new int[9];
    private static int[] actual = new int[9];

    public static void reset() {
        for(int x = 0; x < 9; x++)
        {
            actual[x] = -1;
            workspace[x] = -1;
        }
    }

    public static void copy() {
        for(int x = 0; x < 9; x++)
            workspace[x] = actual[x];
        
    }
    

    public static void claim(int move, int mark)
    {
        actual[move] = mark;
    }
    
    
    //This Print method is very basic.  Feel Free to change it to something that is 
    //  easier for you to use...

    public static void print() {
        for(int x = 0; x < 9; x++)
        {
            if(x > 0 && x%3 == 0 ) System.out.println("\n---+---+---");
            if(actual[x]==-1) System.out.print("   ");
            else if(actual[x]==1) System.out.print(" X ");
            else System.out.print(" O ");
	    if( (x+1)%3 != 0 ) System.out.print("|");
        }
        System.out.println("\n");
    }
    
}
