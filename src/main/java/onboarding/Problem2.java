package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean flag = false;
        char cmp;

        while(flag == false&& answer.length() > 0){
            flag = true;
            for(int i = 0; i < answer.length()-1;i++){
                if(answer.length() == 1)
                    break;

                if(answer.charAt(i) == answer.charAt(i+1)){
                    int idx = i + 2;
                    flag = false;
                    while(idx<answer.length()){
                        if(answer.charAt(i)!=answer.charAt(idx)){
                            break;
                        }
                        idx++;
                    }

                    answer = answer.substring(0, i) + answer.substring(idx);
                }
            }
        }
        return answer;
    }
}