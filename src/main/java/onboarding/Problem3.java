package onboarding;

public class Problem3 {
    public static int count(int num){
        int count=0;
        while(num != 0) {
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
                count++;
            // To check if the other digit has 3,6,9
            num /= 10;
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int num = i;
            // Only one indentation per function
            answer +=count(num);
        }
        return answer;
    }

}
