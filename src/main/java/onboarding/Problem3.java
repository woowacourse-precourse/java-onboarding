package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int getOneNumberClappingCount(int number) {
        int clappingCount = 0;
        while(number != 0) {
            if(number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                clappingCount += 1;
            }
            number /= 10;
        }
        return clappingCount;
    }
}
