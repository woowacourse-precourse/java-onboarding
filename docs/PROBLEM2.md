
## 구현 기능 목록
- 중복 제거
  - Set으로 변환시키면서 자연스럽게 중복 제거 유도하기
    - 선택이유 고민하기 : HashSet(순서보장x, 복잡도 성능 가장 우수) 
                       vs LinkedHashSet(입력한 순서대로 데이터를 정렬)
    - [출처2](http://kwseo.github.io/2015/09/24/time-complexity-about-collections/)
    - 선택한 set 공부하기
      - [주요 기능 확인](http://www.tcpschool.com/java/java_collectionFramework_set)
      - HashSet은 hashCode() 
        - -> 동일 해시코드 여부 비교 
        - equals() -> true로 중복 저장하지 않음
- 변환 기능
  - 문자열을 배열로 변환
  - 반복문으로 set에 저장
  - set 보유 값을 반복문으로
  - 
- 

  

---
### 제거된 기능
- ~~변환하기~~
- ~~순서보장~~
  - 피곤해서 알파벱 순서가 헷갈리고 순서 보장 필요한 걸로 착각..
- ~~소문자구하기~~ && ~~길이제한~~
  - 소문자, 문자열 길이 제한(1~1000)은 구할 필요 없이 주어진 사항이므로 삭제

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

## 문제 분석 메모

### given
주어지는 암호 문자열

### when
주어지는 암호 문자열 = 연속하는 중복 문자
중복을 삭제하라

###  then
중복을 삭제한 결과 = true
== 중복 문자들을 삭제한 결과
== 문자열 - 중복 char된 문자열 또는 char

길이가 1이상 1000이하
알파벳 소문자로만 이어짐

"프로그래밍 요구사항 : 외부 라이브러리 사용하지 않는다"
자바 지원 라이브러리인지 명시 x && 1번 문제 util 제공했으므로
java.lang +java.util까지 컬렉션 사용 가능하다고 판단

list - 순서 보장o, 중복 허용
set - 순서 보장x, 중복되지 않는 집합 형태
맵 - 키 밸류 서로 다른 데이터 지정 가능

순서 보장 필요하지 않고 중복되지 않아야 하는 set 선택

[출처 - 생활코딩 보고 썼던 글](https://velog.io/@urtimeislimited/컬렉션-프레임워크)

궁금증 : 문자열 -> set집합으로 한 번에 못 전달하는가?

