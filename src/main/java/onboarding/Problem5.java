package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        // 제한사항
        if(money < 1 || money > 1000000)
        {
            // 돈의 액수 범위를 넘을 경우
            // System.out.println("돈의 액수 범위 제한");
            return answer;
        }

        // 결과를 저장할 임시 리스트
        List<Integer> resultList = new ArrayList<>();

        // 오만원권 교환
        int ohMan = money/50000;
        resultList.add(ohMan);

        money%=50000;

        // 만원권 교환
        int man = money/10000;
        resultList.add(man);

        money%=10000;

        // 오천원권 교환
        int ohCheon = money/5000;
        resultList.add(ohCheon);

        money%=5000;

        // 천원권 교환
        int cheon = money/1000;
        resultList.add(cheon);

        money%=1000;

        // 오백원권
        int ohBaek = money/500;
        resultList.add(ohBaek);

        money%=500;

        // 백원권
        int baek = money/100;
        resultList.add(baek);

        money%=100;

        // 오십원권
        int ohSib = money/50;
        resultList.add(ohSib);

        money%=50;

        // 십원권
        int sib = money/10;
        resultList.add(sib);

        // 일원권
        int ill = money%=10;
        resultList.add(ill);

        answer = resultList;

        return answer;
    }
}

// 기능 요구 사항
// ✔ 1. 큰 순서의 화폐권 순으로 주기
// ✔ 2. 해당 화폐권 수 저장

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// ✔ 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// ✔ 3. 프로그램 종료 시 "System.exit()"를 호출 X
// ✔ 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// ✔ 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기
