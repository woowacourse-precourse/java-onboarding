package onboarding;

import java.util.*;
import java.util.Map.*;

class Problem1 {
    private static final int SIZE=2;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.size() != SIZE || crong.size() != SIZE) return -1;

        if(pobi.get(0) != (pobi.get(1)-1) || (crong.get(0)) != (crong.get(1)-1)) return -1;

        Map<List<Integer>,Integer> map = new HashMap<>();
        map.put(pobi,0);
        map.put(crong,0);

        for(Entry<List<Integer>,Integer> entry:map.entrySet()){
            for(int i=0;i<SIZE;i++){
                int len  = Integer.toString(entry.getKey().get(i)).length();
                int[] arr = new int[len];
                int sum=0,mul=1,max=0;
                int tmp = entry.getKey().get(i);
                for(int j=0;j<len;j++){
                    arr[j] = tmp%10;
                    tmp = tmp/10;
                    sum += arr[j];
                    mul *= arr[j];
                }
                max = Math.max(sum,mul);
                map.put(entry.getKey(),(Math.max(map.get(entry.getKey()),max)));
            }
        }

        if(map.get(pobi) > map.get(crong)) answer = 1;
        else if(map.get(pobi) < map.get(pobi)) answer = 2;
        else answer = 0;

        return answer;
    }
}