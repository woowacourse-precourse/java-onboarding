package onboarding.problem1;

public class Book {

    public static final int LAST_PAGE = 400;
    public static final int FIRST_PAGE = 1;

    private Page page;

    public Book(Page page) {
        this.page=page;
    }

    public boolean isNotLeftPageOdd(){
        if(this.page.getLeftPage()%2!=1) return true;
        return false;
    }

    public boolean isNotRightPageEven(){
        if(this.page.getRightPage()%2!=0) return true;
        return false;
    }

    public boolean hasFirstPageOrLess() {
        if(this.page.getLeftPage() <= FIRST_PAGE ||this.page.getRightPage()<=FIRST_PAGE )return true;
        return false;
    }

    public boolean hasLastPageOrMore() {
        if(LAST_PAGE<=this.page.getLeftPage() || LAST_PAGE<=this.page.getRightPage())return true;
        return false;
    }

    public int pageDifference() {
        return page.getRightPage()- page.getLeftPage();
    }

    public int leftPageCalc(PageCalculator pageCalculator){
        return pageCalculator.reduce(page.getLeftPage());
    }

    public int rightPageCalc(PageCalculator pageCalculator){
        return pageCalculator.reduce(page.getRightPage());
    }
}
