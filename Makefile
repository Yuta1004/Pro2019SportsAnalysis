JAVA := java
JAVAC := javac
JAVA_OPTS = -cp bin
JAVAC_OPTS = -d bin -sourcepath src

SRCS := $(wildcard src/*.java)

run: Main.class
	$(JAVA) $(JAVA_OPTS) Main

Main.class: $(SRCS)
	$(JAVAC) $(JAVAC_OPTS) src/Main.java 

clean:
	rm -rf bin/*.class
