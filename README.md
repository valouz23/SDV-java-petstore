### Bienvenue dans mon projet java petstore

Quelques détails :

BDD
- J'ai utilisé une base de données local mariadb,appelée petstore, si ce n'est pas votre cas il faudra changer l'url dans le fichier persistence.xml, ainsi que l'utilisateur et le mot de passe
- J'ai mis tous les noms de table et colonnes dans la base de données totalement ne minuscule, parce qu'avec linux je dois respecter la casse et c'était plus pratique pour moi
- Pour la création et suppression des tables, j'ai laissé la détection des classes à construire par défaut dans le fichier persistence.xml, car tout doit être construit, donc pas besoin de tout spécifier moi-même

Classes
- Pour éxecuter l'insertion des données, il suffit de lancer Main, il y a dedans les données à insérer, ainsi que la requête pour récupérer tous les animaux d'un magasin spécifique. J'ai aussi adapté les fonctions toString des classes Cat et Fish afin de les afficher de manière un minimum sympa.
- Pour l'isolation, je n'ai pas jugé nécessaire d'ajouter des interfaces, mais j'ai séparés les entités dans des packages pour regrouper tout ce qui concernait les animaux dans un package "animals", et tout ce qui concernait les produits dans un package "products"
- Dans la création des classes, j'ai spécifié des noms pour chaque colonne à créer, mais souvent le nom de colonne est le même que le nom d'attribut, ce qui crée de la redondance, mais je l'ai fait tout de même pour montrer que je savais le faire :D

Enfin, je l'ai expliqué dans le code, mais j'ai mis un système de cascade pour la création des objets.
Les animaux créés créent les magasins dont ils ont besoin s'ils n'existent pas déjà
Puis les magasins créent les adresses et produits dont ils ont besoin s'ils n'existent pas déjà
