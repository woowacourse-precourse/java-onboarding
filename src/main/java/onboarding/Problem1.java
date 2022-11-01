package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer;
//      포비에 관한 변수 설정
        int pobiLsum = 0;
        int pobiLmul = 1;
        int pobiLnum = pobi.get(0);
        int pobiRsum = 0;
        int pobiRmul = 1;
        int pobiRnum = pobi.get(1);
//      포비의 좌측페이지 각 자리수 합과 곱의 최대값 구하기
        while(pobiLnum!=0){
            pobiLsum += pobiLnum%10;
            pobiLmul *= pobiLnum%10;
            pobiLnum /= 10;
        }
        int pobiLmax = Math.max(pobiLmul, pobiLsum);
//      포비의 우측페이지 각 자리수 합과 곱의 최대값 구하기
        while(pobiRnum!=0){
            pobiRsum += pobiRnum%10;
            pobiRmul *= pobiRnum%10;
            pobiRnum /= 10;
        }
        int pobiRmax = Math.max(pobiRmul, pobiRsum);
//      포비의 결과값
        int pobimax = Math.max(pobiLmax, pobiRmax);

//      크롱에 대한 변수 설정
        int crongLsum = 0;
        int crongLmul = 1;
        int crongLnum = crong.get(0);
        int crongRsum = 0;
        int crongRmul = 1;
        int crongRnum = crong.get(1);
//      크롱의 좌측페이지 각 자리수 합과 곱의 최대값 구하기
        while(crongLnum!=0){
            crongLsum += crongLnum%10;
            crongLmul *= crongLnum%10;
            crongLnum /= 10;
        }
        int crongLmax = Math.max(crongLmul, crongLsum);
//      크롱의 우측페이지 각 자리수 합과 곱의 최대값 구하기
        while(crongRnum!=0){
            crongRsum += crongRnum%10;
            crongRmul *= crongRnum%10;
            crongRnum /= 10;
        }
        int crongRmax = Math.max(crongRmul, crongRsum);
//      크롱의 결과값
        int crongmax = Math.max(crongLmax, crongRmax);

//      포비와 크롱의 수 비교 결과
        if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1){
            answer = -1;
        }else if(pobimax > crongmax){
            answer = 1;
        }else if(pobimax < crongmax){
            answer = 2;
        }else {
            answer = 0;
        }
        return answer;
    }
}