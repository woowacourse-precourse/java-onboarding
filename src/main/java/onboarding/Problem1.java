package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiScore = 0;
        int crongScore = 0;

        if (hasException(pobi) || hasException(crong)) {
            answer = -1;
            return answer;
        }

        for (Integer pageNum : pobi) {
            String num = Integer.toString(pageNum);
            pobiScore = Math.max(pobiScore, add(num.toCharArray()));
            pobiScore = Math.max(pobiScore, multiple(num.toCharArray()));
        }

        for (Integer pageNum : crong) {
            String num = Integer.toString(pageNum);
            crongScore = Math.max(crongScore, add(num.toCharArray()));
            crongScore = Math.max(crongScore, multiple(num.toCharArray()));
        }

        if (pobiScore > crongScore) {
            answer = 1;
        }
        if (crongScore > pobiScore) {
            answer = 2;
        }
        if (pobiScore == crongScore) {
            answer = 0;
        }

        return answer;
    }

    public static int add(char[] num) {
        int result = 0;
        for (char digit : num) {
            result += digit - '0';
        }
        return result;
    }

    public static int multiple(char[] num) {
        int result = 1;
        for (char digit : num) {
            result *= (digit - '0');
        }
        return result;
    }

    public static boolean hasException(List<Integer> game) {
        int leftPage = game.get(0);
        int rightPage = game.get(1);
        if (game.size() != 2) {
            return true;
        }
        if (rightPage - leftPage != 1) {
            return true;
        }
        if (leftPage % 2 != 1) {
            return true;
        }
        if (rightPage % 2 != 0) {
            return true;
        }
        if (leftPage < 2 || rightPage >= 400) {
            return true;
        }
        return false;
    }
}