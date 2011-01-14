FrontlineSMS Distribution Builder
=================================
This is the parent project for FrontlineSMS which allows you to build distributable bundles including the FrontlineSMS core and standard plugins.

If you are adding a plugin to the project, it should be added in the `<dependencies/>` section of the pom.xml.


Building for Windows
--------------------
A Java-based bundle can be built using the following command:
    mvn clean package
The package should then be available at `target/FrontlineSMS-<version>-windows-jet.zip`

Building a Windows installer requires you to have [Excelsior JET](www.excelsior-usa.com/jet.html) installed.  To build the installer, run:
    mvn clean package net.frontlinesms.build:maven-jetpackager-plugin:jetbuild


Building for Mac
----------------
If you are using OS X, a Mac disc image (.dmg) containing an executable .package can be built by running:
    mvn clean package mvn clean package net.frontlinesms.build:maven-osxappbundle-plugin:bundle


Building for Linux
------------------
There are different Linux packages for different architectures.  To build them all, run:
    mvn clean package
The packages can be found in `target/FrontlineSMS-<version>_linux_<architecture>-dist.zip`
