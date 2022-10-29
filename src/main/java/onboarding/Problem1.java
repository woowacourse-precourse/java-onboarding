package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int pMax=0, cMax=0;
        // 예외 처리
        if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1) {
            return answer;
        }

        for(int i=0;i<2;i++) {
            // 각 자리 숫자 합, 곱 구하기
            int num1 = pobi.get(i);
            int num2 = crong.get(i);

            //각 자리 숫자들을 저장하는 리스트
            List<Integer> pobiNum = new ArrayList<>();
            List<Integer> crongNum = new ArrayList<>();
            while(num1!=0) {
                pobiNum.add(num1%10);
                num1/=10;
            }
            while(num2!=0) {
                crongNum.add(num2%10);
                num2/=10;
            }

            int pobiSum = sum(pobiNum);
            int pobiMul = multiple(pobiNum);
            int crongSum = sum(crongNum);
            int crongMul = multiple(crongNum);

            if(pobiSum>pMax) {
                pMax = pobiSum;
            }
            if(pobiMul>pMax) {
                pMax = pobiMul;
            }
            if(crongSum>cMax) {
                cMax = crongSum;
            }
            if(crongMul>cMax) {
                cMax = crongMul;
            }
        }

        if(pMax==cMax) {
            answer = 0;
        } else if(pMax>cMax) {
            answer = 1;
        } else if(pMax<cMax){
            answer = 2;
        }

        return answer;
    }

    private static int sum(List<Integer> list) {
        int result = 0;
        for(int num : list) {
            result += num;
        }
        return result;
    }

    private static int multiple(List<Integer> list) {
        int result = 1;
        for(int num : list) {
            result *= num;
        }
        return result;
    }
}