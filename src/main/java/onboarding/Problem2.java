package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String prev = "";
        String answer = cryptogram;
        while (!prev.equals(answer)) {
            if (answer.equals("")) {
                return "";
            }
            prev = answer;
            answer = removeSuccessiveString(answer);
        }
        return answer;
    }

    static String removeSuccessiveString(String cryptogram) {
        /* i번 째부터 j번 째까지 문자가 같은지 확인하고, 중복된 경우 제거 */
        int i = 0;  // 시작 문자 인덱스
        int j = i + 1;  // 끝 문자 인덱스
        while (j < cryptogram.length()) {
            if (cryptogram.charAt(i) == cryptogram.charAt(j) && j + 1 == cryptogram.length()) {     // i번째 문자와 j번째 문자가 같고, j번째 문자가 마지막 문자이면
                cryptogram = cryptogram.substring(0, i);    // 연속 문자열 제거 후
                j += 1;  // 반복문 빠져나감.
                continue;
            }
            if (cryptogram.charAt(i) == cryptogram.charAt(j) && j + 1 != cryptogram.length()) {     // i번째 문자와 j번째 문자가 같고, j번째 문자가 마지막 문자가 아니면
                j += 1; //  다음 문자도 같은지 확인
                continue;
            }
            if (cryptogram.charAt(i) != cryptogram.charAt(j) && i + 1 == j) {     // i번째 문자와 j번째 문자가 다르고, i와 j가 1 차이인 경우 다음 인덱스 체크
                i += 1;
                j += 1;
                continue;
            }
            if (cryptogram.charAt(i) != cryptogram.charAt(j) && i + 1 < j) {      // i번째 문자와 j번째 문자가 다르고, i와 j사이에 반복된 문자가 있는 경우 반복 문자 제거
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(j);
                j = i + 1;
            }
        }
        return cryptogram;
    }
}