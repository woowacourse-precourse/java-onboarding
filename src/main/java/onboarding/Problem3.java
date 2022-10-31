package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = count(number);
        return answer;
    }
    public static int count(int number){
        int temp1 = 0;
        int temp2 = 0;
        int count = 0;

        for(int i = 1; i < number + 1; i++) {
            int num = i;
            while (num != 0) {
                temp1 = num % 10;
                if (temp1 == 3 || temp1 == 6 || temp1 == 9) {
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }
}
