# Weekop

Application written in Java EE technology based on the factory method pattern.
The home page displays a list of websites added by users. As a logged in user, we can vote for this content,
you can also add our own websites.


![weekop](https://user-images.githubusercontent.com/59224048/90867695-12e7c480-e396-11ea-8f58-3c8402b03f7a.png)

## Technologies

* Javax Servlet
* JSP 
* JSTL
* MySQL
* HTML
* CSS
* Bootstrap


## How to start the application locally

* In the src/main/webapp/META-INF directory there is the context.xml file, in which the username and password
 to the database must be completed.
 
    ```
    context.xml 
    
      username=
      password=
    
    ```  

* I am using MySQL, which runs on the default port 3306. If your database name is different or you use a different port,
 remember to change it in the url parameter.
 
    ```
    context.xml 
    
      url="jdbc:mysql://localhost:3306/weekop?useEncoding=true&amp;characterEncoding=UTF-8"
    
    ```

* If you use Tomcat version higher than 8.0, additional configuration 
 is required for proper password encryption. In my case (Tomcat version 9.0.34) it will be:

    ```
    context.xml
    
      <Realm>
        <CredentialHandler className="org.apache.catalina.realm.MessageDigestCredentialHandler" algorithm="MD5"/>
      </Realm>
    ```


## Project presentation

In the src/main/webapp/META-INF/sql directory there is the weekop.sql file with a prepared database structure 
and with ready data to be uploaded, among others 2 users whose accounts you can log in.

```
  username: admin
  password: superPassword
```

```
  username: ZosiaWasilonek
  password: password
```


## Contact 

zofiawasilonek@.gmail.com<br>
<a href="https://www.linkedin.com/in/zofia-wasilonek/">Linkedin</a>
