import java.util.*;
import java.io.IOException;
import java.io.*;

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
            String [] spl = inputlist.get(0).split(" -> ");

            String point1 = spl[0];
            String point2 = spl[1];

            String [] p1 = point1.split(",");
            String [] p2 = point2.split(",");

            String x1 = p1[0];
            String y1 = p1[1];
            String x2 = p2[0];
            String y2 = p2[1];

            if(x1 == x2){
                for(int i = y1; i < y2; i++){
                    String p = x1 + "," + i;
                    points.put(p, 1);
                }
            } 
            if(y1 == y2) {
                for(int i = x1; i < x2, i++){
                    String p = i + "," + y1;
                    points.put(p, 1);
                }
            } 

            
        }



    }
}