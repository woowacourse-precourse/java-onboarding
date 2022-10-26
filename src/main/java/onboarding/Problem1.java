package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    /*
     * 입력이 유효한지 판별합니다.
     *
     * @param 두 개의 페이지 배열입니다.
     * @return 두 페이지 배열이 모두 유효하면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(List[] pagesList) {

        for(List<Integer> pages: pagesList) {
            boolean valid =
                hasTwoElements(pages) &&
                hasValidNumbers(pages);
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
        boolean valid = pages.size() == 2;
        return valid;
    }


    /*
     * 두 페이지가 자연수인지, 연속한 홀수 짝수 페이지인지 확인합니다.
     *
     * @param 한 명의 페이지 숫자들이 들어있는 배열입니다.
     * @return 두 숫자가 옳은 페이지라면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidNumbers(List<Integer> pages) {
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        boolean valid =
            leftPage > 0 &&
            rightPage > 0 &&
            leftPage % 2 == 1 &&
            rightPage % 2 == 0 &&
            rightPage - leftPage == 1;
        return valid;
    }

    /*
     * 각각의 페이지 숫자의 자릿수를 떼어 배열로 바꿔줍니다.
     *
     * @param 두 개의 페이지 배열입니다.
     * @return 자연수 배열이 포함된 배열을 반환합니다.
     * */
    private static List<List> convertPageToSplitNumber(List[] pagesList) {
        List<List> splitNumberLists = new ArrayList<>();
        for (List<Integer> pages: pagesList) {
            List<List> splitNumberList = new ArrayList<>();
            for (int pageNumber: pages) {
                List<Integer> splitNumber = splitByDigit(pageNumber);
                splitNumberList.add(splitNumber);
            }
            splitNumberLists.add(splitNumberList);
        }
        return splitNumberLists;
    }

    /*
     * 숫자를 자릿수별로 떼어준다.
     *
     * @param 자연수
     * @return 자연수를 자릿수별로 떼어낸 정수 배열
     * */
    private static List<Integer> splitByDigit(int pageNumber) {
        return new ArrayList<>();
    }

    /*
     * Problem1의 솔루션 코드입니다.
     *
     * @param 포비와 크롱의 페이지 배열입니다.
     * @return 포비가 이기면 1, 크롱이 이기면 2, 무승부면 0, 인자값이 잘못되었다면 -1을 반환합니다.
     * */

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List[] pagesList = {pobi, crong};

        if (isValidInput(pagesList)) {
            return -1;
        };

        List<List> splitNumberLists = convertPageToSplitNumber(pagesList);
        System.out.println(splitNumberLists);

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