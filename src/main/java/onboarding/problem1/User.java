package onboarding.problem1;

import java.util.List;

class PageException extends Exception{

}

public class User {
    private List<Integer> pages;
    private int userScore = 0;

    public User(List<Integer> pages){
        this.pages = pages;
    }

    public void checkPageValidation() throws PageException{
        if(pages.size() !=2){
            throw new PageException();
        }

        if(pages.get(0) != pages.get(1)-1){
            throw new PageException();
        }
    }

    private Integer calculateSumScore(Integer page){
        int sum = 0;

        while(page != 0){
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    private int calculateMulScore(Integer page){
        int mul = 1;

        while(page != 0){
            mul *= page % 10;
            page /= 10;
        }

        return mul;
    }

    private int[] calculatePageScore(int leftPage, int rightPage){
        int leftPageScore = Math.max(calculateSumScore(leftPage), calculateMulScore(leftPage));
        int rightPageScore = Math.max(calculateSumScore(rightPage), calculateMulScore(rightPage));

        return new int[] {leftPageScore, rightPageScore};
    }

    private void calculateUserScore(int[] pageScore){
        userScore = Math.max(pageScore[0], pageScore[1]);
    }

    public int getUserScore(){
        calculateUserScore(calculatePageScore(pages.get(0), pages.get(1)));
        return userScore;
    }
}
