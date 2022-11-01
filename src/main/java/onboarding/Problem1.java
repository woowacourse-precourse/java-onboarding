package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /*
         * 기능 요구 사항
         * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
         *
         * 포비와 크롱의 점수를 비교하여 가장 높은 사람이 게임의 승자가 된다.
         *
         * */

        if (check_continuous(pobi) && check_continuous(crong)) {
            int pobi_max = caculate_max(pobi);
            int crong_max = caculate_max(crong);
            if(pobi_max > crong_max) answer = 1;
            if(pobi_max < crong_max) answer =  2;
            if(pobi_max == crong_max) answer = 0;
        }


        /*
         * 기능 요구 사항
         * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
         *
         *  [1, 2], [399, 400] 페이지는 펼치지 않는다.
         *
         * */

        if (pobi.get(0) == 1 || crong.get(0) == 399)   answer = -1;

        // 둘중 한명이라도 페이지가 연속적이지 않으면 예외 반환 실행
        if(!check_continuous(pobi) || !check_continuous(crong)) answer = -1;

        return answer;
    }

        /*
         * 기능 요구 사항
         * 1. 책을 임의로 펼친다.
         *
         * 왼쪽 페이지와 오른쪽 페이지의 번호를 얻는다.
         * 둘 중 한명이라도 페이지가 연속적이지 않으면 예외 반환
         * */
    private static boolean check_continuous(List<Integer> list) {
        if(list.get(1) - list.get(0) == 1) return true;
        else return false;
    }


        /*
         * 기능 요구 사항
         * 2. 왼쪽 페이지 번호의 각 자리를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
         * 3. 오른쪽 페이지 번호의 각 자리를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
         *
         * 각 자리를 모두 더한 것과, 각 자리를 모두 곱한 값을 비교하여 큰수를 구한다.
         * */
    // 각 자리수의 합 반환
    private static int num_sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i%10;
            i=i/10;
        }
        return sum;
    }

    // 각 자리수의 곱 반환
    private static int num_multiple(int i) {
        int multiple = 1;
        while (i > 0) {
            multiple *= i % 10;
            i = i / 10;
        }
        return multiple;
    }

    /*
     * 기능 요구 사항
     * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
     *
     * 각 자리를 모두 더한 것과, 각 자리를 모두 곱한 값을 비교하여 큰수를 구한다.
     * */
    // 개인의 최대 페이지 값 반환
    private static int caculate_max(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        int sum_max = Math.max(num_sum(left), num_sum(right));
        int multiple_max = Math.max(num_multiple(left), num_multiple(right));
        int max = Math.max(sum_max, multiple_max);
        return max;
    }
}
