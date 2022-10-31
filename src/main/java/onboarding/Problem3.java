package onboarding;

public class Problem3 {

    private static int countClap(int num) {
        int count=0, temp;
        while(num != 0) {
            temp = num % 10;
            if(temp==3 || temp==6 || temp==9)
                count++;
            num /= 10;
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
