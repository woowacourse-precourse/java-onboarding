package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean changed = true;

        String[] cryptoArr = cryptogram.split("");
        List<String> cryptoList = Arrays.asList(cryptoArr);

        while (changed) {
            List<String> cryptoListCopy = new ArrayList<>();
            for (int i = 0; i < cryptoList.size() - 1; i++) {
                String str1 = cryptoList.get(i);
                String str2 = cryptoList.get(i + 1);
                if (str1.equals(str2))
                    i += 1;
                else
                    cryptoListCopy.add(cryptoList.get(i));
            }
            if (!cryptoList.get(cryptoList.size() - 2).equals(cryptoList.get(cryptoList.size() - 1)))
                cryptoListCopy.add(cryptoList.get(cryptoList.size() - 1));

            if (cryptoList.equals(cryptoListCopy))
                changed = false;
            else
                changed = true;
            cryptoList = cryptoListCopy;
            if (cryptoList.isEmpty())
                break;
        }
        return cryptoList.toString();
    }


    public static void main(String args[]) {
        String cryptogram = "browoanoommnaon";
        System.out.println(Problem2.solution(cryptogram));
    }
}
