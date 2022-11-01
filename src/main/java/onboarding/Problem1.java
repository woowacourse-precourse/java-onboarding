package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!check(pobi, crong)) {
            answer = -1;
            return answer;
        }

        int pobiPoint = GetPoint(pobi);
        int crongPoint = GetPoint(crong);

        if (pobiPoint > crongPoint) {
            answer = 1;
        }
        else if (pobiPoint < crongPoint) {
            answer = 2;
        }
        else  {
            answer = 0;
        }
        return answer;
    }
    public static boolean check(List<Integer> list1, List<Integer> list2) {
        if (list1.get(1) - list1.get(0) != 1 || list2.get(1) - list2.get(0) != 1) {
            return false;
        }
        else return true;
    }
    public static Integer GetPoint (List<Integer> list) {
        ArrayList<Integer> max = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int sum = 0, mult = 1;
            String s = list.get(i).toString();

            for (int j = 0; j < s.length(); j++) {
                sum += Integer.parseInt(s.substring(j, j+1));
                mult *= Integer.parseInt(s.substring(j, j+1));
            }

            if (sum <= mult) {
                max.add(i, mult);
            }
            else {
                max.add(i, sum);
            }
        }

        if (max.get(0) < max.get(1)) {
            return max.get(1);
        }
        else return max.get(0);
    }
}