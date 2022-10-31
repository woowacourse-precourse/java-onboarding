package onboarding;

public class Problem3 {

    // 각 자릿수에 있는 3, 6, 9의 수 카운트하는 함수
    public static int count369(int number) {
        int count = 0;
        while (number > 0) {
            int temp = number % 10;
            if (temp == 3 || temp == 6 || temp == 9) {
                count += 1;
            }
            number = number / 10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number+1; i++) {
            answer += count369(i);
        }

        return answer;
    }
}
