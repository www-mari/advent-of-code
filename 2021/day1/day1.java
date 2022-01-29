import java.util.*;
import java.io.IOException;
import java.io.*;

public class day1 {

    public static void main(String [] args) throws IOException {

        Scanner scan;
        File inputfile = new File(args[0]);
        ArrayList<Integer> inputlist = new ArrayList<Integer>();
        int countinput = 0;
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


        // PART 1
        int increase = 0;

        for(int i = 0; i < inputlist.size() -1; i++){
            int first = inputlist.get(i);
            int second = inputlist.get(i+1);

            if(second > first){
                increase++;
            }
        }

        System.out.println("part 1: " + increase);

        //PART 2
        int increase2 = 0;

        for(int i = 0; i < inputlist.size() -3; i++){
            int group1sum = inputlist.get(i) + inputlist.get(i+1) + inputlist.get(i+2);
            int group2sum = inputlist.get(i+1) + inputlist.get(i+2) + inputlist.get(i+3);

            if(group2sum > group1sum){
                increase2++;
            }
        }

        System.out.println("part 2: " + increase2);

    }
}