package onboarding.problem1;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.stream.Stream;

public class Page {
    private final int page;
    public enum pageDirection{
        LEFT_PAGE(true), RIGHT_PAGE(false);
        private final boolean direction;
        pageDirection(boolean direction){this.direction = direction;}

        public boolean getValue(){return this.direction;}
    }

    public Page(int page, boolean isLeftPage){
        validateEachPage(page, isLeftPage);

        this.page = page;
    }

    private static void validateEachPage(int page, boolean isLeftPage){
        if(page < 1 || page > 400){
            throw new IllegalStateException("페이지는 1 ~ 400 사이의 값을 가져야 합니다.");
        }
        if(isLeftPage != (page % 2 == 1)){
            throw new IllegalStateException("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 값을 가져야 합니다");
        }
    }

    public int getPageSum(){
        int sum = 0;
        int[] valueOfEachPosition = Stream.of(String.valueOf(this.page).split("")).mapToInt(Integer::parseInt).toArray();

        for(int value : valueOfEachPosition){
            sum += value;
        }

        return sum;
    }

    public int getPageProduct(){
        int product = 1;
        int[] valueOfEachPosition = Stream.of(String.valueOf(this.page).split("")).mapToInt(Integer::parseInt).toArray();

        for(int value : valueOfEachPosition){
            product *= value;
        }

        return product;
    }

    public int getMaxValue(){
        return Math.max(getPageSum(),getPageProduct());
    }
}
