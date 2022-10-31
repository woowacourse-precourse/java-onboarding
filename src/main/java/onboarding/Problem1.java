package onboarding;

import java.util.List;

class Problem1 {
    public static boolean exception(List<Integer> pageList) {
        int left = pageList.get(0);
        int right = pageList.get(1);

        if (!(left % 2 != 0 && right % 2 == 0)) { // 왼쪽 페이지가 홀 수, 오른쪽 페이지가 짝 수가 아닌 경우
            return true;
        }

        if (right - left != 1) { // 페이지가 연속적이지 않은 경우
            return true;
        }

        if (left == 1 || right == 400) { // 첫번째 페이지 혹은 마지막 페이지를 편 경우
            return true;
        }

        if (!(1 <= left && left <= 400) || !(1 <= right && right <= 400)) { // 둘 중 하나라도 1 ~ 400 까지의 페이지를 벗어난 경우
            return true;
        }

        return false;
    }

    public static int biggest(int pageNumber) {
        int add = 0;
        int multiply = 1;

        String stringPageNumber = Integer.toString(pageNumber);

        for (int i = 0; i < stringPageNumber.length(); i++) {
            int digit = stringPageNumber.charAt(i) - '0';

            add += digit;
            multiply *= digit;
        }

        return Math.max(add, multiply); // 더 큰 것을 리턴
    }

    public static int winner(int pobiScore, int crongScore) {
        // pobi win = 1, crong win = 2, draw = 0
        return pobiScore > crongScore ? 1 :
                (pobiScore < crongScore) ? 2 : 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exception(pobi) || exception(crong)) { // 둘 중 하나라도 Exception 이 true 인 경우 바로 예외의 경우이다.
            return -1;
        }

        int pobiScore = Math.max(biggest(pobi.get(0)), biggest(pobi.get(1)));
        int crongScore = Math.max(biggest(crong.get(0)), biggest(crong.get(1)));

        return winner(pobiScore, crongScore);
    }
}