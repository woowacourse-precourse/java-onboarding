package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = frogWord(word);
        return answer;
    }
    public static String frogWord(String word){
        StringBuffer fword = new StringBuffer(word);

        for(int i = 0 ; i < fword.length() ; i++){
            if(fword.charAt(i) > 64 && fword.charAt(i) < 91)
                fword.replace(i,i+1, Character.toString(155-fword.charAt(i)));
            else if(fword.charAt(i) > 96 && fword.charAt(i) < 123)
                fword.replace(i,i+1, Character.toString(219-fword.charAt(i)));
        }
        return fword.toString();
    }
}
