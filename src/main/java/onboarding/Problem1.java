package onboarding;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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

        //maxValue를 담을 배열 생성
        ArrayList<Integer>pobiMaxArray = new ArrayList<Integer>();
        ArrayList<Integer>crongMaxArray = new ArrayList<Integer>();

        //CASE pobi
        for(int j=0; j<pobi.size(); j++) {
            //각 페이지 번호를 담을 배열 생성
            ArrayList<Integer>tempList = new ArrayList<Integer>();

            //페이지 번호를 자리수 별로 분리하여 tempList에 add
            String tempStr = pobi.get(j).toString();
            for(int i=0; i<tempStr.length(); i++) {
                tempList.add((tempStr.charAt(i) - '0'));
            }

            int max_mul = 1;
            int max_add = 0;

            //곱셈 및 덧셈 계산
            for(int k=0; k<tempList.size(); k++) {
                max_mul *= tempList.get(k);
                max_add += tempList.get(k);
            }

            //각 계산 결과를 Max List에 저장
            pobiMaxArray.add(max_mul);
            pobiMaxArray.add(max_add);

            //tempList 초기화
            tempList.clear();
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

            int max_mul = 1;
            int max_add = 0;

            //곱셈 및 덧셈 계산
            for(int k=0; k<tempList.size(); k++) {
                max_mul *= tempList.get(k);
                max_add += tempList.get(k);
            }

            //각 계산 결과를 Max List에 저장
            crongMaxArray.add(max_mul);
            crongMaxArray.add(max_add);

            //tempList 초기화
            tempList.clear();
        }

        //최대 값 저장
        int pobiMaxNum = Collections.max(pobiMaxArray);
        int crongMaxNum = Collections.max(crongMaxArray);

        //최대 값 비교
        if(pobiMaxNum > crongMaxNum) {
            answer = 1;
        } else if (pobiMaxNum < crongMaxNum) {
            answer = 2;
        } else if (pobiMaxNum == crongMaxNum) {
            answer = 0;
        }

        //예외 Case 처리 : 페이지 번호 차가 1이 넘는 경우
        if ((pobi.get(1) - pobi.get(0) > 1) || (crong.get(1) - crong.get(0) > 1)) {
            answer = -1;
        }

        return answer;
    }
}