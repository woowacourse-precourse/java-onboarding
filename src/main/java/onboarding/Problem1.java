package onboarding;

import java.util.List;

class Problem1 {

    /*
     * 입력이 유효한지 판별합니다.
     *
     * @param 두 개의 페이지 배열입니다.
     * @return 두 페이지 배열이 모두 유효하면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(List<Integer> pobi, List<Integer> crong) {
        List[] pagesList = {pobi, crong};

        for(List<Integer> pages: pagesList) {
            boolean valid =
                hasTwoElements(pages) &&
                hasCorrectNumbers(pages);
            if(valid == false) {
                return false;
            }
        }

        return true;
    }

    /*
     * 페이지가 두 장인지 확인합니다.
     *
     * @param 한 명의 페이지 숫자들이 들어있는 배열입니다.
     * @return 숫자들의 개수가 2라면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasTwoElements(List<Integer> pages) {
        boolean correct = pages.size() == 2;
        return correct;
    }


    /*
     * 두 페이지가 자연수인지, 연속한 홀수 짝수 페이지인지 확인합니다.
     *
     * @param 한 명의 페이지 숫자들이 들어있는 배열입니다.
     * @return 두 숫자가 옳은 페이지라면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasCorrectNumbers(List<Integer> pages) {
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        boolean correct =
                leftPage > 0 &&
                        rightPage > 0 &&
                        leftPage % 2 == 1 &&
                        rightPage % 2 == 0 &&
                        rightPage - leftPage == 1;
        return correct;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        boolean valid = isValidInput(pobi, crong);
        if (valid == false) {
            return -1;
        };

        return 0;
    }

    public static void main(String[] args) {
        Integer test1 = solution(List.of(97, 98), List.of(197, 198));
        Integer test2 = solution(List.of(-3, -2), List.of(1, 2));
        Integer test3 = solution(List.of(1, 2), List.of(3, 6));
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }
}