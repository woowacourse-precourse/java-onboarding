package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        return answer;
    }

   static int sum(List<Integer> value) {
        int value1 = 0; // 0의 값
        int value2 = 0; // 1의 값
        int value1tmp = value.get(0);
        int value2tmp = value.get(1);

        int tmp = 0; // 중간 저장


        for (int i=0;i<(int)(Math.log10(value.get(0))+1);i++) {
            value1 += value1tmp%10;
            value1tmp /= 10;
        }

        for (int i=0;i<(int)(Math.log10(value.get(0))+1);i++) {
            value2+= value2tmp%10;
            value2tmp /= 10;
        }

        return maxScore(value1, value2); // a or b 큰 수
    }

    static int multi(List<Integer> value){

        int value1 = 1;
        int value2 = 1;
        int value1tmp = value.get(0);
        int value2tmp = value.get(1);

        int tmp = 0; // 중간 저장


        for (int i=0;i<(int)(Math.log10(value.get(0))+1);i++) {
            value1 *= value1tmp%10;
            value1tmp /= 10;
        }

        for (int i=0;i<(int)(Math.log10(value.get(0))+1);i++) {
            value2 *= value2tmp%10;
            value2tmp /= 10;
        }
        return maxScore(value1,value2);
    }

    static int maxScore(int a, int b){
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

}


