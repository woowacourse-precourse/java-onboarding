package onboarding;

import java.util.List;

class Problem1 {
    public static int Calculator(List<Integer> Array) {
        int Array_Sum =0;
        int Array_multi=1;
        for (Integer data: Array) {
            while (data!=0){
                int TempVal = data%10;
                Array_Sum+=TempVal;
                Array_multi*=TempVal;
                data/=10;
            }
        }
        return Math.max(Array_Sum,Array_multi);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 1) 책 페이지가 정상적인지 체크한다
        if (pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1) {
            return -1;
        // 2) 첫 페이지와 끝 페이지가 나왔는지 확인한다.
        } else if (pobi.contains(1) || pobi.contains(400) ||
                crong.contains(1) || crong.contains(400)) {
            return -1;
        }
        int Pobi_Value = Calculator(pobi);
        int crong_Value = Calculator(crong);

        if (Pobi_Value > crong_Value) answer = 1;
        else if (Pobi_Value < crong_Value) answer= 2;
        else answer = 0;

        return answer;
    }

}