# 1주차_Problem2

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

암호문을 해독하는 클래스인 Decoder클래스를 만들었다. 입력한 문자열을 List에 Character로 저장하였고 같은 단어 탐색할때 편리할 수 있게 리스트의 맨 앞과 맨 뒤에는 null문자를 넣었다. 

```java
public class Decoder
{
    private List<Character> cryptogramList;

    public Decoder(String cryptogram)
    {
        cryptogramList= new ArrayList<>();
        cryptogramList.add('\u0000');
        for(int i = 0 ; i < cryptogram.length();i++)
        {
            cryptogramList.add(cryptogram.charAt(i));
        }
        cryptogramList.add('\u0000');
    }
}
```

이후 중복 문자를 제거하는 메소드를 만들었다 중복 문제를 제거한 결과를 이용하여 Decoder를 생성하여 리턴하고 equals 메소드를 오버 라이딩 하여 클라이언트 클래스에서 중복 제거가 발생하는지 체크할 수 있다.

```java
private boolean isSuccessive(int index)
{
    return cryptogramList.get(index-1) != cryptogramList.get(index)
            && cryptogramList.get(index) != cryptogramList.get(index+1);
}

public Decoder removeDuplicatedCharacter()
{
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < cryptogramList.size() -1;i++)
    {
        if(isSuccessive(i))
        {
            sb.append(cryptogramList.get(i));
        }
    }
    Decoder newDecoder = new Decoder(sb.toString());
    return newDecoder;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Decoder)) return false;
    Decoder decoder = (Decoder) o;
    if(decoder.cryptogramList.size() != cryptogramList.size()) return false;
    for(int i = 1; i < cryptogramList.size() -1; i++)
    {
        if(cryptogramList.get(i) != decoder.cryptogramList.get(i))
        {
            return false;
        }
    }
    return true;
}
```

클라이언트 클래스 코드, 이전 디코더의 결과와 비교해서 서로 같으면 중복 제거가 발생하지 않은것으로 판단해서 중단 후 결과를 반환하였다.

```java
public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);
        while(true)
        {
            Decoder newDecoder = decoder.removeDuplicatedCharacter();
            if(newDecoder.equals(decoder))
            {
                break;
            }

            decoder = newDecoder;
        }
        return decoder.toString();
    }
}
```