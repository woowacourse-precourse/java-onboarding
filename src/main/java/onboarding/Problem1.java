package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        pobi = new ArrayList<>(pobi);
        crong = new ArrayList<>(crong);
//        /수정가능을 위한 재선언/
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            System.out.println("페이지조건 통과x -1리턴");
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        int sumLeftPobi = 0;
        int sumRightPobi = 0;
        int sumLeftCrong = 0;
        int sumRightCrong = 0;
        int mulLeftPobi = 1;
        int mulRightPobi = 1;
        int mulLeftCrong = 1;
        int mulRightCrong = 1;

        do{
            mulLeftPobi *= pobi.get(0)%10;
            sumLeftPobi += pobi.get(0)%10;
            pobi.set(0,pobi.get(0)/10);
        }while (pobi.get(0)>0);
// Pobi의 왼쪽페이지의 합 및 곱을 계산
        do{
            mulRightPobi *= pobi.get(1)%10;
            sumRightPobi += pobi.get(1)%10;
            pobi.set(1,pobi.get(1)/10);
        }while (pobi.get(1)>0);
// Pobi의 오른쪽페이지의 합 및 곱을 계산
        do{
            mulLeftCrong *= crong.get(0)%10;
            sumLeftCrong += crong.get(0)%10;
            crong.set(0,crong.get(0)/10);
        }while (crong.get(0)>0);
// Crong의 왼쪽페이지의 합 및 곱을 계산
        do{
            mulRightCrong *= crong.get(1)%10;
            sumRightCrong += crong.get(1)%10;
            crong.set(1,crong.get(1)/10);
        }while (crong.get(1)>0);
// Crong의 오른쪽페이지의 합 및 곱을 계산
        int pobiScore = sumLeftPobi;
        if(sumRightPobi > pobiScore) pobiScore = sumRightPobi;
        if(mulLeftPobi > pobiScore) pobiScore = mulLeftPobi;
        if(mulRightPobi > pobiScore) pobiScore = mulRightPobi;
// Pobi의 모든 값 중 최대값을 pobiScore에 점수로 할당
        int crongScore = sumLeftCrong;
        if(sumRightCrong > crongScore) crongScore = sumRightCrong;
        if(mulLeftCrong > crongScore) crongScore = mulLeftCrong;
        if(mulRightCrong > crongScore) crongScore = mulRightCrong;
// Crong의 모든 값 중 최대값을 crongScore에 점수로 할당
        if(pobiScore>crongScore){answer = 1;}
        else if(pobiScore<crongScore){answer = 2;}
        else {answer = 0;}
        ;
// Pobi의 점수가 더 높으면 1,Crong의 점수가 더 높으면2, 같은값일땐 0을 answer에 할당
        System.out.println(sumLeftPobi +","+ sumRightPobi +","+ sumLeftCrong +","+ sumRightCrong);
        System.out.println(mulLeftPobi +","+ mulRightPobi +","+ mulLeftCrong +","+ mulRightCrong);

        return answer;
    }
}