### **Plans**

|                        |
|------------------------|
|Création d'un `PreparedStatement`|
|Insertion de paramètres dans un `PreparedStatement`|
|Exécution du `PreparedStatement`|
|Réutiliser un `PreparedStatement`|
|Performances de « PreparedStatement »|

+ Un `PreparedStatement` est un type spécial d'objet d'instruction avec quelques fonctionnalités utiles. N'oubliez pas que vous avez besoin d'une instruction pour exécuter soit « une requête » soit une « mise à jour ». Vous pouvez utiliser un `PreparedStatement` au lieu d'un `Statement` et bénéficier des fonctionnalités de `PreparedStatement`.

### **Les principales fonctionnalités du PreparedStatement sont :**
+ Facile à insérer des paramètres dans l'instruction SQL.
+ Facile à réutiliser le `PreparedStatement` avec de nouveaux paramètres.
+ Peut augmenter les performances des instructions exécutées.
+ Permet des mises à jour par lots plus faciles.

### **Création d'un `PreparedStatement`**
+ Avant de pouvoir utiliser un `PreparedStatement`, vous devez d'abord le créer. Pour ce faire, utilisez `connection.preparedStatement()`, comme ceci :
+ Le `PreparedStatement` est maintenant prêt à recevoir une insertion de paramètres.


        String sql = "select * from employee_table where employee_id=?"
        PreparedStatement preparedStatement = connection.preparedStatement(sql)


### **Insertion de paramètres dans un PreparedStatement**
+ Partout où vous devez insérer un paramètre dans `SQL`, vous devez écrire un point d'interrogation (?). Par exemple:

        String sql = "select * from employee_table where employee_id=?"

+ Une fois qu'un `PreparedStatement` est créé (préparé) pour l'instruction SQL ci-dessus, vous pouvez insérer des paramètres à l'emplacement du point d'interrogation. Cela se fait en utilisant les nombreuses méthodes `setXXX()`. Voici un exemple:

        preparedStatement.setLong(123);

+ Le premier chiffre (1) est l'index des paramètres pour lesquels insérer la valeur. Voici le même exemple avec un peu plus de détails :

        String sql = "select * from employee_table where employee_id=?"
        PreparedStatement preparedStatement = connection.preparedStatement(sql)
        preparedStatement.setLong(123);

+ Vous pouvez avoir plusieurs paramètres dans une instruction SQL. Insérez simplement plus de bronzage, un point d'interrogation. Voici un exemple simple :

        String sql = "select * from employee_table where firstname=? and lastname=?"
        PreparedStatement preparedStatement = connection.preparedStatement(sql)
        preparedStatement.setString(1, "John");
        preparedStatement.setString(2, "Smith");

### **Exécution du `PreparedStatement`**
+ L'exécution de `PreparedStatement` ressemble à l'exécution d'une `Statement` normale pour exécuter une requête, appelez la méthode `executeQuery` ou `executeUpdate`. Voici un exemple `executeQuery` :

        String sql = "select * from employee_table where firstname=? and lastname=?"
        PreparedStatement preparedStatement = connection.preparedStatement(sql)
        preparedStatement.setString(1, "John");
        preparedStatement.setString(2, "Smith");    
        ResultSet result = preparedStatement.executeQuery();

+ Comme vous pouvez le voir, la méthode `executeQuery` renvoie un `ResultSet`. Itération du `ResultSet`. Voici un exemple `executeUpdate` :

        String sql = "select * from employee_table where firstname=? and lastname=? where id=?"
        PreparedStatement preparedStatement = connection.preparedStatement(sql)
        preparedStatement.setString(1, "John");
        preparedStatement.setString(2, "Smith");   
        preparedStatement.setLong(3, 123);
        int rowsAffected = preparedStatement.executeUpdate();

+ La méthode `executeUpdate` est utilisée lors de la mise à jour de la base de données. Il renvoie un « int » qui indique combien d'enregistrements de la base de données ont été affectés par la mise à jour.


### **Réutilisation d'un `PreparedStatement`**
+ Une fois qu'un `PreparedStatement` est préparé, il peut être réutilisé après exécution. Vous réutilisez un `PreparedStatement` en définissant de nouvelles valeurs pour les paramètres, puis vous l'exécutez à nouveau. Voici un exemple simple :

        String sql = "select * from employee_table where firstname=? and lastname=? where id=?"
        PreparedStatement preparedStatement = connection.preparedStatement(sql)
        
        preparedStatement.setString(1, "Gary");
        preparedStatement.setString(2, "Larson");   
        preparedStatement.setLong(3, 123);
        int rowsAffected = preparedStatement.executeUpdate();

        preparedStatement.setString(1, "Stan");
        preparedStatement.setString(2, "Lee");   
        preparedStatement.setLong(3, 456);
        int rowsAffected = preparedStatement.executeUpdate();

### **Performances de `PreparedStatement`**
+ Il faut du temps à une base de données pour analyser une « chaîne SQL » et créer un plan de requête pour celle-ci. Un plan de requête est une analyse de la manière dont la base de données peut exécuter la requête de la manière la plus efficace.
+ Si vous soumettez une nouvelle instruction SQL complète pour chaque requête ou mise à jour de la base de données, la base de données doit analyser le « SQL » et pour les requêtes, créer un plan de requête. En réutilisant un `PreparedStatement existant, vous pouvez réutiliser à la fois l'analyse `SQL` et le plan de requête pour les requêtes ultérieures. Cela accélère l'exécution des requêtes, en réduisant la surcharge d'analyse et de planification des requêtes de chaque exécution.

### **Il existe deux niveaux de réutilisation potentielle pour un `PreparedStatement`**
+ Réutilisation de `PreparedStatement` par le `pilote JDBC`.
+ Réutilisation de `PreparedStatement` par la base de données.

+ Tout d'abord, le `pilote JDBC` peut mettre en cache les objets `PreparedStatement` en interne, et ainsi réutiliser les objets `PreparedStatement`. Cela peut économiser un peu de temps de création de `PreparedStatement`.
+ Deuxièmement, le plan d'analyse et de requête mis en cache pourrait potentiellement être réutilisé dans des applications Java, par exemple des serveurs d'applications dans un cluster, en utilisant la même base de données.
  