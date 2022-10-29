package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int getSum(List<Integer> nums) {
        int sum = 0;
        for (int i: nums) {
            ArrayList<Integer> newnums = splitNum(i);
            for (int j: newnums){
                sum+=j;
            }
        }
        return sum;
    }
    public static int getMul(List<Integer> nums) {
        int mul = 1;
        for (int i: nums) {
            ArrayList<Integer> newnums = splitNum(i);
            for (int j: newnums){
                mul *=j;
            }
        }
        return mul;
    }
    public static ArrayList<Integer> splitNum(int oldNum){
        String oldList = Integer.toString(oldNum);
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < oldList.length(); i++){
            newList.add(oldList.charAt(i) - '0');
        }
        return newList;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_score_sum = getSum(pobi);
        int pobi_score_mul= getMul(pobi);
        int pobi_score = max(pobi_score_mul, pobi_score_sum);
        int crong_score_sum = getSum(crong);
        int crong_score_mul = getMul(crong);
        int crong_score = max(crong_score_mul, crong_score_sum);
        return answer;
    }
}