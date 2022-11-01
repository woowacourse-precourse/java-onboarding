package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "answer";
        answer = "";
        String abclist = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int char_index = abclist.indexOf(Character.toLowerCase(c));
            if (char_index == -1){
                answer += c;
            } else if (c != Character.toLowerCase(c)){
                answer += Character.toUpperCase(abclist.charAt(25 - char_index));
            } else {
                answer += abclist.charAt(25 - char_index);
            }//if
        }//for
        return answer;
    }
}
