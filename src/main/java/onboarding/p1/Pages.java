package onboarding.p1;

import java.util.List;

public class Pages {

    private final List<Integer> pageList;

    public Pages(List<Integer> list) {
        validateLength(list);
        validateStartEnd(list);
        validateContinuity(list);
        this.pageList = list;
    }

    private void validateLength(List<Integer> list) {
        int length = list.size();
        if (length != 2) {
            throw new IllegalArgumentException("페이지 수는 2개여야 합니다.");
        }
    }

    private void validateStartEnd(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        if (left <= 1) {
            throw new IllegalArgumentException("첫 페이지는 펼 수 없습니다.");
        }
        if (right >= 400) {
            throw new IllegalArgumentException("마지막 페이지는 펼 수 없습니다.");
        }
    }

    private void validateContinuity(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        if (left != right - 1) {
            throw new IllegalArgumentException("책에는 연속된 페이지만 있을 수 있습니다.");
        }
    }

    public int findPage(int left_right) {
        return this.pageList
                .get(left_right);
    }

}
