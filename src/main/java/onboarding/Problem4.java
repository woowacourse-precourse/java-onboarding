package onboarding;

/**
 * 1. 문자열의 첫 문자 부터 끝 문자 까지 반복문 실행
 * 2. 문자가 소문자이면 z부터 해당 문자의 차이를 'a'혹은 'A'문자에 더해서 원래 문자를 구한다.
 */
public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        // 1. 문자열의 첫 문자 부터 끝 문자 까지 반복문 실행
        for(int i=0; i < word.length() ; i++){

            // 2. 문자가 소문자이면 z부터 해당 문자의 차이를 'a'혹은 'A'문자에 더해서 원래 문자를 구한다.
            if(word.charAt(i)>'a' && word.charAt(i)< 'z'){
                answer.append((char) ('a' + 'z' - word.charAt(i)));
            }else if(word.charAt(i)>'A' && word.charAt(i)< 'Z'){
                answer.append((char) ('A' + 'Z' - word.charAt(i)));
            }else{
                answer.append(word.charAt(i));
            }
        }
        return answer.toString();
    }
}
