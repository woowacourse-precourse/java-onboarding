package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

//pobi와 crong의 길이는 2이다.
        if (pobi.size() != 2 && crong.size() != 2){
            return -1;
        }
        return compareLogic(pobi, crong);
    }


    private static int plusLogic(List<Integer> lst){
        List<Integer> plus = new ArrayList<>();

        for(int i = 0; i < lst.size(); i++) {
            String s = Integer.toString(lst.get(i));

            for (int j = 0; j < s.length(); j++) {
                int sum = 0;
                sum += Integer.parseInt(s.substring(i, i + 1));
                plus.add(sum);
            }
        }
        return Collections.max(plus);
    }


}