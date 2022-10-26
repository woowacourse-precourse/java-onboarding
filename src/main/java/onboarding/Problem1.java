package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // Exception | Check Page Condition
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1)
            return -1;

        int pobiPlusMax = Math.max(plusPerSite(pobi.get(0)), plusPerSite(pobi.get(1)));
        int pobiMulMax = Math.max(multiplePerSite(pobi.get(0)), multiplePerSite(pobi.get(1)));
        int pobiMax = Math.max(pobiPlusMax, pobiMulMax);

        int crongPlusMax = Math.max(plusPerSite(crong.get(0)), plusPerSite(crong.get(1)));
        int crongMulMax = Math.max(multiplePerSite(crong.get(0)), multiplePerSite(crong.get(1)));
        int cronMax = Math.max(crongPlusMax, crongMulMax);

        if(pobiMax > cronMax) answer = 1;
        else if(pobiMax < cronMax) answer = 2;
        else answer = 0;

        return answer;
    }

    private static int plusPerSite(int input){
        String strInput = Integer.toString(input);
        int result = 0;

        for(String str: strInput.split("")) {
            result += Integer.parseInt(str);
        }
        return result;
    }

    private static int multiplePerSite(int input){
        String strInput = Integer.toString(input);
        int result = 1;

        for(String str: strInput.split("")){
            result *= Integer.parseInt(str);
        }
        return result;
    }

}