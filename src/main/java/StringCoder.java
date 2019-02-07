import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class StringCoder {

    public static String code(String stringToCode) {
        if (stringToCode.equals("")) {
            System.out.println("empty string");
            return null;
        } else {
            String stringToCode2 = stringToCode.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
            List<Character> charList = new ArrayList<Character>();
            for (char c : stringToCode2.toCharArray()) {
                charList.add(c);
            }
            Collections.sort(charList);
            String result = "";
            int count = 1;
            for (int i = 0; i < charList.size(); i++) {
                if (i < charList.size() - 1) {
                    while (charList.get(i).equals(charList.get(i + 1))) {
                        count++;
                        i++;
                    }
                    result = result.concat(charList.get(i).toString()) + count;
                    count = 1;

                }
            }
            result = result.concat(charList.get(charList.size() - 1).toString()) + count;

            System.out.println(result);
            return result;
        }
    }
}


//
//        Hello world -> d1e1h1l3o2r1w1
//        Ala ma kota -> a4k1l1m1o1t1
//        Java is awesome -> a3e2i1j1m1o1s2v1w1
//        Don't repeat yourself -> a1d1e3f1l1n1o2p1r2s1t2u1y1