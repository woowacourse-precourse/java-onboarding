package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i<=number; i++){
            answer += checkThree(i);
        }
        return answer;
    }

    //숫자에서 3, 6, 9의 개수를 체크하는 기능
    static int checkThree(int n){
        int result = 0;
        while(n>0){
            int tmp = n%10;
            if(tmp == 3 || tmp ==6 || tmp == 9)result++;
            n/=10;
        }
        return result;
    }
}
