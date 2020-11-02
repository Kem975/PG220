all: clean
	javac -d build src/game_components/Grid.java
	javac -d build src/game_components/Player.java
	javac -d build src/game_components/players/*.java
	javac -d build src/game_components/*.java
	javac -d build -cp build src/game_components/players/*.java
	java -cp build Game

clean:
	rm -rf build*/*