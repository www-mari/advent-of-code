import java.util.*;
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.regex.*;

public class day8 {

    public static void main(String [] args) throws IOException {

        // char sequence \x##: length 1
        // char sequence \\: length 1
        // char sequence \": length 1

        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String input = "";

        int totalchars = 0;
        int memorychars = 0;

        while(sc.hasNextLine()){

            input = sc.nextLine();
            totalchars += input.length();

            String ws = input.substring(1, input.length() -1);
            //System.out.println(ws);

            String ws1 = ws.replace("\\\"", "~");
            //memorychars += ws1.length();
            String ws2 = ws1.replace("\\\\", "~");
            //String ws3 = ws2.replaceAll("\\x", "~");
            String ws3 = ws2.replaceAll("[x][0-9a-f]{2}", "");
            String ws4 = ws3.replace("\\", "~");

            // System.out.println("remove quote " + ws1);
            // System.out.println("remove slash " + ws2);
            // System.out.println("remove ascii " + ws3);
            // System.out.println("remove final " + ws4);

            memorychars += ws4.length();
            
        }

        System.out.println(totalchars);
        System.out.println(memorychars);
        // System.out.println("test: " + "\\\"");
        // System.out.println("test: " + "\\\\");
        // System.out.println("test: " + "\\x");
        System.out.println("result: " + (totalchars - memorychars));
    }
}
