package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int check = 1;
        while (check != 0) {
            check = 0; // 중복된 경우 있을 경우 0이 아님
            int count = 0; // 중복이 끝났을 때를 판단하는 키
            String str = "";
            for (int i = 1; i < cryptogram.length(); i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) { // 이전문자와 중복일 경우
                    count++;
                    check++;
                } else if (count != 0 && cryptogram.charAt(i) != cryptogram.charAt(i - 1)) {
                    count = 0; // 한문자의 중복 종료
                    if (i + 1 == cryptogram.length()) { // 마지막 문자일 경우 마지막 문자 추가
                        str += cryptogram.charAt(i);
                    }
                } else {
                    str += cryptogram.charAt(i - 1);
                    if (i + 1 == cryptogram.length()) { // 마지막 문자일경우 마지막 문자 추가
                        str += cryptogram.charAt(i);
                    }
                }
            }
            cryptogram = str;
        }
        answer = cryptogram;
        return answer;
    }
}
