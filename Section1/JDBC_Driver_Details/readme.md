#### **Qu'est-ce que le pilote JDBC en Java ?**
+ 
+ Un `Driver` n'est rien d'autre qu'un logiciel mais un logiciel requis pour se connecter à une base de données à partir d'un programme Java. 
+ `JDBC` n'est qu'une `API`, que Java a conçue et la mise en œuvre de ces « API » repose sur différents fournisseurs, car différentes bases de données fonctionnent de manière différente, elles utilisent en interne des protocoles différents.

+ Ainsi MySQL donne sa propre implémentation de `JDBC`, nous l'appelons le pilote `MySQL JDBC` et nous l'utilisons lorsque nous voulons nous connecter à la base de données `MySQL` à partir du programme Java. 
+ De même, `Orcale, SQL SERVER, Sysbase et PostgreSQL` ont fourni leur propre implémentation de « JDBC API » pour les connecter. Étant donné que le programme Java utilise `l'API JDBC`, ils sont portables sur différentes bases de données, tout ce que vous avez à faire est de modifier le « pilote JDBC », qui n'est qu'un fichier « JAR » si vous utilisez un « pilote JDBC » de type 4.

#### **Pourquoi de nombreux types de pilotes JDBC**

+ Les différents types de `pilotes JDBC` proviennent de leur fonctionnement, qui dépend essentiellement de deux facteurs : la portabilité et les performances.
+ Le `pilote JDBC de type 1` est le plus médiocre en termes de portabilité et de performances, tandis que les « pilotes JDBC de type 4 » sont hautement portables et offrent les meilleures performances.

+ Étant donné que la base de données est très importante et que presque toutes les applications Java utilisent la base de données sous une forme ou une autre, il est important de bien apprendre `JDBC`.

<img src= "https://1.bp.blogspot.com/-N8chZs9gm3o/VZqJaq9O6JI/AAAAAAAADSQ/00NdSyCL8Pg/s1600/4%2Btypes%2Bof%2BJDBC%2BDrivers%2Bhow%2Bthey%2Bwork%2Bin%2BJava.JPG"/>


#### **Qu'est-ce que le pilote de type 1 dans JDBC**

+ Il s'agit du plus ancien « pilote JDBC », principalement utilisé pour connecter une base de données comme « MS Access » à partir du système d'exploitation Microsoft Windows.
+ Le « pilote JDBC de type 1 » traduit en fait les appels « JDBC » en appels « ODBC (Object Database Connectivity) », qui à leur tour se connectent à la base de données.
+ Puisqu'il agit comme un pont entre « JDBC et ODBC », il est également connu sous le nom de « pilote de pont JDBC ODBC ».
+ Ce pilote avait de très mauvaises performances en raison de plusieurs couches de traduction qui avaient lieu avant que votre programme ne se connecte à la base de données.
+ Il est également moins portable car il s'appuie sur le « pilote ODBC » pour se connecter à la base de données indépendante de la plate-forme.
+ Il est désormais obsolète et utilisé uniquement pour le développement et les tests, Java 8 a même supprimé ce pilote du `JDK`.

#### **Qu'est-ce que le pilote de type 2 dans JDBC**

+ Il s'agissait du deuxième « pilote JDBC » introduit par Java après le type 1, d'où son nom de type 2.
+ Dans ce pilote, les performances ont été améliorées en réduisant la couche de communication.
+ Au lieu de parler au « pilote ODBC », le « pilote JDBC » parle directement au « Client DB » en utilisant l'« API » native.
+ C'est pourquoi il est également connu sous le nom d'« API » native ou de pilote partiellement Java.
+ Puisqu'il nécessite une « API » native pour se connecter au « Client DB », il est également moins portable et moins plate-forme.
+ Les performances du « pilote JDBC de type 2 » sont légèrement meilleures que celles du « pilote JDBC de type 1 ».

#### **Qu'est-ce qu'un pilote de type 3 dans JDBC?**
+ Il s'agissait du troisième pilote JDBC introduit par Java, donc connu sous le nom de type 3. Il était très différent des pilotes JDBC de type 1 et de type 2 dans le sens où il était entièrement écrit en Java, contrairement aux deux pilotes précédents qui n'étaient pas écrits en Java. . C'est pourquoi on l'appelle également tous les pilotes Java. Ce pilote utilise une approche à 3 niveaux, à savoir client, serveur et base de données. Ainsi, un client et un serveur Java communiquent entre eux en utilisant le protocole Net. Ce type de pilote JDBC est également connu sous le nom de pilote JDBC du protocole Net. Ce pilote n'a jamais gagné en popularité car le fournisseur de base de données était réticent à réécrire sa bibliothèque native existante principalement en C et C++.

#### **Qu'est-ce que le pilote de type 4 dans JDBC?

+ Il s'agit du pilote que vous utilisez le plus probablement pour vous connecter à une base de données moderne comme Oracle, SQL Server, MySQL, SQLLIte et PostgreSQL, etc. Ce pilote est implémenté en Java et communique directement avec la base de données en utilisant son protocole natif. Ce pilote inclut tous les appels à la base de données dans un seul fichier JAR, ce qui le rend très facile à utiliser. Tout ce que vous devez faire pour connecter une base de données à partir d'un programme Java est d'inclure le fichier JAR du pilote JDBC correspondant. En raison de son poids léger, il est également appelé pilote JDBC fin. Étant donné que ce pilote est également écrit en Java pur, il est portable sur toutes les plates-formes, ce qui signifie que vous pouvez utiliser le même fichier JAR pour vous connecter à MySQL même si votre programme Jav s'exécute sous Windows, Linux ou Solaris. Les performances de ce type de pilote JDBC sont également les meilleures parmi tous car le fournisseur de base de données apprécie ce type et toutes les améliorations qu'il apporte sont également adaptées aux pilotes de type 4.
