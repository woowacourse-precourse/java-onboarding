package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int plusPage(ArrayList<Integer> pagelist) {
        int sum = 0;
        for (int element : pagelist) {
            sum += element;
        }
        return sum;
    }

    public static int comparePlusAndMulti(int plusedpage, int multipliedpage) {
        if (plusedpage < multipliedpage) {
            return multipliedpage;
        }else if (plusedpage > multipliedpage) {
            return plusedpage;
        }else {
            return plusedpage;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;

    }
}

