package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 예외 사항에 대한 함수 except()
        // 최대값을 구하는 함수 maxNumber()

        if (! except(pobi) || ! except(crong)) return -1;

        int pobiNumber = Math.max(maxNumberByPage(pobi.get(0)), maxNumberByPage(pobi.get(1)));
        int crongNumber = Math.max(maxNumberByPage(crong.get(0)), maxNumberByPage(crong.get(1)));

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean except(List<Integer> list) {

        return list.get(0).equals(list.get(1) - 1);
    }

    public static Integer maxNumberByPage( int page) {
        int mul = 1;
        int add = 0;

        while (page > 0) {
            int n = page % 10;
            mul *= n;
            add += n;
            page /= 10;
        }

        return Math.max(mul, add);
    }
}