package onboarding;

class IntegerToStringArray{
    public String[] toStringArray(int number){
        return Integer.toString(number).split("");
    }
}

class CountClapGame{
    IntegerToStringArray integerToStringArray = new IntegerToStringArray();

    public int countInArrayClap(int number){
        int count = 0;
        String[] array = integerToStringArray.toStringArray(number);
        for (String st : array) {
            if(st.equals("3") || st.equals("6") || st.equals("9")){
                count++;
            }
        }
        return count;
    }

    public int countClap(int number){
        int cnt = 0;
        for(int i=1;i<=number;i++){
            if(i < 10){
                if(i == 3 || i == 6 || i == 9){
                    cnt++;
                }
            } else{
                cnt += countInArrayClap(i);
            }
        }
        return cnt;
    }
}

public class Problem3 {

    private final static CountClapGame countClapGame = new CountClapGame();

    public static int solution(int number) {
        return countClapGame.countClap(number);
    }
}
