package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // 1. 모든 정보 확인
        int totalSize = forms.size();

        for(int idx=0; idx<totalSize; idx++)
        {
            String email = forms.get(idx).get(0);
            String nicName = forms.get(idx).get(1);

            // 각 정보 결과 확인
            System.out.println("이메일 : " + email + ", 닉네임 : " + nicName);
        }

        return answer;
    }
}

// 기능 요구 사항
// 1. 모든 정보 확인
// 2. 닉네임 중복 체크
// 3. 중복 닉네임의 이메일 결과 리스트에 저장
// 4. 결과 리스트 내 정렬 & 중복 확인
// 5. 제한사항

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// 3. 프로그램 종료 시 "System.exit()"를 호출 X
// 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기