package onboarding;

import java.util.List;

class Problem1 {

    static int min = 1;
    static int max = 399;
    static int x = (int) (Math.random() * (max - min) + min);
    static int y = x + 1;

    static int a = (int) (Math.random() * (max - min) + min);
    static int b = a + 1;
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
        pobi.add(x);
        pobi.add(y);
        crong.add(a);
        crong.add(b);

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
        if (pobiMaxNumber[0] > crongMaxNumber[0]){
            answer = 1;
        } else if (pobiMaxNumber[0] < crongMaxNumber[0]){
            answer = 2;
        }else{
            answer = -1;
        }
        return answer;
    }
    }