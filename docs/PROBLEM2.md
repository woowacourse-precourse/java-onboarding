## 🛠️ 문제 2번 기능 목록

### `List<String> cryptogramList`

1. 매개변수로 들어온 문자열 cryptogram을 List 형태로 바꿔서 저장합니다.
2. String 클래스의 split(””)을 이용하면 문자열을 “” 단위로 나눠서 배열로 만들 수 있습니다.
3. Arrays.asList()를 사용해서 2번에서 만든 배열을 List타입으로 만듭니다.

### 중복되는 문자열 제거

```java
for(int i = 1; i < cryptogramList.size(); i++) {
	  if(cryptogramList.get(i - 1).equals(cryptogramList.get(i))) {
	      cryptogramList.remove(i);
	      cryptogramList.remove(i - 1);
	      i -= 2;
	  }
}
```

1. cryptogramList의 크기만큼 반복문을 실행합니다.
2. 시작 인덱스를 1부터 진행하여 이전 인덱스에 있는 문자열과 같은지 비교합니다.
3. 2번과정에서 같다면 cryptogramList에서 해당 인덱스 2개의 문자열을 제거합니다.
4. 반복문이 끝나고 실행되는 증감연산자 i++를 고려하여 i -= 2를 해줍니다.


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
