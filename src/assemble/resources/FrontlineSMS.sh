#!/bin/sh
# FrontlineSMS Launcher for Linux & OS-X
#
# Author: Emmanuel Kala <emkala@gmail.com>, Alex Anderson <alex@frontlinesms.com>

java -version

echo "Launching FrontlineSMS."
echo "Please wait..."

# Change to the directory hosting this script
cd `dirname $0`

# Name of the JAR file containing the main class
CLASSPATH=""

# Get all the JARs in a folder and add them to the classpath variable
buildClasspath() {
	for jar in $(ls $1/*.jar); do
	    CLASSPATH="$CLASSPATH:$jar"
	done
}

buildClasspath "lib"
buildClasspath "cp"

# Launch the application using the classpath variable we set above, and setting the
# system property java.library.path to the current directory to allow the bundled
# JNI libs to be loaded without needing to be moved to another directory.
java -Djava.library.path=. -classpath $CLASSPATH net.frontlinesms.DesktopLauncher
