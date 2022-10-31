package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        //System.out.println("result: " + decode(cryptogram));
        return decode(cryptogram);
}

    private static String decode(String str) {
        String reuslt = "";

        boolean check = true;

        String[] array = str.split("");

        List<String> list = Arrays.asList(array);


        while (check) {
            check = false;
            List<String> current = new ArrayList<>();
            current.addAll(list);


            for (int i = 0; list.size() - 1 > i; i++) {

                if (list.get(i).equals(list.get(i + 1))) { // 문자 같으면
                    // 같은 두 문자 제거
                    current.remove(i + 1);
                    current.remove(i);
                    // list 갱신
                    list = current;

                    check = true;
                    continue;
                }
            }
            list = current;

        }

        // StringBuilder 선언
        StringBuilder sb = new StringBuilder();
        // 초기화
        for (String s : list) {
            sb.append(s);
        }

        reuslt = sb.toString();
        return reuslt;

    }
    /*
    public static void main(String[] args) { // TEST
        String s = "browoanoommnaon";

        solution(s);
    }
    
     */

}
