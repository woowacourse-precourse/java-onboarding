package onboarding;

public class Problem4 {

    // 기능 목록 1 : 한 단어를 청개구리 사전을 참고하여 반대로 변환하는 함수
    public static Character transformReverse(Character ch){
        int temp = (int)ch;
        if(temp>=65&&temp<=90){
            temp = 90-(temp-65);
        }
        if(temp>=97&&temp<=122){
            temp = 122-(temp-97);
        }
        return (char)temp;
    }
    public static String solution(String word) {
        String answer = "";

        // 주어진 문자열을 변환시키는 반복문
        for(int i=0;i<word.length();i++){
            answer += transformReverse(word.charAt(i));
        }

        return answer;
    }
}
