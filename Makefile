JAVA := java
JAVAC := javac
SRCS := $(wildcard *.java)
OPTS :=

run: Main.class
	$(JAVA) Main

Main.class: $(SRCS)
	$(JAVAC) Main.java 
