package onboarding;

public class Problem3 {
    public static String numberString="6389";
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    // 자릿수, 숫자 기반으로 최대 숫자 체크
    public static int checkMaxNumberClapCount(int digit, int digitNumber){
        int nextDigit = digit+1;
        int nextDigitNumber = numberString.charAt(nextDigit) - '0'; //다음 자릿수 기반 최대 숫자 연산
        int countForNextDigit = count369InDigitNumber(nextDigitNumber);
        int countForDigit = digitNumber%3 ==0 ? 1 : 0;

        int leftDigits = calculateLeftDigits(nextDigit);

        if(countForDigit == 0) {
            if(countForNextDigit == 0) {
                return 0;
            }
            if(leftDigits == 0) {
                //뒤에 더 자리 없을 때
                return countForNextDigit;
            }
            return (int)Math.pow(10,leftDigits)*countForNextDigit;
        }

        if(countForNextDigit == 0) {
            if(leftDigits == 0) {
                return countForDigit;
            }
            return (int)Math.pow(10,leftDigits)*countForDigit;
        }

        if(leftDigits == 0) {
            return countForDigit*countForNextDigit;
        }

        return (int)Math.pow(10,leftDigits)*countForDigit*countForNextDigit;
    }

    private static int count369InDigitNumber(int digitNumber) {
        if(digitNumber>=9) {
            return 3;
        }
        if(digitNumber>=6) {
            return 2;
        }
        if(digitNumber>=3){
            return 1;
        }
        return 0;
    }

    private static int calculateLeftDigits(int digit) {
        return numberString.length() - (digit + 1);
    }
}
