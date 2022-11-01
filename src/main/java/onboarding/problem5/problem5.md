### problem5 기능 명세서

### Bank Class
| 이름 | 기능 | 
| --- | --- | 
| bankInit | 은행(LinkedHashMap)에 각 지폐와 동전별 초기 데이터 삽입 함수 |
| exchangeMoney | 각 지폐와 동전별 money 변환 함수 <br/> 개수 Map에 저장 |
| getExchangeResult | 각 지폐와 동전별 개수 반환 함수 |


### Problem5.java
- 1. Bank 인스턴스 객체를 생성하여 [ 오만원, 만원, 오천원, 천원...] 지폐를 초기화(세팅) 해줍니다.
- 2. 각 지폐와 동전으로 변환된 값을 HashMap 에 Key(지폐|동전)-Value(개수) 형식으로 저장합니다.
- 3. 각 지폐와 동전별 Value 값을 리스트 형식으로 반환하여 구현하였습니다. 