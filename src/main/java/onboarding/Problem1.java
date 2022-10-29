package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_left = pobi.get(0);       //pobi 왼쪽 페이지
        int pobi_right = pobi.get(1);      //pobi 오른쪽 페이지
        int crong_left = crong.get(0);     //crong 왼쪽 페이지
        int crong_right = crong.get(1);    //crong 오른쪽 페이지

        if(pobi_left % 2 == 0 || pobi_right != pobi_left+1) return -1;     //짝수로 시작하거나 연속되지 않은 페이지
        if(pobi_left == 1 || pobi_right == 400) return -1;                   //첫장 or 마지막장
        if(crong_left % 2 == 0 || crong_right != crong_left+1) return -1;
        if(crong_left == 1 || crong_right == 400) return -1;

        String pobi_left_str = Integer.toString(pobi_left);
        String pobi_right_str = Integer.toString(pobi_right);
        String crong_left_str = Integer.toString(crong_left);
        String crong_right_str = Integer.toString(crong_right);

        return answer;
    }

    public static int plus(int result, String page){
        for(int i=0; i<page.length(); i++){
            String number_i = page.substring(i, i+1);
            result += Integer.parseInt(number_i);
        }

        return result;
    }
}