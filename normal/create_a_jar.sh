#!/bin/bash
make release
cd build
jar -cfe puissance.jar game_components/Game game_components/*.class game_components/rule_set/*.class game_components/players/*.class
cd ..
cp build/puissance.jar puissance.jar
