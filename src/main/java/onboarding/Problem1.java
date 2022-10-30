package onboarding;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pMax=0;
        int cMax=0;
        List<Integer> pList=new ArrayList<Integer>();
        List<Integer> cList=new ArrayList<Integer>();

        for(int i=0;i<pobi.size();i++){

            if(pobi.get(i) == 1 || pobi.get(i)==400){
                answer = -1;
                break;
            }

            int tmp = pobi.get(i);
            int sum=0,multi=1;
            while(tmp>0){
                sum += tmp%10;
                multi *=tmp%10;
                tmp/=10;
            }
            pList.add(sum);
            pList.add(multi);

        }
        for(int i=0;i<crong.size();i++){

            if(crong.get(i) == 1 || crong.get(i)==400){
                answer = -1;
                break;
            }
            int tmp = crong.get(i);
            int sum = 0, multi = 1;
            while(tmp > 0){
                sum+=tmp%10;
                multi*=tmp%10;
                tmp/=10;
            }
            cList.add(sum);
            cList.add(multi);
        }
        pList.sort(Comparator.reverseOrder());
        cList.sort(Comparator.reverseOrder());
        pMax = pList.get(0);
        cMax = cList.get(0);

        if(pMax == cMax){
            answer = 0;
        }else if(pMax > cMax){
            answer = 1;
        }else if(pMax < cMax){
            answer = 2;
        }
        if(pobi.get(1)-pobi.get(0)!=1){
            answer = -1;
        }
        if(crong.get(1)-crong.get(0)!=1){
            answer = -1;
        }
        return answer;
    }
}