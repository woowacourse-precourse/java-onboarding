package onboarding;

class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decryptString(cryptogram);
        return answer;
    }

    // 같은 문자가 연속되는 문자열을 검출해서 반환해주는 역할
    public static String sameWord(String words) {
        boolean check = true;

        for (int i = 0; i < words.length() - 1; i++) {
            String temp = (char) words.charAt(i) + "";
            int count = 0;                              // 문자가 2개 이상일 수도 있기 때문에 생성해둠
            check = true;
            // 현재 글자가 2개연속으로 포함되는지 검출
            while (check) {
                String tempBefore = temp;
                temp += words.charAt(i) + "";

                if (words.contains(temp)) {      // 연속으로 포함될때
                    check = true;
                    count++;
                }
                if (!words.contains(temp) && count > 0) {         // 연속으로 포함되지만 더이상 포함되지 않을 때 (종료)
                    return tempBefore;

                }
                if (!words.contains(temp) && count == 0) {         // 애초에 포함 X
                    check = false;
                }

            }
        }
        return "";
    }

    // 암호 해독해주는 메서드
    public static String decryptString(String cryptogram) {
        boolean isOK = true;
        while (isOK) {
            int length = cryptogram.length();
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                String sameWords = sameWord(cryptogram);
                cryptogram = cryptogram.replace(sameWords, "");  // 같은 문자 나왔을 때 없애줌
                i -= 1;     // 없애줬으니 1칸 뒤로
                break;
            }
            if (length == cryptogram.length()) isOK = false;            // 처음 문자와 길이가 같다 => 변화가 없다 => 암호 해독 끝났다
        }

        return cryptogram;
    }
}