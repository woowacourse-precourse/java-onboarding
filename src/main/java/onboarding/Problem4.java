/*
1, 대문자, 소문자 유무를 판단한다.
2, 아스키 코드의 차를 이용한 대칭성 조건을 만들어준다. array의 아스키코드 = Z-'A'
3, 출력한다.

*/
package onboarding;

public class Problem4 {
    public static String solution(String word) {
    String answer = "";

    for(int i = 0; i < word.length();i++){
        if('A' <= word.charAt(i) && word.charAt(i) <= 'Z'){
            int uppercaseTemp = 'A' + ('Z' - word.charAt(i));
            answer += (char)uppercaseTemp;
        }
        else if('a' <= word.charAt(i) && word.charAt(i) <= 'z'){
            int lowercaseTemp = 'a' + ('z' - word.charAt(i));
            answer += (char)lowercaseTemp;
        }
        else{
            answer += word.charAt(i);
        }
    }
    return answer;
    }
}
