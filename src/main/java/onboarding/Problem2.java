package onboarding;

public class Problem2 {

    // 기능 요구 사항
    // TODO 중복 문자의 시작 인덱스를 리턴하는 메서드
    public static int getIndex(String cryptogram) {
        for (int i = 0; i <cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) return i;
        }
        return -1;
    }

    // TODO 중복 문자를 삭제하는 메서드
    public static String deleteCryptogram (String cryptogram) {
        int startIdx = getIndex(cryptogram);

        if (startIdx == -1) return cryptogram;

        int endIdx = startIdx;

        for (; endIdx < cryptogram.length(); endIdx++) {
            if (cryptogram.charAt(startIdx) == cryptogram.charAt(endIdx)) continue;
            break;
        }

        String result = "";
        result = cryptogram.substring(0, startIdx) + cryptogram.substring(endIdx);
        return deleteCryptogram(result);
    }

    public static String solution(String cryptogram) {
        String answer = deleteCryptogram(cryptogram);
        return answer;
    }
}