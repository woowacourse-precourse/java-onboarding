package onboarding.problem1;

public class Page {
    private Integer leftPage;
    private Integer rightPage;
    public Page(Integer leftPage,Integer rightPage) {
        this.leftPage = leftPage;
        this.rightPage=rightPage;
    }

    public Integer getLeftPage() {
        return leftPage;
    }

    public Integer getRightPage() {
        return rightPage;
    }
}
