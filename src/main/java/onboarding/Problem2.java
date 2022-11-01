package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = cryptogram;

        boolean check = true;

        while (check) {
            List<Integer> skipNumber = new ArrayList<>();
            String deleteString = "";
            check = false;

            // i번째와 i+1번째가 중복일 경우 해당 위치를 저장
            for (int i = 0; i < result.length() - 1; i++) {
                if (result.charAt(i) == result.charAt(i + 1)) {
                    skipNumber.add(i);
                    skipNumber.add(i + 1);
                }
            }

            // 저장된 위치를 빼고 문자열 선언
            for (int i = 0; i < result.length(); i++) {
                if (!skipNumber.contains(i)) {
                    deleteString += result.charAt(i);
                }
            }

            result = deleteString;

            // 연속으로 중복된 문자가 있는 경우 반복
            for (int i = 0; i < result.length() - 1; i++) {
                if (result.charAt(i) == result.charAt(i + 1)) {
                    check = true;
                    break;
                }
            }

        }

        return result;
    }
}