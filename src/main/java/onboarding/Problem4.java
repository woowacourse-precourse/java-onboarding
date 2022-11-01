package onboarding;

public class Problem4 {
    // ascii 표를 이용하여 청개구리 사전 구현
    static char convertReverse(char character){
        int ascii = (int)character;
        int startPoint = 0;
        int endPoint = 0;
        int displacement;
        int reverseAscii;
        // 대문자일 경우 변환
        if(65 <= ascii && ascii <= 90){
            startPoint = 65;
            endPoint = 90;
        }
        // 소문자일 경우 변환
        if(97<= ascii && ascii <= 122){
            startPoint = 97;
            endPoint = 122;
        }
        // 띄어쓰기의 경우 변환 없이 반환
        if(ascii == 32){
            return (char)ascii;
        }
        displacement = ascii - startPoint;
        reverseAscii = endPoint - displacement;
        return (char)reverseAscii;
    }
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            answer = answer.concat(String.valueOf(convertReverse(word.charAt(i))));
        }
        return answer;
    }
}
