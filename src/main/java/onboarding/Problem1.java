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


    }


}