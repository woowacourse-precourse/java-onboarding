package onboarding.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import onboarding.problem1.Page.pageDirection;

public class PagePair {
    enum CompareResult{
        DRAW(0), WIN(1), LOSE(2);
        private final int value;
        CompareResult(int value){
            this.value = value;
        }
        public int getValue(){return value;}
    }

    private final List<Page> pagePair;

    public PagePair(List<Integer> pages){
        Page leftPage = new Page(pages.get(0), pageDirection.LEFT_PAGE.getValue());
        Page rightPage = new Page(pages.get(1), pageDirection.RIGHT_PAGE.getValue());
        validatePagePair(pages);

        this.pagePair = Arrays.asList(leftPage,rightPage);
    }
    private static void validatePagePair(List<Integer> pages){
        if(pages.get(0) + 1 != pages.get(1)){
            throw new IllegalStateException("두 페이지는 연속된 값을 가져야 합니다");
        }
    }

    public int getMaxValueOfPair(){
        return Math.max(pagePair.get(0).getMaxValue(), pagePair.get(1).getMaxValue());
    }

    public int comparePagePair(PagePair otherPair){
        if(this.getMaxValueOfPair() > otherPair.getMaxValueOfPair()){
            return CompareResult.WIN.getValue();
        }
        if(this.getMaxValueOfPair() < otherPair.getMaxValueOfPair()){
            return CompareResult.LOSE.getValue();
        }
        return CompareResult.DRAW.ordinal();
    }
}
