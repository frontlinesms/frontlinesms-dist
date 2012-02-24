#!/bin/sh
# FrontlineSMS Launcher for Linux & OS-X
#
# Author: Emmanuel Kala <emkala@gmail.com>, Alex Anderson <alex@frontlinesms.com>

echo "[ Starting FrontlineSMS ]"
echo "Please wait..."
echo

echo "[ Java version ]"
java -version
echo

# Change to the directory hosting this script
echo "[ Setting working directory to: $0 ]"
cd `dirname $0`
echo

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

# Build ports list
echo "[ Configuring serial ports ]"
echo "By default your operating system may not see modems on ports other than /dev/tty*"
echo "Add port names to file 'serialports' if you want them visible to FrontlineSMS."
PORTS=""
while read port; do
	if [ -n "$port" ]; then
		if [ -n "$PORTS" ]; then
			PORTS="$PORTS:"
		fi
		PORTS="$PORTS$port"
	fi
done < 'serialports'
echo "Adding serial ports: $PORTS"
echo

# Launch the application using the classpath variable we set above, and setting the
# system property java.library.path to the current directory to allow the bundled
# JNI libs to be loaded without needing to be moved to another directory.
echo "[ Launching Java ]"
java -Djava.library.path=. -Dgnu.io.rxtx.SerialPorts="$PORTS" -classpath $CLASSPATH net.frontlinesms.DesktopLauncher

echo
echo "[ FrontlineSMS exited ]"
echo "See you next time! \o/"
echo

