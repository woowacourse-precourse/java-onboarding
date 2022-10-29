package onboarding;

public class Book {
    private Integer leftPage;
    private Integer rightPage;
    public Book(Integer leftPage, Integer rightPage) {
        this.leftPage=leftPage;
        this.rightPage=rightPage;
    }

    public boolean hasFirstPageOrLess() {
        if(this.leftPage<=1)return true;
        return false;
    }

    public boolean hasLastPageOrMore() {
        if(400<=this.rightPage)return true;
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
