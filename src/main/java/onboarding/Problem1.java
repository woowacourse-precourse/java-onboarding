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
    private static boolean isValidInput(List[] pageNumbers) {

        for(List<Integer> pages: pageNumbers) {
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
     * 두 페이지가 1~400의 자연수인지, 연속한 홀수 짝수 페이지인지 확인합니다.
     *
     * @param 한 명의 페이지 숫자들이 들어있는 배열입니다.
     * @return 두 숫자가 옳은 페이지라면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidNumbers(List<Integer> pages) {
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        boolean valid =
            leftPage > 0 &&
            leftPage <= 400 &&
            rightPage > 0 &&
            rightPage <= 400 &&
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
    private static List<List> convertIntoSplitPageNumbers(List[] pageNumbers) {
        List<List> splitPageNumbers = new ArrayList<>();
        for (List<Integer> pages: pageNumbers) {
            List<List> splitPages = new ArrayList<>();
            for (int number: pages) {
                List<Integer> splitNumber = splitByDigit(number);
                splitPages.add(splitNumber);
            }
            splitPageNumbers.add(splitPages);
        }
        return splitPageNumbers;
    }

    /*
     * 숫자를 자릿수별로 떼어준다.
     *
     * @param 자연수
     * @return 자연수를 자릿수별로 떼어낸 정수 배열
     * */
    private static List<Integer> splitByDigit(int number) {
        List<Integer> splitNumber = new ArrayList<>();
        while (number > 0) {
            splitNumber.add(number % 10);
            number /= 10;
        }
        return splitNumber;
    }

    /*
     * 페이지 게임의 승자를 가려주는 코드입니다.
     *
     * @param 두 개의 페이지 배열입니다.
     * @return 무승부는 0, 포비의 승리는 1, 크롱의 승리는 2입니다.
     * */
    private static int findWinner(List<List>  splitPageNumbers) {
        List<List> splitPobi = splitPageNumbers.get(0);
        List<List> splitCrong = splitPageNumbers.get(1);

        int pobiMax = getBiggerNumber(addNumbers(splitPobi.get(0)), multiplyNumbers(splitPobi.get(1)));
        int crongMax = getBiggerNumber(addNumbers(splitCrong.get(0)), multiplyNumbers(splitCrong.get(1)));
        if (pobiMax == crongMax) {
            return 0;
        }
        if (getBiggerNumber(pobiMax, crongMax) == pobiMax) {
            return 1;
        }
        return 2;
    }

    /*
     * 두 숫자를 비교해 큰 수를 알려줍니다.
     *
     * @param 두 개의 정수입니다.
     * @return 둘 중 큰 정수입니다.
     * */
    private static int getBiggerNumber(int numberX, int numberY){
        if (numberX > numberY) {
            return numberX;
        }
        return numberY;
    }

    /*
     * 배열 안의 모든 숫자를 더해줍니다.
     *
     * @param 정수를 포함한 배열입니다.
     * @return 모든 정수의 합입니다.
     * */
    private  static int addNumbers(List<Integer> splitNumbers){
        int result = 0;
        for (int number: splitNumbers) {
            result += number;
        }
        return result;
    }

    /*
     * 배열 안의 모든 숫자를 곱해줍니다.
     *
     * @param 정수를 포함한 배열입니다.
     * @return 모든 정수의 곱입니다.
     * */
    private  static int multiplyNumbers(List<Integer> splitNumbers){
        int result = 1;
        for (int number: splitNumbers) {
            result *= number;
        }
        return result;
    }

    /*
     * Problem1의 솔루션 코드입니다.
     *
     * @param 포비와 크롱의 페이지 배열입니다.
     * @return 포비가 이기면 1, 크롱이 이기면 2, 무승부면 0, 인자값이 잘못되었다면 -1을 반환합니다.
     * */

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List[] pageNumbers = {pobi, crong};
        if (isValidInput(pageNumbers) == false) {
            return -1;
        };

        List<List> splitPageNumbers = convertIntoSplitPageNumbers(pageNumbers);
        int result = findWinner(splitPageNumbers);

        return result;
    }
}