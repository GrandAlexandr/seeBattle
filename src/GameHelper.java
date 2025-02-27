import java.io.*;
import java.util.*;
public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private  int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;
    public String getUserInput (String prompt){
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e){
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }
    public ArrayList<String> placeDotCom (int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphacoords = new String [comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean succes = false;
        int location = 0;

        comCount ++;
        int incr = 1;
        if ((comCount % 2) == 1) {incr = gridLength;}
        while (!succes & attempts++ < 200){//3
            location = (int) (Math.random() * gridSize);
           // System.out.println("probuem " + location);
            int x = 0;
            succes = true;
            while (succes && x < comSize) {//2
                if (grid[location]==0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        succes = false;
                    }
                    if (x > 0 & (location % gridLength == 0)) {
                        succes = false;
                    }
                } else {//1
                       // System.out.println("ispolzuetsia" + location);
                        succes = false;
                    }//1
                }//2
            }//3
           int a = 0;
            int row = 0;
            int column = 0;
            //System.out.println("\n");
            while (a < comSize) {
                grid[coords[a]] = 1;
                row = (int) (coords[a] / gridLength);
                column = coords[a] % gridLength;
                temp = String.valueOf(alphabet.charAt(column));
                alphaCells.add(temp.concat(Integer.toString(row)));
                a++;
                //System.out.println(x + " = " + alphaCells.get(x-1));
            }
           // System.out.println("\n");

        return alphaCells;
    }
}
