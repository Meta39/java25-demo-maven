# java25-demo-maven
java25-demo-maven

## spring-boot-demo
### 注意事项
1.如果在windows需要生成exe，则需要使用 GraalVM JDK 25、 Visual Studio2022及以上
2.右边 maven 执行顺序mvn clean compile spring-boot:process-aot native:compile -DskipTests
3.双击 exe 启动，控制台输出start success.表示启动成功
4.如果需要扫描xml文件夹，则启动时需要增加参数：