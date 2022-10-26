package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 1;
        int mul2 = 1;
        ArrayList<Integer> result = new ArrayList<>();
        int leftresult = 0;
        int rightresult = 0;
        int leftresult1 = 0;
        int rightresult1 = 0;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int a1 = pobi.get(0);
        int a2 = pobi.get(1);
        while(a1 !=0){
            left.add(a1%10);
            a1 /= 10;
        }
        while(a2!=0){
            right.add(a2%10);
            a2 /= 10;
        }
        for(int i =0; i< left.size();i++){
            sum1 += left.get(i);
            mul1 *= left.get(i);
        }
        for(int i=0; i< right.size();i++){
            sum2 += right.get(i);
            mul2 *= right.get(i);
        }
        if(sum1>mul1){
            leftresult = sum1;
        }
        else{
            leftresult = mul2;
        }
        if(sum2>mul2){
            leftresult1 = sum2;
        }
        else{
            leftresult1 = mul2;
        }
        result.add(leftresult);
        result.add(leftresult1);


        //오른쪽(crong)
        ArrayList<Integer> left1 = new ArrayList<>();
        ArrayList<Integer> right1 = new ArrayList<>();
        ArrayList<Integer> result1 = new ArrayList<>();
        int summ1 = 0;
        int summ2 = 0;
        int mull1 = 1;
        int mull2 = 1;
        int leftresult2 = 0;
        int rightresult2 = 0;
        int leftresult3 = 0;
        int rightresult3 = 0;
        int b1 = crong.get(0);
        int b2 = crong.get(1);
        while(b1 !=0){
            left1.add(b1%10);
            b1 /= 10;
        }
        while(b2!=0){
            right1.add(b2%10);
            b2 /= 10;
        }
        for(int i =0; i< left1.size();i++){
            summ1 += left1.get(i);
            mull1 *= left1.get(i);
        }
        for(int i=0; i< right1.size();i++){
            summ2 += right1.get(i);
            mull2 *= right1.get(i);
        }
        if(summ1>mull1){
            leftresult2 = summ1;
        }
        else{
            leftresult2 = mull2;
        }
        if(summ2>mull2){
            leftresult3 = summ2;
        }
        else{
            leftresult3 = mull2;
        }
        result1.add(leftresult2);
        result1.add(leftresult3);
        for(int i =0; i<result.size();i++){
            if(result.get(i)==result1.get(i)){
                answer  = 0;
            }
            else if(result.get(i)>result1.get(i)){
                answer  = 1;
            }
            else if(result.get(i)<result1.get(i)){
                answer  = 2;
            }
            else answer = -1;
        }
        return answer;
    }
}