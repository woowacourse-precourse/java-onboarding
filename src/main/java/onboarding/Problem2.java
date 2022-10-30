package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = sub_solution(cryptogram);
        return answer;
    }
    public static String sub_solution(String input){
        boolean flag = false;
        String answer = "";
        for(int i = 0 ; i < input.length() ; i++){
            if(i == 0){
                if(input.charAt(0) != input.charAt(1)) answer += input.charAt(0);
                else flag = true;
            }
            else if (i == input.length() - 1){
                if(input.charAt(input.length()-1) != input.charAt(input.length()-2)) answer += input.charAt(input.length()-1);
                else flag = true;
            }
            else{
                char cur = input.charAt(i);
                char prev = input.charAt(i-1);
                char next = input.charAt(i+1);
                if(cur != prev && cur != next) answer += cur;
                else flag = true;
            }
        }
        if(flag) return sub_solution(answer);
        else return answer;
    }
}
