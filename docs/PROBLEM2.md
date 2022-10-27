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

## 기능 요구사항 및 체크리스트 정리(1차)

### 1. 문제풀이 알고리즘 정리
- ⬜ StringBuilder 클래스를 활용하여 입력된 문자열을 앞에서 부터 한 글자씩 더해가며 이전 문자와 동일한 문자인지 확인한다.
- ⬜ 현재 추가해야할 문자와 이전 문자가 동일하면 이전 문자를 삭제하고 다음 문자로 넘어간다.
- ⬜ 동일하지 않다면 StringBuilder 객체에 현재 문자를 추가한다.
- ⬜ 연속으로 중복된 문자들을 삭제한 결과 문자열을 반환한다.