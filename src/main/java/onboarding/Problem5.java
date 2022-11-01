package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] cntArr = new int[9];
        int []moneyArr = new int[9];

        for (int i=0; i<cntArr.length; i++){
            cntArr[i] =0;
            moneyArr[i] =0;
        }
        //System.out.println(Arrays.toString(cntArr)+'\n'+Arrays.toString(moneyArr));

        String tmp = Integer.toString((money));
        // int []moneyArr = new int[tmp.length()];
        int indexMoneyArr = moneyArr.length-1;
        for (int i= tmp.length()-1; i>=0; i--)
            moneyArr[indexMoneyArr--] = tmp.charAt(i) -'0';

        //   System.out.println(Arrays.toString(moneyArr));

        int indexOfCntArr = cntArr.length-2; // 일원 동전 제외
        // System.out.println(indexOfCntArr);

        cntArr[cntArr.length-1] = moneyArr[moneyArr.length-1];
        for (int i=moneyArr.length-2; i>2; i--){
            //  System.out.println("indexOfCntArr= " + indexOfCntArr+'\n'+"i= "+i);
            if(i>3) {
                if (moneyArr[i] < 5)
                    cntArr[indexOfCntArr] = moneyArr[i];
                else {
                    cntArr[indexOfCntArr] = moneyArr[i] - 5;
                    cntArr[indexOfCntArr - 1]++;
                }
                if(indexOfCntArr!=1)
                    indexOfCntArr-=2;
            }
            else{ //만원권 오만원권으로만 계산가능, indexOfCntArr는 만원 단위에 멈춰있음
                cntArr[indexOfCntArr - 1] += moneyArr[i]*2;
            }
        }
        cntArr[indexOfCntArr - 1] += moneyArr[2]*20;

        // System.out.println(Arrays.toString(moneyArr));
        //System.out.println(Arrays.toString(cntArr));
        List<Integer> result1 = Arrays.stream(cntArr).boxed().collect(Collectors.toList());
        answer = IntStream.of(cntArr).boxed().collect(Collectors.toList());

        return answer;
    }
}
