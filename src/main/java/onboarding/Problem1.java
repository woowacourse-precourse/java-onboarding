package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkArr(pobi) && checkArr(crong)) {
            int pobiMax = getBigNum(pobi);
            int crongMax = getBigNum(crong);

            System.out.println(pobiMax);
            System.out.println(crongMax);
            if (pobiMax > crongMax) {
                answer = 1;
            } else if (crongMax > pobiMax) {
                answer = 2;
            } else {
                answer = 0;
            }
        } else {
            answer = -1;
        }
        return answer;
    }
    public static int getBigNum(List<Integer> p){
        int leftPage = p.get(0);
        int rightPage = p.get(1);
        return Math.max(mathMax(leftPage), mathMax(rightPage));
    }
    public static int mathMax(int pageNum){
        String[] pageArr = String.valueOf(pageNum).split("");
        int add = 0;
        int multi = 1;
        for (String s : pageArr){
            add += Integer.parseInt(s);
            multi *= Integer.parseInt(s);
        }
        return Math.max(add, multi);
    }
/*
    public static void main(String[] args) {
        List<Integer> pobi = Arrays.asList(99, 102);
        List<Integer> crong = Arrays.asList(211, 212);

        System.out.println(solution(pobi, crong));
    }
*/
    public static boolean checkArr(List<Integer> arr) {
        for (Integer a : arr) {
            if (a < 1 || a > 400 || a == 1 || a == 399) {
                return false;
            }
        }
        if (arr.get(1) - arr.get(0) > 1 || arr.get(1) - arr.get(0) < 1){
            return false;
        }
        return true;
    }
}

