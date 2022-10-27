package onboarding;

import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    public static final int EXCEPTION_RETURN_VALUE = -1;
    public static final int POBI_WINNER_RETURN_VALUE = 1;
    public static final int CRONG_WINNER_RETURN_VALUE = 2;
    public static final int TIE = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Pages pobiPages = Pages.of(pobi);
        Pages crongPages = Pages.of(crong);

        if (PageValidator.isInValidPages(pobiPages) || PageValidator.isInValidPages(crongPages)) {
            return EXCEPTION_RETURN_VALUE;
        }

        Score pobiScore = getHighestScore(pobiPages);
        Score crongScore = getHighestScore(crongPages);

        if (pobiScore.isHigherThan(crongScore)) {
            return POBI_WINNER_RETURN_VALUE;
        } else if (pobiScore.isLowerThan(crongScore)) {
            return CRONG_WINNER_RETURN_VALUE;
        }

        return TIE;
    }

    private static Score getHighestScore(Pages pages) {
        int highestScore = Math.max(
            Math.max(
                add(pages.getFrontPage()), add(pages.getBackPage())
            ),
            Math.max(
                multiply(pages.getFrontPage()), multiply(pages.getBackPage())
            )
        );

        return Score.of(highestScore);
    }

    private static Integer add(Page page) {
        return page.getEachNumberList()
            .stream().mapToInt(number -> number)
            .sum();
    }

    private static Integer multiply(Page page) {
        int result = 1;
        for (Integer number : page.getEachNumberList()) {
            result = result * number;
        }
        return result;
    }

    public static class PageValidator {
        public static final int PAGE_MAX_LIMIT = 400;
        public static final int PAGE_MIN_LIMIT = 1;

        public static boolean isInValidPages(Pages pages) {
            return isPageSeparated(pages) || isPageLastOrHigher(pages) || isPageFirstOrLower(pages);
        }

        private static boolean isPageSeparated(Pages pages) {
            return (pages.getBackPage().getNumber() - pages.getFrontPage().getNumber()) != 1;
        }

        private static boolean isPageLastOrHigher(Pages pages) {
            return PAGE_MAX_LIMIT <= pages.getBackPage().getNumber();
        }

        private static boolean isPageFirstOrLower(Pages pages) {
            return pages.getFrontPage().getNumber() <= PAGE_MIN_LIMIT;
        }
    }

    public static class Pages {
        public final Page frontPage;
        public final Page backPage;

        private Pages(Page frontPage, Page backPage) {
            this.frontPage = frontPage;
            this.backPage = backPage;
        }

        public static Pages of(List<Integer> target) {
            return new Pages(
                Page.of(Math.min(target.get(0), target.get(1))),
                Page.of(Math.max(target.get(0), target.get(1)))
            );
        }

        public Page getFrontPage() {
            return frontPage;
        }

        public Page getBackPage() {
            return backPage;
        }
    }

    public static class Page {
        private final Integer pageNumber;

        private Page(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }

        public static Page of(Integer pageNumber) {
            return new Page(pageNumber);
        }

        public Integer getNumber() {
            return pageNumber;
        }

        public List<Integer> getEachNumberList() {
            return pageNumber.toString().chars().map(ch -> ch - 48).boxed().collect(Collectors.toList());
        }
    }

    public static class Score implements Comparable<Score> {
        private final Integer score;

        public Score(Integer score) {
            this.score = score;
        }

        public static Score of(Integer score) {
            return new Score(score);
        }

        @Override
        public int compareTo(Score anotherScore) {
            return Integer.compare(score, anotherScore.score);
        }

        public boolean isHigherThan(Score anotherScore) {
            return this.compareTo(anotherScore) > 0;
        }

        public boolean isLowerThan(Score anotherScore) {
            return this.compareTo(anotherScore) < 0;
        }
    }
}
