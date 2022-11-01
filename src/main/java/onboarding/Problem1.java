package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pLeft = pobi.get(0);
        int pRight = pobi.get(1);
        int cLeft = crong.get(0);
        int cRight = crong.get(1);

        if (pLeft == 1 || pRight == 400 || cLeft == 1 || cRight == 400){
            return -1;
        }
        if (pLeft % 2 != 1 || pRight % 2 != 0 || cLeft % 2 != 1 || cRight % 2 != 0) {
            return -1;
        }
        if (pRight - pLeft != 1 || cRight - cLeft != 1){
            return -1;
        }

        int pScore = max(max(sum(pLeft), mul(pLeft)), max(sum(pRight), mul(pRight)));
        int cScore = max(max(sum(cLeft), mul(cLeft)), max(sum(cRight), mul(cRight)));

        if (pScore > cScore) answer = 1;
        else if (cScore > pScore) answer = 2;
        else answer = 0;

        System.out.println(answer);

        return answer;
    }

    public static int max(int a, int b){
        return a > b ? a : b;
    }
    public static int sum(int a){
        int res = 0;
        while (a != 0){
            res += a % 10;
            a /= 10;
        }
        return res;
    }

    public static int mul(int a){
        int res = 1;
        while (a != 0){
            res *= a % 10;
            a /= 10;
        }
        return res;
    }
}