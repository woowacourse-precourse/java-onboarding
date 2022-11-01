package onboarding;
import java.util.*;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        boolean isTrue = true;

        String[] ary = cryptogram.split("");

        List<String> list = Arrays.asList(ary);

        while(isTrue) {
            isTrue = false;
            List<String> lString = new ArrayList<>();
            lString.addAll(list);

            for(int i  = 0; i < list.size() - 1; i++) {
                if(list.get(i).equals(list.get(i+1))) {
                    lString.remove(i+1);
                    lString.remove(i);
                    list = lString;
                    isTrue = true;
                    continue;
                }
            }

            list = lString;

        }

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }
        answer = sb.toString();
        return answer;
    }
}
