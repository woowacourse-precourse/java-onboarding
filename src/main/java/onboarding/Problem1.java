package onboarding;

import java.util.List;

class Problem1 {

    boolean checkException(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) != 1) {
            return false;
        }
        if (crong.get(1) - crong.get(0) != 1) {
            return false;
        }
        if ((pobi.get(0) == 1) || (crong.get(0) == 1)) {
            return false;
        }
        if ((pobi.get(1) == 400) || (crong.get(1) == 400) {
            return false;
        }
        return true;
    }

    int plusPage(Integer page) {
        int num = 0;
        String page_str = Integer.toString(page);

        for(int i=0; i < page_str.length(); i++){
            num += Integer.parseInt(page_str.substring(i, i+1));
        }
        return num;
    }

    int multiplyPage(Integer page) {
        int num = 1;
        String page_str = Integer.toString(page);

        for(int i=0; i < page_str.length(); i++){
            num *= Integer.parseInt(page_str.substring(i, i+1));
        }
        return num;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int leftPageNum;

        if (!checkException(pobi, crong)) {
            return -1;
        }

        return answer;
    }
}