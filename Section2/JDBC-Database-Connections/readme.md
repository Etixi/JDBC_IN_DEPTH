### **JDBC : Connexions à la base de données**

#### **Chargement du pilote JDBC**
#### **Ouverture de la connexion**
#### **Fermeture de la connexion**

+ Avant de pouvoir lire ou écrire des données dans la base de données via `JDBC`, vous devez ouvrir la connexion à la base de données.

#### **Chargement du pilote JDBC**

+ La première chose à faire avant de pouvoir ouvrir une connexion à une base de données est de charger le « pilote JDBC » pour la base de données.
+ En fait, à partir de Java 6, cela n'est plus nécessaire, mais cela n'échouera pas.
+ Vous chargez le `pilote JDBC` comme ceci :

             Classe.forName("driverClassName")

+ Chaque `Pilote JDBC` possède une classe de pilote principale qui initialise le pilote lorsqu'il est chargé.
+ Par exemple, dans `MySQL Database driver`, vous écrivez ceci:

             Classe.forName("com.mysql.jdbc.Driver")

+ Vous ne devez charger le pilote qu'une seule fois. Vous n'avez pas besoin de le charger avant chaque ouverture de connexion. Seulement avant l'ouverture de la première connexion.


#### **Ouverture de la connexion**

+ Pour ouvrir une connexion à une base de données, vous utilisez la classe `java.sql.DriverManager`. 
+ Vous appelez sa méthode `getConnection()`, comme ceci:
                
                String url = "jdbc:mysql://localhost:3306/jdbcdb
                String user = "root";
                String password = "root";
                Connection connection = DriverManager.getConnection(url, user, password);

+ L'url est l'url de votre base de données. 
+ Vous devez consulter la documentation de votre base de données et de votre pilote JDBC pour voir quel est le format de votre base de données spécifique. 
+ L'URL indiquée ci-dessus concerne une base de données MySQL. 
+ Les paramètres `user` et `password` sont le nom d'utilisateur et le mot de passe de votre base de données.

#### **Fermeture de la connexion**

+ Une fois que vous avez fini d'utiliser la connexion à la base de données, vous devez la fermer. 
+ Cela se fait en appelant la méthode `connection.close()`, comme ceci:

                Connection.close();
