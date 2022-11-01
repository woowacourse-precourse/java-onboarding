package onboarding;

public class Problem3 {
    public  int solution(int number) {
       return count(number);
    }

    private int count(int number){
        int result = 0;

        for(int cnt = 1; cnt <= number;cnt++){
            String str = String.valueOf(cnt);

            for(int i = 0; i<str.length();i++){
                char chk = str.charAt(i);

                if(chk == '3'|| chk =='6'||chk == '9'){
                    result = result + 1;
                }
            }
        }
        return result;
    }
}
