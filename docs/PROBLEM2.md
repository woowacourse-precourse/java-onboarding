## 🚀 주어진 문제

<details>
    <summary> <b> 기능 요구 사항</b> </summary>
    <div markdown="1">
암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
    <br>
    </div>
</details>

<details>
    <summary> <b> 제한사항 </b> </summary>
    <div markdown="1">
- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.
    <br>
    </div>
</details>

<details>
    <summary> <b> 실행 결과 예시 </b> </summary>
    <div markdown="1">

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |

<br>
</div>
</details>

<br>

## 👩🏻‍💻 문제 해결하기
### 구현할 기능 목록

- [x] 문자열을 char로 분리해서 리스트에 넣기
- [x] 리스트에서 연속하는 중복 문자들의 인덱스들을 찾기 (반복)
- [x] 해당 인덱스들을 리스트에서 삭제하기 (반복)
- [x] 리스트에 남은 문자들 모아서 반환하기