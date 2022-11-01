package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int p0 = pobi.get(0);
        int p1 = pobi.get(1);
        int c0 = crong.get(0);
        int c1 = crong.get(1);

        //페이지가 연속된 번호가 아닌경우, 주어진 조건에 맞지 않는 경우
        if(p0 + 1 != p1 || c0 +1 != c1 || p0<1 || c0<1 || p1>400 || c1>400)
            return -1;
        //페이지가 왼쪽 오른쪽이 정확하지 않은경우
        if(p0 %2 ==0 || p1 %2 ==1 || c0 %2 ==0 || c1 %2 ==1)
            return -1;
        int ppl0 =0, pmul0 =1, ppl1=0, pmul1=1,
                cpl0 =0, cmul0 =1, cpl1=0, cmul1=1;
        int pmax =0, cmax =0;

        // Pobi의 최대값 구하기
        while(p0!=0){
            ppl0 += p0 %10;
            pmul0 *= p0 %10;
            p0 /= 10;
        }
        pmax = Math.max(ppl0,pmul0);
        while(p1!=0){
            ppl1 += p1 %10;
            pmul1 *= p1 %10;
            p1 /= 10;
        }
        pmax = Math.max(pmax, ppl1);
        pmax = Math.max(pmax, pmul1);

        // Crong의 최대값 구하기
        while(c0!=0){
            cpl0 += c0 %10;
            cmul0 *= c0 %10;
            c0 /= 10;
        }
        cmax = Math.max(cpl0, cmul0);
        while(c1!=0){
            cpl1 += c1 %10;
            cmul1 *= c1 %10;
            c1 /= 10;
        }
        cmax = Math.max(cmax, cpl1);
        cmax = Math.max(cmax, cmul1);

        // 게임의 결과 확인
        if(pmax > cmax) answer = 1;
        else if(cmax > pmax) answer = 2;
        else answer = 0;

        return answer;
    }
}