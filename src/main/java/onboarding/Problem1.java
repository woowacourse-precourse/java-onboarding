package onboarding;

import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(validateCheck(pobi,crong)){
            int pobiMax = findMaxNum(pobi);
            int crongMax = findMaxNum(crong);
            answer = findWinner(pobiMax,crongMax);
        }
        else {
            answer = -1;
        }
        return answer;
    }
    private static boolean validateCheck(List<Integer> pobi, List<Integer> crong){
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);
        if(pobiLeft % 2 == 0 || crongLeft % 2 == 0 ||
        pobiRight % 2 == 1 || crongRight%2==1){
            return false;
        }
        else if((pobiRight - pobiLeft) != 1 || (crongRight - crongLeft)!=1){
            return false;
        }
        else if((pobiLeft<=1 || pobiRight>=400) || (crongLeft<=1 || crongRight>=400)){
            return false;
        }
        else {
            return true;
        }
    }
    private static int findMaxNum(List<Integer> num){
        int result = 0;
        int leftNum = num.get(0);
        int rightNum = num.get(1);

        result = Math.max(findMaxScore(leftNum),findMaxScore(rightNum));
        return result;
    }
    private static int findMaxScore(int num){
        int sum = 0;
        int mul = 1;
        String[] cmp = String.valueOf(num).split("");
        for(String s : cmp){
            sum += Integer.parseInt(s);
            mul *= Integer.parseInt(s);
        }
        return Math.max(sum,mul);
    }
    private static int findWinner(int pobi, int crong){
        if(pobi > crong){
            return 1;
        }
        else if(pobi < crong){
            return 2;
        }
        else if(pobi == crong){
            return 0;
        }
        else{
            return -1;
        }
    }

}