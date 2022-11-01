package onboarding;

public class Problem3 {

    // 1. 숫자 한 자리씩 3,6,9인지를 확인하기
    static int getClapCount(int num)
    {
        int count = 0;
        int value = 0;

        // 각 자리 숫자를 하나씩 보기
        while(num != 0)
        {
            value = num%10;

            if(value == 3 || value == 6 || value == 9)
                count += 1;

            num/=10;
        }
        
        // 총 박수 수 반환
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        int clapCount = 0;

        int curNumber = 1;

        // 2. 입력받은 숫자까지 박수 수 더하기
        while(curNumber <= number)
        {
            // 수에 따른 박수 수 구하기
            clapCount += getClapCount(curNumber);

            // 체크할 수 증가시키기
            curNumber += 1;
        }

        // 총 박수 수
        answer = clapCount;

        return answer;
    }
}

// 기능 요구 사항
// ✔ 1. 숫자 한 자리씩 3,6,9인지를 확인하기
// ✔ 2. 1번 작업 반복하며, 박수 더하기

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// ✔ 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// ✔ 3. 프로그램 종료 시 "System.exit()"를 호출 X
// ✔ 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// ✔ 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기