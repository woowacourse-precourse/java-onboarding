package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=0; i<number+1; i++){
            char[] intToChar = String.valueOf(i).toCharArray();
            answer += containThree(intToChar);
        }

        return answer;
    }

    private static int containThree(char[] num){
        int cnt = 0;
        for(int i=0; i<num.length; i++){
            if(num[i] == '3') cnt++;
        }
        return cnt;
    }
}
