package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    // 중복 문자 확인, 제거
    public static int chackSameChar(String cryptogram) {
        char c = NULL;
        int count = 0;
        for (int i = 0; i < cryptogram.length(); i++) {
            if (c == cryptogram.charAt(i)) {
                cryptogram = cryptogram.substring(0, i-1) + cryptogram.substring(i);
                count++;
            }
            c = cryptogram.charAt(i);
        }
        return count;
    }
}

/*
기능
1. 중복 문자 저장
2. 중복 문자 제거
3. 반복
4. 중복 문자 없을 시 스탑
 */