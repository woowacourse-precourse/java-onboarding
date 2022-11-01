package onboarding;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int pobiCalc(List<Integer> pobi){
        List<Integer> pList = new ArrayList<>();
        int pMax = 0;
        for(int i=0;i<pobi.size();i++){
            int num = pobi.get(i);
            int sum=0,multi=1;
            while(num>0){
                sum += num%10;
                multi *=num%10;
                num/=10;
            }
            pList.add(sum);
            pList.add(multi);

        }
        pList.sort(Comparator.reverseOrder());
        pMax = pList.get(0);
        return pMax;
    }

    public static int crongCalc(List<Integer> crong){
        List<Integer> cList = new ArrayList<>();
        int cMax = 0;
        for(int i=0;i<crong.size();i++){
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
        cList.sort(Comparator.reverseOrder());
        cMax = cList.get(0);
        return cMax;
    }
    public static int checkArg(List<Integer> pobi,List<Integer> crong){
        int check = 0;

        if(pobi.get(1)-pobi.get(0)!=1){
            check = -1;
        }
        for(int i=0;i<pobi.size();i++) {

            if (pobi.get(i) == 1 || pobi.get(i) == 400) {
                check = -1;
                break;
            }
        }
        if(crong.get(1)-crong.get(0)!=1){
            check = -1;
        }
        for(int i=0;i<crong.size();i++) {
            if (crong.get(i) == 1 || crong.get(i) == 400) {
                check = -1;
                break;
            }
        }
        return check;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = checkArg(pobi,crong);
        if(answer != -1){
            int pMax=pobiCalc(pobi);;
            int cMax=crongCalc(crong);
            if(pMax == cMax){
                answer = 0;
            }else if(pMax > cMax){
                answer = 1;
            }else if(pMax < cMax){
                answer = 2;
            }
        }
        return answer;
    }
}