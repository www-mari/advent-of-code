import java.util.*;
import java.io.IOException;
import java.io.*;

public class day2 {

    public static void main(String [] args) throws IOException {

        Scanner scan;
        File inputfile = new File(args[0]);
        ArrayList<String> inputlist = new ArrayList<String>();
        int countinput = 0;
        String s = "";

        try {
            scan = new Scanner(inputfile);
            while(scan.hasNext()){
                s = scan.nextLine();
                inputlist.add(s);
            }
        } catch (Exception e){
            System.out.println("read error");
            e.printStackTrace();
        }


        // PART 1
        int length = 0;
        int depth = 0;

        for(int i = 0; i < inputlist.size(); i++){
            String [] line = inputlist.get(i).split(" ");

            if(line[0].contains("forward")){
                length += Integer.valueOf(line[1]);
            } 
            if(line[0].contains("up")){
                depth -= Integer.valueOf(line[1]);
            }
            if(line[0].contains("down")){
                depth += Integer.valueOf(line[1]);
            }   
        }

        int total = length * depth;
        System.out.println("part 1: " + total);


        // PART 2
        int length2 = 0;
        int depth2 = 0;
        int aim = 0;

        for(int i = 0; i < inputlist.size(); i++){
            String [] line = inputlist.get(i).split(" ");

            if(line[0].contains("forward")){
                length2 += Integer.valueOf(line[1]);
                depth2 += aim * Integer.valueOf(line[1]);
            } 
            if(line[0].contains("up")){
                aim -= Integer.valueOf(line[1]);
            }
            if(line[0].contains("down")){
                aim += Integer.valueOf(line[1]);
            }  
        }

        int total2 = length2 * depth2;
        System.out.println("part 2: " + total2);

    }
}