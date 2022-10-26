package onboarding;

import java.util.List;

class Problem1 {
    public static int getMax(List<Integer> listIn) {
        int[] temp = new int[2];
        String pageStr;
        int output = 0;

        for (int i = 0; i < 2; i++) {
            pageStr = Integer.toString(listIn.get(i));
            temp[0] = 1;
            for (int j = 0; j < pageStr.length(); j++) {
                temp[0] *= (pageStr.charAt(j) - '0');
                temp[1] += (pageStr.charAt(j) - '0');
            }
            output = Math.max(output, Math.max(temp[0], temp[1]));
        }
        return output;
    }

    public static int compare(int pobiResult, int crongResult) {
        if (pobiResult > crongResult) return 1;
        else if (pobiResult < crongResult) return 2;
        else return 0;
    }

    public static boolean lengthCheck(List<Integer> listIn) {
        return listIn.size() != 2;
    }

    public static boolean indexCheck(List<Integer> listIn) {
        int firNum = listIn.get(0);
        int secNum = listIn.get(1);

        if (firNum >= secNum) return true;
        if ((firNum % 2) != 1 && (secNum % 2) != 0) return true;
        if ((secNum - firNum) != 1) return true;
        if (firNum <= 0 || secNum > 400) return true;

        return false;
    }

    public static boolean exceptionCheck(List<Integer> pobi, List<Integer> crong) {
        if (lengthCheck(pobi) || lengthCheck(crong) || indexCheck(pobi) || indexCheck(crong)) return true;
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exceptionCheck(pobi, crong)) return -1;

        int pobiResult = getMax(pobi);
        int crongResult = getMax(crong);

        return compare(pobiResult, crongResult);
    }
}