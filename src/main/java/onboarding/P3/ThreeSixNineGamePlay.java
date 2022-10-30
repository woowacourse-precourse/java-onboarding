package onboarding.P3;

public class ThreeSixNineGamePlay {
    public static int ThreeSixNine(int num){
        int sum = 0;

        for(int i=1; i<=num; i++){
            String s = Integer.toString(i);
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
                    sum+=1;
                }
            }
        }
        return sum;
    }

}
