容器映射：
在创建容器的时候，将宿主机的目录与容器内的目录进行映射，这样我们就可以通过修改宿主机某个目录的文件从而去影响容器。  
创建容器 添加-v参数 后边为 宿主机目录:容器目录，例如：  
`docker run -di -v /usr/local/myhtml:/usr/local/myhtml --name=mycentos3 centos:7`

容器挂载arthas：
1. 下载arthas：
`curl -O https://alibaba.github.io/arthas/arthas-boot.jar && java -Dfile.encoding=UTF-8 -jar arthas-boot.jar`
&& 之前的部分是下载 Arthas，之后的部分是启动 Arthas。

也可以直接下载`curl -O https://alibaba.github.io/arthas/arthas-boot.jar `
之后`docker cp arthas busi-gsm-dmctest:/opt/busi-gsm/.`到容器中

### trace
方法内部调用路径，并输出方法路径上的每个节点上耗时
用法：
- 只想看到某个方法的rt大于某个时间之后的trace结果 `trace *StringUtils isBlank '#cost>100'` 超过100ms的时候，才会输出trace的结果
- 次数限制：`trace xxx 方法  -n 3 '#cost > 5'`

### tt
记录下当时方法调用的所有入参和返回值、抛出的异常TimeTunnel 
- -t记录每次执行情况，-n记录的次数 ` tt -t demo.MathGame primeFactors -n 3`
- `tt -i 1003` 具体调用详情，出入参
详见`https://alibaba.github.io/arthas/tt.html`



