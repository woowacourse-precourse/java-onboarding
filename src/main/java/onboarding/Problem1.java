package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_score, crong_score;

        if(verify(pobi) && verify(crong)){
            pobi_score = compare(pobi);
            crong_score = compare(crong);

            if(pobi_score > crong_score){
                answer = 1;
            } else if(pobi_score == crong_score){
                answer = 0;
            } else {
                answer = 2;
            }
        } else {
            answer = -1;
        }
        return answer;
    }

    public static boolean verify(List<Integer> data){
        if(data.get(0) % 2 == 0){
            return false;
        } else if(data.get(1) - data.get(0) != 1){
            return false;
        } else if(data.get(0) == 0 || data.get(1) == 400){
            return false;
        } else {
            return true;
        }
    }

    public static int compare(List<Integer> data){
        int left, right;
        left = cal(data.get(0));
        right = cal(data.get(1));
        if(left >= right){
            return left;
        } else {
            return right;
        }
    }

    public static int cal(int data){
        List<Integer> digits = split(data);
        int hap = digits.get(0);
        int gop = digits.get(0);
        for(int i=1;i< digits.size();i++){
            hap += digits.get(i);
            gop *= digits.get(i);
        }
        if(hap >= gop){
            return hap;
        } else {
            return gop;
        }
    }

    public static List<Integer> split(int num){
        List<Integer> temp = new ArrayList<>();
        while(num > 0){
            temp.add(num % 10);
            num /= 10;
        }
        Collections.reverse(temp);
        return temp;
    }
}