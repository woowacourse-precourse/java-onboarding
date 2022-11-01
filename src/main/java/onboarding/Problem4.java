package onboarding;

//1.완탐: word
//1) 대문자인 경우
//'Z'-(글자-'A') 로 변환
//2) 소문자인 경우
// 'Z'-(글자-'a') 로변환
//2.반환
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        //1.완탐: word
        //1) 대문자인 경우
        //'Z'-(글자-'A') 로 변환
        //2) 소문자인 경우
        // 'Z'-(글자-'a') 로변환
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                answer+=(char)('Z'-(word.charAt(i)-'A'));
            }
            if(word.charAt(i)>='a' && word.charAt(i)<='z'){
                answer+=(char)('z'-(word.charAt(i)-'a'));
            }
            if(word.charAt(i)==' '){
                answer+=' ';
            }
        }
        //2.반환
        return answer;
    }
}