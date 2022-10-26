package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {

    public static String solution(String cryptogram) {

        boolean language = validation(cryptogram);
        if (!language) {
            return "";
        }

        String result = "";
        boolean check = true;
        // 문자열을 리스트로 변환
        String[] input_array = cryptogram.split("");
        List<String> values = Arrays.asList(input_array);

        // 앞,뒤 동일문자 없을 때까지 반복
        while (check) {
            check = false;
            // R_String 리스트로 동일문자 삭제 작업
            List<String> R_String = new ArrayList();
            R_String.addAll(values);

            // 앞,뒤 비교하여 동일한 문자 삭제
            for(int i = 0; i < values.size() -1; i++) {
                if (values.get(i).equals(values.get(i + 1))) {
                    R_String.remove(i + 1);
                    R_String.remove(i);
                    values = R_String;
                    check = true;
                    continue;
                }
            }
        }

        // 리스트를 문자열로 변환
        result = String.join("", values);
        return result;
    }
    private static boolean validation(String text) {
        // 길이가 1미만, 1000 초과
        if(text.length() < 1 || text.length() > 1000) {
            return false;
        }
        return true;
    }
}
