package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);


        return answer;
    }

    public static int plus(int page) {

        int plusResult = 0;

        String pageString = Integer.toString(page);
        String[] stringArray = pageString.split("");

        for(int i = 0; i < stringArray.length; i++) {
            plusResult += Integer.parseInt(stringArray[i]);
        }

        return plusResult;
    }

}