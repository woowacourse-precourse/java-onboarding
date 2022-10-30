package onboarding;

/**
 * 1. 각 char값이 문자인지 판단
 * 2. 문자가 소문자인지 대문자인지 판별후 규칙에 따른 문자변환
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char c;

        for(int i = 0 ; i < word.length() ; i++){
            c = word.charAt(i);

            //char값이 문자인지 판단
            if(Character.isLetter(c)){

                //문자가 소문자일시
                if(Character.isLowerCase(c)){
                    c = (char)(122 - (int)(c) + 97);
                }
                // 문자가 대문자일시
                else if(Character.isUpperCase(c)){
                    c = (char)(90 - (int)(c) + 65);
                }
            }

            answer += c;
        }

        return answer;
    }
}
