package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

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

