package onboarding;

import java.util.*;
import java.util.Map.*;

public class Problem5 {
    private static final int[] arr= {50000,10000,5000,1000,500,100,50,10,1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for(int i=0;i<arr.length;i++) map.put(arr[i],0);

        for(int i=0;i<arr.length;i++){
            while(money>=arr[i]){
                money = money-arr[i];
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
            if(money==0) break;
        }

        for(Entry<Integer,Integer> entry:map.entrySet()){
            answer.add(entry.getValue());
        }

        return answer;
    }
}
