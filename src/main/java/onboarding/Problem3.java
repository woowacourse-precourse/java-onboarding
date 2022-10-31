package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return step_Main(number);
    }
    private static int step_Main(int number){
        String co=Integer.toString(number);
        int answer=0;
        if(co.length() <=2) answer=step_Ten(number,number/10);
        else if(co.length() ==3) answer =step_Hundred(number,number/100);
        else if(co.length() ==4 || (number==10000)) answer= step_Thousand(number,number/1000);
        return answer;
    }
    private static int step_Ten(int number,int choice_Ten) {
        int answer=0;
        if(number < 10) return number/3;
        answer=((choice_Ten-1)-((choice_Ten-1)/3))*3+((choice_Ten-1)/3)*13+3;
        answer= choice_Ten%3 == 0  ?
                answer+(number%10+(number%10/3))+1:
                answer+(number%10)/3;
        return answer;
    }
    private static int step_Hundred(int number,int choice_Hundred) { //100의 자리
        int answer=0;
        answer=((choice_Hundred-1)-((choice_Hundred-1)/3))*60+((choice_Hundred-1)/3)*160+60;

        answer=number-choice_Hundred*100 > 9 ? //10보다 작은 경우
                answer+step_Ten(number-choice_Hundred*100,(number-choice_Hundred*100)/10):
                answer+(number-choice_Hundred*100)/3;

        answer= choice_Hundred%3 == 0 ?
                answer+(number-choice_Hundred*100)+1:
                answer;

        return answer;
    }
    private static int step_Thousand(int number,int choice_Thousand) {
        int answer=0;
        answer=((choice_Thousand-1)-((choice_Thousand-1)/3))*900+((choice_Thousand-1)/3)*1900+900;
        answer=number-choice_Thousand*1000 > 99 ? //100보다 작은 경우
                answer+step_Hundred(number-choice_Thousand*1000,(number-choice_Thousand*1000)/100):
                answer+step_Ten(number-choice_Thousand*1000,(number-choice_Thousand*1000)/10);
        answer = choice_Thousand%3 == 0 ?
                answer+(number-choice_Thousand*1000)+1:
                answer;
        return answer;
    }
}
