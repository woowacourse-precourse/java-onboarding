## 🚀 주어진 문제

<details>
    <summary> <b> 기능 요구 사항</b> </summary>
    <div markdown="1">

어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.

엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.

| A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Z | Y | X | W | V | U | T | S | R | Q | P | O | N | M | L | K | J | I | H | G | F | E | D | C | B | A |

<br>
</div>
</details>

<details>
    <summary> <b> 제한사항 </b> </summary>
    <div markdown="1">

- word는 길이가 1 이상 1,000 이하인 문자열이다.
- 알파벳 외의 문자는 변환하지 않는다.
- 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
  
    <br>
    </div>
</details>

<details>
    <summary> <b> 실행 결과 예시 </b> </summary>
    <div markdown="1">

| word | result |
| --- | --- |
| "I love you" | "R olev blf" |

<br>
</div>
</details>

<br>

## 👩🏻‍💻 문제 해결하기
### 구현할 기능 목록

- [ ] 청개구리 사전 설정하기
- [ ] 입력받은 문자열을 한 글자씩 분리하기
- [ ] 청개구리 사전을 활용하여 문자 변환하기
- [ ] 변환한 문자들을 한 문자열로 합치기