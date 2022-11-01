package onboarding;

/** 구현 기능 목록
 * 1. 한 숫자를 매개변수로 받아 그 숫자에 3, 6, 9가 몇 번 들어가는지 세어서 반환
 * 2. 1부터 매개변수로 받은 숫자까지 총 3, 6, 9가 몇 번 들어가는지 세어서 반환
 * */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = totalCount69(number);
        return answer;
    }

    private static int count369(int number) {
        int count = 0;
        while (number > 0) {
            if (number % 10 != 0 && (number % 10) % 3 == 0)
                count++;
            number /= 10;
        }
        return count;
    }

    private static int totalCount69(int number) {
        int totalCount = 0;
        for (int i=0; i <= number; i++)
            totalCount += count369(i);
        return totalCount;
    }
}
