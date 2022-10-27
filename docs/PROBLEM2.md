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

## 구현 기능 목록

- (1) String 을 LinkedList 로 변환하는 기능
- (2) 중복 체크 기능
  - true : 같은 알파벳 소문자가 2번 이상 붙어 나열되면 중복
- (3) 중복 문자 제거 기능
  - String to char array? String to ArrayList? String to LinkedList
    - 데이터의 추가, 삭제에 효율적인 LinkedList 이용
    - [나만의 노트(노션) : 자료구조 LinkedList](https://grizzled-eoraptor-f92.notion.site/Linked-List-c6e85fa12b7a4ebe9945fb1cfe1f40e0)

- (4) LinkedList 을 String 로 변환하는 기능
