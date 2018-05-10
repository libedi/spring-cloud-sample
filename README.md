# spring-cloud-sample
Spring-Cloud Sample Project

** Spring Cloud **

1. Hystrix : Circuit Breaker
 - API 호출시 오류/지연 등이 발생했을 경우, 다른 API 또는 대체 메서드 실행
 - @HystrixCommand() 애노테이션으로 메서드 단위로 지정
 - 내부 프로퍼티로 설정 가능

2. Ribbon : Load Balancer
 - Client-side Load Balancer
 - 로드밸런싱을 S/W적으로 구현
 - IRule/IPing 등을 통해 API Server 별 헬스체크
 - Hystrix가 API 서버군 별 체크라면, Ribbon 은 API 서버별 체크
 - @LoadBalanced RestTemplate 또는 "Spring-Cloud-Feign" 을 통해 사용가능.

3. Eureka : API 서버 검색기(Service Discovery)
 - 각 API 서버는 하드코딩 된 서버URL/포트가 아닌 Eureka 서버를 통한 URL/포트 정보를 제공받아 사용.
 - Eureka 서버와 Eureka Client 로 구분.
 - 각 API 서버는 Eureka Client 를 구현해야 함.
 - API 서버는 로딩시 Eureka 서버로 해당 서버URL과 포트 정보를 전송하고,
 - Eureka 서버는 각 Client에게 해당 정보를 주기적으로 fetch 한다. (fetch 주기에 따라 서버 스위칭이 일어난다. 따라서 접속한 서버가 죽었을 경우, 약간의 시간동안 오류가 날 수 있음.)

4. Zuul : API Gateway
 - 위의 Hystrix, Ribbon, Eureka Client 기능을 탑재한 API Gateway.
 - Eureka Client 를 사용하기 위해서는 해당 라이브러리를 import 해줘야 한다.

5. Spring-Cloud-Feign : REST Client
 - API Gateway 내 서버들이 서로 호출시 Hystrix, Ribbon, Eureka Client 기능을 수행하도록 하는 라이브러리.
 - 인터페이스에 @FeignClient() 애노테이션을 설정하고 abstract method에 @RequestMapping() 을 수행하는 것으로 끝.(오오..)
 - Eureka Client가 구현되지 않은 외부 API 호출시, Eureka 기능을 disabled 시키고 호출할 수 있다.

6. Spring-Cloud-Config : 설정파일을 외부로!
 - 설정파일을 git repository 에 올려놓으면, Spring-Cloud-Config-Server에서 해당 내용을 불러와 각 API 서버 구동시 해당 내용을 사용할 수 있게 함.
 - 설정파일이 git에서 관리되므로, history 확인 및 pull request와 review가 가능하게 해 안정성 증대.
