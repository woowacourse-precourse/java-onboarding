package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char prev = ' ';
        while(true) {
            String temp = cryptogram.substring(0, 1);
            int len = cryptogram.length();
            for(int i = 1; i < len; i++) {
                // 2. 이전 글자와 현재 글자가 같다면 temp 뒤에 이미 들어간 문자도 잘라준다.
                if (prev == cryptogram.charAt(i)) {
                    temp = temp.substring(0, temp.length() - 1);
                    continue;
                }
                // 1. for문을 돌면서 temp에 한 글자씩 붙일 껀데
                temp += cryptogram.substring(i, i + 1);
                prev = cryptogram.charAt(i);
            }
            cryptogram = temp;
            // 3. 같은 글자가 다 지워져서 없거나 조작 전 후의 길이가 같으면 while 탈출
            if(cryptogram.length() == 0 || len == cryptogram.length()) {
                answer = cryptogram;
                break;
            }
        }
        return answer;
    }
}
