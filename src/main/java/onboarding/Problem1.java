package onboarding;

import java.util.List;

class Problem1 {
    static boolean isValid(List<Integer> pobi, List<Integer> crong){
        List<Integer> firstPage = List.of(1, 2);
        List<Integer> lastPage = List.of(399, 400);

        if(pobi.size() != 2 || crong.size() != 2) return false;
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return false;
        if(pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) return false;
        if(pobi.equals(firstPage) || pobi.equals(lastPage) || crong.equals(firstPage) || crong.equals(lastPage)) return false;
        return true;
    }
    static int maxNum(int num) {
        int sum=0;
        int mul=1;

        while(num > 0){
            int tmp = num % 10;
            sum += tmp;
            mul *= tmp;
            num /= 10;
        }
        return Math.max(sum, mul);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValid(pobi, crong)) return -1;
        int pobiLeft = maxNum(pobi.get(0));
        int pobiRight = maxNum(pobi.get(1));
        int crongLeft = maxNum(crong.get(0));
        int crongRight = maxNum(crong.get(1));

        int pobiMaxNum = Math.max(pobiLeft, pobiRight);
        int crongMaxNum = Math.max(crongLeft, crongRight);

        if(pobiMaxNum > crongMaxNum) return 1;
        else if (pobiMaxNum < crongMaxNum) return 2;
        else return 0;
    }
}