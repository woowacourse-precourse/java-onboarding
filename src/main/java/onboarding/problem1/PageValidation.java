package onboarding.problem1;

import java.util.List;

/**
 * true : 검증 성공
 * false  : 검증 실패
 */
public class PageValidation {

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
        for (Integer page : pages) {
            if (page < 1 || page > 400) {
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
