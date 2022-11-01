package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isNotValid(pobi, crong)){
            return  -1;
        }

        int pobi_max = getLarger(pobi.get(0),pobi.get(1));
        int crong_max = getLarger(crong.get(0),crong.get(1));

        return getWinner(pobi_max, crong_max);
    }

    private static int getWinner(int pobi_max, int crong_max) {
        if(pobi_max > crong_max){
            return 1;
        }
        if(pobi_max == crong_max){
            return 0;
        }
        if(pobi_max < crong_max){
            return 2;
        }
        return -1;
    }

    private static boolean isNotValid(List<Integer> pobi, List<Integer> crong) {
        return Math.abs(pobi.get(0) - pobi.get(1)) > 1 || Math.abs(crong.get(0) - crong.get(1)) > 1;
    }

    private static int getLarger(int left, int right) {
        int l = getMax(String.valueOf(left));
        int r = getMax(String.valueOf(right));
        return Math.max(l,r);
    }

    private static int getMax(String str) {
        int sum = 0;
        int multiply = 1;
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i)-'0';
            sum += now;
            multiply *= now;
        }
        return sum >= multiply ? sum : multiply;
    }
}