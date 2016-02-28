## Elaboration du Fichier XML et lecture des Informations ##

**Le Fichier Xml** est créer grace à une application java annexe **DownLaodFile.java**

### Le fichier XML ###

Il y a quatre niveaux explotées dans la fichier

- get-pat-loan

- loan

- z36 contenant z36-id et z36-due-date

- z13 contenant z13-author, z13-title et z13-imprint


**z36-id** contient le numéro etudiant

**z36-due-date** contient la date de retour du livre

**z13-author** contient le nom de l'auteur

**z13-title** contient le nom du livre

**z13-imprint** contient l'année d'impression du livre

### Lecture dans le fichier XML ###

Nous avons créé une classe XMLParser qui permet de lire dans le fichier. Nous avons aussi créé un objet Livre pour récupérer les informations extraitent du fichier.

L'algorithme du XMLParser est découpé de la manière suivante : chaque niveau de balise est traité dans un méthode. Chaque méthode appel une sous méthode qui traite la balise inférieur.

Cet objet est par la suite utilisé dans l'activité EmpruntXML pour affichier les information du livre.