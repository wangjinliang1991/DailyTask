## 幂等框架

使用的demo示例
```java
//====使用方式1：在业务代码中处理幂等======
// 接口调用方
Idempotence idempotence = new Idempotence();
String idempotenceId = idempotence.createId();
Order order = createOrderWithIdempotence(...,idenpotenceId);

//接口实现方
public class OrderController{
    private Idempotence idempotence;//依赖注入
    public Order createOrderWithIdempotence(...,idenpotenceId){
        //前置操作
        boolean existed = idempotence.check(idempotenceId);
        if(existed){
            //两种处理方式 1.查询order，并返回；2.返回duplication operation exception
        }
        idempotence.record(idempotenceId);
        //...执行正常业务逻辑
    }
    
    public Order createOrder(...){
        //...
    }   
}


//=========使用方式2：在框架层面处理幂等========
//接口调用方
Idempotence idempotence = new Idempotence();
String idempotenceId = idempotence.createId();
//...通过feign框架将幂等号添加到http header中...

//接口实现方
public class OrderController{
    @IdempotenceRequired
    public Order createOrder(...){
        //...
    }
}
//在AOP切面中处理幂等
@Aspect
public class IdempotenceSupportAdvice{
    @Autowired
    private Idempotence idempotence;
    
    @Pointcut("@annotation(com.xx.idempotence.annotation.IdempotenceRequired)")
    public void controllerPointcut(){
    }
    
    @Around(value="controllerPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        //从http header中获取幂等号idempotenceId
        //前置操作
        boolean existed = idempotence.check(idempotenceId);
        if(existed){
            //两种处理方式 1.查询order，并返回；2.返回duplication operation exception
        }
        idempotence.record(idempotenceId);
        
        Object result = joinPoint.proceed();
        return result;
    }
}
```
