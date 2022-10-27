package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getMaxDataByOnePage(String page) {

        int pageLength = page.length();

        int rightAdd = 0;
        int rightMultiply = 1;
        for (int i = 0; i < pageLength; i++) {
            int number = Integer.parseInt(page.charAt(i) + "");
            rightAdd += number;
            rightMultiply *= number;
        }

        return Math.max(rightAdd, rightMultiply);
    }

    private static boolean checkException(List<Integer> list) {
        if (list.get(0) + 1 != list.get(1)) {
            return false;
        }
        if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0) {
            return false;
        }
        if (list.size() != 2) {
            return false;
        }
        return true;
    }


}