import java.util.*;
import java.io.IOException;
import java.io.*;

public class day3 {

    public static void main(String [] args) throws IOException {

        Scanner scan;
        File inputfile = new File(args[0]);
        ArrayList<String> inputlist = new ArrayList<String>();
        ArrayList<String> oxygen = new ArrayList<String>();
        ArrayList<String> co2 = new ArrayList<String>();
        int countinput = 0;
        String s = "";

        try {
            scan = new Scanner(inputfile);
            while(scan.hasNext()){
                s = scan.nextLine();
                inputlist.add(s);
                oxygen.add(s);
                co2.add(s);
            }
        } catch (Exception e){
            System.out.println("read error");
            e.printStackTrace();
        }

        // PART 1
        String gamma = "";
        String epsilon = "";

        for(int j = 0; j < 12; j++){

            int ones = 0;
            int zeros = 0;

            for(int i = 0; i < inputlist.size(); i++){
                String bin = inputlist.get(i);

                if(bin.charAt(j) == '1'){ones++;}
                if(bin.charAt(j) == '0'){zeros++;}
            }

            if(ones > zeros){
                gamma += "1";
                epsilon += "0";
            } else {
                gamma += "0";
                epsilon += "1";
            }
        }

        // System.out.println("gamma: " + gamma);
        // System.out.println("epsilon: " + epsilon);
        int gamma_dec = Integer.parseInt(gamma, 2);
        int epsilon_dec = Integer.parseInt(epsilon, 2);

        int total = gamma_dec * epsilon_dec;
        System.out.println("part 1: " + total);


        // PART 2
        for(int j = 0; j < 12; j++){
            int ones = 0;
            int zeros = 0;

            for(int i = 0; i < oxygen.size(); i++){

                String bin = oxygen.get(i);
                if(bin.charAt(j) == '1'){ones++;}
                if(bin.charAt(j) == '0'){zeros++;}
            }

            if(ones > zeros){
                Iterator<String> itr = oxygen.iterator(); 
                while (itr.hasNext()) { 
                    String bin = itr.next(); 
                    if (bin.charAt(j) == '0' && oxygen.size() > 1) { 
                        itr.remove(); 
                    } 
                }
            } else if(ones == zeros) {
                Iterator<String> itr = oxygen.iterator(); 
                while (itr.hasNext()) { 
                    String bin = itr.next(); 
                    if (bin.charAt(j) == '0' && oxygen.size() > 1) { 
                        itr.remove(); 
                    } 
                }
            } else {
                Iterator<String> itr = oxygen.iterator(); 
                while (itr.hasNext()) { 
                    String bin = itr.next(); 
                    if (bin.charAt(j) == '1' && oxygen.size() > 1) { 
                        itr.remove(); 
                    } 
                }                   
            }
        }

        for(int j = 0; j < 12; j++){
            int ones = 0;
            int zeros = 0;

            for(int i = 0; i < co2.size(); i++){

                String bin = co2.get(i);
                if(bin.charAt(j) == '1'){ones++;}
                if(bin.charAt(j) == '0'){zeros++;}
            }

            if(ones > zeros){
                Iterator<String> itr = co2.iterator(); 
                while (itr.hasNext()) { 
                    String bin = itr.next(); 
                    if (bin.charAt(j) == '1' && co2.size() > 1) { 
                        itr.remove(); 
                    } 
                }
            } else if(ones == zeros) {
                Iterator<String> itr = co2.iterator(); 
                while (itr.hasNext()) { 
                    String bin = itr.next(); 
                    if (bin.charAt(j) == '1' && co2.size() > 1) { 
                        itr.remove(); 
                    } 
                }
            } else {
                Iterator<String> itr = co2.iterator(); 
                while (itr.hasNext()) { 
                    String bin = itr.next(); 
                    if (bin.charAt(j) == '0' && co2.size() > 1) { 
                        itr.remove(); 
                    } 
                }                   
            }
        }
        // System.out.println("oxygen list 1 size: " + oxygen.size());
        // System.out.println("oxygen: " + oxygen.get(0));
        // System.out.println("c02 list 2 size: " + co2.size());
        // System.out.println("co2: " + co2.get(0));

        int o2_dec = Integer.parseInt(oxygen.get(0), 2);
        int co2_dec = Integer.parseInt(co2.get(0), 2);
        System.out.println("part 2: " + o2_dec * co2_dec);

    }
}