package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int capitalConstant = 'A' + 'Z';
        int smallConstant = 'a' + 'z';

        /*1.입력 문자열을 맨 앞부터 순회하며 대소문자 여부를 판별한다.*/
        for(int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if(curr >= 'A' && curr <= 'Z'){
                curr = (char)(capitalConstant - curr);
            }

            if(curr >= 'a' && curr <= 'z'){
                curr = (char)(smallConstant - curr);
            }
            /*2.변환한 암호를 결과 String에 이어붙인다.*/
            sb.append(curr);
        }

        /*3.입력 문자열을 끝까지 순회했다면 결과 String을 반환한다.*/
        answer = sb.toString();

        return answer;
    }
}
