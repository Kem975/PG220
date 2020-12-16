---------------------------------Pour compiler et créer un executable .jar---------------------------------

-placer les sources dans le même dossier que le script "create_a_jar.sh"

-modifier le Makefile:
	-dans la recette "release": #liste des sources = la liste des toutes les sources (avec les sous-dossier etc)
	-(optionel) dans la recette "run": #nom de la classe principale = le nom (complet) de la classe contenant le main
	-(optionel) dans la recette "run_jar": #nom du fichier .jar = le nom du fichier .jar executable

-modifier le script "create_a_jar.sh":
	-jar -cfe #nom du fichier .jar #nom de la classe principale #liste des fichiers .class:
		-#nom du fichier .jar = le nom du fichier .jar à créer
		-#nom de la classe principale = le nom (complet) de la classe contenant le main
		-#liste des fichiers .class = la liste des toutes fichiers compilés .class (avec les sous-dossier etc)

-executer le script "create_a_jar.sh": un fichier .jar a dû être créer dans le dossier courant.


----------------------------Pour executer les scripts de tests--------------------------------------------

Les scripts de tests sont excutable sur toute distribution linux possedant une interface graphique (X11). 
Ils simulent des entrées claviers utilisateur, puis compare le résultat des executions avec ce qui est attendu.
Deux packages sont néessaires à leur execution: il faut donc les installer préalablement:
-xdotool: "sudo apt-get install xdotool" : permet de simuler les entrées claviers
-wmctrl: "sudo apt-get install xdotool" : permet de gérer les fenêtres

Le script permettant de lancer les tests est "test_scenarios.sh" : il lancera les tests correspondant aux scenarios présents dans le dossier "test_scenario" enregistrera les resultats dans "result_test.txt". 
Pour chaque scenario le script ouvre un nouveau terminal et execute le scenario des entrées claviers sur le jeu (ne pas interagir avec le programme tant que le scenario n'est pas terminé). 
Il enregistre ensuite dans le dossier "result" ce qui s'affiche à la console et le "log.txt" correspondant à l'historique puis les compare 
aux résultats attendu (globalement avec la synthaxe du sujet).

Il existe 12 scénarios possibles, tous présents dans le dossier "possible_scenarios":

-game_exit.sc : le joueur 1 sort directement avec la commande "sortir"

-game_check_diagonal_1_victory.sc: les differents types de victoire
-game_check_horizontal_victory.sc  
-game_check_diagonal_2_victory.sc  
-game_check_vertical_victory.sc  

-game_tie.sc: le cas de l'égalité

-game_complete_fight.sc: une partie complète en 3 manches       
   
-game_error_player_1.sc: mauvais format pour les type/nom de joueurs
-game_error_player_2.sc

-game_error_invalid_column_full.sc: mauvais format/valeurs pour les colonnes
-game_error_invalid_column_format.sc  
-game_error_invalid_column_number.sc


Les scenarios ne sont que la suite des entrées de l'utilisateurs, vous pouvez les consulter avec un simple editeur de texte.
Après avoir executer les scénarios, le script les compare avec les différents fichiers correspondants dans le dossier "expected_result":
-log_scenario.txt: correspond à ce qui est attendu pour l'historique
-result_scenario.txt: correspond à ce qui est attendu pour les sortie en console

Pour lancer les scripts:
-placer le fichier .jar dans le dossier contenant le script "test_scenario.sh"
-copier les différents scenarios à tester depuis le dossier "possible_scenarios" vers le dossier "test_scenarios"
-lancer la commande "./text_scenario.sh jeu.jar" où jeu.jar est le nom de votre fichier .jar

Les résulats des tests apparaîtront dans le fichier result_test.txt.
