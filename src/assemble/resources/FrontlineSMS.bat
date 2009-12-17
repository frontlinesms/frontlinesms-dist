@echo off
echo Launching FrontlineSMS for Windows...

REM launch the application
java -cp ${project.artifactId}-${project.version}.jar;lib/*;cp/* net.frontlinesms.DesktopLauncher