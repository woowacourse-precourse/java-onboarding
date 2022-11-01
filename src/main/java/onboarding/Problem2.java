package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";

        /**
         * 중복 문자 체크
         * 중복 문자 제거
         * 반복
         * 없으면 끝
         */

        String str = cryptogram;

        while (true) {
            boolean isOverlap = false;
            boolean[] overlapCheck = new boolean[str.length()];

            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    isOverlap = true;
                    break;
                }
            }

            if (!isOverlap) {
                break;
            }

            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    overlapCheck[i] = true;
                    overlapCheck[i + 1] = true;
                }
            }

            String temp = "";
            for (int i = 0; i < str.length(); i++) {
                if (overlapCheck[i]) {
                    continue;
                }
                temp += str.charAt(i);
            }

            str = temp;
        }


        return answer = str;
    }
}
