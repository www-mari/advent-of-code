import java.util.*;
import java.io.IOException;
import java.io.*;
import java.lang.*;

public class day9 {

    public int distance = 0;

    public static void main(String [] args) throws IOException {

        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String input = "";
        int[] visited = new int[8];
        ArrayList<String> distances = new ArrayList<String>();
        
        String city1 = "AlphaCentauri";
        String city2 = "Snowdin";
        String city3 = "Tambi";
        String city4 = "Faerun";
        String city5 = "Norrath";
        String city6 = "Straylight";
        String city7 = "Tristram";
        String city8 = "Arbre";
        String[] cities = {city1, city2, city3, city4, city5, city6, city7, city8};

        while(sc.hasNextLine()){

            input = sc.nextLine();
            String [] spl = input.split(" ");
            String from = spl[0];
            String to = spl[2];
            String dis = spl[4];
            String cc = from + "~" + to + "~" + dis;

            distances.add(cc);
        }

        for(int i = 0; i < cities.length; i++){
        }
    }

    public int findNext(int[] visited, String city, ArrayList distances){

        int vc = 0;
        int dist = 0;
        int tmp = 0;

        for(int i = 0; i < 8; i++){
            if(visited[i] == 1){
                vc++;
            }
        }
        if(vc == 8){
            return -1;
        } else {
            visited[city] = 1;

            for(int i = 0; i < distances.size(); i++){
                if(distances.get(i).contains(city)){
                    String [] spl = distances.get(i).split("~");


                }
            }
        }

        return dist;
    }
}
