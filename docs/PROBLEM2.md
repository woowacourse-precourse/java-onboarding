# 프리코스 1주차 - 온보딩 - 암호 해독


## ✅ 기능 목록
- [X] 중복된 문자열 제거
- [X] 중복된 문자열이 없을 때 까지 제거 과정 반복
- [X] 결과 반환

## 🚨 유의 사항
- [X] 모든 문자가 동일한 문자열이 들어오는 경우
- [X] 모든 문자가 다른 문자열이 들어오는 경우
- [X] 길이가 1인 문자열이 들어오는 경우

## 📝 커밋 메세지
&nbsp;feat : 기능 구현  
&nbsp;mod  : 기능 수정  
&nbsp;docs : ReadME 수정  
&nbsp;refactoring : 리팩토링  
&nbsp;test : 커스텀 테스트



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
