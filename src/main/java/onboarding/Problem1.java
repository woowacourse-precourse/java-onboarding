package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int leftpage = pobi.get(0);





        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static ArrayList<Integer> sperater(int page) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while(page > 0) {
            numbers.add(page % 10);
            page /= 10;
        }
        return numbers;
    }
}

