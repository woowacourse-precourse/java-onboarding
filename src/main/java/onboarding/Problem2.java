package onboarding;

public class Problem2 {
    // 전체 기능 호출
    public static String solution(String cryptogram) {
        return decryption(cryptogram);
    }
    // 문자열 암호해독 메서드
    private static String decryption(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        char[] splitCryptogram = cryptogram.toCharArray();
        boolean[] isReduplication = new boolean[splitCryptogram.length];
        int reduplicationCount = 0;

        // i번째 문자와 i-1번째 문자가 같은지 비교
        for (int i = 1; i < splitCryptogram.length; i++) {
            if (splitCryptogram[i] == splitCryptogram[i-1]) {
                isReduplication[i] = true;
                isReduplication[i-1] = true;
            }
        }

        // isReduplication을 참고하여 중복하지 않은 문자열만 answer에 추가
        for (int i = 0; i < isReduplication.length; i++) {
            if (isReduplication[i]) {
                reduplicationCount += 1;
                continue;
            }
            answer.append(splitCryptogram[i]);
        }

        // 중복된 문자가 있다면 암호해독 메서드 재귀호출
        if (reduplicationCount > 0) {
            return decryption(answer.toString());
        }
        return answer.toString();
    }
}
