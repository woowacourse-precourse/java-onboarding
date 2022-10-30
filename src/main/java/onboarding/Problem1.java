package onboarding;

import java.util.List;

class Problem1 {
    public static int Calculator(List<Integer> Array) {
        int Array_Sum =0;
        int Array_multi=1;
        // 10의 자리를 나머지로 추출하여 덧셈과 곱셈 진행
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
        // 체크해야 할점
        // 1 : 좌우페이지가 정상적인지 확인
        // 2 : 첫페이지,끝페이지 아닌지 확인

        int answer = Integer.MAX_VALUE;
        // 1) 책 페이지가 정상적인지 체크한다
        if (pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1) {
            return -1;
        // 2) 첫 페이지와 끝 페이지가 나왔는지 확인한다.
        } else if (pobi.contains(1) || pobi.contains(400) ||
                crong.contains(1) || crong.contains(400)) {
            return -1;
        }
        // 3) 덧셈과 곱셈 중 가장 큰값 가져오기
        int Pobi_Value = Calculator(pobi);
        int crong_Value = Calculator(crong);


        // 4) answer에 값 지정하고 리턴
        if (Pobi_Value > crong_Value) answer = 1;
        else if (Pobi_Value < crong_Value) answer= 2;
        else answer = 0;

        return answer;
    }

}