package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!checkException(pobi) || !checkException(crong)) {
            return -1;
        }

        int pobiMaxData = getUserMaxData(pobi);
        int crongMaxData = getUserMaxData(crong);


        if (pobiMaxData > crongMaxData) {
            return 1;
        } else if (pobiMaxData < crongMaxData) {
            return 2;
        } else {
            return 0;
        }
    }

    private static int getUserMaxData(List<Integer> user) {
        int leftMaxData = getMaxDataByOnePage(user.get(0).toString());
        int rightMaxData = getMaxDataByOnePage(user.get(1).toString());

        return Math.max(leftMaxData, rightMaxData);
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
        if (list.get(0) < 1 || list.get(0) > 400 || list.get(1) < 1 || list.get(1) > 400) {
            return false;
        }
        if (list.get(0) == 1 || list.get(1) == 400) {
            return false;
        }
        return true;
    }


}