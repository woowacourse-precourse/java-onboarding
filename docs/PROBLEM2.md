## 🚀 기능 목록

1. 인자로 받은 문자열(`cryptogram`)에 대한 유효성 검사를 실시한다.
    1. `cryptogram`의 길이가 1이상 1000이하여야 한다.
    2. `cryptogram`에는 알파벳 소문자만 포함되어야 한다.
2. 유효성 검사가 끝났다면 Stack 객체를 생성하여 push, pop, peek 메서드를 활용하여 메인 로직을 구성한다.
    1. peek로 stack의 맨 위에 있는 값이 현재 넣을려고 하는 값과 같다면 pop, 다르다면 push
3. `cryptogram` 문자열을 모두 stack에 넣거나 빼는 것을 마무리했다면 이 stack에 남아있는 문자들을 하나씩 뽑아내여 StringBuilder 버퍼에 append해준다.
    1. stack은 LIFO 구성이므로 버퍼를 reverse() 메서드를 통해 뒤집어 준 후에 String 형으로 변환시킨다.