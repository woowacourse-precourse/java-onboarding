package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 제한 사항 1 - - number는 1 이상 10,000 이하인 자연수이다.
        if (number < 1 || number > 10000) {
            answer = -1;
            return answer;
        }
        for(int i = 1; i< (number+1); i++){
            String num = Integer.toString(i);
            char[] character = num.toCharArray();
            for (char x : character){
                if((x == '3') || (x =='6') || (x=='9')) answer += 1;
            }
        }
        return answer;
    }
}
