package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer=cryptogram;
        String check_list="([a-z])\\1+";

        while(true) {

            int before_len=answer.length();
            answer=answer.replaceAll(check_list,"");

            if(before_len==answer.length())
                break;

        }

        return answer;
    }
}
