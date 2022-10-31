package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] frog = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            frog[i] = word.charAt(i);
        }
        char x = ' ';

        for (int i = 0; i < frog.length; i++) {
            if(frog[i]==32){ //공백
                x = ' ';
            }else if(frog[i] < 90){ //대문자
                x =  (char)(155-(int)frog[i]);
            } else if (97 <= frog[i]) { //소문자
                x = (char)(219-(int)frog[i]);
            }
            answer += x;
        }
        return answer;
    }
}
