package onboarding;

import java.util.List;

import static java.lang.Math.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int[] result = {0,0};
        int[] answer = {0,0,0,0};
        int[] sum = {0,0,0,0};
        int[] multi = {1,1,1,1};
        int[] page = {pobi.get(0), pobi.get(1) ,crong.get(0),crong.get(1)}; // pages

        // Exceptions
        if(page[1]-page[0]!=1 || page[3]-page[2]!=1 || page[0]<=1 || page[1]>=400 || page[2]<=1 || page[3]>=400){
            return -1;
        }

        // each page's additions and multiplications
        for(int i=0; i<page.length; i++){
            while(page[i]>0){
                sum[i] += page[i]%10;
                multi[i] *= page[i]%10;
                page[i]/=10;
            }
            if(sum[i]>multi[i]){
                answer[i] += sum[i];
            }
            else{
                answer[i] += multi[i];
            }
        }

        // CHOOSE THE BIG PAGE
        // pobi's page
        if(answer[0]>answer[1]){
            result[0] = answer[0];
        }
        else{
            result[0] = answer[1];
        }
        // crong's page
        if(answer[2]>answer[3]){
            result[1] = answer[2];
        }
        else{
            result[1] = answer[3];
        }

        // WHO IS THE WINNER?
        if(result[0]>result[1]){ //pobi is the winner
            return 1;
        }
        else if(result[0]<result[1]){ //crong is the winner
            return 2;
        }
        else{ //draw
            return 0;
        }

    }
}