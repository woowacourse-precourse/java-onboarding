package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++){
            int length = (int)Math.log10(i)+1;
            int temp = i;
            for (int j = 0; j < length; j++){
                int a = temp%10;
                if (a == 3 || a ==6 || a== 9) answer++;
                temp /=10;
            }
        }
        return answer;
    }
}
