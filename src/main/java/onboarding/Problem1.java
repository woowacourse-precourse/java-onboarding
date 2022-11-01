package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외처리 사항
        if (checkInvalid(pobi, crong)) {
            return -1;
        }

        // Step1: 포비가 펼친 페이지 번호
        List<Integer> p1 = eachNum(pobi.get(0));
        List<Integer> p2 = eachNum(pobi.get(1));

        // Step1: 크롱이 펼친 페이지 번호
        List<Integer> c1 = eachNum(crong.get(0));
        List<Integer> c2 = eachNum(crong.get(1));

        // Step 2~4: 포비의 점수
        int pobiMaxLeft = maxNum(addNum(p1), mulNum(p1));
        int pobiMaxRight = maxNum(addNum(p2), mulNum(p2));
        int pobiMax = maxNum(pobiMaxLeft, pobiMaxRight);

        // Step 2~4: 크롱의 점수
        int crongMaxLeft = maxNum(addNum(c1), mulNum(c1));
        int crongMaxRight = maxNum(addNum(c2), mulNum(c2));
        int crongMax = maxNum(crongMaxLeft, crongMaxRight);

        // Step 5: 두 사람의 점수 비교
        int result = compareNum(pobiMax, crongMax);
        if (result > 0) { // 포비 승
            answer = 1;
        } else if (result < 0) { // 크롱 승
            answer = 2;
        } else { // 무승부
            answer = 0;
        }
        return answer;
    }

    private static boolean checkInvalid(List<Integer> p, List<Integer> c) {
        // pobi와 crong의 길이는 2이다
        if (p.size() != 2 || c.size() != 2) {
            return true;
        }

        Integer n1 = p.get(0);
        Integer n2 = p.get(1);
        Integer c1 = c.get(0);
        Integer c2 = c.get(1);

        // 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다
        if (n1 <= 1 || n2 >= 400 || c1 <= 1 || c2 >= 400) {
            return true;
        }
        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수이다
        if (n1 % 2 == 0 || n2 % 2 == 1 || c1 % 2 == 0 || c2 % 2 == 1) {
            return true;
        }
        // 임의로 책을 펼쳤을 때 순서대로 연속된 숫자가 나온다
        if (n2 - n1 != 1 || c2 - c1 != 1) {
            return true;
        }
        return false;
    }

    // 각 자리 숫자를 List 배열로 바꿔주는 함수
    private static List<Integer> eachNum(int num) {
        ArrayList<Integer> arrList = new ArrayList<>();
        while (num > 0) {
            arrList.add(num % 10);
            num /= 10;
        }
        return arrList;
    }

    // 각 자리 숫자를 모두 더한 수를 구하는 함수
    private static int addNum(List<Integer> arrList) {
        int result = 0;
        for (int number : arrList) {
            result += number;
        }
        return result;
    }

    // 각 자리 숫자를 모두 곱한 수를 구하는 함수
    private static int mulNum(List<Integer> arrList) {
        int result = 1;
        for (int number : arrList) {
            result *= number;
        }
        return result;
    }

    // 더 큰 수를 반환하는 함수
    private static int maxNum(int first, int sec) {
        if (first > sec) {
            return first;
        } else {
            return sec;
        }
    }

    // 두 수의 대소를 비교하는 함수
    public static int compareNum(int first, int sec) {
        return first - sec;
    }

}