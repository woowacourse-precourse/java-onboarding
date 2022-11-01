package onboarding;

public class Problem4 {
//    아스키 a~z : 97~122 ; 97 + 122 = 219
//    아스키 A~Z : 65~90  ; 65 + 90 = 155
    public static char change(char before){
        if (before == ' '){
            return ' ';
        }
        int asc = before;
        char after = ' ';
        if (asc >= 97) {
            after = (char)(219 - asc);
        }
        else{
            after = (char)(155 - asc);
            }
        return after;
    }
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += change(word.charAt(i));
        }

            return answer;
    }
}
