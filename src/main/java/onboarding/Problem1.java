package onboarding;

import java.util.List;

class Problem1 {

    private static final int SIZE = 2;
    private static final int POBI_INDEX = 0;
    private static final int CRONG_INDEX = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int[] scores = new int[SIZE];

        User[] users = inItUsers(pobi, crong);

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