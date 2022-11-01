package onboarding;

public class Problem4 {
    /**
     - 문제:
     word가 주어지면 청개구리 사전을 참고해 반대로 변환하며 메서드를 완성해라

     - 제한사항:
     1) 1~1000 문자열
     2) 알파벳 외에는 변환하지 않음
     3) 알파벳 대문자는 대문자로, 소문자는 소문자로 변환

     - 해결 방법:
     1) 아스키코드를 활용
     2) 아스키코드 a 숫자를 기준으로 입력 문자가 a에서 얼마나 떨어져있는지를 확인
     3) 그 수를 아스키코드 z 숫자에서 빼줌
     4) 대소문자에 대해서 적용
     5) 알파벳 아닌 경우는 바로 붙쳐줌

     **/
    public static String solution(String word) {
        String answer = "";

        int AsciiStart = 65; // A
        int AsciiEnd = 90; // Z
        int asciistart = 97; // a
        int asciiend = 122; // z
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                count = asciistart - word.charAt(i);
                if(count < 0) count *= -1;
                char z = (char) (asciiend - count);
                answer += z;
            }
            else if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                count = AsciiStart - word.charAt(i);
                if(count < 0) count *= -1;
                char z = (char) (AsciiEnd - count);
                answer += z;
            }
            else answer += word.charAt(i);
        }

        return answer;
    }
}
