package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = solveCryptogram(cryptogram);

        return answer;
    }

    /**
     * 주어진 문자열에서 중복하는 문자들을 지움
     *
     * @return 연속하는 중복 문자를 삭제한 결과 String
     */
    public static String solveCryptogram(String cryptogram) {
        char[] cryptogramArray = cryptogram.toCharArray();
        ArrayList<Character> cryptogramList = new ArrayList<>();

        for (char c : cryptogramArray) {
            cryptogramList.add(c);
        }

        while (true) {
            boolean isDuplication = false;
            for (int i = 1; i < cryptogramList.size(); i++) {
                if (cryptogramList.get(i) == cryptogramList.get(i - 1)) {
                    isDuplication = true; // 연속된 같은 문자가 있으면 true
                    cryptogramList.remove(i - 1);
                    cryptogramList.remove(i - 1);
                }
            }
            /* 만약 중복된 문자가 없었다면 : 암호 해독 완료 */
            if (!isDuplication) {
                break;
            }
        }

        String result = new String("");
        for (char c : cryptogramList) {
            result += c;
        }

        return result;
    }
}
