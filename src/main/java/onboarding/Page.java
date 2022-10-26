package onboarding;

public class Page {
    private final int page;

    public Page(int page) {
        this.page = page;
    }

    public boolean validationCheck() {
        return !(this.page == 1 || this.page == 400);
    }
}
