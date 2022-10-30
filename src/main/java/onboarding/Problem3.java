package onboarding;

public class Problem3 {
    public enum Game {
        three(3),
        six(6),
        nine(9);

        private final int district;

        Game(int district) {
            this.district = district;
        }
    }
    public enum Number {
        min(1),
        max(10_000),
        dight(10);

        private final int value;

        Number(int value) {
            this.value = value;
        }
    }
    public static int solution(int number) {
        int answer;

        checkException(number);

        answer = countNumber(number);

        return answer;
    }

    public static int countNumber(int num) {
        int cnt = 0;

        for (int i = 0; i <= num; i++)
            cnt += findDuplication(i);

        return cnt;
    }
    //중복 체크
    public static int findDuplication(int num) {
        int cnt = 0;

        while (num > 0) {
            if ((num % Number.dight.value) == Game.three.district
                    || (num % Number.dight.value) == Game.six.district
                    || (num % Number.dight.value) == Game.nine.district)
                cnt++;
            num /= Number.dight.value;
        }

        return cnt;
    }
    /*
    예외 처리 함수
     */
    public static void checkException(int number) {
        if (number < Number.min.value || number > Number.max.value)
            throw new IllegalArgumentException("ERROR");
    }
}
