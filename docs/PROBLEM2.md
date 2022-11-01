# 기능 목록
1. cryptogram을 answer로 복제한다.
2. answer의 첫 문자부터 비교하여 새로운 문자면 cryptogram의 새 문자로서 왼쪽부터 채워넣는다.
3. 동일한 문자가 나오면 채워넣을 위치 진행을 한 칸 한 번만 되돌린다.
4. cryptogram이 answer와 일치할 때까지 1~3을 반복한 뒤 출력한다.

## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |
