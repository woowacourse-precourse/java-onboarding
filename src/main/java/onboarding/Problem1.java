package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        Integer pobiScore = getScore(pobi);
        Integer crongScore = getScore(crong);

        if (pobiScore == -1 || crongScore == -1)
            return answer;
        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }

    static public Integer sumDigits(Integer num) {
        Integer sum = 0;

        while (!num.equals(0)) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    static public Integer mulDigits(Integer num) {
        Integer mul = 1;

        while (!num.equals(0)) {
            mul *= num % 10;
            num /= 10;
        }
        return mul;
    }

    static public boolean isError(List<Integer> pages) {
        return pages.get(0) % 2 != 1 || pages.get(1) - pages.get(0) != 1;
    }

    static public Integer getScore(Integer page) {
        return Integer.max(sumDigits(page), mulDigits(page));
    }
    static public Integer getScore(List<Integer> pages) {
        if (!isError(pages))
            return Integer.max(getScore(pages.get(0)), getScore(pages.get(1)));
        return -1;
    }
}