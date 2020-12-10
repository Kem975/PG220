all: clean
	javac -d build src/game_components/GridTailleException.java
	javac -d build -cp build src/game_components/Grid.java src/game_components/Log.java src/game_components/Player.java
	javac -d build -cp build src/game_components/rule_set/*.java
	javac -d build -cp build src/game_components/players/*.java
	javac -d build -cp build src/game_components/Log.java
	javac -d build -cp build src/game_components/graphic_display/states/*.java src/game_components/graphic_display/*.java src/game_components/Game.java
	java -cp build game_components/Game

clean:
	rm -rf build
