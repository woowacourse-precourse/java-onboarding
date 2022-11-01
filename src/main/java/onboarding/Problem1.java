package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    //배열의 각 자리 수 더한 결과, 곱합 결과 모두 배열로 반환해주는 메서드
    public static ArrayList<Integer> getResults(List<Integer> mylist){
        ArrayList<Integer> arr=new ArrayList<>();
        int sum=0,multi=1;
        if(mylist.get(1)-mylist.get(0)==1){
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
        }else{
            arr.add(-1);
        }


        return arr;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Integer> p_arr=getResults(pobi);
        ArrayList<Integer> c_arr=getResults(crong);

        int p_max=Collections.max(p_arr);
        int c_max=Collections.max(c_arr);

        if(p_arr.size()==1 || c_arr.size()==1){
            answer=-1;
        }else{
            if(p_max>c_max){
                answer=1;
            }else if(p_max==c_max){
                answer=0;
            }else{
                answer=2;
            }
        }


        return answer;
    }
}