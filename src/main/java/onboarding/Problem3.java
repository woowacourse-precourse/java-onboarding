package onboarding;

public class Problem3 {
    //10의 n제곱 계산
    public static int squareTen(int figures){
        return (int)(Math.pow(10, figures-1));
    }

    //재귀적으로 계산
    public static int countFigures(int number, int figures){
        int count = 0;
        int noCount = 0;
        int figureSquareTen = squareTen(figures);

        //한 자리 수일 경우
        if(figures == 0){
            for(int i =0; i<=number; i++){
                if(i%3 == 0 & i!=0)
                    count++;
            }
            return count;
        }

        //두 자리 수 이상이면면
       if(number/figureSquareTen%3 ==0)
            noCount = number/figureSquareTen;

        for(int i = 0; i<=number/figureSquareTen; i++){
            if(i%3 == 0 & i!=noCount & i!=0){
                count += figureSquareTen;
                count += countFigures(figureSquareTen-1, figures-1);
            }else if(i == noCount& i!=0){
                count += number %figureSquareTen + 1;
                count+= countFigures(number%figureSquareTen, figures-1);
            }else if(i == number/figureSquareTen){
                count += countFigures(number%figureSquareTen, figures-1);
            }else{
                count += countFigures(figureSquareTen-1, figures-1);
            }
        }
        return count;

    }

    //clap 수 계산 method
    public static int countClap(int number){
        int count = 0;

        if((number/1000)!=0){//천의 자리 수이면
            count += countFigures(number, 4);
        }else if((number/100)!=0){
            count += countFigures(number, 3);
        }else if((number/10)!=0){
            count += countFigures(number, 2);
        }else{
            count += countFigures(number, 1);
        }

        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        answer = countClap(number);
        return answer;
    }
}
