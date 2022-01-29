import java.util.*;
import java.io.IOException;
import java.io.*;
import java.lang.*;

public class day3 {

    public static void main(String [] args) throws IOException {

        int houses = 1;

        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String input = "";

        HashMap<String, String> hm = new HashMap<String, String>();

        while(sc.hasNextLine()){
            input = sc.nextLine();
        }

        String santa = "";
        String robo = "";

        for(int i = 0; i < input.length(); i++){
            if(i % 2 == 0){
                santa += input.charAt(i);
            } else {
                robo += input.charAt(i);
            }
        }

        System.out.println("input length " + input.length());
        System.out.println("santa length " + santa.length());
        //System.out.println(santa);
        System.out.println("robo length " + robo.length());
        //System.out.println(robo);

        deliver(santa, hm);
        deliver(robo, hm);

        houses += hm.size();
        System.out.println(houses);
    }

    public static void deliver(String input, HashMap<String, String> hm){

        int x = 0;
        int y = 0; 
        String coords = "";

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '^'){
                y += 1;
                coords = x + "," + y;
                if(!hm.containsKey(coords)){
                    hm.put(coords, "-");
                    //System.out.println(coords);
                }
            } else if (input.charAt(i) == 'v'){
                y -= 1;
                coords = x + "," + y;
                if(!hm.containsKey(coords)){
                    hm.put(coords, "-");
                    //System.out.println(coords);
                }                
            } else if (input.charAt(i) == '>'){
                x += 1;
                coords = x + "," + y;
                if(!hm.containsKey(coords)){
                    hm.put(coords, "-");
                    //System.out.println(coords);
                }                 
            } else if (input.charAt(i) == '<') {
                x -= 1;
                coords = x + "," + y;
                if(!hm.containsKey(coords)){
                    hm.put(coords, "-");
                    //System.out.println(coords);
                } 
            } else {}

        }
    }

}