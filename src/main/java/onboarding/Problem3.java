package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int divid = number / 10;
        int remain = number % 10;

        answer += divid*3;

        if(divid == 0){
            return remain/3;
        }

        // 30,60,90 의 수 일때
        if(divid % 3 == 0 && divid /3 !=0){
            if(divid /3 == 1){
                answer += remain + 1;
            }else{
                answer = (divid/3 -1) * 13;
            }
            if(remain /3 ==1){
                answer+=1;
            } else if (remain /3 == 2) {
                answer+=2;
            }
        }else{
            if(divid/3 >=1){
                answer +=(divid/3)*10;
            }else{
                answer += remain/3;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(30));
    }
}
