package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String removeDup(String str) {
        String[] strArr = str.split("");
        ArrayList result = new ArrayList();
        int flag = 0;
        for (String s: strArr) {
            if (result.size() == 0) {
                result.add(s);
                continue;
            }
            if ((result.get(result.size()-1)).equals(s)) {
                flag = 1;
                continue;
            }
            if (flag == 1) {
                result.remove(result.size()-1);
                flag = 0;
            }
            result.add(s);
        }
        return String.join("", result);
    }

    public static void main(String[] args){
        System.out.println(removeDup("browoanoommnaon"));
    }
}
