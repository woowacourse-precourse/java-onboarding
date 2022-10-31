# Solution: bunsung92

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
> oomm 의 중복이 제거됨
3. "browoaaon"
> nn 의 중복이 제거됨
4. "browoon"
> aa 의 중복이 제거됨
5. "brown"
> oo 의 중복이 제거됨

***
## `cursor` 를 사용
- why?
  - `현재 값`과 `다음 값`을 비교함
- 같으면?
  - `substring` 을 이용해서 문자열을 잘라냄.
- 잘라낸 다음 커서를 현재 위치 이전으로 돌림.
- 다르면?
  - cursor 를 다음으로 이동
  - cursor 의 최종 값에 1을 더한 값이 입력된 문자열의 총 길이를 초과하면 종료
- 최종 값 반환

### Commit
- [x] feat: add cursor and substring