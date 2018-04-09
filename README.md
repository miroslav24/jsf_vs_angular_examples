# jsv_vs_angular_examples
Contains examples of JSF and Angular applications

Steps how to run projects:
1. for JSF and Angular backend
	- install JDK
	- install maven
	- install your favourite IDE
	- run "mvn install" in particular project root directory to build war file
	- download wildfly-10.1.0.Final at http://wildfly.org/downloads . You can use default configuration - port 8080
	- in Intellij Idea to open project open pom.xml and open it as project
2. for angular frontend
	- download and install nodejs: https://nodejs.org/en/download/ (during instalation install npm package manager)
	- run in command line (if you are behind proxy) 
	  npm config set proxy http://Ivanis.Miroslav:Password@[proxy_ip]:[proxy_port]
	- download visual studio code https://code.visualstudio.com/ + plugins: debugger for chrome - for debugging, move TS (for moving files with updating references)
	- in front end root directory run npm install for installing external libraries. Then run npm start to start app on port 4200
	- you can open project in Visual studio code by opening front end root directory.