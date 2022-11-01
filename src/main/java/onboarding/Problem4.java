package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        //convert String to char Array
        char[] ch = word.toCharArray();

        //convert characters
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == ' '){
                answer += ' ';
            } else {
                int parsed = (int) ch[i];
                if(parsed < 97){
                    answer += (char)(parsed + (90-parsed) - (parsed-65));
                }
            }
        }

        return answer;
    }
}
