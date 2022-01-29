import java.util.*;
import java.io.IOException;
import java.io.*;
import java.lang.*;

public class day2 {

    public static void main(String [] args) throws IOException {

        int wrapping = 0;
        int ribbon = 0;
        int [] arr = new int[3];

        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String input = "";

        while(sc.hasNextLine()){
            String line = sc.nextLine();

            String [] dims = line.split("x");
            int length = Integer.parseInt(dims[0]);
            int width = Integer.parseInt(dims[1]);
            int height = Integer.parseInt(dims[2]);

            int bow = length * width * height;

            int lw = length * width;
            int wh = width * height;
            int lh = length * height;

            int p_lw = length * 2 + width * 2;
            int p_wh = width * 2 + height * 2;
            int p_lh = length * 2 + height * 2;
            
            int sa = (2 * lw) + (2 * wh) + (2 * lh);
            int smallest = Math.min(lw, Math.min(wh, lh));

            int peri = Math.min(p_lw, Math.min(p_wh, p_lh));

            wrapping += sa;
            wrapping += smallest;

            ribbon += bow;
            ribbon += peri; 

        }

        System.out.println(wrapping);
        System.out.println(ribbon);
    }
}