package onboarding;

public class Problem3 {
    private static int[] numberOfClaps;

    public static int solution(int number) {
        return 0;
    }

    private static int isNumber369(int number){
        if(number==3 || number==6 || number==9){
            return 1;
        }
        return 0;
    }

    private static void initNumberOfClaps(int number) {
        numberOfClaps=new int[number+9]; //ArrayIndexoutofboundsexception 때문에 3,6,9를 1로 초기화 하기 위해선 +9해줘야 한다.
        numberOfClaps[3]=1;
        numberOfClaps[6]=1;
        numberOfClaps[9]=1;

        for(int i=10;i<=number;i++){
            numberOfClaps[i]=numberOfClaps[i/10]+isNumber369(i%10);
        }
    }

}
