package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 기능 구현 사항
 * 1. 연속된 부분 찾기
 * 2. 연속 지점이 끝나는 부분의 인덱스를 리턴해주는 함수
 * 3. 답이 나올 때까지 반복
 */
public class Problem2 {
    private static int findLastIndex(String src) {
        char fir = src.charAt(0);
        for (int i = 1; i <= src.length(); i++) {
            if (i == src.length() && src.charAt(i - 1) == src.charAt(i - 2)){
                return 1;
            }
            if (src.charAt(i) != fir) {
                return (i - 1);
            }
        }
        return 0;
    }
    private static String deleteDuplicateChar(String cryptogram){
        String result = "";
        int lastIndex = cryptogram.length() - 1;
        for (int i = 0; i < lastIndex + 1; i++){
            if ((i != lastIndex) && (cryptogram.charAt(i) == cryptogram.charAt(i+1))) {
                i += findLastIndex(cryptogram.substring(i));
                continue;
            }
            result += cryptogram.charAt(i);
        }
        return result;
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String deleteString = "";
        while (true) {
            deleteString = deleteDuplicateChar(answer);
            if (!deleteString.equals(answer)){
                answer = deleteString;
            } else {
                break;
            }
        }
        return answer;
    }
}
