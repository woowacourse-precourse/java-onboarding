package onboarding.problem1;

import java.util.List;

public interface PageValidator {
    /**
     * PageScore 객체에 값을 저장하기 전에 해당 값을 확인하는 과정
     * 조건에 맞지 않는 경우 Exception을 발생
     * @param user 크기가 2인 Integer 배열, 각각의 원소는 1~400 범위에서 각각 홀수와 짝수
     */
    static boolean isValid(List<Integer> user){
        if (user == null) {
            throw new NullPointerException("잘못된 입력입니다. List<Integer> 객체가 null입니다.");
        }

        if (user.size() != 2) {
            throw new IllegalArgumentException("잘못된 입력입니다. List<Integer>의 크기는 항상 2여야 합니다.");
        }

        if (isInvalidRange(user.get(0), user.get(1))) {
            throw new IllegalArgumentException("잘못된 입력입니다. leftPage는 홀수인 자연수, rightPage는 짝수인 자연수입니다.");
        }

        return true;
    }

    /**
     * 입력된 왼쪽, 오른쪽 페이지가 홀짝이 맞는지,<br/>
     * 좌우가 연결된 페이지인지,<br/>
     * 1 ~ 400 범위 안에 있는지 검사<br/>
     * @param leftPage  왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 잘못된 경우 true, 조건에 부합하는 경우 false
     */
    private static boolean isInvalidRange(int leftPage, int rightPage) {
        if (1 > leftPage || leftPage > 400 || 1 > rightPage || rightPage > 400){
            return true;
        } else if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return true;
        } else if (rightPage - leftPage != 1) {
            return true;
        }
        return false;
    }
}
