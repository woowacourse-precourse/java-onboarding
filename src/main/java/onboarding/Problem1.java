package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0)) != 1 || (crong.get(1) - crong.get(0)) != 1) {
            return -1;
        }

        int pobi_num = compareNumber(pobi.get(0), pobi.get(1));
        int crong_num = compareNumber(crong.get(0), crong.get(1));

        if (pobi_num > crong_num)
            return 1;
        else if (crong_num > pobi_num)
            return 2;
        else
            return 0;
    }

    /**
     *
     * @param num1 왼쪽 페이지 숫자
     * @param num2 오른쪽 페이지 숫자
     * @return 두 숫자의 각 자리의 합과 곱을 비교한 후 가장 큰 값
     */
    public static int compareNumber(int num1, int num2){
        int first = getMaxNumber(num1);
        int second = getMaxNumber(num2);

        return (first > second) ? first : second;
    }

    /**
     *
     * @param num 페이지 숫자
     * @return 숫자의 각 자리의 합과 곱 중 더 큰 값
     */
    public static int getMaxNumber(int num){
        int multi_num=1, sum_num=0;

        while (num > 0){
            int last_num = num % 10;

            multi_num *= last_num;
            sum_num += last_num;

            num /= 10;
        }

        if (multi_num > sum_num)
            return multi_num;
        else
            return sum_num;
    }
}