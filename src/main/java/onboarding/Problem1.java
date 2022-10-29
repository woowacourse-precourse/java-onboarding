package onboarding;

// 리스트 타입을 사용하기 모듈 임포트
import java.util.List;

// 문제 1 클래스
class Problem1 {
    // 1. 책을 임의로 펼친다.
    // 포비와 크롱의 임의의 책 페이지 받아오기
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 받아온 책 페이지 출력해보기
        System.out.println("pobi가 펼친 책 페이지 : " + pobi);
        System.out.println("crong이 펼친 책 페이지 : " + crong);

        return answer;
    }
}

// 프로그래밍 요구 사항
// 1. JDK 11 버전
// 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// 3. 프로그램 종료 시 "System.exit()"를 호출 X
// 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기