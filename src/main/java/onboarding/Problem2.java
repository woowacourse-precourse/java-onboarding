package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int count = 1;
        while (count != 0) {
            cryptogram = chackSameChar(cryptogram);
            count = countSameChar(cryptogram);
        }
        answer = cryptogram;

        return answer;
    }

    // 중복 문자 확인, 제거
    public static String chackSameChar(String cryptogram) {
        char c = '\0';
        for (int i = 0; i < cryptogram.length(); i++) {
            if (c == cryptogram.charAt(i)) {
                c = cryptogram.charAt(i);
                cryptogram = cryptogram.substring(0, i - 1) + cryptogram.substring(i + 1);
            } else {
                c = cryptogram.charAt(i);
            }
        }
        return cryptogram;
    }

    public static int countSameChar(String cryptogram) {
        char c = '\0';
        int count = 0;
        for (int i = 0; i < cryptogram.length(); i++) {
            if (c == cryptogram.charAt(i)) {
                count++;
            } else {
                c = cryptogram.charAt(i);
            }
        }
        return count;
    }
}

/*
기능
1. 문자 저장 및 연속한 중복 문자 제거
2. 연속하여 중복하는 문자 없을 때까지 반복
 */