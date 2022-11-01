package onboarding;

public class Problem2 {

    // 기능 목록 1 : 중복 문자를 제거하는 함수
    public static String removeDuplicate(String cryptogram) {
        boolean state;

        while (true) {
            state = false;
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    state = true;
                    int j;
                    for (j = i + 1; j < cryptogram.length() - 1; j++) {
                        if (cryptogram.charAt(j) != cryptogram.charAt(j + 1)) {
                            break;
                        }
                    }
                    if (j == cryptogram.length() - 1) {
                        cryptogram = cryptogram.substring(0, i);
                        break;
                    }
                    if (j != cryptogram.length()) {
                        cryptogram = cryptogram.substring(0, i) + cryptogram.substring(j + 1,
                            cryptogram.length());
                    }
                    i--;
                }
            }
            if (!state || cryptogram.length() == 0) {
                break;
            }
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "";

        // 중복 문자 제거
        answer = removeDuplicate(cryptogram);

        return answer;
    }
}
