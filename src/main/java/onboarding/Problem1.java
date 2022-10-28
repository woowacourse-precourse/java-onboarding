package onboarding;

import java.util.List;

class Problem1 {


//    2. Solution에서 한 사람의 페이지 번호를 받는 메서드
    public static int someone(List<Integer> bookNum) {
//      페이지List 받아서 String으로 쪼갬
        String[] leftpage = Integer.toString(bookNum.get(0)).split("");
        String[] rightpage = Integer.toString(bookNum.get(1)).split("");

//        int bookMax = Math.max(findMax(leftpage), findMax(rightpage));

        return Math.max(findMax(leftpage), findMax(rightpage));
    }



}