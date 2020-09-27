@ECHO OFF
REM Placeholder for people used to run.bat from older version redirecting them to read the readme
echo.
echo =======================================================================================
echo 

@rem ##########################################################################
set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%
set JAR_APP1=%DIRNAME%target\WfhScheduler-0.0.1-SNAPSHOT-jar-with-dependencies.jar
set JAR_APP2=%DIRNAME:~0,-13%SeleniumMavenTemplate\WfhScheduler.jar

@rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

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
@echo on
call mvn clean package assembly:single
call xcopy  "%JAR_APP1%" "%JAR_APP2%" /E/D /Y
@rem echo "%DIRNAME_APP2%"

:fail
@rem exit fail

