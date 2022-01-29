import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mdawg on 12/4/2015.
 */
public class day7 {

    public static Map<String, Integer> VARS = new HashMap<>();
    public static ArrayList<String> INSN = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String str;
        while ((str = reader.readLine()) != null) {
            String[] strs = str.split(" ");
            if (strs.length == 3) {
                try {
                    int i = Integer.parseInt(strs[0]);
                    VARS.put(strs[2], i);
                    continue;
                } catch (Exception e) {
                }
            }
            INSN.add(str);
        }

        // PART 1
        doVar("a");
        System.out.println(VARS.get("a"));
    }

    public static String doVar(String name) {
        if (VARS.get(name) != null) {
            return name;
        } else {
            for (String string : INSN) {
                String[] split = string.split(" ");
                if (split[split.length - 1].equals(name)) {
                    System.out.println(string);
                    String str = (split[split.length - 1]);
                    if (split.length == 3) {
                        VARS.put(str, getValue(split[0]));
                    } else if (split[0].equals("NOT")) {
                        VARS.put(str, (~getValue(split[1])) & 0xFFFF);
                    } else {
                        switch (split[1]) {
                            case "OR":
                                VARS.put(str, getValue(split[0]) | getValue(split[2]));
                                break;
                            case "AND":
                                VARS.put(str, getValue(split[0]) & getValue(split[2]));
                                break;
                            case "LSHIFT":
                                VARS.put(str, getValue(split[0]) << getValue(split[2]));
                                break;
                            case "RSHIFT":
                                VARS.put(str, getValue(split[0]) >> getValue(split[2]));
                                break;
                        }
                    }
                }
            }
        }
        return name;
    }

    public static int getValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            doVar(input);
            return VARS.get(input);
        }
    }
}