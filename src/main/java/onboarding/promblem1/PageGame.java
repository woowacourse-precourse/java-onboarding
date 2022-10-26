package onboarding.promblem1;

import java.util.List;
import java.util.stream.Collectors;

public class PageGame {

    public static int start(List<Integer> gamer1, List<Integer> gamer2) {
        Pages pages1 = createPage(gamer1);
        Pages pages2 = createPage(gamer2);
        return pages1.compareTo(pages2);
    }

    private static Pages createPage(List<Integer> gamer) {
        return new Pages(createPageNumbers(gamer));
    }

    private static List<PageNumber> createPageNumbers(List<Integer> gamer) {
        return gamer.stream()
                .map(PageNumber::new)
                .collect(Collectors.toList());
    }
}
