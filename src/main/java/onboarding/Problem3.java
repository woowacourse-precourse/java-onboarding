package onboarding;

public class Problem3 {
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

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
