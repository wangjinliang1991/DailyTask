## 限流框架
### 应用场景
首先要设置限流规则，配置到配置文件中，demo配置如下
```yaml
configs:
- appId: app-1
    limits:
    - api: /v1/user
      limit: 100
    - api: /v1/order
      limit: 50
- appId: app-2
    limits:
    - api: /v1/user
      limit: 50
    - api: /v1/order
      limit: 50
```

收到接口请求，应用将请求发送给限流框架，限流框架告诉应用，接口请求是允许继续处理，还是出发限流熔断。
框架代码的demo
```java
String appId = "app-1";//调用方APP-ID
String url = "http://www.eudemon.com/v1/user/12345";//请求url
RateLimiter rateLimiter = new RateLimiter();
boolean passed = rateLimiter.limit(appId,url);
if (passed){
    //放行接口请求，继续后续的处理
}else{
    //接口请求被限流
}
```

结合刚才的demo，从使用角度说，限流框架包含两部分功能：配置限流规则和提供编程接口RateLimiter类验证请求是否被限流。
