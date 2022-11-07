package onboarding.problem1.page;

import java.util.List;

public class PlayerFactory {

    public Player getPlayer(List<Integer> pages) {
        validatePage(pages);
        return new Player(pages);
    }

    private void validatePage(List<Integer> pages) {
        if (!isValidSize(pages.size())) {  // 페이지 개수 체크
            throw new IllegalArgumentException("페이지는 2개 입력해야 합니다.");
        }

        if (!isValidRange(pages)) {  // 잘못된 범위 혹은 간격일 경우
            throw new IllegalArgumentException("페이지는 1~400 범위 내로 골라야 합니다.");
        }

        if (!isValidInterval(pages)) {
            throw new IllegalArgumentException("두 페이지 간 차이는 1이어야 합니다.");
        }
    }

    private boolean isValidSize(int size) {
        final int DEFAULT_PAGE_SIZE = 2;
        return size == DEFAULT_PAGE_SIZE;
    }

    private boolean isValidRange(List<Integer> pages) {
        // page의 범위를 validation 합니다.
        int MAX_PAGE = 400;
        int MIN_PAGE = 1;

        for (Integer page : pages) {
            if (page < MIN_PAGE || MAX_PAGE < page) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidInterval(List<Integer> pages) {
        // 이미 위에서 페이지 사이즈가 검증되었으므로, 2라고 확신해도 됨.
        Integer firstPage = pages.get(0);
        Integer secondPage = pages.get(1);

        return secondPage - firstPage == 1;
    }
}
