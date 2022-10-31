package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    public static String decode(String str) {
        String answer = "";

        boolean check = true;

        String[] array = str.split("");

        List<String> list = Arrays.asList(array);

        while (check) {
            check = false;
            List<String> cur_string = new ArrayList<>();
            cur_string.addAll(list);

            for (int i = 0; list.size() - 1 > i; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    System.out.println(cur_string);
                    System.out.println(list.get(i) + " " + list.get(i + 1));
                    cur_string.remove(i + 1);
                    cur_string.remove(i);
                    list = cur_string;
                    check = true;
                    continue;
                }
            }

            list = cur_string;

            System.out.println(list);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        answer = sb.toString();
        System.out.println(answer);
        return answer;
    }
}
