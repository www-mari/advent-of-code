import java.util.*;
import java.io.IOException;
import java.io.*;

public class day4 {

    public static void main(String [] args) throws IOException {
        
        Scanner scan;
        File inputfile = new File(args[0]);
        String calling = "15,62,2,39,49,25,65,28,84,59,75,24,20,76,60,55,17,7,93,69,32,23,44,81,8,67,41,56,43,89,95,97,61,77,64,37,29,10,79,26,51,48,5,86,71,58,78,90,57,82,45,70,11,14,13,50,68,94,99,22,47,12,1,74,18,46,4,6,88,54,83,96,63,66,35,27,36,72,42,98,0,52,40,91,33,21,34,85,3,38,31,92,9,87,19,73,30,16,53,80";
        int[][][] cards = new int[100][5][5];
        int[][][] marked = new int[100][5][5];
        int card_num = 0; 
        int row_num = 0;

        try {
            scan = new Scanner(inputfile);
            while(scan.hasNext()){
                String str = scan.nextLine();

                // if line is empty, new card index & reset row number
                if(str.length() <1){
                    card_num++;
                    row_num = 0;
                }
                // otherwise, put cards in nested array
                else {
                    String [] spl = str.split(" ");
                    int index = 0;
                    for(int i = 0; i < spl.length; i++){
                        if(spl[i].length() >0){
                            cards[card_num][row_num][index] = Integer.parseInt(spl[i]);
                            index++;
                        }
                    }
                    row_num++;
                }
            }
        } catch (Exception e){
            System.out.println("read error");
            e.printStackTrace();
        }

        // split calling numbers and transfer to int array 
        String [] callnum = calling.split(",");
        int [] callnums = new int[callnum.length];
        for(int a = 0; a < callnum.length; a++){
            callnums[a] = Integer.parseInt(callnum[a]);
        }

        for(int w = 0; w < callnums.length; w++){ // for each number called
            for(int x = 0; x < 100; x++){ // for each bingo card
                for(int y = 0; y < 5; y++){ // for each row in a card
                    for(int z = 0; z < 5; z++){ // for each number in row

                        if(callnums[w] == cards[x][y][z]){ // if called number matches number on the card
                            marked[x][y][z] = 1; // set spot as "marked" in marking array
                        }
                    }
                }
            }
            int win_num = check(marked); // after each number is called, check for a winner
            if(win_num != 0){
                winner(cards, win_num, calling, w); // if there is a winner, calculate result & break loop
                break;
            } // else, continue  with next number 
        }
    }

    public static int check(int[][][] marked){
        int card_number = 0; 

        for(int i = 0; i < 100; i++){ //card number
            for(int j = 0; j < 5; j++){ //row number
                for(int k = 0; k < 5; k++){ //column number 

                }
            }
        }
        //System.out.println("checked for winner");
        return 0;
    }

    public static void winner(int[][][] cards, int card, String calling, int call_index){

        String nums = "";
        int sum = 0; 

        for(int n = 0; n < call_index; n++){
            nums += calling.charAt(n);
            nums += "+";
        } nums += calling.charAt(call_index);

        for(int r = 0; r < 5; r++){ //row 
            for(int c = 0; c < 5; c++){ //col
                String num = Integer.toString(cards[card][r][c]);
                if(!nums.contains(num)){
                    sum += Integer.parseInt(num);
                }
            }
        }
        System.out.println(sum);
        
    }
}