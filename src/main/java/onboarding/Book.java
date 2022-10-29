package onboarding;

public class Book {
    public static final int LAST_PAGE = 400;
    public static final int FIRST_PAGE = 1;

    private Page leftPage;
    private Page rightPage;
    public Book(Page leftPage, Page rightPage) {
        this.leftPage=leftPage;
        this.rightPage=rightPage;
    }

    public boolean hasFirstPageOrLess() {
        if(this.leftPage.getPage() <= FIRST_PAGE ||this.rightPage.getPage()<=FIRST_PAGE )return true;
        return false;
    }

    public boolean hasLastPageOrMore() {
        if(LAST_PAGE<=this.leftPage.getPage() || LAST_PAGE<=this.rightPage.getPage())return true;
        return false;
    }

    public int getDifference() {
        return rightPage.getPage()- leftPage.getPage();
    }

    public int leftPageCalc(PageCalculator pageCalculator){
        return pageCalculator.reduce(leftPage);
    }

    public int rightPageCalc(PageCalculator pageCalculator){
        return pageCalculator.reduce(leftPage);
    }
}
