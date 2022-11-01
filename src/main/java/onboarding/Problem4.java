package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder(word);
        char alph;
        int k;
        for(k=0;k<answer.length();k++){
            alph = answer.charAt(k);
            if(alph >= 'A' && alph <= 'Z'){
                alph = (char)( (int)'A' + ( 25 - ((int)alph - (int)'A')));
            }if(alph >= 'a' && alph <= 'z'){
                alph = (char)( (int)'a' + ( 25 - ((int)alph - (int)'a')));
            }
            answer.setCharAt(k, alph);
        }

        return answer.toString();
    }
}
