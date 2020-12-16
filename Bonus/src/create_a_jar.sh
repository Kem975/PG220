#!/bin/bash
make release
cd build
jar -cfe #nom du fichier .jar #nom de la classe principale #liste des fichiers .class
cd ..
cp build/#nom du fichier.jar #nom du fichier .jar
