package onboarding;

public class Book {
    public static final int LAST_PAGE = 400;
    public static final int FIRST_PAGE = 1;
    private Integer leftPage;
    private Integer rightPage;
    public Book(Integer leftPage, Integer rightPage) {
        this.leftPage=leftPage;
        this.rightPage=rightPage;
    }

    public boolean hasFirstPageOrLess() {
        if(this.leftPage<= FIRST_PAGE || this.rightPage<=FIRST_PAGE)return true;
        return false;
    }

    public boolean hasLastPageOrMore() {
        if(LAST_PAGE<=this.leftPage || LAST_PAGE <=this.rightPage)return true;
        return false;
    }

    public int getDifference() {
        return rightPage-leftPage;
    }

    public Integer getLeftPage() {
        return leftPage;
    }

    public Integer getRightPage() {
        return rightPage;
    }
}
