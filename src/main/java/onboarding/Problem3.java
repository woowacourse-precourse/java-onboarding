package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i< (number+1); i++){
            String num = Integer.toString(i);
            char[] character = num.toCharArray();
            for (char x : character){
                if((x == '3') || (x=='6') || (x=='9')) answer += 1;
            }
        }
        return answer;
    }
}
