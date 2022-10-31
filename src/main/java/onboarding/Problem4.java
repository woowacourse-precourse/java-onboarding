package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char tmp;
        for(int idx = 0; idx<word.length();idx++){
            //대문자
            if(word.charAt(idx) >64 && word.charAt(idx)<91){
                tmp = (char)(155- word.charAt(idx));
                answer+=tmp;
            }

            //소문자
            else if(word.charAt(idx) >96 && word.charAt(idx)<123){
                tmp = (char)(219- word.charAt(idx));
                answer+=tmp;
            }

            else
                answer+=" ";
        }
        return answer;
    }
}
