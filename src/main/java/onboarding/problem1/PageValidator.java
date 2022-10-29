package onboarding.problem1;

import java.util.List;

public class PageValidator {

    // 객체 지향에서 본인의 값은 본인이 관리해라!
    // 검증과 생성 책임을 팩토리로 위임. > !!
    // 재사용, 성능... 객체지향...
    public static boolean isValidPage(List<List<Integer>> pagesList) {
        // page들을 받아 validation 합니다.
        // pageList 중 하나라도 검증에 실패하면 false를 반환한다.
        for (List<Integer> page : pagesList) {
            if (!isValidSize(page.size())) {  // 페이지 개수 체크
                return false;
            }

            if (!isValidRange(page) || !isValidInterval(page)) {  // 잘못된 범위 혹은 간격일 경우
                return false;
            }
        }

        return true;  // 위 사항에 아무것도 해당되지 않으면 검증 성공.
    }

    private static boolean isValidSize(int size) {
        final int DEFAULT_PAGE_SIZE = 2;
        return size == DEFAULT_PAGE_SIZE;
    }

    private static boolean isValidRange(List<Integer> pages) {
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

    private static boolean isValidInterval(List<Integer> pages) {
        // 이미 위에서 페이지 사이즈가 검증되었으므로, 2라고 확신해도 됨.
        Integer firstPage = pages.get(0);
        Integer secondPage = pages.get(1);

        return secondPage - firstPage == 1;
    }
}
