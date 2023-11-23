### **JDBC (Connectivité de base de données Java)**

+ `L'API Java JDBC` permet aux applications Java de se connecter à
  bases de données relationnelles via API standard, afin que vos applications Java deviennent indépendantes des applications utilisées.

<img src = "https://jenkov.com/images/java-jdbc/jdbc.png"/>

### **Application Java utilisant JDBC pour se connecter à une base de données**

+ `JDBC` standardise la façon de se connecter à une base de données, comment exécuter des requêtes sur celle-ci,
  comment naviguer dans le résultat d'une telle requête et comment exécuter des mises à jour dans la base de données.
  JDBC ne standardise pas le SQL envoyé à la base de données. Cela peut encore varier d’une base de données à l’autre.

### **PRÉSENTATION DE JDBC**

#### **1) Composants JDBC de base**
#### **2) Cas d'utilisation courants de JDBC**
#### **3) Un diagramme d'interaction des composants JDBC**

#### **The JDBC API consists of the following core parts :**

+ JDBC Drivers (Pilotes JDBC)
+ Connections (Connexions)
+ Statements (Déclarations)
+ Result Sets (Ensembles de résultats)


#### **Il existe quatre cas d'utilisation de base de JDBC autour desquels s'articule la plupart des travaux JDBC :**

+ Interroger la base de données (lire les données de celle-ci).
+ Interrogez les métadonnées de la base de données.
+ Mettre à jour la base de données.
+ Effectuer des transactions.

### **Composants JDBC de base**

#### **Pilote JDBC/JDBC Driver**

+ Un `JDBC Driver` est un ensemble de classes Java qui vous permet de connecter une base de données.
+ Par exemple, MySQL aura son propre `JDBC Driver`. Un `JDBC Driver` implémente de nombreuses « interfaces JDBC ».
+ Lorsque votre code utilise un `JDBC Driver` donné, il utilise en fait simplement les « interfaces JDBC » standard.
+ Le `JDBC Driver` concret sans que votre code ne s'en aperçoive. Bien entendu, les `JDBC Driver` peuvent varier légèrement en termes de fonctionnalités qu'ils prennent en charge.


#### **Connexion**

+ `Oracle JDBC Driver` est chargé et initialisé, vous devez connecter la base de données.
+ Vous le faites en obtenant une connexion à la base de données via l'API JDBC et le pilote chargé.
+ Toute communication avec la base de données se fait via une connexion.
+ Une application peut avoir plusieurs connexions ouvertes à une base de données à la fois.
+ Ceci est en fait très courant lorsque vous avez une application Web.


#### **Déclaration/Statement**

+ `A Statement` est utilisé pour exécuter des requêtes et des mises à jour sur la base de données.
+ Il existe différents types d'instructions que vous pouvez utiliser dans `JDBC`.


#### **Ensemble de résultats/ResultSet**

+ Lorsque vous effectuez une requête sur la base de données, vous récupérez un `ResultSet`.
+ Vous pouvez ensuite parcourir ce `ResultSet` pour lire le résultat de la requête.


### **Cas d'utilisation JDBC courants**

#### **Interroger la base de données**

+ L'un des cas d'utilisation les plus courants consiste à lire à partir d'une base de données.
+ Lire des données à partir d'une base de données s'appelle interroger la base de données.

#### **Interroger les métadonnées de la base de données**

+ Un autre cas d'utilisation courant consiste à interroger les métadonnées de la base de données.
+ Les métadonnées de la base de données contiennent des informations sur la base de données elle-même.
+ Par exemple, sur les tables définies, les colonnes de chaque table, les types de données, etc.

#### **Mettre à jour la base de données**

+ Un autre cas d'utilisation très courant de `JDBC` consiste à mettre à jour la base de données.
+ Mettre à jour la base de données signifie y écrire des données.
+ Autrement dit, ajouter de nouveaux enregistrements ou modifier (mettre à jour) des enregistrements existants.


#### **Effectuer des transactions**

+ Les transactions sont un autre cas d'utilisation courant.
+ Une transaction regroupe plusieurs mises à jour et éventuellement requêtes en une seule action.
+ Soit toutes les actions sont exécutées, soit aucune ne l'est.

#### **Un diagramme d'interaction des composants JDBC**

+ Voici un exemple de la façon dont les composants principaux interagissent lors de l'exécution d'une requête de base de données.

<img src = "https://jenkov.com/images/java-jdbc/overview.png"/>