package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        pobi = new ArrayList<>(pobi);
        crong = new ArrayList<>(crong);

        if (pobi.get(1) - pobi.get(0) !=1 || crong.get(1) -crong.get(0) != 1){
            return -1;
        }
        int answer;
        int sumLeftPobi = 0;
        int sumRightPobi = 0;
        int sumLeftCrong = 0;
        int sumRightCrong = 0;
        int mulLeftPobi = 1;
        int mulRightPobi = 1;
        int mulLeftCrong = 1;
        int mulRightCrong = 1;
        do{
            mulLeftPobi *= pobi.get(0) % 10;
            sumLeftPobi += pobi.get(0) % 10;
            pobi.set(0,pobi.get(0) / 10);
        }while (pobi.get(0) > 0);

        do{
            mulRightPobi *= pobi.get(1) % 10;
            sumRightPobi += pobi.get(1) % 10;
            pobi.set(1, pobi.get(1) / 10);
        }while (pobi.get(1) > 0);

        do{
            mulLeftCrong *= crong.get(0) % 10;
            sumLeftCrong += crong.get(0) % 10;
            crong.set(0, crong.get(0) / 10);
        }while (crong.get(0) > 0);

        do{
            mulRightCrong *= crong.get(1) % 10;
            sumRightCrong += crong.get(1) % 10;
            crong.set(1,crong.get(1) / 10);
        }while (crong.get(1) > 0);

        int pobiScore = sumLeftPobi;
        if(sumRightPobi > pobiScore) pobiScore = sumRightPobi;
        if(mulLeftPobi > pobiScore) pobiScore = mulLeftPobi;
        if(mulRightPobi > pobiScore) pobiScore = mulRightPobi;

        int crongScore = sumLeftCrong;
        if(sumRightCrong > crongScore) crongScore = sumRightCrong;
        if(mulLeftCrong > crongScore) crongScore = mulLeftCrong;
        if(mulRightCrong > crongScore) crongScore = mulRightCrong;

        if(pobiScore>crongScore){answer = 1;}
        else if(pobiScore<crongScore){answer = 2;}
        else {answer = 0;}

        return answer;
    }
}
