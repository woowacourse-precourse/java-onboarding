package onboarding;

import java.util.ArrayList;

public class Problem2 {

    public static String finder(String a) {
        ArrayList lis = new ArrayList();
        lis.add(a.charAt(0));

        int index = 0;


        for (int i = 1; i < a.length(); i++) {
            char value = (a.charAt(i));

            char before_value = (char) lis.get(index);

            if (value == before_value) {
                lis.remove(index);
                index -= 1;
            } else {
                lis.add(value);
                index += 1;
            }
        }


        if (lis.size() == 0) {
            return "";
        }

        String result = "";


        for (int i = 0; i < lis.size(); i++) {
            result += lis.get(i);
        }
        return result;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
