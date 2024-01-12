### **CallableStatement dans le concept JDBC**
+ **Création d'un `CallableStatement`**
+ **Définition des valeurs des paramètres**
+ **Exécution du Callable**
+ **Paramètres IN, OUT et OUTPUT**
<hr>

+ Un `java.sql.CallableStatement` est utilisé pour appeler des procédures stockées dans une base de données. Une procédure stockée est comme une fonction ou une méthode dans une classe, sauf qu'elle se trouve dans la base de données. Certaines opérations de base de données peuvent bénéficier en termes de performances d'être exécutées dans le même espace mémoire que le serveur de base de données, en tant que procédure stockée.

                 CallableStatement  callableStatement = connection.prepareCall("{Call calculatStatistics(?,?)}");


### **Création d'un `CallableStatement`**
+ Vous créez une instance de `CallableStatement` en appelant la méthode `prepareCall()` sur un objet de connexion. Voici un exemple:
+ Si la procédure stockée renvoie un ResultSet et que vous avez besoin d'un ResultSet autre que celui par défaut (par exemple avec une capacité de conservation, une concurrence, etc. différentes), vous devrez déjà spécifier ces caractéristiques lors de la création du `CallableStatement`. Voici un exemple:

        CallableStatement  callableStatement = connection.prepareCall("{Call calculatStatistics(?,?)}",
        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY,ResultSet.CLOSE_CURSORS_OVER_COMMIT
        );
        

### **Définition des valeurs des paramètres**
+ Vous pouvez définir des paramètres dans le SQL, aux endroits où vous mettez un `?`. Voici un exemple:

        CallableStatement  callableStatement = connection.prepareCall("{Call calculatStatistics(?,?)});
        callableStatement.setString(1, "param1");
        callableStatement.setInt(2, 123);

### **Exécution de CallableStatement**
+ Une fois que vous avez défini les valeurs des paramètres que vous devez définir, vous êtes prêt à exécuter le `CallableStatement`. Voici comment procéder :

        ResultSet result = callableStatement.executeQuery();

+ La méthode `executeQuery()` est utilisée si la procédure stockée renvoie un `ResultSet`. Si la procédure stockée met simplement à jour la base de données, vous pouvez appeler la méthode `executeUpdate()` à la place, comme ceci :

        callableStatement.executeUpdate();

### **Il existe trois types de paramètres de procédure stockée :**
+ L'objet `PreparedStatement` utilise uniquement le paramètre `IN`. L'objet `CallableStatement` peut utiliser les trois.
+ `Paramètres IN`
    + Un paramètre dont la valeur est inconnue lors de la création des instructions `SQL`. Vous liez les valeurs aux paramètres `IN` avec les méthodes `setXXX()`.
+ Paramètres `OUT`
    + Un paramètre dont la valeur est fournie par l'instruction `SQL` qu'il renvoie. Vous récupérez les valeurs des paramètres `OUT` avec les méthodes `getXXX()`.
+ Paramètres `INOUT`
    + Un paramètre qui fournit à la fois des valeurs d'entrée et de sortie. Vous liez des variables avec les méthodes `setXXX()` et récupérez les valeurs avec les méthodes `getXXX()`.


        CallableStatement  callableStatement = connection.prepareCall("{Call calculatStatistics(?,?)});
        callableStatement.setString(1, "param1");
        callableStatement.setInt(2, 123);

        callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
        callableStatement.registerOutParemeter(2, java.sql.Types.INTEGER);

        ResultSet result = callableStatement.executeQuery();
        while(result.next()){...}

        String out1 = callableStatement.getString(1)
        int out2 = callableStatement.getInt(2)