package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!check(pobi)) { //페이지가 제한 사항에 만족하는지 확인한다.
            return -1;
        }
        if (!check(crong)) {
            return -1;
        }

        int pobiScore, crongScore;
        pobiScore = getMaxScore(pobi); //페이지로 가질수 있는 가장 높은 점수를 반환한다.
        crongScore = getMaxScore(crong);

        if (pobiScore > crongScore) answer = 1; //포비가 이긴 경우
        else if (pobiScore < crongScore) answer = 2; //크롱이 이긴 경우
        else if (pobiScore == crongScore) answer = 0; //비긴 경우
        else answer = -1; //예외사항
        return answer;
    }

    static boolean check(List<Integer> name) {
        int odd = name.get(0);
        int even = name.get(1);
        if (odd == 1) return false;
        if (even == 400) return false;
        if (odd + 1 != even) return false;
        if (odd % 2 != 1) return false;
        return true;
    }

    static int getMaxScore(List<Integer> name) {
        int score[] = new int[4];
        score[0] = getSum(name.get(0));
        score[1] = getSum(name.get(1));
        score[2] = getMul(name.get(0));
        score[3] = getMul(name.get(1));
        return Arrays.stream(score).max().getAsInt();
    }

    static int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    static int getMul(int num) {
        int mul = 1;
        while (num != 0) {
            mul *= num % 10;
            num /= 10;
        }
        return mul;
    }
}