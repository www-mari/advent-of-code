import java.util.*;
import java.io.IOException;
import java.io.*;
import java.lang.*;

public class day5 {

    public static void main(String [] args) throws IOException {

        Scanner scan;
        File inputfile = new File(args[0]);
        ArrayList<Integer> inputlist = new ArrayList<Integer>();
        HashMap<String, Integer> points = new HashMap<String, Integer>();
        String s = "";

        try {
            scan = new Scanner(inputfile);
            while(scan.hasNext()){
                s = scan.nextLine();
                inputlist.add(Integer.valueOf(s));
            }
        } catch (Exception e){
            System.out.println("read error");
            e.printStackTrace();
        }

        for(int i = 0; i < inputlist.size(); i++){
            String [] spl = inputlist.get(0).toString().split(" -> ");

            String point1 = spl[0];
            String point2 = spl[1];

            String [] p1 = point1.split(",");
            String [] p2 = point2.split(",");

            int x1 = Integer.parseInt(p1[0]);
            int y1 = Integer.parseInt(p1[1]);
            int x2 = Integer.parseInt(p2[0]);
            int y2 = Integer.parseInt(p2[1]);

            if(x1 == x2){
                for(int j = y1; j < y2; j++){
                    String p = x1 + "," + j;
                    points.put(p, 1);
                }
            } 
            if(y1 == y2) {
                for(int k = x1; k < x2; k++){
                    String p = k+ "," + y1;
                    points.put(p, 1);
                }
            } 

            
        }



    }
}