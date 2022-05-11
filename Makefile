SRC = \
	./src/Competiton/*.java \
	./src/Selection/*.java \
	./src/spectateur/*.java \
	./src/util/*.java \
	
TEST = \
	./test/competitionTest/*.java \
	./test/selectionTest/*.java \

all : docs classes tournament.jar league.jar


tests : classes
	javac -classpath junit5-4.2.9.jar $(TEST)

docs : 
	javadoc $(SRC) -d doc

classes : 
	javac $(SRC) -d classes

tournament : 
	java -jar ./jar/tournament.jar

league : 
	java -jar ./jar/league.jar

master : 
	java -jar ./jar/master.jar