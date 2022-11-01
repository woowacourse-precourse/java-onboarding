package onboarding;

class ProblemSolve4{
    public static String reverseAlphabet(String word){
        char[] chars = word.toCharArray();

        for (int i=0;i<chars.length;i++){
            if (chars[i]==' '){
                continue;
            }
            int temp = (int)chars[i];
            if (65<=temp && temp<=90){
                chars[i] = (char)(65 + (90 - temp));
            }
            else if (97<=temp && temp<=122){
                chars[i]=(char)(97 + (122-temp));
            }
        }
        return String.valueOf(chars);
    }
}
public class Problem4 {
    /*
    * 기능 구현 목록
    * 문자열을 순회하면서, 각 문자의 아스키코드 값 이 97미만이면 대문자 변환, 97이상이면 소문자변환하기.
    * 문제의 문자열 변환 로직. 대,소문자 A +(대,소문자 Z - (현재 문자 아스키 코드값))
    * */
    public static String solution(String word) {
        return ProblemSolve4.reverseAlphabet(word);
    }
}
