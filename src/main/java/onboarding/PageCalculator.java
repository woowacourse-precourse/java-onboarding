package onboarding;

public interface PageCalculator {
    default int reduce(Page page){
        String[] pageSplitStrings = getSplitStrings(page);
        return calc(pageSplitStrings);
    }

    int calc(String[] pageSplitStrings);

    private String[] getSplitStrings(Page page) {
        Integer pageNumber = page.getPage();
        String str = pageNumber.toString();
        String[] split = str.split("");
        return split;
    }
}
