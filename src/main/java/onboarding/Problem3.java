package onboarding;

public class Problem3 {
    public static int countFourFigures(int number) {
        int count = 0;
        int noCount = 0;

        //세 자리 숫자 clap 계산
        count += countThreeFigures(number % 1000);

        if(number/1000%3 ==0)
            noCount = number/1000;

        //천의 자리가 3, 6, 9 중 하나일 경우
        for(int i =0; i<=number/1000; i++){
            if(i%3 == 0 & i!=noCount & i!=0) {
                count += 1000;
                count += countThreeFigures(999);
            }else if(i == noCount & i!=0) {
                count += number % 1000 + 1;
            }else if(i == number/1000) {
                count += countThreeFigures(number % 1000);
            }else{
                count += countThreeFigures(999);
            }
        }
        count += countThreeFigures(999);

        return count;
    }

    //number가 세 자리 수일 경우
    public static int countThreeFigures(int number){
        int count = 0;
        int noCount = 0;

        if(number/100%3 == 0){
            noCount = number/100;
        }
        for(int i =0; i<=number/100; i++) {
            if (i % 3 == 0 & i != noCount & i!=0) {
                count += 100;
                count += countTwoFigures(99);
            } else if (i == noCount & i!=0) {
                count += number % 100 + 1;
            }else if(i== number/100){
                count += countTwoFigures(number%100);
            }else {
                count += countTwoFigures(99);
            }
        }

        return count;
    }

    //number가 두 자리 수일 경우
    public static int countTwoFigures(int number){
        int count = 0;
        int noCount = 0;


        if(number/10%3 == 0){
            noCount = number/10;
        }
        for(int i =0; i<=number/10; i++){
            if(i%3 == 0 & i !=noCount & i!=0) {
                count += 10;
                count+= countOneFigures(9);
            }else if(i == noCount & i!=0){
                count+= number%10+1;
                count += countOneFigures(number%10);
            }else if(i == number/10){
                count += countOneFigures(number%10);
            }else{
                count+= countOneFigures(9);
            }
        }
        return count;
    }

    //number가 한 자리 수일 경우
    public static int countOneFigures(int number){
        int count = 0;

        for(int i =0; i<=number; i++){
            if(i%3 == 0 & i!=0)
                count++;
        }
        return count;

    }

    //clap 수 계산 method
    public static int countClap(int number){
        int count = 0;

        if((number/1000)!=0){//천의 자리 수이면
            count += countFourFigures(number);
        }else if((number/100)!=0){
            count += countThreeFigures(number);
        }else if((number/10)!=0){
            count += countTwoFigures(number);
        }else{
            count += countOneFigures(number);
        }

        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        answer = countClap(number);
        return answer;
    }
}
