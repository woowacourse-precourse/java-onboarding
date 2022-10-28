package onboarding.problem1;

public class Person {

    private String name;
    private int leftPageNumber;
    private int rightPageNumber;
    private int maxScore;

    public Person(String name, int leftPageNumber, int rightPageNumber) {
        this.name = name;
        this.leftPageNumber = leftPageNumber;
        this.rightPageNumber = rightPageNumber;
    }

    public String getName() {
        return name;
    }

    public int getLeftPageNumber() {
        return leftPageNumber;
    }

    public int getRightPageNumber() {
        return rightPageNumber;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
