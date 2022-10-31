package onboarding;
import java.util.List;

/**
 * 주어진 숫자는 1의자리 숫자, 10의자리 숫자, 100의 자리 숫자임으로 먼저 각각의 숫자의 자리를 먼저 파악하고 각 자리에 숫자를 추출한다.
 * 추출한 숫자들을 이용해서 덧셈과 곱셈을 진행한후 두개의 결과를 비교하여 더 큰값이 대표 번호가 된다.
 * 포비와 크롱에 대표번호를 비교하여 포비숫자가 크다면 1, 크롱 숫자가 크다면 2, 무승부는 0, 예외사항은 -1을 리턴한다.
 *
 * @author heeyoung lee
 * @date 2022.10.30
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiNumber = finalNumber(pobi);
        int crongNumber = finalNumber(crong);

        int answer;

        /*
         * 크롱과 포비에 숫자를 비교, 그에 따른 숫자를 리턴
         */
        if(pobiNumber==crongNumber) answer = 0;
        else if(pobiNumber==-1 || crongNumber==-1) answer = -1;
        else{
            answer = (pobiNumber > crongNumber) ? 1 : 2;
        }
        return answer;
    }

    /**
     * 매개변수로 주어진 숫자의 자리수를 파악. 매개변수가 1보다 작거나 400보다 크다면 -1를 리턴
     *
     * @param givenNum
     * @return count라는 변수를 이용, 1의자리 숫자: 1, 10의자리 숫자: 2, 100의자리 숫자: 3
     */
    public static int digitNumber(int givenNum){
        if(givenNum <= 1 || givenNum >=400) return -1;

        int count = 0;
        while(givenNum>0){
            givenNum /= 10;
            count++;
        }
        return count;
    }

    /**
     * 매개변수가 주어졌을때 그 숫자의 덧셈과 곱셈을 비교.
     * digitNumber 메소드를 이용해서 숫자의 자리수를 파악후 switch statement를 이용해서 자리수에 해당하는데로 곱셈과 덧셈의 값을 구함.
     * 각 자리 숫자를 추출해야하기 때문에 1의자리, 10의자리, 100의자리, 곱셈, 덧셈 변수를 생성.
     *
     * @param num
     * @return 곱셈과 덧셈중 더 큰 숫자를 리턴
     */

    public static int greaterNumber(int num){
        int digitNum = digitNumber(num);

        int onesDigit = -1;
        int tensDigit = -1;
        int hundredsDigit = -1;
        int addition = -1;
        int multiplication = -1;

        switch (digitNum){

            case 1:
                    return 1;
            case 2:
                    onesDigit = num % 10;
                    tensDigit = num / 10 % 10;

                    addition = onesDigit + tensDigit;
                    multiplication = onesDigit * tensDigit;
                    return Math.max(addition, multiplication);
            case 3:
                    onesDigit = num % 10;
                    tensDigit = num / 10 % 10;
                    hundredsDigit = num/100;

                    addition = onesDigit + tensDigit + hundredsDigit;
                    multiplication = onesDigit * tensDigit * hundredsDigit;
                return Math.max(addition, multiplication);
            default:
                return -1;
        }
    }

    /**
     * 예외사항의 모든 경우에 수를 포함시킴.
     *  1. 매개변수가 빈 리스트일때
     *  2. 연속 숫자가 아닐경우
     *  3. 첫번째 숫자가 홀수가 아닐경우
     *  4. 두번째 숫자가 짝수가 아닐경우
     *  5. 페이지 숫자가 1이나 400일경우
     *
     * @param list
     * @return 위에 상태중 하나라도 해당한다면 -1을 리턴. Math.max 메소드를 이용 두개의 페이지 숫자중 더 큰 숫자를 리턴
     */
    public static int finalNumber(List<Integer> list){
        // if the list is empty, OR even page - odd page != 1, OR first number is not odd, OR second number is not even
        // OR page number is either 1 or 400
        int odd = list.get(0);
        int even = list.get(1);

        if(list==null || even-odd!=1 || odd%2!=1 || even%2!=0 || greaterNumber(odd)==-1 || greaterNumber(even)==-1){
            return -1;
        }
        return Math.max(greaterNumber(odd), greaterNumber(even));
    }

}