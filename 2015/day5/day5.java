import java.util.*;
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.regex.*;

public class day5 {

    //public static final Pattern REGEX1 = Pattern.compile(".?([a-z][a-z]).?\1.*?");
    public static final Pattern REGEX1 = Pattern.compile("(..).*\\1");
    //public static final Pattern REGEX2 = Pattern.compile(".?([a-z]){1}.\1.?");
    public static final Pattern REGEX2 = Pattern.compile("(.).\\1");

    public static void main(String [] args) throws IOException {

        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String input = "";

        int nicestrings = 0;

        while(sc.hasNextLine()){
            input = sc.nextLine();

            boolean vowels = false;
            boolean dupe = false;
            boolean disallowed = true;
            boolean pairs = false;
            boolean sandwich = false;

            // check for 3 vowels
            int vowelcounter = 0;
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    vowelcounter++;
                }
            }
            if(vowelcounter >= 3){
                vowels = true;
            }

            // check for duplicate chars
            for(int i = 0; i < input.length() - 1; i++){
                if(input.charAt(i) == input.charAt(i+1)){
                    dupe = true;
                }
            }

            // check for disallowed strings
            for(int i = 0; i < input.length() - 1; i++){
                String check = "";
                check += input.charAt(i);
                check += input.charAt(i+1);
                if(check.equals("ab") || check.equals("cd") || check.equals("pq") || check.equals("xy")){
                    disallowed = false;
                }
            }

            // check for two pairs of characters
            pairs = REGEX1.matcher(input).find();

            // check for character sandiwches
            sandwich = REGEX2.matcher(input).find();

            // part 1
            // if(vowels & dupe & disallowed){
            //     nicestrings++;
            // }

            //part 2
            if(pairs & sandwich){
                nicestrings++;
            }
        }

        System.out.println(nicestrings);

    }
}