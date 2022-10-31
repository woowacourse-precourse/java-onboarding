package onboarding;

public class Problem3 {
    // 각 자리 숫자가 3, 6, 9인지 판단해 해당하는 횟수를 반환하는 함수 
    public static int check_count(int number) {
        int count = 0;

        while (number != 0) {
            if ((number % 10) != 0 && ((number % 10) % 3) == 0) {
                count += 1;
            }
            number /= 10;
        }

        return count;
    }
    
    // 작동 함수
    public static int solution(int number) {
        int answer = 0;

        for (int n = 1; n <= number; n++) {
            answer += check_count(n);
        }

        return answer;
    }
}
