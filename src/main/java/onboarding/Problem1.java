package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        String pobiOdd = pobi.get(0).toString();
        String pobiEven = pobi.get(1).toString();
        String crongOdd = crong.get(0).toString();
        String crongEven = crong.get(1).toString();

        int pobiMax=-1;
        int crongMax=-1;
        int[] pobiMaxList= {0,0,1,1}; //각각 홀수 덧셈, 짝수 덧셈, 홀수 곱셈, 짝수 곱셈
        int[] crongMaxList= {0,0,1,1};
        boolean error = false;

        //페이지가 범위를 벗어날 경우, 홀수와 짝수가 바뀌었을 경우, 연속되지 않을 경우 에러
        if (pobi.get(0)%2==0||pobi.get(1)%2==1||crong.get(0)%2==0||crong.get(1)%2==1) {
            error=true;
        }
        if (pobi.get(0)+1!=pobi.get(1)||crong.get(0)+1!=crong.get(1)) {
            error=true;
        }
        if (pobi.get(0)<1||pobi.get(0)>400||pobi.get(1)<0||pobi.get(1)>400||crong.get(0)<1||crong.get(0)>400||crong.get(1)<1||crong.get(1)>400) {
            error = true;
        }

        for (int i=0; i<pobiOdd.length(); i++) {
            pobiMaxList[0]+= (int) Character.getNumericValue(pobiOdd.charAt(i));
            pobiMaxList[2] *= (int) Character.getNumericValue(pobiOdd.charAt(i));
        }

        for (int i=0; i<pobiEven.length(); i++) {
            pobiMaxList[1] += (int) Character.getNumericValue(pobiEven.charAt(i));
            pobiMaxList[3] *= (int) Character.getNumericValue(pobiEven.charAt(i));
        }

        for (int i=0; i<crongOdd.length(); i++) {
            crongMaxList[0] += (int) Character.getNumericValue(crongOdd.charAt(i));
            crongMaxList[2] *= (int) Character.getNumericValue(crongOdd.charAt(i));
        }

        for (int i=0; i<crongEven.length(); i++) {
            crongMaxList[1] += (int) Character.getNumericValue(crongEven.charAt(i));
            crongMaxList[3] *= (int) Character.getNumericValue(crongEven.charAt(i));
        }

        for (int i=0; i<4; i++) {
            if (pobiMax<pobiMaxList[i]) {
                pobiMax=pobiMaxList[i];
            }
        }

        for (int i=0; i<4; i++) {
            if (crongMax<crongMaxList[i]) {
                crongMax=crongMaxList[i];
            }
        }

        if (error) {
            answer=-1;
        } else if (pobiMax>crongMax) {
            answer=1;
        } else if (pobiMax<crongMax) {
            answer=2;
        } else if (pobiMax==crongMax) {
            answer=0;
        }
    }
}
        return answer;
    }
}