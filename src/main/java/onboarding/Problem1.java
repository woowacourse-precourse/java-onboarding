package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PageOperator{
    private Integer getMultiply(Integer pageNumber){
        Integer mul = 1;
        while (pageNumber > 0){
            mul *= pageNumber % 10;
            pageNumber /= 10;
        }
        return mul;
    }
    private Integer getSum(Integer pageNumber){
        Integer sum = 0;
        while(pageNumber > 0){
            sum += pageNumber % 10;
            pageNumber /= 10;
        }
        return sum;
    }

    private Integer getMaxNumber(Integer pageNumber){
        Integer multiplyResult = getMultiply(pageNumber);
        Integer sumResult = getSum(pageNumber);
        return  multiplyResult > sumResult ? multiplyResult : sumResult;
    }

    public Integer getMaxPageNumber(List<Integer> pages){
        return pages.stream().map(this::getMaxNumber)
                .max((page1, page2)-> page1 < page2 ? page1 : page2).get();
    }
}

class PageGame{
    PageOperator pageOperator;
    List<Integer>[] pageDatas = new List[2];

    private boolean isFaultPageData(List<Integer> pageData){
        if(pageData.get(0)+1 != pageData.get(1))return true;
        if(pageData.get(1) == 0 )return true;
        return false;
    }
    public PageGame(List<Integer> pobi, List<Integer> crong){
        pageOperator = new PageOperator();
        pageDatas[0] = pobi;
        pageDatas[1] = crong;
    }

    public Integer start(){
        for(var pageData: pageDatas){
            if(isFaultPageData(pageData))throw new RuntimeException();
        }
        Integer pobi = pageOperator.getMaxPageNumber(pageDatas[0]);
        Integer crong = pageOperator.getMaxPageNumber(pageDatas[1]);
        if(pobi > crong)return 1;
        if(pobi < crong)return 2;
        if(pobi == crong)return 0;
        throw new RuntimeException();
    }
}

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageGame game = new PageGame(pobi, crong);
        try {
            return game.start();
        }catch (RuntimeException e){
            return -1;
        }
    }
}