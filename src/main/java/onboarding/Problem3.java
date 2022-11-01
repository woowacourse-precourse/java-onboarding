package onboarding;

public class Problem3 {

    public static int solution(int number) {

        int count=0;
        for(int i=1; i<number+1; i++) {
            count += check(i);
        }
        int answer = count;
        return answer;
    }

    private static int check(int num) {
        int count=0;
        String number = Integer.toString(num);
        for(int i=0; i<number.length(); i++){
            if(number.charAt(i)=='3'||number.charAt(i)=='6'||number.charAt(i)=='9') {
                count++;
            }
        }
        return count;
    }
}
