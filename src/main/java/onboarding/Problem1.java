package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 && crong.size() != 2) {
            return -1;
        }
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        if (pobi.get(0) <= 1 || pobi.get(1) >= 400 || crong.get(0) <= 1 || crong.get(1) >= 400) {
            return -1;
        }
        if (pobi.get(0) > pobi.get(1) || crong.get(0) > crong.get(1)) {
            return -1;
        }
        if (pobi.get(0) % 2 == 0 || pobi.get(1) % 2 != 0 || crong.get(0) % 2 == 0 || crong.get(1) % 2 != 0) {
            return -1;
        }


        int pobimax=0;
        int crongmax=0;



        pobimax = Math.max(Maxnum(pobi.get(0)), Maxnum(pobi.get(1)));
        crongmax = Math.max(Maxnum(crong.get(0)), Maxnum(crong.get(1)));

        if(pobimax > crongmax)
            return 1;
        else if (pobimax == crongmax)
            return 0;
        else
            return 2;

    }


    public static int Maxnum(int num) {
        int sum = 0, mul = 1;
        while(num != 0) {
            sum += num % 10;
            mul *= num % 10;
            num /= 10;
        }
        return Math.max(sum, mul);
    }
}