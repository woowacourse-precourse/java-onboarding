package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //화패를 나타내는 숫자배열
        int[] arr=new int[]{50000,10000,5000,1000,500,100,50,10,1};
        int idx=0;
        List<Integer> list=new ArrayList<>();
        //모든 화폐를 돌면서
        while(idx<=8){
            if(money>=arr[idx]){
                list.add(money/arr[idx]);
                money%=arr[idx];
            }else{
                list.add(0);
            }
            idx++;
        }

        return list;
     }
}
