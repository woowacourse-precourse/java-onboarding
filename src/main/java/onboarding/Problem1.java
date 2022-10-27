package onboarding;

import java.util.List;

class Problem1 {

    public boolean checkOutOfRangeException(List<Integer> list) {
        return (list.get(0) > 1) && (list.get(1) < 400);
    }

   public boolean checkPageNumberValidityException(List<Integer> list) {
       return (list.get(0) % 2 == 1) && (list.get(1) - list.get(0) == 1);
   }

    public boolean checkException(List<Integer> list) {
        return checkOutOfRangeException(list) && checkPageNumberValidityException(list);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}