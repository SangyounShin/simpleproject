## 프로젝트 시작 전 준비사항
### - lombok 설치
lombok 이 로컬 PC에 설치가 되어있지 않다면 아래 사이트를 참고하여 lombok 설치 진행

http://www.libqa.com/wiki/105


## 초기 데이터 명세

### API 호출의 기본이 되는 SensorDataRequestDTO, SensorDataSearchDTO 의 구조는 아래와 같다.
```
deviceId : IoT 센서 device 별 고유 ID
serviceId : IoT 센서 사업자 service 별 ID
sensorCode : 센서에서 전달하는 데이터 
```

#### 초기 데이터

| device id | service id | sensor code |
| --- | --- | --- |
| D0001 | S0001 | 0000111001 |
| D0002 | S0001 | 0000111022 |
| D0002 | S0001 | 000011555 |
| D0003 | S0002 | 0000111111	 |
| D0004 | S0002 | 0000111999 |
| D0005 | S0003 | 22220111001 |
| D0006 | S0004 | 990dasd111001 |


## 주요 API 명세
### - SensorData 추가

| URL | Method type |
| --- | --- |
| /api/addData | POST |

  - Request body (JSON)

ex)

```
{
	"deviceId": "KR00001",
	"serviceId": "S00001",
	"sensorCode": "123123491894571289371983"
}
```

### - SensorData 조회
#### 1. deviceId 조회

| URL | Method type |
| --- | --- |
| /api/search/deviceId/{id} | GET |

ex)

http://localhost:8080/api/search/deviceId/D0002

```
[
    {
        "deviceId": "D0002",
        "serviceId": "S0001",
        "sensorCode": "0000111022"
    },
    {
        "deviceId": "D0002",
        "serviceId": "S0001",
        "sensorCode": "000011555"
    }
]
```

#### 2. serviceId 조회

| URL | Method type |
| --- | --- |
| /api/search/serviceId/{id} | GET |

ex)

http://localhost:8080/api/search/serviceId/S0002

```
[
    {
        "deviceId": "D0003",
        "serviceId": "S0002",
        "sensorCode": "0000111111"
    },
    {
        "deviceId": "D0004",
        "serviceId": "S0002",
        "sensorCode": "0000111999"
    }
]
```

#### 3. 생성날짜 별 조회


| URL | Method type |
| --- | --- |
| /api/search/date/{yyyyMMdd} | GET |
  
  - yyyyMMdd 에 default 를 넣으면 5분전 데이터 ~ 현재까지 조회

ex)

http://localhost:8080/api/search/date/20190520

```
[
    {
        "deviceId": "KR00001",
        "serviceId": "S00001",
        "sensorCode": "123123491894571289371983"
    },
    {
        "deviceId": "D0006",
        "serviceId": "S0004",
        "sensorCode": "990dasd111001"
    },
    {
        "deviceId": "D0005",
        "serviceId": "S0003",
        "sensorCode": "22220111001"
    },
    {
        "deviceId": "D0003",
        "serviceId": "S0002",
        "sensorCode": "0000111111"
    },
    {
        "deviceId": "D0004",
        "serviceId": "S0002",
        "sensorCode": "0000111999"
    },
    {
        "deviceId": "D0002",
        "serviceId": "S0001",
        "sensorCode": "000011555"
    },
    {
        "deviceId": "D0002",
        "serviceId": "S0001",
        "sensorCode": "0000111022"
    },
    {
        "deviceId": "D0001",
        "serviceId": "S0001",
        "sensorCode": "0000111001"
    }
]
```
