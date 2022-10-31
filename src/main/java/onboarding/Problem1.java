package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!pageValidation(pobi) || !pageValidation(crong)){
            return -1;
        }

        int pobiMax = comparePages(pobi);
        int crongMax = comparePages(crong);

        if(pobiMax > crongMax) {
            return 1;
        }
        if (pobiMax < crongMax) {
            return 2;
        }
        return 0;
    }

    static int comparePages(List<Integer> player) {
        int max = 0;
        for (Integer page : player) {
            int tmp = max(page);
            if(max < tmp) max = tmp;
        }
        return max;
    }
    static int max(int page) {
        List<Integer> pageDigit = new ArrayList<>();
        while(page > 0) {
            int num = page % 10;
            pageDigit.add(num);

            page /= 10;
        }
        int sum = 0; int multi = 1;
        for (Integer integer : pageDigit) {
            sum += integer;
            multi *= integer;
        }
        return Math.max(sum, multi);
    }

    static boolean pageValidation(List<Integer> player) {
        for (Integer i : player) if (i < 1 || i > 400) {
            return false;
        }
        if(player.size() != 2) return false;

        if (player.get(0) % 2 != 1 || player.get(1) % 2 !=0) {
            return false;
        }
        return player.get(1) - player.get(0) == 1;
    }


}