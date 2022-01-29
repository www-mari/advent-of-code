import java.util.*;
import java.io.IOException;
import java.io.*;
import java.lang.*;

public class day6 {

    public static void main(String [] args) throws IOException {

        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String input = "";

        int[][] lights = new int[1000][1000];

        while(sc.hasNextLine()){
            input = sc.nextLine();

            String [] spl = input.split(" ");
            if(spl.length == 4){
                //toggle
                String from = spl[1];
                String to = spl[3];
                toggle(lights, from, to);
            } else {
                if(spl[1].contains("on")){
                    //on
                    String from = spl[2];
                    String to = spl[4];
                    on(lights, from, to);
                }
                if(spl[1].contains("off")){
                    //off
                    String from = spl[2];
                    String to = spl[4];
                    off(lights, from, to);
                }
            }
        }
        // PART 1
        // int counter = 0;
        // for(int i = 0; i < 1000; i++){
        //     for(int j = 0; j < 1000; j++){
        //         if(lights[i][j] == 1){
        //             counter++;
        //         }
        //     }
        // }

        // PART 2
        int brightness = 0;
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                brightness += lights[i][j];
            }
        }

        //System.out.println(counter);
        System.out.println(brightness);
        //System.out.println(Arrays.deepToString(lights));

    }

    public static void on(int[][] lights, String from, String to){
        String [] splitFrom = from.split(",");
        int fx = Integer.parseInt(splitFrom[0]);
        int fy = Integer.parseInt(splitFrom[1]);
        String [] splitTo = to.split(",");
        int tx = Integer.parseInt(splitTo[0]);
        int ty = Integer.parseInt(splitTo[1]);

        // PART 1
        // for(int i = fx; i <= tx; i++){
        //     for(int j = fy; j <= ty; j++){
        //         lights[i][j] = 1;
        //     }
        // }

        //PART 2
        for(int i = fx; i <= tx; i++){
            for(int j = fy; j <= ty; j++){
                lights[i][j] += 1;
            }
        }
    }

    public static void off(int[][] lights, String from, String to){
        String [] splitFrom = from.split(",");
        int fx = Integer.parseInt(splitFrom[0]);
        int fy = Integer.parseInt(splitFrom[1]);
        String [] splitTo = to.split(",");
        int tx = Integer.parseInt(splitTo[0]);
        int ty = Integer.parseInt(splitTo[1]);

        // PART 1
        // for(int i = fx; i <= tx; i++){
        //     for(int j = fy; j <= ty; j++){
        //         lights[i][j] = 0;
        //     }
        // }

        // PART 2
        for(int i = fx; i <= tx; i++){
            for(int j = fy; j <= ty; j++){
                if(lights[i][j] > 0){ 
                    lights[i][j] -= 1; 
                }
            }
        }
    }

    public static void toggle(int[][] lights, String from, String to){
        String [] splitFrom = from.split(",");
        int fx = Integer.parseInt(splitFrom[0]);
        int fy = Integer.parseInt(splitFrom[1]);
        String [] splitTo = to.split(",");
        int tx = Integer.parseInt(splitTo[0]);
        int ty = Integer.parseInt(splitTo[1]);

        // PART 1
        // for(int i = fx; i <= tx; i++){
        //     for(int j = fy; j <= ty; j++){
        //         lights[i][j] ^= 1;
        //     }
        // }

        // PART 2
        for(int i = fx; i <= tx; i++){
            for(int j = fy; j <= ty; j++){
                lights[i][j] += 2;
            }
        }
    }
}
