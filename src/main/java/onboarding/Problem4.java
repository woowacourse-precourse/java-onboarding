package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 입력된 문자열을 한글자씩 확인하며 청개구리 문자로 바꾼다.
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(Character.isLowerCase(c)) {  // 소문자
                c = (char)('z' - c + 'a');
            }
            if(Character.isUpperCase(c)) {  // 대문자
                c = (char)('Z' - c + 'A');
            }
            //System.out.println(c + "  " + (c + 0) + "  " + ('Z' - c) + "  " + ('z' - c));
            answer += c;
        }

        return answer;
    }
}
