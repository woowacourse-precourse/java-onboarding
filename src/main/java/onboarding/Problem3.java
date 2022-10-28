package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++)
            if (Integer.toString(i).contains("3") || Integer.toString(i).contains("6") || Integer.toString(i).contains("9")) {
                answer += count_three(i);
        }

        return answer;
    }

    public static int count_three(int num){
        int result = 0;

        while (num > 0){
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
                result+=1;
            num /= 10;
        }
        return result;
    }
}
