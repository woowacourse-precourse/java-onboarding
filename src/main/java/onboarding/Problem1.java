package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)){
            return -1;
        }
        ArrayList<Integer> left_pobi_num = eachNum(pobi.get(0));
        ArrayList<Integer> right_pobi_num = eachNum(pobi.get(1));
        ArrayList<Integer> left_crong_num = eachNum(crong.get(0));
        ArrayList<Integer> right_crong_num = eachNum(crong.get(1));

        int left_pobi_mx = Math.max(Mul(left_pobi_num), Add(left_pobi_num));
        int right_pobi_mx = Math.max(Mul(right_pobi_num), Add(right_pobi_num));
        int left_crong_mx = Math.max(Mul(left_crong_num), Add(left_crong_num));
        int right_crong_mx = Math.max(Mul(right_crong_num), Add(right_crong_num));

        int pobi_mx = Math.max(left_pobi_mx, right_pobi_mx);
        int crong_mx = Math.max(left_crong_mx, right_crong_mx);

        int answer = Integer.MAX_VALUE;

        if(pobi_mx == crong_mx){
            answer = 0;
        }
        else if(pobi_mx > crong_mx){
            answer = 1;
        }
        else if(pobi_mx < crong_mx){
            answer = 2;
        }

        return answer;
    }

    public static ArrayList<Integer> eachNum(Integer a) { // 각 자리수를 ArrayList로 추출하는 함수
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(a != 0){
            arr.add(a%10);
            a /= 10;
        }
        return arr;
    }

    public static int Mul(ArrayList<Integer> arr){ // 구해진 각 자리 수들을 곱하는 함수
        int ret = 1;
        for(int x : arr){
            ret *= x;
        }
        return ret;
    }
    public static int Add(ArrayList<Integer> arr){ // 구해진 각 자리 수들을 더하는 함수
        int ret = 0;
        for(int x : arr){
            ret += x;
        }
        return ret;
    }



}