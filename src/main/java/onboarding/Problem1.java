package onboarding;

import java.util.List;

class Problem1 {

    private static final int SIZE = 2;
    private static final int POBI = 0;
    private static final int CRONG = 1;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int[] scores = new int[SIZE];

        User[] users = inItUsers(pobi, crong);

        int result = compareToScores(users);

        answer = (answer == result) ? EXCEPTION : result;

        return answer;
    }

    private static int compareToScores(User[] users) {

        int draw = 0;
        int pobiWin = 1;
        int crongWin = 2;

        int pobiScore = users[POBI].getScore();
        int crongScore = users[CRONG].getScore();

        if (users[POBI].isException() || users[CRONG].isException()) {
            return Integer.MAX_VALUE;
        }

        if (pobiScore > crongScore) {
            return pobiWin;
        } else if (pobiScore < crongScore) {
            return crongWin;
        }

        return draw;
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
        int right = pobi.get(rightIndex);
        users[POBI] = new User(left, right);

        left = crong.get(leftIndex);
        right = crong.get(rightIndex);
        users[CRONG] = new User(left, right);

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
        int score;

        public User(int left, int right) {
            this.left = left;
            this.right = right;
        }

        private boolean isException() {
            int maxPage = 400;

            if (right - left > 1 || left % 2 == 0 || right % 2 == 1 || right > maxPage || left > right) {
                return true;
            }

            return false;
        }

        private int getScore() {
            int plusScore = getMaxPlus();
            int multipleScore = getMaxMultiple();

            score = plusScore > multipleScore ? plusScore : multipleScore;
            return score;
        }

        private int getMaxPlus() {
            int leftScore = plus(left);
            int rightScore = plus(right);

            return leftScore > rightScore ? leftScore : rightScore;
        }

        private int getMaxMultiple() {
            int leftScore = multiple(left);
            int rightScore = multiple(right);

            return leftScore > rightScore ? leftScore : rightScore;
        }
    }
}