package onboarding;

import java.util.List;

class Problem1 {

    private static final int SIZE = 2;
    private static final int POBI_INDEX = 0;
    private static final int CRONG_INDEX = 1;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int[] scores = new int[SIZE];

        User[] users = inItUsers(pobi, crong);

        scores[POBI_INDEX] = getScore(users[POBI_INDEX]);
        scores[CRONG_INDEX] = getScore(users[CRONG_INDEX]);

        return answer;
    }

    private static int getScore(User user) {
        int maxPage = 400;
        int maxNum = 0;

        int left = user.getLeft();
        int right = user.getRight();

        if (right - left > 1 || left % 2 == 0 || right % 2 == 1 || right > maxPage || left > right) {
            return EXCEPTION;
        }

        for (int op = 0; op < SIZE; op++) {
            int leftPage = left;
            int rightPage = right;

            if (op == 0) {
                leftPage = plus(leftPage);
                rightPage = plus(rightPage);
            } else if (op == 1) {
                leftPage = multiple(leftPage);
                rightPage = multiple(rightPage);
            }
            maxNum = Math.max(maxNum, Math.max(leftPage, rightPage));
        }

        return maxNum;
    }

    private static int multiple(int value) {
        int answer = 1;
        String page = intToString(value);

        for (int i = 0; i < page.length(); i++) {
            answer *= charToInt(page.charAt(i));
        }

        return answer;
    }

    private static int plus(int value) {
        int answer = 0;
        String page = intToString(value);

        for (int i = 0; i < page.length(); i++) {
            answer += charToInt(page.charAt(i));
        }

        return answer;
    }

    private static User[] inItUsers(List<Integer> pobi, List<Integer> crong) {
        int leftIndex = 0;
        int rightIndex = 1;

        User[] users = new User[SIZE];

        int left = pobi.get(leftIndex);
        int right = pobi.get(leftIndex);
        users[POBI_INDEX] = new User(left, right);

        left = crong.get(leftIndex);
        right = crong.get(rightIndex);
        users[CRONG_INDEX] = new User(left, right);

        return users;
    }

    private static int charToInt(char c) {
        return Character.getNumericValue(c);
    }

    private static String intToString(int num) {
        return String.valueOf(num);
    }

    private static class User {
        int left;
        int right;

        public User(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }
}