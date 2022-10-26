package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;


        return answer;
    }

}
class Person{
    private int leftPage;
    private int rightPage;
    private int score;

    Person(List<Integer> pages){
        this.leftPage = pages.get(0);
        this.rightPage = pages.get(1);
    }
    public int getLeftPage() {
        return leftPage;
    }

    public int getRightPage() {
        return rightPage;
    }

    public int getScore() {
        return score;
    }
}

class ExceptionHandling{
    private int leftPage;
    private int rightPage;

    ExceptionHandling(Person person){
        this.leftPage = person.getLeftPage();
        this.rightPage = person.getRightPage();
    }

    private boolean isConsecutivePages() {
        if (rightPage - leftPage == 1) {
            return true;
        }
        return false;
    }

    private boolean isInRange(){
        if(leftPage > 0 && leftPage <= 400 && rightPage > 0 && rightPage <= 400){
            return true;
        }
        return false;
    }

    private boolean isRightPageFormat(){
        if(leftPage % 2 == 1 && rightPage % 2 == 0){
            return true;
        }
        return false;
    }

}