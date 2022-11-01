package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int i = 0;
        while(true){
            if(answer.length() == 0){
                break;
            }
            if(answer.charAt(i) == answer.charAt(i+1)){
                System.out.println(answer);
                answer = answer.substring(0, i) +  answer.substring(i+2,answer.length());
                i = 0;
                continue;
            }else{
                i++;
                if(i == answer.length() - 1 ){
                    break;
                }
            }
        }

        return answer;
    }
}
