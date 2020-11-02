all: clean
	javac -d build src/game_components/*.java
	javac -d build -cp build src/game_components/players/*.java
	java -cp build Game

clean:
	rm -rf build*/*