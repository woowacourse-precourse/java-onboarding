package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    /* checkOddEven: 왼쪽 페이지인 경우 홀수인지, 오른쪽 페이지인 경우 짝수인지 확인하는 함수 */
    //맞으면 1, 틀리면 0 리턴
    public static int checkOddEven(int index, int num){
        if(index==0) {
            if (num % 2 == 1) return 1;
        } else if (index==1) {
            if (num%2==0) return 1;
        }
        return 0;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobi_re  = new ArrayList<Integer>();
        List<Integer> crong_re  = new ArrayList<Integer>();

        //왼쪽 페이지가 오른쪽 페이지보다 1작은지 확인
        if(pobi.get(0)+1 != pobi.get((1))) return -1;
        if(crong.get(0)+1 != crong.get((1))) return -1;

        for(int i=0; i<2; i++){
            // 각 페이지가 시작면과 마지막 면인지, 왼쪽 페이지인 경우 홀수인지, 오른쪽 페이지인 경우 오른쪽인지 확인. 조건 하나라도 아니라면 예외사항으로 간주
            if((pobi.get(i) == 1) | (pobi.get(i) == 400) | (crong.get(i) == 1) | (crong.get(i) == 400) | (checkOddEven(i, pobi.get(i))!=1)| (checkOddEven(i, crong.get(i))!=1)){
                return -1;
            }
        }

        return answer;
    }
}
