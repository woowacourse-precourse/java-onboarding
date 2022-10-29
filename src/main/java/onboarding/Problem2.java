package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    // 반복문을 통해 문자를 만드는 함수
    public static String deleteReduplicationString(String cryptogram) {
        String resultString = cryptogram.substring(0, 1);
        for (int i = 1; i < cryptogram.length(); i++) {
            String lastChar = resultString.substring(resultString.length()-1, resultString.length());
            String nextChar = cryptogram.substring(i, i+1);
            if (checkReduplication(lastChar, nextChar) continue;
            resultString += nextChar;
        }
        return resultString;
    }
}
