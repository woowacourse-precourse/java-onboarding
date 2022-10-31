package onboarding;

import java.util.List;
import java.lang.IllegalArgumentException;

class PageList{
    private List<Integer> list;
    public PageList(List<Integer> list){
        validatePageRange(list);
        validatePageDiff(list);
        validatePageLeftRight(list);
        this.list = list;
    }
    public void validatePageRange(List<Integer> list){
        if(list.get(0)<=1 || list.get(1)>=400)
            throw new IllegalArgumentException("Invalid Page Range");
    }
    public void validatePageDiff(List<Integer> list){
        if(list.get(1)-list.get(0)!=1)
            throw new IllegalArgumentException("Invalid Page Difference");
    }
    public void validatePageLeftRight(List<Integer> list){
        if(list.get(0)%2==0 || list.get(1)%2==1)
            throw new IllegalArgumentException("Invalid Page Odd & Even");
    }
    public int getMaxValueOfOne(int item){
        String value = Integer.toString(item);
        int sumTmp = 0;
        int mulTmp = 1;
        for(int j=0;j<value.length();j++){
            int tmp = Integer.parseInt(value.substring(j,j+1));
            sumTmp += tmp;
            mulTmp *= tmp;
        }
        return Math.max(sumTmp, mulTmp);
    }
    public int getMaxValueOfAll(){
        return Math.max(getMaxValueOfOne(this.list.get(0)), getMaxValueOfOne(this.list.get(1)));
    }
}
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try{
            PageList pobiPageList = new PageList(pobi);
            PageList crongPageList = new PageList(crong);

            int pobiMax = pobiPageList.getMaxValueOfAll();
            int crongMax = crongPageList.getMaxValueOfAll();

            if(pobiMax==crongMax)
                return 0;
            if(pobiMax>crongMax)
                return 1;
            if(pobiMax<crongMax)
                return 2;
        }catch(Exception e){
            return -1;
        }
        return -1;
    }
}