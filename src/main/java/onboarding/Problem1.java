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

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        int pobiResult = getMax(pobi);
        int crongResult = getMax(crong);
        
        answer = compare(pobiResult, crongResult);

        return answer;
    }
}