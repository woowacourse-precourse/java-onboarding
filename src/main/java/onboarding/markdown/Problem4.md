# 1주차_Problem4

## 🚀 기능 요구 사항

어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.

엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.

| A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Z | Y | X | W | V | U | T | S | R | Q | P | O | N | M | L | K | J | I | H | G | F | E | D | C | B | A |

### 제한사항

- word는 길이가 1 이상 1,000 이하인 문자열이다.
- 알파벳 외의 문자는 변환하지 않는다.
- 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.

### 실행 결과 예시

| word | result |
| --- | --- |
| "I love you" | "R olev blf" |

각 문자를 변환하기 위해서 map을 이용하고 변환기 역할을 하는 Encoder클래스를 만들었다. 생성자를 통해 Encoder를 생성 할 때, 모든 알파벳 문자와 맞는 변환 문자를 매핑하기 위해 initEncoder() 메소드도 정의 하였다.

```java
public class Encoder
{
    private static final int SIZE=26;
    private static final char LOWER_CHAR_A= 'a';
    private static final char LOWER_CHAR_Z = 'z';
    private static final char UPPER_CHAR_A = 'A';
    private static final char UPPER_CHAR_Z = 'Z';
    private HashMap<Character, Character> map;
    private void initEncoder()
    {
        for(int i = 0 ; i < SIZE; i++)
        {
            addCharacter((char)(LOWER_CHAR_A + i),(char)(LOWER_CHAR_Z-i));
            addCharacter((char)(UPPER_CHAR_A + i),(char)(UPPER_CHAR_Z-i));
        }
    }
    private void addCharacter(Character key,Character value)
    {
        if(map.containsKey(key))
        {
            map.remove(key);
        }
        map.put(key,value);
    }
    public Encoder()
    {
        map = new HashMap<>();
        initEncoder();
    }
}
```

이후 입력된 단어를 알맞는 변환 문자로 바꾸는 함수를 만들었다. 변환 대상이 아닌 문자는 그대로 반환한다.

```java
public String encode(String word)
{
    StringBuilder sb = new StringBuilder();
    for(int i = 0 ; i < word.length();i++)
    {
        char key = word.charAt(i);
        char value = map.containsKey(key) ? map.get(key) : key;
        sb.append(value);
    }
    return sb.toString();
}
```

변환하는 방법에 Map을 사용하지 않고 규칙성같은 다른 방법을 찾으려 했지만 떠오르지 않았다.