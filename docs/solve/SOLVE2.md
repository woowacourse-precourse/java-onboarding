### 🚀 기능 목록

####  problem2 - solution()
[요구] 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return
- removeDuplicate(): cryptogram의 연속하는 중복 문자들을 삭제 후 리턴하는 메서드
  - List\<String> newCryptogram: 입력된 문자열에서 **연속하는 중복 문자들을 제거한 문자열
  - String pre: for문에서 이전 alphabet을 저장한다.
  - for (String alphabet : cryptogram.split(""))
    - if (newCryptogram.isEmpty()): alphabet이 cryptogram의 첫 글자를 가리킬 때
      - newCryptogram에 alphabet을 넣는다.
    - if (alphabet.equals(newCryptogram.get(newCryptogram.size() - 1))): alphabet과 newCryptogram의 마지막 문자를 비교한다.
      - 일치하면 연속하는 중복 문자들임을 의미한다.
      - newCryptogram에서 마지막 문자를 제거한다.
      - 계속해서 연속할 수 있기에 pre에 alphabet을 저장하고 if문을 나온다.
    - if (pre.equals(alphabet)): pre와 alphabet를 비교한다.
      - 일치하면 연속한 중복 문자임을 의미한다.
      - newCryptogram에 alphabet를 저장하지 않고 다음 for문을 돈다
    - 위의 if문을 모두 통과하면 pre에 alphabet을 저장하고 newCryptogram에 alphabet을 넣는다.
  - newCryptogram을 String으로 변환해 리턴한다.