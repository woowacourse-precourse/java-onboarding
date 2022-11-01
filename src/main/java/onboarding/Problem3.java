package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        String numStr = String.valueOf(number);
        int len = numStr.length();


        for(int i=0; i<len; i++){
            int prevhead = (i == 0) ? 0 : Integer.parseInt(numStr.substring(0,i));

            int head = numStr.charAt(i) - '0';

            if(head%3 == 0 && head != 0){
                if(i<len -1) answer += Integer.parseInt(numStr.substring(i+1));
                answer +=1;
            } // 현재 자릿수로 인해 발생하는 박수 수

            int power = len - 1 -i;

            if(head > 0) answer += (head - 1)/3 * Math.pow(10, power); // 자릿수는 같지만 number보다 작은 수들의 박수 수

            answer += 3*Math.pow(10, power)*prevhead; // 상위 자릿수에서 발생하는 현재 자릿수의 박수 수
        } // 각 자릿수 마다 반복

        return answer;
    }


}
