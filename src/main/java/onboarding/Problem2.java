package onboarding;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decode(cryptogram);
        return answer;
    }

    private static String decode(String str) {
        String tmp_answer = "";
        boolean decoding = true;

        String[] arr = str.split("");
        List<String> list = Arrays.asList(arr);

        while (decoding) {
            List<String> tmp_str = new ArrayList<>();
            tmp_str.addAll(list);
            decoding = false;

            for (int i = 0; list.size() - 1 > i; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    tmp_str.remove(i + 1);
                    tmp_str.remove(i);
                    list = tmp_str;
                    decoding = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        tmp_answer = sb.toString();
        return tmp_answer;
    }
}
