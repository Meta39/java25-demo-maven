@echo off
@REM 下面这行是为了解决中文乱码
chcp 65001 > nul
@echo 启动exe的时候要追加 -Djavax.xml.accessExternalDTD=all 参数使用 mybatis 的 xml 文件
@echo 进入到exe目录。运行cmd，再执行chcp 65001 》 nul。防止乱码。然后再执行：XXX.exe -Djavax.xml.accessExternalDTD=all
@echo 确保 Windows 安装了 Visual Studio Community

@echo Maven 默认使用的是系统变量JAVA_HOME，如果IDEA和系统变量不一致，则需要临时设置JAVA_HOME。
set JAVA_HOME=C:/Users/X/.jdks/graalvm-ce-25.0.1

set PACKAGE_CMD=mvn clean compile spring-boot:process-aot native:compile -DskipTests -f pom.xml
echo %PACKAGE_CMD% ......
%PACKAGE_CMD%

exit
