package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 1;
        int maxNum = 0;
        int num;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int addSum = 0;
                int mulSum = 1;
                if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) {
                    answer = -1;
                }
                num = getNum(pobi, crong, i, j);
                addSum = getAddSum(addSum, num);
                mulSum = getMulSum(mulSum, num);
                maxNum = getMaxNum(maxNum, i, addSum, mulSum);
                answer = getAnswer(answer, maxNum, i, addSum, mulSum);
            }
        }
        return answer;
    }
    private static int getNum(List<Integer> pobi, List<Integer> crong, int i, int j) {
        int num;
        if(i == 0){
            num = pobi.get(j);
        }else{
            num = crong.get(j);
        }
        return num;
    }
}