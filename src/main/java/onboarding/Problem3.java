package onboarding;

public class Problem3 {

    static boolean clappingHands(int number) {
        while(number != 0) {
            int val = number % 10;
            if (val == 3 || val == 6 || val == 9)
                return true;

            number /= 10;
            }
        return false;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++)
            if(clappingHands(i)) answer++;

        return answer;
    }
}
