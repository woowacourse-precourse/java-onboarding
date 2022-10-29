package onboarding.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy;

public class PagePair {
    private static final boolean LEFT_PAGE = true;
    private static final boolean RIGHT_PAGE = false;
    private final List<Page> pagePair;

    public PagePair(List<Integer> pages){
        Page leftPage = new Page(pages.get(0), LEFT_PAGE);
        Page rightPage = new Page(pages.get(1), RIGHT_PAGE);
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
}
