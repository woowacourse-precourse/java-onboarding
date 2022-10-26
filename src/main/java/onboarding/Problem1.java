package onboarding;

import java.util.List;


/**
 * [o] 책을 임의로 펼친다.
 * [o] 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * [o] 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * [o] 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * [o] 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * [ ] 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 * [ ] 포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        if (pobiMax > crongMax) {
            answer = 1;
        } else if (pobiMax < crongMax) {
            answer = 2;
        } else if (pobiMax == crongMax) {
            answer = 0;
        }

        return answer;

    }

    public static int getSumNumberOfDigits(int num) {
        int sum = 0;
        String s = Integer.toString(num);

        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.substring(i, i + 1));
        }

        return sum;
    }

    public static int getMultipleNumberOfDigits(int num) {
        int multiple = 1;
        String s = Integer.toString(num);

        for (int i = 0; i < s.length(); i++) {
            multiple *= Integer.parseInt(s.substring(i, i + 1));
        }

        return multiple;
    }

    public static int getMax(List<Integer> pages) {
        int max = 0;
        for (Integer page : pages) {
            max = Math.max(Math.max(getSumNumberOfDigits(page), getMultipleNumberOfDigits(page)), max);
        }

        return max;
    }

    public static boolean isRandomPage(List<Integer> pages) {
        if (pages.get(1) - pages.get(0) == 1) {
            return true;
        } else {
            return false;
        }
    }
}