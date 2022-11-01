package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isValidPageNumbers(List<Integer> pageNumbers) {
        if (pageNumbers.size() != 2){
            return false;
        }
        if ((1 <= pageNumbers.get(0) && pageNumbers.get(0) <= 400)
                && (1 <= pageNumbers.get(1) && pageNumbers.get(1) <= 400)){
            return false;
        }
        if (pageNumbers.get(0)%2 != 1){
            return false;
        }
        if (pageNumbers.get(0)+1 != pageNumbers.get(1)){
            return false;
        }
        return true;
    }

}