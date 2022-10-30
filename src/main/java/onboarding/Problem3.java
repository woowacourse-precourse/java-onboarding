package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int num, temp;

        for(int i=1; i<=number; i++) {
            num = i;

            while(num != 0) {
                temp = num % 10;
                if(temp==3 || temp==6 || temp==9)
                    answer++;
                num /= 10;
            }
        }
        return answer;
    }
}
