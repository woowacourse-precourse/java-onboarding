package onboarding;

import java.util.List;

/*기능 요구 사항*/
/* 1. 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이다.
*  2. 페이지 번호의 각 숫자를 모두 더하거나 모두 곱해 큰 수를 구한다
*  3. 가장 큰 수를 본인의 점수로 하고, 점수를 비교해 높은 사람이 승자가 된다.
*  4. 시작 면(1)이나 마지막 면(400)이 나오도록 책을 펼치지 않는다.
*  5. 포비가 이기면 1, 크롱이 이기면 2, 무승부는 0
*  6. 예외 사항은 -1로 retrun 한다. */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /*예외 사항
        * 1. (4) 시작면이나 마지막 면이 나오도록 책을 펼치지 않는다.
        * 2. 왼쪽 페이지, 오른쪽 페이지 번호 순서대로 들어가 있다.
        * 3. 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이다.*/
        if(pobi.get(0) <= 1 || pobi.get(1) >=400 || crong.get(0) <= 1 || crong.get(1) >=400) return -1;
        if(pobi.get(0) != pobi.get(1)-1 || crong.get(0) !=crong.get(1) -1) return -1;
        if(pobi.get(0)%2 == 0 || pobi.get(1)%2 ==1 || crong.get(0)%2 == 0 || crong.get(1)%2 ==1) return -1;

        /*포비의 점수 구하기*/
        int pobiScore = 0;
        for(int i=0; i<2; i++){
            int add = pobi.get(i)%10;
            int mul = pobi.get(i)%10;
            int c=1;
            do{
                add += (pobi.get(i)/(int)Math.pow(10,c))%10;
                mul *= (pobi.get(i)/(int)Math.pow(10,c))%10;
            }while(pobi.get(i)/(int)Math.pow(10,++c)> 0);
            if(add > pobiScore) pobiScore = add;
            if(mul > pobiScore) pobiScore = mul;
        }

        /*크롱의 점수 구하기*/
        int crongScore = 0;

        for(int i=0; i<2; i++){
            int add = crong.get(i)%10;
            int mul = crong.get(i)%10;
            int c=1;
            do{
                add += (crong.get(i)/(int)Math.pow(10,c))%10;
                mul *= (crong.get(i)/(int)Math.pow(10,c))%10;
            }while(crong.get(i)/(int)Math.pow(10,++c) >0);

            if(add > crongScore) crongScore = add;
            if(mul > crongScore) crongScore = mul;
        }

        if(pobiScore==crongScore) answer =0;
        else if(pobiScore>crongScore) answer = 1;
        else answer = 2;

        return answer;
    }
}