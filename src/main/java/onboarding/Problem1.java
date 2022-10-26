package onboarding;

import java.util.List;

class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        return answer;
    }

    public static boolean checkInvalidInput(List<Integer> list){
        int leftPage = list.get(0);
        int rightPage = list.get(1);

        if(rightPage - leftPage != 1)
            return false;

        if (leftPage%2 != 1)
            return false;

        if (rightPage %2 != 0)
            return false;

        return true;
    }
}