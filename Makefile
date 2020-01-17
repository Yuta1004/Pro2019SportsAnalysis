JAVA := java
JAVAC := javac
JAVA_OPTS = -cp bin
JAVAC_OPTS = -d bin -sourcepath src

SRCS := $(wildcard src/yuge/*.java)

run: Main.class
	$(JAVA) $(JAVA_OPTS) Main

test: ExecuteTest.class
	$(JAVA) $(JAVA_OPTS) ExecuteTest

Main.class: $(filter-out $(SRCS), src/yuge/test/*)
	$(JAVAC) $(JAVAC_OPTS) src/Main.java 

ExecuteTest.class: $(SRCS)
	$(JAVAC) $(JAVAC_OPTS) src/ExecuteTest.java

clean:
	rm -rf bin/*.class bin/*/*.class
