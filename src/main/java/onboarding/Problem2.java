package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String[] str = cryptogram.split("");
        List<String> strList = new ArrayList<>(Arrays.asList(str));
        boolean boo = true;

        while (boo) {
            if (strList.size() == 0) {
                break;
            }
            boo = isBoo(strList, boo);
        }

        answer = String.join("", strList);

        return answer;
    }

    private static boolean isBoo(List<String> strList, boolean boo) {
        for (int i = 0; i < strList.size()-1; i++) {
            if (strList.get(i).equals(strList.get(i+1))) {
                strList.remove(i);
                strList.remove(i);
                boo = true;
                break;
            } else {
                boo = false;
            }
        }
        return boo;
    }
}