## 기능 정리

- [x] 길이가 2이상인 소문자 알파벳의 패턴을 찾아주는 정규표현식(`regex`) matcher를 만드는 기능
- [x] 문자열의 중복을 없애는 기능
  - 중복 제거 : 빈 문자열로 바꿔준다는 것
- [x] 문자열의 중복이 없어질 때까지 중복을 없애는 기능
- [x] 예외 처리 기능
  - [x] 영어 소문자만 들어오는지 확인하는 기능
  - [x] 문자열 길이가 1이상 1000이하인지 확인해주는 기능

<br>

## 생각해봐야할 것들

1. `regex`의 성능

   - Java11 docs `Pattern`에 대해 본 결과 regex pattern이 1회용인지, 재사용 가능성이 있는지에 따라서 코드를 고려해야 한다고 함. 현재 여기서는 `eraseSuccessiveCharacters` method가 `Pattern`을 사용하고, `eraseSuccessiveCharactersUntilUnchanged` method가 그런 `eraseSuccessiveCharacters`를 여러번 호출하기에 static 상수로 선언하여 공유할 수 있게 할 것임.


<br>

## 느낀점 정리 : [My Github Blog](https://xi-jjun.github.io/2022-10-26/wootecoBackendFirstWeek)

<br>

# 아래는 원본 문서입니다

<br>

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
