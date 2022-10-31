package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!(isRight(pobi) && isRight(crong))) return -1;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(List.of(13,14), List.of(13,14)));
        System.out.println(solution(List.of(15,14), List.of(13,14)));
        System.out.println(solution(List.of(16,17), List.of(13,14)));
        System.out.println(solution(List.of(0,14), List.of(13,14)));
        System.out.println(solution(List.of(3,400), List.of(13,14)));
    }
    private static boolean isRight(List<Integer> list) {
        return isRightPage(list) && isNotFirstOrLastPage(list);
    }

    private static boolean isNotFirstOrLastPage(List<Integer> list) {
        boolean cond1 = (list.get(0) != 0);
        boolean cond2 = (list.get(1) != 400);
        return cond1 && cond2;
    }

    private static boolean isRightPage(List<Integer> list) {
        if(list.get(0) > list.get(1)) return false;
        boolean cond1 = (list.get(0)%2 == 1);
        boolean cond2 = (list.get(1)%2 == 0);
        return cond1 && cond2;
    }
}