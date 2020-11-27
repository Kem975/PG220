all: clean
	javac -d build src/game_components/GridTailleException.java
	javac -d build -cp build src/game_components/Grid.java
	javac -d build -cp build src/game_components/Rules.java
	javac -d build -cp build src/game_components/rule_set/*.java
	javac -d build -cp build src/game_components/Player.java
	javac -d build -cp build src/game_components/players/*.java
	javac -d build -cp build src/game_components/Log.java
	javac -d build -cp build src/Game.java
	java -cp build Game

clean:
	rm -rf build
