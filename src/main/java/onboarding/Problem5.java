package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int arr[] = {0,0,0,0,0,0,0,0,0};
        List<Integer> answer = new ArrayList<>();
        while(money > 0){
            if(money >= 50000){
                money -= 50000;
                arr[0] += 1;
            }else if(money >= 10000){
                money -= 10000;
                arr[1] += 1;
            }else if(money >= 5000){
                money -= 5000;
                arr[2] += 1;
            }else if(money >= 1000){
                money -= 1000;
                arr[3] += 1;
            }else if(money >= 500){
                money -= 500;
                arr[4] += 1;
            }else if(money >= 100){
                money -= 100;
                arr[5] += 1;
            }else if(money >= 50){
                money -= 50;
                arr[6] += 1;
            }else if(money >= 10){
                money -= 10;
                arr[7] += 1;
            }else if(money >= 1){
                money -= 1;
                arr[8] +=1;
            }
        }

        for (int i = 0; i < arr.length; i++){
            answer.add(arr[i]);
        }
        return answer;
    }
}
