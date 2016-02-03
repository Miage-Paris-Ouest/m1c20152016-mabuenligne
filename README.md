# Projet "Ma BU en ligne" #

[![Build Status](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mabuenligne.svg?branch=master)](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mabuenligne)
### Contexte:###

La bibliothèque universitaire souhaite intégrer la mobilité au sein de son processus d'emprunt de livres. Pour se faire une application mobile devra être développée afin de donner la possibilité aux utilisateurs de gérer leurs emprunts à distance.

### Les objectifs: ###



- Créer une interface pour la gestion de chaque utilisateur(lambda et lecteur)

	L'utilisateur (lambda) pourra:
	- accéder aux informations générale de la BU(infos pratiques)
	- rechercher un livre selon différents critères (catégorie, nom, auteur, etc.)
	- être mis en relation avec les contacts de la BU


- L'utilisateur(lecteur) pourra:

	- consulter la liste des livres qu'il a empruntés / historique des prêts
	- prolonger ses prêts
	- paramétrer ses alertes de rendu
	- afficher des notifications "alerte" en fonction de la date de rendu paramétrée
	- consulter ses retards et pénalités
	- accéder à toutes les fonctionnalités de l'utilisateur lambda


###Logique d'utilisation###

- Une page d’accueil proposant 2 boutons :
	- Accès à l’espace utilisateur
	- Accès à l’espace lecteur(via connexion)

- Page utilisateur : 2 boutons :
	- recherche de livre
	- infos&Contact

- Page Connexion : 2boutons :
	- Connexion (lecteur)
	- Menu ( retour à l’accueil)

- Page Lecteur : 5 boutons :
	- recherche
	- historique emprunts
	- paramétrer alertes de rendus
	- Consulter ses retards 
	- Infos&Contact

### Use Case ###


![](https://github.com/Miage-Paris-Ouest/m1c20152016-mabuenligne/blob/master/Dossier%20Fonctionnel/Cas%20d'utilisation%20Lecteur.png?raw=true)

### Choix technique ###

Développement mobile : Android
 
 -----------------------------------

### Processus de développement ###

- Creation de la page d'infos et contact
- Creation de la page accueil avec un seul bouton(utilisateur)
- Creation de la page utilisateur avec un seul bouton(infos&contact)
- Ajout d'un second bouton a la page utilisateur(recherche livre)
- Développement de la fonction de recherche(avec développement d'une page de réponse vide ou non)
- Creation page lecteur avec 2 boutons(recherche et infos&contact)
- Creation page de connexion avec 2 boutons(connexion et menu)
- Développement de la fonction de connexion
- Ajout d'un second bouton à la page d'accueil(connexion)
- Ajout 3 boutons page lecteur 
- Développement fonction historique d'emprunt
- Développement fonction d'alerte de rendus
- Développement fonction retard 
