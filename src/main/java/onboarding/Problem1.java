package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validationCheck(pobi, crong)) {
            int pobi_max = getMaxValue(pobi);
            int crong_max = getMaxValue(crong);
            int answer = Integer.MAX_VALUE;
            return answer;
        }
        return -1;
    }

    public static boolean validationCheck(List<Integer> user_1, List<Integer> user_2) {
        if (user_1.contains(1) || user_1.contains(400) ||
                user_2.contains(1) || user_2.contains(400)) {
            return false;
        } else if (user_1.get(0) < 1 || user_1.get(1) > 400 ||
                user_2.get(0) < 1 || user_2.get(1) > 400) {
            return false;
        } else if (user_1.get(1) != user_1.get(0) + 1 ||
                user_2.get(1) != user_2.get(0) + 1) {
            return false;
        } else if (user_1.get(0) % 2 != 1 ||
                user_2.get(0) % 2 != 1) {
            return false;
        } else if (user_1.size() != 2 || user_2.size() != 2) {
            return false;
        }
        return true;
    }

    public static int getMaxValue(List<Integer> user) {
        String left = Integer.toString(user.get(0));
        String right = Integer.toString(user.get(1));
        int biggest = -1;
        int[] temp = {0, 1, 0, 1};
        for (int i = 0; i < left.length(); i++) {
            temp[0] += (left.charAt(i) - '0');
            temp[1] *= (left.charAt(i) - '0');
        }
        for (int i = 0; i < right.length(); i++) {
            temp[2] += (right.charAt(i) - '0');
            temp[3] *= (right.charAt(i) - '0');
        }

        for (int elem : temp) {
            if (elem > biggest) {
                biggest = elem;
            }
        }
        return biggest;
    }
    public static int getWinner(int user_1, int user_2) {
        if (user_1 > user_2) {
            return 1;
        }
        else if (user_1 < user_2) {
            return 2;
        }
        return 0;
    }
}