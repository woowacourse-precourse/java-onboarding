package onboarding.problem1;

public interface PageCalculator {
    default int reduce(Integer page){
        String[] pageSplitStrings = getSplitStrings(page);
        return calc(pageSplitStrings);
    }

    int calc(String[] pageSplitStrings);

    private String[] getSplitStrings(Integer page) {
        String str = page.toString();
        String[] split = str.split("");
        return split;
    }
}
