package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (pobi.get(1) - pobi.get(0) != 1) {
            return -1;
        }
        if (crong.get(1) - crong.get(0) != 1) {
            return -1;
        }

        String pobiLeft = String.valueOf(pobi.get(0));  // 97
        int sum = 0;
        int mul = 1;
        for (int i = 0; i < pobiLeft.length(); ++i) {
            sum += Integer.parseInt(pobiLeft.charAt(i) + "");
            mul *= Integer.parseInt(pobiLeft.charAt(i) + "");
        }
        int maxOfPobi = Math.max(sum, mul);

        String pobiRight = String.valueOf(pobi.get(1));
        sum = 0;
        mul = 1;
        for (int i = 0; i < pobiRight.length(); ++i) {
            sum += Integer.parseInt(pobiRight.charAt(i) + "");
            mul *= Integer.parseInt(pobiRight.charAt(i) + "");
        }
        maxOfPobi = Math.max(maxOfPobi, Math.max(sum, mul));

        String crongLeft = "" + crong.get(0);
        sum = 0;
        mul = 1;
        for (int i = 0; i < crongLeft.length(); ++i) {
            sum += Integer.parseInt(crongLeft.charAt(i) + "");
            mul *= Integer.parseInt(crongLeft.charAt(i) + "");
        }
        int maxOfcrong = Math.max(sum, mul);

        String crongRight = String.valueOf(crong.get(1));
        sum = 0;
        mul = 1;
        for (int i = 0; i < crongRight.length(); ++i) {
            sum += Integer.parseInt(crongRight.charAt(i) + "");
            mul *= Integer.parseInt(crongRight.charAt(i) + "");
        }
        maxOfcrong = Math.max(maxOfcrong, Math.max(sum, mul));

        if (maxOfcrong == maxOfPobi) {
            return 0;
        } else if (maxOfPobi > maxOfcrong) {
            return 1;
        } else {
            return 2;
        }
    }


}