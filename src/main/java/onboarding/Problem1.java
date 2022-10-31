package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!checkException(pobi, crong)) return -1;
        answer = comparePobiAndCrong(pobi, crong);
        return answer;
    }

    private static boolean checkException(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) + 1 == pobi.get(1) && crong.get(0) + 1 == crong.get(1);
    }

    private static int comparePobiAndCrong(List<Integer> pobi, List<Integer> crong) {
        int pobiMaxNum = compareTwoOperations(pobi);
        int crongMaxNum = compareTwoOperations(crong);
        if (pobiMaxNum > crongMaxNum) {
            return 1;
        } else if (pobiMaxNum == crongMaxNum) {
            return 0;
        } else {
            return 2;
        }
    }

    private static int compareTwoOperations(List<Integer> list) {
        return list.stream()
          .mapToInt(item ->  Math.max(addEachDigit(item), multiplyEachDigit(item)))
          .max()
          .getAsInt();
    }

    private static int multiplyEachDigit(int pageNum) {
        int answer = 1;
        String s = Integer.toString(pageNum);

        for (int i = 0; i < s.length(); i++) {
            answer *= Integer.parseInt(s.substring(i, i + 1));
        }
        return answer;
    }

    private static int addEachDigit(int pageNum) {
        int answer = 0;
        String s = Integer.toString(pageNum);

        for (int i = 0; i < s.length(); i++) {
            answer += Integer.parseInt(s.substring(i, i + 1));
        }
        return answer;
    }
}