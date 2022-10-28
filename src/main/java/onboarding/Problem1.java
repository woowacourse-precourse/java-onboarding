package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0)) != 1 || (crong.get(1) - crong.get(0)) != 1) {
            return -1;
        }

        int pobi_first = getMaxNumber(pobi.get(0));
        int pobi_second = getMaxNumber(pobi.get(1));

        int crong_first = getMaxNumber(crong.get(0));
        int crong_second = getMaxNumber(crong.get(1));

        int pobi_num = (pobi_first > pobi_second) ? pobi_first : pobi_second;
        int crong_num = (crong_first > crong_second) ? crong_first : crong_second;

        if (pobi_num > crong_num)
            return 1;
        else if (crong_num > pobi_num)
            return 2;
        else
            return 0;
    }

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