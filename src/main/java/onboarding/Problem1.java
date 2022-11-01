package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (check(pobi) == false || check(crong) == false) {
            answer = -1;
        } else {
            List<Integer> pobiScore = List.of(
                    add(pobi.get(0)),
                    add(pobi.get(1)),
                    mul(pobi.get(0)),
                    mul(pobi.get(1))
            );

            List<Integer> crongScore = List.of(
                    add(crong.get(0)),
                    add(crong.get(1)),
                    mul(crong.get(0)),
                    mul(crong.get(1))
            );

            int maxPobi = 0;
            int maxCrong = 0;
            for (int i : pobiScore) {
                maxPobi = Math.max(i, maxPobi);
            }
            for (int i : crongScore) {
                maxCrong = Math.max(i, maxCrong);
            }

            if (maxPobi > maxCrong) answer = 1;
            else if (maxCrong > maxPobi) answer = 2;
            else answer = 0;
        }

        return answer;
    }

    private static int add(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    private static int mul(int n) {
        int sum = 1;
        while (n != 0) {
            sum *= n%10;
            n /= 10;
        }
        return sum;
    }

    private static boolean check(List<Integer> list) {
        if (list.get(0)%2 != 1 || list.get(1)%2 != 0) {
            return false;
        } else if (list.get(0) == 1 || list.get(1) == 400) {
            return false;
        } else if (list.get(0)+1 != list.get(1)) {
            return false;
        } else {
            return true;
        }
    }
}