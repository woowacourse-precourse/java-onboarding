package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static ArrayList<Integer> getResults(List<Integer> mylist){
        ArrayList<Integer> arr=new ArrayList<>();
        int sum=0,multi=1;

        for(int i=0;i<2;i++){
            int n=mylist.get(i);
            while(n>0){
                sum+=n%10;
                multi*=n%10;
                n/=10;
            }
            arr.add(sum);
            arr.add(multi);
            sum=0;
            multi=1;
        }

        return arr;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        ArrayList<Integer> p_arr=getResults(pobi);
        ArrayList<Integer> c_arr=getResults(crong);

        int p_max=Collections.max(p_arr);
        int c_max=Collections.max(c_arr);

        if(p_max>c_max){
            answer=1;
        }else if(p_max==c_max){
            answer=0;
        }else{
            answer=2;
        }

        return answer;
    }
}