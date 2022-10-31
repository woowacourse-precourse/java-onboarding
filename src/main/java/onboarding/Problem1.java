package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    private static final int MOD_NUMBER = 10;
    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
        List<Integer> crong = new ArrayList<>();
        pobi.add(99);
        pobi.add(132);

        crong.add(211);
        crong.add(212);

        System.out.println(solution(pobi, crong));

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotAvailable(pobi) || isNotAvailable(crong)) { //둘 중 하나라도 NotAvailable 하다면 return -1
            return -1;
        }
        int pobi_max = getMax(pobi);
        int crong_max = getMax(crong);

        return getWinner(pobi_max, crong_max);
    }

    private static int getWinner(int pobi_max, int crong_max) {
        if (pobi_max > crong_max) {
            return 1;
        }
        else if (pobi_max < crong_max) {
            return 2;
        }
        else { //pobi_max == crong_max
            return 0;
        }
    }

    // 포비와 크롱의 Max를 구하는 메소드
    private static int getMax(List<Integer> pageList) {
        int max = Integer.MIN_VALUE;
        for (Integer pageNumber : pageList) {
            int sum = sum_page(pageNumber);
            if (sum > max) {
                max = sum;
            }

            int multiple = multiple_page(pageNumber);
            if (multiple > max) {
                max = multiple;
            }
        }
        return max;
    }

    /**
     * sum_page, multiple_page 의 중복된 부분을 리팩토링 할 수 있을까?
     */
    private static int sum_page(int pageNumber) {
        int sum = 0;
        while(pageNumber / MOD_NUMBER != 0) {
            int rest = pageNumber % MOD_NUMBER;
            pageNumber /= MOD_NUMBER;

            sum += rest;
        }
        sum += pageNumber;

        return sum;
    }

    private static int multiple_page(int pageNumber) {
        int result = 1;
        while(pageNumber / MOD_NUMBER != 0) {
            int rest = pageNumber % MOD_NUMBER;
            pageNumber /= MOD_NUMBER;

            result *= rest;
        }
        result *= pageNumber;

        return result;
    }



    //Available하고 NotAvailable을 두 개 만든건, !isAvailable 보다 isNotAvailable이 더 명확할 것 같아서쓴다.
    private static boolean isNotAvailable(List<Integer> list) {
        return !isAvailable(list);
    }
    private static boolean isAvailable(List<Integer> list) {
        //==제한 사항에 담겨 있는 것들 ==//
        if (list.size() != 2) { //리스트의 사이즈가 2가 아니라면, false
            return false;
        }
        if (list.get(0) % 2 != 1) { //0번 인덱스가 홀수가 아니라면, false
            return false;
        }
        if (list.get(1) % 2 != 0) { //1번 인덱스가 짝수가 아니라면, false
            return false;
        }


        if (list.get(1) - list.get(0) != 1) { //홀수 짝수의 연속된 페이지가 아니라면
            return false;
        }

        return true;
    }
}