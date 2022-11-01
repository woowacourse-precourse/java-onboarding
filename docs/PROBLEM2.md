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

---

### 풀이 기록
#### 생각 정리
순차적으로 만나는 중복 문자를 제거하는 일을 while 순환으로 돌려보기로 했다.

break case는 해당 순환에서 제거한 중복 문자의 수가 0일 때로 설정하면 될 것 같다.

#### 기능 목록
1. 문자열 검증
2. 문자열내 중복 문자 확인 
3. 문자열내 중복 문자 제거 
