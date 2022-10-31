package onboarding;

import java.util.List;

class Problem1 {

    private static int max_num(List<Integer> pages) {

        String left  = pages.get(0) + "";
        String right = pages.get(1) + "";
        int[] myNum = {0, 0, 1, 1};
        int result   = -1;

        // 만약 left 와 right 의 길이가 다르더라도 바뀌는 지점에서는
        // 무조건 left 가 더 높기 때문에 left 기준으로 반복
        for(int i = 0; i < left.length(); i++) {
            myNum[0] += left.charAt(i)  - '0';
            myNum[1] += right.charAt(i) - '0';
            myNum[2] *= left.charAt(i)  - '0';
            myNum[3] *= right.charAt(i) - '0';
        }


        for (int j : myNum) {
            result = Math.max(result, j);
        }

        return result;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        boolean chk = pobi.get(0)+1 == pobi.get(1)
                && (crong.get(0)+1 == crong.get(1))
                && pobi.get(0) > 0
                && crong.get(0) > 0
                && pobi.get(1) < 401
                && crong.get(1) < 401;


        if (chk) {

            int pobi_num  = max_num(pobi);
            int crong_num = max_num(crong);

            if (pobi_num > crong_num)       return 1;

            else if (pobi_num < crong_num)  return 2;

            else                            return 0;

        } else {
            return -1;
        }
    }
}