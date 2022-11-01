package onboarding;

import java.util.List;

class Problem1 {
    //유효한 인자 확인
    public static boolean isVaildInput(List<Integer> list){
        if (list.get(1) - list.get(0) != 1 || (list.get(0) % 2 != 1) || (list.get(1) % 2 != 0) || list.size() != 2)
            return false;
        else if(list.get(0) < 0 || list.get(0) > 400 || list.get(1) < 0 || list.get(1) > 400)
            return false;
        else
            return true;
    }
    //각 페이지의 최대값 만들기
    public static int getMaxValue(List<Integer> list) {
        int leftMax;
        int rightMax;

        leftMax = calculateMax(list.get(0));
        rightMax = calculateMax(list.get(1));
        return (leftMax > rightMax) ? leftMax : rightMax;
    }
    //곱셈과 덧셈의 최대값 비교 후 정하는 함수
    public static int calculateMax(int num) {
        int length = (int) (Math.log10(num) + 1);
        if (length == 1) {
            return (num);
        } else if (length == 2) {
            int sum = (num % 100 / 10) + (num % 10);
            int multi = (num % 100 / 10) * (num % 10);
            return (sum > multi) ? sum : multi;
        } else {
            int sum = (num % 1000 / 100) + (num % 100 / 10) + (num % 10);
            int multi = (num % 1000 / 100) * (num % 100 / 10) * (num % 10);
            return (sum > multi) ? sum : multi;
        }
    }
    //main 함수
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isVaildInput(pobi) || !isVaildInput(crong))
            return -1;
        int pobiMaxvalue = getMaxValue(pobi);
        int crongMaxvalue = getMaxValue(crong);

        if(pobiMaxvalue == crongMaxvalue)
            return 0;
        return (pobiMaxvalue > crongMaxvalue) ? 1 : 2;
    }
}