package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int[] result = {0,0};
        int[] answer = {0,0,0,0};
        int[] sum = {0,0,0,0};
        int[] multi = {1,1,1,1};
        int[] page = {pobi.get(0), pobi.get(1) ,crong.get(0),crong.get(1)}; // pages

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

        return answer;
    }
}