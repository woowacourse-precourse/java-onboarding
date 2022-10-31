package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return game369(number);
    }

    // 369 게임 중 손뼉 치는 횟수 반환 함수
    static int game369(int number) {
        int count = 0;
        int j;

        for (int i = 1; i <= number; i++) {
            j = i;
            while (j > 0) {
                if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9) {
                    count++;
                }
                j /= 10;
            }
        }

        return count;
    }
}
