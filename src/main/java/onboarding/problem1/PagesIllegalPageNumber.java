package onboarding.problem1;

public class PagesIllegalPageNumber extends IllegalArgumentException {
    public PagesIllegalPageNumber() {
        super("페이지 값은 다음과 같은 조건을 만족해야 합니다 : [n*2+1, n*2+2] (n>=0)");
    }
}
