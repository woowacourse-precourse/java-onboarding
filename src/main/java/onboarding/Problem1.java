package onboarding;

import java.util.List;

class Problem1 {

    public static int pageSum(int x){
        int answer = 0;
        while (x != 0){
            answer += x % 10;
            x /= 10;
        }
        return answer;
    }
    public static int pageMultiplication(int x){
        int answer = 1;
        while (x !=0){
            answer *= x % 10;
            x /= 10;
        }
        return answer;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int q = 0;
        int w = 0;
        while (q != 1 && q != 399){
            q = (int)(Math.random() * 100) + 1;
        }
        w = q +1;


        int x = pobi.get(0);
        int y = pobi.get(1);
        int a = crong.get(0);
        int b = crong.get(1);

        int [] pobiMaxNumber = {pageSum(x), pageSum(y), pageMultiplication(x), pageMultiplication(y)};
        int tmp;

        for (int i = 0; i < pobiMaxNumber.length - 1; i++) {
            for (int j = i + 1; j < pobiMaxNumber.length; j++) {
                if (pobiMaxNumber[j] > pobiMaxNumber[i]) {
                    tmp = pobiMaxNumber[j];
                    pobiMaxNumber[j] = pobiMaxNumber[i];
                    pobiMaxNumber[i] = tmp;
                }
            }
        }

        int [] crongMaxNumber = {pageSum(a), pageSum(b), pageMultiplication(a), pageMultiplication(b)};

        tmp = 0;
        for (int i = 0; i < crongMaxNumber.length - 1; i++) {
            for (int j = i + 1; j < crongMaxNumber.length; j++) {
                if (crongMaxNumber[j] > crongMaxNumber[i]) {
                    tmp = crongMaxNumber[j];
                    crongMaxNumber[j] = crongMaxNumber[i];
                    crongMaxNumber[i] = tmp;
                }
            }
        }
        answer = 0;

        if (x+1 != y || a+1 != b){
            answer = -1;
        }else if (pobiMaxNumber[0] > crongMaxNumber[0]){
            answer = 1;
        } else if (pobiMaxNumber[0] < crongMaxNumber[0]) {
            answer = 2;
        }else if (pobiMaxNumber[0] == crongMaxNumber[0]){
            answer = 0;
        }
        return answer;
    }
    }