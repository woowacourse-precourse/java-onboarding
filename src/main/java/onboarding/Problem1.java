package onboarding;
import java.util.List;
import java.util.ArrayList;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
       int pobiMaxNum = Math.max(SumMax(pobi), MultiMax(pobi));
       int crongMaxNum = Math.max(SumMax(crong), MultiMax(crong));
       if(Math.abs(pobi.get(0) - pobi.get(1)) != 1 || Math.abs(crong.get(0) - crong.get(1)) != 1){
           return -1;
       }
       if(pobiMaxNum - crongMaxNum > 0 ){
            return 1;
       }
       else if(pobiMaxNum - crongMaxNum < 0 ){
            return 2;
        }
       else{
           return 0;
       }
    }

    public static int SumMax(List<Integer> pages){
        int sum[] = {0, 0};
        for(int i = 0 ; i < pages.size(); i++){
            int sumNum = 0;
            int baseNumber = pages.get(i);
            sumNum += baseNumber / 100;
            if(baseNumber / 100 > 0 ){
                baseNumber -= ((baseNumber / 100) * 100);
            }
            sumNum += baseNumber / 10;
            if(baseNumber / 10 > 0 ){
                baseNumber -= ((baseNumber / 10) * 10);
            }
            sumNum += baseNumber;
            sum[i] = sumNum;
        }
            return Math.max(sum[0], sum[1]);
    }
    public static int MultiMax(List<Integer> pages){
        int sum[] = {0, 0};
        for(int i = 0 ; i < pages.size(); i++){
            int MultiNum = 1;
            int baseNumber = pages.get(i);
            if(Math.floorMod(baseNumber, 100) != 0){
                MultiNum *= Math.floorMod(baseNumber, 100);
                if(baseNumber / 100 > 0 ){
                    baseNumber -= ((baseNumber / 100) * 100);
                }
                MultiNum *= baseNumber / 10;
                if(baseNumber / 10 > 0 ){
                    baseNumber -= ((baseNumber / 10) * 10);
                }
                MultiNum *= baseNumber;
                sum[i] = MultiNum;
            }
            else{
                if(Math.floorMod(baseNumber, 10) != 0){
                    MultiNum *= baseNumber / 10;
                    if(baseNumber / 10 > 0 ){
                        baseNumber -= ((baseNumber / 10) * 10);
                    }
                    MultiNum *= baseNumber;
                    sum[i] = MultiNum;
                }
                else{
                    MultiNum *= baseNumber;
                    sum[i] = MultiNum;
                }
            }
        }
        return Math.max(sum[0], sum[1]);
    }

    public static void main(String[] args){
        List<Integer> pobi = new ArrayList<>();
        List<Integer> crong = new ArrayList<>();
        pobi.add(97);
        pobi.add(98);
        crong.add(197);
        crong.add(198);
        System.out.println(solution(pobi, crong));
    }
}