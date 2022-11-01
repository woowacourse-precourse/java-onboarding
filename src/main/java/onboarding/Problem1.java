package onboarding;

import java.util.List;

class Problem1 {
    static int sumStringToInteger(String n1){
        int n = 0;
        for(int i=0; i<n1.length(); i++){
            n += n1.charAt(i) - '0';
        }
        return n;
    }
    static int mulStringToInteger(String n1){
        int n = 1;
        for(int i=0; i<n1.length(); i++){
            n *= n1.charAt(i) - '0';
        }
        return n;
    }
    static int compareNumber(int n1, int n2){
        return (n1 > n2) ? n1 : n2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0) != pobi.get(1) -1 || crong.get(0) != crong.get(1)-1){
            return -1;
        }
        else if(pobi.get(0) == 1 || crong.get(0) == 399){
            return -1;
        }
        String pobiNum1 = String.valueOf(pobi.get(0));
        String pobiNum2 = String.valueOf(pobi.get(1));

        String crongNum1 = String.valueOf(crong.get(0));
        String crongNum2 = String.valueOf(crong.get(1));

        int BigSumNumPobi = compareNumber(sumStringToInteger(pobiNum1),sumStringToInteger(pobiNum2));
        int BigMulNumPobi = compareNumber(mulStringToInteger(pobiNum1),mulStringToInteger(pobiNum2));
        int BigNumPobi = compareNumber(BigMulNumPobi,BigSumNumPobi);

        int BigSumNumCrong = compareNumber(sumStringToInteger(crongNum1),sumStringToInteger(crongNum2));
        int BigMulNumCrong = compareNumber(mulStringToInteger(crongNum1),mulStringToInteger(crongNum2));
        int BigNumCrong = compareNumber(BigMulNumCrong,BigSumNumCrong);

        if(BigNumPobi > BigNumCrong){
            //return 1;
            answer = 1;
        }
        else if(BigNumPobi < BigNumCrong){
            //return 2;
            answer = 2;
        }
        else{
            //return 0;
            answer = 0;
        }

        return answer;
    }
}