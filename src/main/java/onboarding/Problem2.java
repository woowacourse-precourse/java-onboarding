package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 문자열 추가 삭제가 자유로운 StringBuilder로 변환하여 작성
        StringBuilder bWords = new StringBuilder(cryptogram);
        for (int i = 0; i < bWords.length() - 1; i++) {
            while (bWords.charAt(i) == bWords.charAt(i + 1)) {
                if (bWords.charAt(i) == bWords.charAt(i + 1)) {
                    bWords.delete(i, i + 2);
                    i--;
                }
                if (bWords.length() == 0) {
                    break;
                }
            }
        }
        String answer = bWords.toString();
        return answer;
    }
}
