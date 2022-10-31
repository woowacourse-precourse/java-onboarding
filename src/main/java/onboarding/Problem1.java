package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if (!errorHandle(pobi.get(0), pobi.get(1)) || !errorHandle(crong.get(0), crong.get(1))) {
            return -1;
        }
        int pobiScore = max(getBig(pobi.get(0)), getBig(pobi.get(1)));
        int crongScore = max(getBig(crong.get(0)), getBig(crong.get(1)));

        answer = getWinner(pobiScore, crongScore);

        return answer;
    }
    static int getBig(int x) {
        int add = 0;
        int mul = 1;
        int num = 0;
        while (x > 0) {
            num = x % 10;
            x /= 10;
            add += num;
            mul *= num;
        }
        return add > mul ? add : mul;
    }
    static int getWinner(int pobiScore, int crongScore) {
        int diff = pobiScore - crongScore;
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return 2;
        }
        else {
            return 0;
        }
    }
    static int max(int a, int b) {
        return a > b ? a : b;
    }
    static boolean errorHandle(int left, int right) {
        if (left < 1 || left > 400 || right < 1 || right > 400 || right - left != 1) {
            return false;
        }
        return true;
    }
}

