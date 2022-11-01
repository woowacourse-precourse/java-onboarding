package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int count = 0;
        do {
            count = 0;
            for(int i = 0; i < answer.length()-1; i++){
                if (answer.charAt(i) == answer.charAt(i+1)){
                    answer = answer.substring(0,i) + answer.substring(i+2);
                    count += 1;
                    break;
                }//if
            }//for
        } while(count != 0); //do
        return answer;
    }
}
