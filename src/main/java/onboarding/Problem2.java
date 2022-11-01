package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int length = cryptogram.length();
        int index = 0 ;

        while(index <= length - 1){
            if(answer.length() == 0){
                answer += cryptogram.charAt(index);
            }else{
                if(answer.charAt(answer.length()-1) == cryptogram.charAt(index)){
                    if(answer.length() == 1){
                        answer = "";
                    }else{
                        answer = answer.substring(0, answer.length()-1);
                    }
                }else {
                    answer += cryptogram.charAt(index);
                }
            }
            index += 1;
//            System.out.println(answer);
        }

        return answer;
    }
}
