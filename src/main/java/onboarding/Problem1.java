package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(valid(pobi, crong)) return -1; //유효성 검사
        int pobi_max = Math.max(sum_max(pobi), mul_max(pobi)); //pobi의 각 자리를 더한값, 곱한값 중 큰 값을 저장한다
        int crong_max = Math.max(sum_max(crong), mul_max(crong)); //crong의 각 자리를 더한값, 곱한값 중 큰 값을 저장한다.
        if(pobi_max > crong_max) return 1;
        else if(pobi_max == crong_max) return 0;
        else return 2;
    }


    public static int mul_max(List<Integer> pages) {
        int max = 0;
        int[] sum = {0, 0};
        for(int i = 0; i < pages.size(); i++){ //왼쪽 오른쪽 페이지 검사
            int num = pages.get(i);
            int re = 0; //페이지의 각자릿수 곱하기를 저장할 변수
            while(num > 0) {
                if(re == 0) re = num % 10;
                else re *= num % 10;
                num /= 10;

            }
            sum[i] = re;
        }
        return Math.max(sum[0], sum[1]);
    }

    public static int sum_max(List<Integer> pages){
        int max = 0;
        int[] sum = {0, 0};
        for(int i = 0; i < pages.size(); i++){
            int num = pages.get(i);
            int re = 0; //각 자리의 덧셈을 저장할 변수
            while(num > 0){
                re += num % 10;
                num /= 10;
            }
            sum[i] = re;
        }
        return Math.max(sum[0], sum[1]);
    }
    public static Boolean valid(List<Integer> pobi, List<Integer> crong){ //조건에 맞지않으면 true
        //1. 왼쪽 페이지가 오른쪽 페이지 보다 클 때
        if(pobi.get(0) >= pobi.get(1) || crong.get(0) >= crong.get(1)){
            return true;
        }
        //2. 1페이지 400페이지를 벗어났을 때
        if(pobi.get(0) < 0 || crong.get(0) < 0 || pobi.get(1) > 400 || crong.get(1) > 400){
            return true;
        }
        //3. 왼쪽 오른쪽 페이지의 차이가 1이 아닐때
        if(Math.abs(pobi.get(0)-pobi.get(1)) != 1 || Math.abs(crong.get(0) -crong.get(1)) != 1)
            return true;

        return false;
    }
}