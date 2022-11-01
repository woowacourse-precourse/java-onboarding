package onboarding;

public class Problem3 {
    private static Integer check369(int num){
        String numDigit = Integer.toString(num);
        Integer count = 0;
        for(int index=0;index<numDigit.length();index++){
            if(numDigit.charAt(index)=='3'||numDigit.charAt(index)=='6'||numDigit.charAt(index)=='9'){
                count +=1;
            }
        }

        return count;
    }
    private static Integer clap(int number){
        int clapCount = 0;

        for(int num = 1;num<=number;num++){
            clapCount += check369(num);
        }

        return clapCount;
    }
    public static int solution(int number) {
        int answer = 0;
        answer = clap(number);
        return answer;
    }
}
