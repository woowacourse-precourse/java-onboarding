package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /*
        기능 목록
        1. 각 페이지 번호가 담긴 리스트를 만든다.
        2. 리스트를 이용해 가장 큰 수를 구한다.
        3. 두 점수를 비교한다.
        4. 예외 case를 처리한다.
        */
        int answer = Integer.MAX_VALUE;

        //CASE pobi
        for(int j=0; j<pobi.size(); j++) {
            //각 페이지 번호를 담을 배열 생성
            ArrayList<Integer>tempList = new ArrayList<Integer>();

            //페이지 번호를 자리수 별로 분리하여 tempList에 add
            String tempStr = pobi.get(j).toString();
            for(int i=0; i<tempStr.length(); i++) {
                tempList.add((tempStr.charAt(i) - '0'));
            }
        }

        //CASE crong
        for(int j=0; j<crong.size(); j++) {
            //각 페이지 번호를 담을 배열 생성
            ArrayList<Integer>tempList = new ArrayList<Integer>();

            //페이지 번호를 자리수 별로 분리하여 tempList에 add
            String tempStr = crong.get(j).toString();
            for(int i=0; i<tempStr.length(); i++) {
                tempList.add((tempStr.charAt(i) - '0'));
            }
        }
        return answer;
    }
}