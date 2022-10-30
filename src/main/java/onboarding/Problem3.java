package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer += countClapOnThousandsPlace(number);
        answer += countClapOnHundredsPlace(number);
        answer += countClapOnTensPlace(number);
        answer +=countClapOnOnesPlace(number);

        return answer;
    }

    private static int countClapOnThousandsPlace(int number) { //천의 자리 숫자가 파라미터
        //천의 자리 수에 대한 계산
        int thousandsCount = 0;
        for (int i = 3 ; i <= 9 ; i+=3) {
            //3, 6, 9 에 대해 테스트
            int thisNumber = i*1000+999; //3999, 6999, 9999
            if(thisNumber <= number) {
                thousandsCount+=1000;
                continue;
            }
            //작지 않고, 천의 자리 숫자가 3, 6, 9 중 하나라면 (ex. number == 6645, thisNumber == 6999 -> 625번 천의 자리가 '6'이므로 박수치게 됨)
            if(number/1000 == i) {
                int possibleCount = number%1000;
                thousandsCount+=(possibleCount+1);
            }
            break;
        }
        return thousandsCount;
    }

    private static int countClapOnHundredsPlace(int number) {
        int hundredsCount = 0;
        int thisNumber;
        for (int i = 3; i <= 9 ; i+=3) {
            int thousandsPlace;
            for(thousandsPlace = 0; thousandsPlace <= 9; thousandsPlace++) {
                thisNumber = thousandsPlace*1000 + i*100 + 99;
                if(thisNumber <= number) {
                    hundredsCount+=100;
                    continue;
                }
                //thisNumber > number (ex. number == 6645, thisNumber == 6699)
                if (thisNumber/100==number/100) {
                    hundredsCount+=(number%100+1);
                }
               // (ex. number == 6645, thisNumber == 7399) -> 0699, 1699, ... 로 넘어가야함
                break;
            }
        }
        return hundredsCount;
    }

    private static int countClapOnTensPlace(int number) {
        int tensCount = 0;
        int thisNumber;
        for (int i = 3; i <= 9 ; i+=3) {
            int thousandHundredsPlace;
            for(thousandHundredsPlace = 0; thousandHundredsPlace <= 99; thousandHundredsPlace++) {
                thisNumber = thousandHundredsPlace*100 + i*10 + 9;
                if(thisNumber <= number) {
                    tensCount+=10;
                    continue;
                }
                //ex. number == 6639, thisNumber == 6645
                if (thisNumber/10 == number/10) {
                    tensCount+=(number%10+1);
                }
                break;
            }
        }
        return tensCount;
    }

    private static int countClapOnOnesPlace(int number) {
        int onesCount = 0;
        int thisNumber;
        int maxTensPlace = number/10;
        for (int i = 3; i <= 9 ; i+=3) {
            int thousandHundredTensPlace;
            for(thousandHundredTensPlace = 0; thousandHundredTensPlace <= 999; thousandHundredTensPlace++) {
                thisNumber = thousandHundredTensPlace*10 + i;
                if(thisNumber <= number) {
                    onesCount+=1;
                    continue;
                }
                break;
            }
        }
        return onesCount;
    }

}
