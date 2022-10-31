package onboarding;


// 숫자 number가 매개변수로 주어질 때,                              숫자 저장
//  1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록   369 게임의 박수를 카운트 해주는 함수 구현
//                                                      369게임은 10 단위로 3개씩 증가, 35라면 십의 자리 3을 0~5번 총 6번을 추가 
//                                                      같은 방식으로 자리수를 증가시키며 카운트를 구한다.
//  solution 메서드를 완성하라.



public class Problem3 {
    public static int solution(int number) {
        
        int answer = get_clapnum(number);

        return answer;
    }

    public static int get_clapnum(int num){
        //전체 바로 계산?
        //10의 단위로 끊어서 계산 해보자 ex) 10개당 3 100개당 60

        int answerNum = 0;
        
        //자릿수
        int digit = get_digit(num);
        
        answerNum = get_answer_over_ten(num, answerNum, digit);
        
        // 10 = 3 100 (10 * 3 + 10 * 3)= 60 1000(10 * 60 + 100 * 3) = 900
        
        answerNum = get_answer_one_seat(num, answerNum);       


        return answerNum;
    }

    private static int get_answer_one_seat(int num, int answerNum) {
        int oneSeat = 0;
        oneSeat = num % 10;
        //10개당 3
        //1의 자리
        if(oneSeat < 3)
            answerNum += 0;
        else if(oneSeat < 6)
            answerNum += 1;
        else if(oneSeat < 9)
            answerNum += 2;
        else if(oneSeat == 9)
            answerNum += 3;
        return answerNum;
    }

    private static int get_answer_over_ten(int num, int answerNum, int digit) {
        int temp = num;
        int numPerDigit = 3;
        for(int i=1;i<digit; i++)
        {
            int xnum = (int)Math.pow(10,i);
            temp = num/xnum;
            int x = temp % 10;
            answerNum += x * numPerDigit;
            if(x == 3 || x == 6 || x == 9)
                answerNum += (num%xnum) + 1;
            if (x < 4)
                answerNum += 0 * xnum; 
            else if (x < 7)
                answerNum += 1 * xnum; 
            else if (x < 9)
                answerNum += 2 * xnum;
            numPerDigit = numPerDigit*10 + (int)xnum*3;
        }
        return answerNum;
    }

    private static int get_digit(int num) {
        int temp = num;
        int digit = 0;
        while(temp > 0)
        {
            digit++;
            temp = temp/10;
        }
        return digit;
    }

}
