import java.util.*;
import java.io.IOException;
import java.io.*;

public class day1 {

    public static void main(String [] args) throws IOException {

        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String input = "";

        int floor = 0;
        int basement = 0;

        while(sc.hasNextLine()){
            input = sc.nextLine();
        }

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '('){
                floor++;
            }
            if(input.charAt(i) == ')'){
                floor--;
                if(floor == -1){
                    basement = i + 1;
                    break;
                }
            }
        }

        System.out.println(basement);
    }
}