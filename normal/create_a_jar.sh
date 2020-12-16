#!/bin/bash
make release
cd build
jar -cfe puissance.jar game_components/Game game_components/*.class game_components/rule_set/*.class game_components/players/*.class game_components/graphic_display/*.class game_components/graphic_display/states/*.class
cd ..
cp build/puissance.jar puissance.jar
