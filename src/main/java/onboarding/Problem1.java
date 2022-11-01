package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static int Max;
    static ArrayList<Integer> arrNum;

    public static ArrayList<Integer> division(int x){
        arrNum = new ArrayList<>();
        int temp = x;
        while(temp>0){
            arrNum.add(temp % 10);
            temp /= 10;
        }
        return arrNum;
    }
    public static int findMax(ArrayList<Integer> arrNum){
        Max = 0;
        // 1) 곱하기
        int mul = 1;
        for(int j=0; j<arrNum.size(); j++){
            mul *= arrNum.get(j);
        }
        // 2) 더하기
        int plus = 0;
        for(int j=0; j<arrNum.size(); j++){
            plus += arrNum.get(j);
        }
        if(mul > Max) Max = mul;
        if(plus > Max) Max = plus;
        return Max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 예외
        if(pobi.get(0)+1 == pobi.get(1)) return answer = -1;
        if(pobi.get(0)+1 != pobi.get(1)) return answer = -1;
        if(pobi.get(1)-1 != pobi.get(1)) return answer = -1;
        if(crong.get(0)+1 == crong.get(1)) return answer = -1;
        if(crong.get(0)+1 != crong.get(1)) return answer = -1;
        if(crong.get(1)-1 != crong.get(1)) return answer = -1;

        int pobiMax = 0;
        for(int i=0; i<pobi.size(); i++){
            arrNum = division(pobi.get(i));
            pobiMax = findMax(arrNum);
        }

        int congMax = 0;
        for(int i=0; i<crong.size(); i++){
            arrNum = division(crong.get(i));
            congMax = findMax(arrNum);
        }

        if(pobiMax > congMax) answer = 1;
        else if(pobiMax < congMax) answer = 2;
        else if(pobiMax == congMax) answer = 0;
        return answer;
    }
}