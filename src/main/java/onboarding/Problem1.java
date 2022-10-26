package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkError(pobi) || checkError(crong)) {
            return -1;
        }
        return answer;
    }

    public static boolean checkError(List<Integer> inputList) {
        if (inputList.get(0) == null || inputList.get(1) == null || inputList.size() != 2) {
            return true;
        }
        if (inputList.get(0) < 1 || inputList.get(0) > 400 || inputList.get(1) < 1 || inputList.get(1) > 400) {
            return true;
        }
        if (inputList.get(0) % 2 == 0 || inputList.get(1) % 2 == 1) {
            return true;
        }
        if (inputList.get(0) + 1 != inputList.get(1)) {
            return true;
        }
        return false;
    }
}