package onboarding;

public class Problem4 {
    /*기능구현
    조건 : 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
          A - Z, B - Y 과 같은 조합은 아스키코드(정수형 숫자)의 계산으로 알 수 있다. "A" : 65, "Z" : 90
    1. word의 특정 char값의 reverse값이 무엇인지 반환하는 함수를 구현
    * */

    public static String reverseWord(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i++){
            //대문자일때
            if ((int)s.charAt(i) >= 65 && (int)s.charAt(i) <= 90){
                String c = Character.toString((90 - ((int)s.charAt(i) - 65)));
                sb.append(c);

            }

            // 소문자일때
            if ((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 122){
                String c = Character.toString((122 - ((int)s.charAt(i) - 97)));
                sb.append(c);

            }

            // 공백일때
            if ((int)s.charAt(i) == 32){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String solution(String word) {
        String answer = "";

        answer = reverseWord(word);
        return answer;
    }
}
