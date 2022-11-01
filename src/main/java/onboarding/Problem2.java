package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        boolean check = true;
        String[] array = cryptogram.split("");
        List<String> list = Arrays.asList(array);

        while (check) {
            check = false;
            List<String> cur_string = new ArrayList<>();
            cur_string.addAll(list);

            for (int i = 0; list.size() - 1 > i; i++) {

                if (list.get(i).equals(list.get(i + 1))) {
                    //System.out.println("1)" + cur_string);
                    //System.out.println("2)" + list.get(i) + " " + list.get(i + 1));
                    cur_string.remove(i + 1);
                    cur_string.remove(i);
                    list = cur_string;
                    check = true;
                    continue; // for문 탈출. for문 아래 명령어 실행.
                }
            }
            list = cur_string;
            //System.out.println("3)" + list);
        }

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s);
        }

        answer = sb.toString();
        //System.out.println("4)" + answer);
        return answer;
    }
}
