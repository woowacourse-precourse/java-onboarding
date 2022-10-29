package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean flag = false;
        char cmp;

        while(flag == false&& answer.length() > 0){
            cmp = answer.charAt(0);
            for(int i = 1; i < answer.length();i++){
                if(cmp == answer.charAt(i)){
                    answer = answer.substring(0,i-1)+answer.substring(i);
                }
                cmp = answer.charAt(i);

            }

        }
        return answer;
    }
}