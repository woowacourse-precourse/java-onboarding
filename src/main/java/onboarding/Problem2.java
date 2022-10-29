package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String result = cryptogram;
        String result2= "";

        while(true) {
            for(int i=0; i<result.length(); i++) {
                if(i==0 &&result.charAt(i) != result.charAt(i+1)) //i가 0일때
                    result2 += result.charAt(i);
                if(i==result.length()-1 && result.charAt(i) != result.charAt(i-1)) //i가 마지막원소 일때
                    result2 += result.charAt(i);
                if(i!=0 && i!=result.length()-1 && result.charAt(i) != result.charAt(i+1) && result.charAt(i-1) != result.charAt(i)) //앞과 뒤 모두 비교
                    result2 += result.charAt(i);
            }

            if(result2.equals(result)) break; //더 이상 중복이 없으면 끝내기
            result = result2;
            result2 = "";
        }

        answer = result;
        return answer;
    }
}
