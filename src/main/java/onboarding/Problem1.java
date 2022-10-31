package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore=0, crongScore=0; // 점수 저장 변수

        int pobiStrSize=(pobi.get(0)+"").length(), crongStrSize=(crong.get(0)+"").length(); // 페이지 문자열 길이 저장

        // 배열을 순회하면서 더 큰 점수로 갱신
        for(int i=0;i<pobi.size();i++){
            int pobiPlus = 0, pobiMul = 1; // pobi 점수 변수
            int crongPlus=0, crongMul=1; // crong 점수 변수
            String strNumPobi = pobi.get(i)+""; // pobi의 i번째 페이지 번호 문자열로 만들기
            String strNumCrong = crong.get(i)+"";  // crong의 i번째 페이지 번호 문자열로 만들기

            // pobi(crong)의 페이지 번호 문자열 길이가 모두 동일하지 않은경우
            if(strNumPobi.length()!=pobiStrSize || strNumCrong.length()!=crongStrSize){
                return -1;
            }

            // pobi의 i번째 페이지 번호의 각 자리 숫자를 모두 더하고, 모두 곱한다.
            for(int j=0;j<strNumPobi.length();j++){
                pobiPlus+=strNumPobi.charAt(j)-'0';
                pobiMul*=strNumPobi.charAt(j)-'0';
            }
            // crong의 i번째 페이지 번호의 각 자리 숫자를 모두 더하고, 모두 곱한다.
            for(int j=0;j<strNumCrong.length();j++){
                crongPlus+=strNumCrong.charAt(j)-'0';
                crongMul*=strNumCrong.charAt(j)-'0';
            }

            // 큰 점수로 갱신하기
            pobiScore = Math.max(pobiScore, Math.max(pobiPlus, pobiMul));
            crongScore = Math.max(crongScore, Math.max(crongPlus, crongMul));
        }

        int answer = -1;

        if(pobiScore==crongScore) answer=0; // 동점
        else if(pobiScore>crongScore) answer=1; // pobi 승
        else if(pobiScore<crongScore) answer=2; // crong 승

        return answer;
    }
}