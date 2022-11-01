package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        int pobi1 = pobi.get(0);
        int pobi2 = pobi.get(1);
        int crong1 = crong.get(0);
        int crong2 = crong.get(1);

        if (pobi2 - pobi1!=1 || crong2 - crong1!=1) {
            answer = -1;
        }
        else if(pobi1==1 || crong1==1 || pobi2==400 || crong2==400){
            answer= -1;
        }
        else {
            if(Math.max(getmax(pobi1), getmax(pobi2)) > Math.max(getmax(crong1), getmax(crong2))){
                answer= 1;
            }
            else if (Math.max(getmax(pobi1), getmax(pobi2)) < Math.max(getmax(crong1), getmax(crong2))){
                answer= 2;
            }
            else {
                answer= 0;
            }
        }


        return answer;
    }

    // 페이지번호 덧셈, 곱셈하여 최대값 구하기
    public static int getmax(int who) {
        int result = 0;
        int plus = 0;
        int mult = 1;
        String page = Integer.toString(who);

        for(int i=0; i<page.length(); i++){
            plus += Integer.parseInt(page.split("")[i]);
            mult *= Integer.parseInt(page.split("")[i]);
        }
        result = Math.max(plus,mult);
        return result;
    }
}