@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  epic-hackathon-api startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and EPIC_HACKATHON_API_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS="-Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager"

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\epic-hackathon-api-1.0-SNAPSHOT.jar;%APP_HOME%\lib\platform-connector-spring-boot-1.0.11.jar;%APP_HOME%\lib\platform-connector-core-1.0.11.jar;%APP_HOME%\lib\log4j-slf4j-impl-2.9.1.jar;%APP_HOME%\lib\metrics-jvm-3.2.6.jar;%APP_HOME%\lib\metrics-spring-3.1.3.jar;%APP_HOME%\lib\spring-boot-starter-webflux-2.0.1.RELEASE.jar;%APP_HOME%\lib\nio-multipart-parser-1.1.0.jar;%APP_HOME%\lib\spring-boot-starter-test-2.0.1.RELEASE.jar;%APP_HOME%\lib\json-path-2.4.0.jar;%APP_HOME%\lib\dropwizard-metrics-influxdb-1.2.2.jar;%APP_HOME%\lib\dropwizard-metrics-1.0.0.jar;%APP_HOME%\lib\metrics-influxdb-1.2.2.jar;%APP_HOME%\lib\metrics-healthchecks-3.1.2.jar;%APP_HOME%\lib\metrics-annotation-3.1.2.jar;%APP_HOME%\lib\nio-stream-storage-1.1.3.jar;%APP_HOME%\lib\dropwizard-lifecycle-1.0.0.jar;%APP_HOME%\lib\dropwizard-jackson-1.0.0.jar;%APP_HOME%\lib\kafka-clients-0.11.0.0.jar;%APP_HOME%\lib\metrics-core-3.2.6.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\spring-boot-starter-web-services-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-actuator-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-web-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-json-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-test-autoconfigure-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-test-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-actuator-autoconfigure-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-actuator-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-boot-2.0.1.RELEASE.jar;%APP_HOME%\lib\spring-ws-core-3.0.1.RELEASE.jar;%APP_HOME%\lib\spring-xml-3.0.1.RELEASE.jar;%APP_HOME%\lib\spring-webmvc-5.0.5.RELEASE.jar;%APP_HOME%\lib\spring-context-5.0.5.RELEASE.jar;%APP_HOME%\lib\httpasyncclient-4.1.4.jar;%APP_HOME%\lib\reactor-extra-3.1.6.RELEASE.jar;%APP_HOME%\lib\logstash-logback-encoder-4.10.jar;%APP_HOME%\lib\cglib-2.2.jar;%APP_HOME%\lib\groovy-all-2.4.14.jar;%APP_HOME%\lib\log4j-jul-2.9.1.jar;%APP_HOME%\lib\log4j-core-2.9.1.jar;%APP_HOME%\lib\log4j-api-2.9.1.jar;%APP_HOME%\lib\consul-client-0.16.3.jar;%APP_HOME%\lib\converter-jackson-2.0.2.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.9.5.jar;%APP_HOME%\lib\jackson-module-afterburner-2.7.6.jar;%APP_HOME%\lib\jackson-datatype-joda-2.7.6.jar;%APP_HOME%\lib\jackson-datatype-guava-2.7.6.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.9.5.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.9.5.jar;%APP_HOME%\lib\jackson-databind-2.9.5.jar;%APP_HOME%\lib\vault-java-driver-3.0.0.jar;%APP_HOME%\lib\client-java-util-0.1.jar;%APP_HOME%\lib\cglib-nodep-3.2.5.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.8.7.jar;%APP_HOME%\lib\retrofit-2.1.0.jar;%APP_HOME%\lib\trigga-1.1.2.jar;%APP_HOME%\lib\disruptor-3.3.7.jar;%APP_HOME%\lib\spring-oxm-5.0.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-reactor-netty-2.0.1.RELEASE.jar;%APP_HOME%\lib\hibernate-validator-6.0.9.Final.jar;%APP_HOME%\lib\spring-webflux-5.0.5.RELEASE.jar;%APP_HOME%\lib\spring-web-5.0.5.RELEASE.jar;%APP_HOME%\lib\system-rules-1.16.1.jar;%APP_HOME%\lib\junit-4.12.jar;%APP_HOME%\lib\assertj-core-3.9.1.jar;%APP_HOME%\lib\mockito-core-2.15.0.jar;%APP_HOME%\lib\hamcrest-library-1.3.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\jsonassert-1.5.0.jar;%APP_HOME%\lib\spring-test-5.0.5.RELEASE.jar;%APP_HOME%\lib\spring-aop-5.0.5.RELEASE.jar;%APP_HOME%\lib\spring-beans-5.0.5.RELEASE.jar;%APP_HOME%\lib\spring-expression-5.0.5.RELEASE.jar;%APP_HOME%\lib\spring-core-5.0.5.RELEASE.jar;%APP_HOME%\lib\xmlunit-core-2.5.1.jar;%APP_HOME%\lib\httpcore-nio-4.4.10.jar;%APP_HOME%\lib\httpclient-4.5.6.jar;%APP_HOME%\lib\httpcore-4.4.10.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\reactor-netty-0.7.6.RELEASE.jar;%APP_HOME%\lib\reactor-core-3.1.6.RELEASE.jar;%APP_HOME%\lib\asm-3.1.jar;%APP_HOME%\lib\dropwizard-validation-1.0.0.jar;%APP_HOME%\lib\dropwizard-util-1.0.0.jar;%APP_HOME%\lib\guava-22.0.jar;%APP_HOME%\lib\jsr305-3.0.1.jar;%APP_HOME%\lib\jackson-annotations-2.9.0.jar;%APP_HOME%\lib\jackson-core-2.9.5.jar;%APP_HOME%\lib\commons-lang3-3.4.jar;%APP_HOME%\lib\client-java-api-0.1.jar;%APP_HOME%\lib\snakeyaml-1.19.jar;%APP_HOME%\lib\commons-codec-1.10.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\okhttp-ws-2.7.5.jar;%APP_HOME%\lib\log4j-1.2.17.jar;%APP_HOME%\lib\okhttp-3.3.0.jar;%APP_HOME%\lib\frigga-0.18.0.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.0.1.RELEASE.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\commons-io-2.5.jar;%APP_HOME%\lib\hibernate-validator-5.2.4.Final.jar;%APP_HOME%\lib\validation-api-2.0.1.Final.jar;%APP_HOME%\lib\jboss-logging-3.3.2.Final.jar;%APP_HOME%\lib\classmate-1.3.4.jar;%APP_HOME%\lib\json-smart-2.3.jar;%APP_HOME%\lib\byte-buddy-1.7.9.jar;%APP_HOME%\lib\byte-buddy-agent-1.7.9.jar;%APP_HOME%\lib\objenesis-2.6.jar;%APP_HOME%\lib\android-json-0.0.20131108.vaadin1.jar;%APP_HOME%\lib\swagger-annotations-1.5.12.jar;%APP_HOME%\lib\logging-interceptor-2.7.5.jar;%APP_HOME%\lib\okhttp-2.7.5.jar;%APP_HOME%\lib\gson-2.6.2.jar;%APP_HOME%\lib\joda-time-2.9.4.jar;%APP_HOME%\lib\error_prone_annotations-2.0.18.jar;%APP_HOME%\lib\j2objc-annotations-1.1.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.14.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.22.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.22.Final.jar;%APP_HOME%\lib\netty-handler-4.1.22.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.22.Final.jar;%APP_HOME%\lib\accessors-smart-1.2.jar;%APP_HOME%\lib\okio-1.8.0.jar;%APP_HOME%\lib\jetty-server-9.3.9.v20160517.jar;%APP_HOME%\lib\javax.el-3.0.0.jar;%APP_HOME%\lib\lz4-1.3.0.jar;%APP_HOME%\lib\snappy-java-1.1.2.6.jar;%APP_HOME%\lib\netty-codec-socks-4.1.22.Final.jar;%APP_HOME%\lib\netty-codec-4.1.22.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.22.Final.jar;%APP_HOME%\lib\netty-transport-4.1.22.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.22.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.22.Final.jar;%APP_HOME%\lib\netty-common-4.1.22.Final.jar;%APP_HOME%\lib\asm-5.0.4.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\jetty-http-9.3.9.v20160517.jar;%APP_HOME%\lib\jetty-io-9.3.9.v20160517.jar;%APP_HOME%\lib\jetty-util-9.3.9.v20160517.jar;%APP_HOME%\lib\micrometer-core-1.0.3.jar;%APP_HOME%\lib\HdrHistogram-2.1.10.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\tomcat-embed-websocket-8.5.29.jar;%APP_HOME%\lib\tomcat-embed-core-8.5.29.jar;%APP_HOME%\lib\tomcat-embed-el-8.5.29.jar;%APP_HOME%\lib\tomcat-annotations-api-8.5.29.jar;%APP_HOME%\lib\spring-jcl-5.0.5.RELEASE.jar;%APP_HOME%\lib\reactive-streams-1.0.2.jar

@rem Execute epic-hackathon-api
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %EPIC_HACKATHON_API_OPTS%  -classpath "%CLASSPATH%" com.tgt.epic.EpicHackathonApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable EPIC_HACKATHON_API_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%EPIC_HACKATHON_API_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
