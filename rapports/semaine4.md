# Rapport semaine 3 :

## Avancé global
Cette semaine, nous avons finis notre restructuration et avons commencé l'implémentation des pouvoirs. 
Cependant nous n'avions pas énormément de temps disponible et n'avons pas pu beaucoup avancé, 
nous comptons évidemment tout faire faire la semaine prochaine pour rattraper ce petit "retard", notamment en fournissant enfin un UML convenable.

## Détails restructuration
Pour la restructuration nous avons avant tout séparé les différentes classes en package partagant un même aspect, 
nous avons augmenté le nombre de nos classe en en créant de nouvelle tel que : 
- Joueur, Humain et IA : Qui s'occupe de gérer le joueur humain et son opposant l'IA. Joueur est une classe abstraite, dont IA et Humain héritent.
- Affichage : Une classe où nous avons regroupé toutes les partie de code s'occupant d'afficher certaines chose
- Defausse : initialement un attribut de Deck, nous avons opté pour la séparé suite au conseil de Mr. Ayadi  

## Détails Ajout de Pouvoirs
Pour le moment l'implémentation n'est pas encore présente/fonctionnel, nous avons juste ajouté un package "Pouvoirs" contenant chaque pouvoir, 
ainsi qu'un attribut m_pouvoir au Pokemon de type Pouvoir qui est une classe abstraite.

### Mise a l'oeuvre

Concernant la pratique, nous avons utilisé la fonctionnalité "**code with me**" de **IntelliJ** permettant de coder en même temps.
Cependant cela ne fait les mise a jour que sur un seul ordinateur, d'où le fait que la plupart des commits ont été faite sur le même compte.

