konkurs
=======



Twoja_sciezka_do_glassfisha\glassfish4\glassfish\domains\domain1\config\domain.xml
Dodać w resources:

`
<jdbc-connection-pool connection-validation-method="auto-commit" datasource-classname="org.postgresql.ds.PGSimpleDataSource" wrap-jdbc-objects="false" res-type="javax.sql.DataSource" name="connectionPool">
      <property name="Password" value="vlliFqilBOUVyWVY-FZfV50Wa3"></property>
      <property name="User" value="mmmwsvrkwfstit"></property>
      <property name="DatabaseName" value="ddehqcgsacci3g"></property>
      <property name="ApplicationName" value="konkurs"></property>
      <property name="ServerName" value="ec2-54-225-101-124.compute-1.amazonaws.com"></property>
      <property name="Ssl" value="true"></property>
      <property name="Sslfactory" value="org.postgresql.ssl.NonValidatingFactory"></property>
    </jdbc-connection-pool>
    <jdbc-resource pool-name="connectionPool" jndi-name="jdbc/myDatasource">
      <property name="sslfactory" value="org.postgresql.ssl.NonValidatingFactory"></property>
      <property name="ssl" value="true"></property>
    </jdbc-resource>
`

Strona działa pod linkiem:

localhost:8080/linkSaver/