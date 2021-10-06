# Send-Email

Vereinfacht dir das senden von Email's in Java

```java
public class TestEmail {
    Session session = new Sessions(true, "false", "mail.server.de", "25", "mail.server.de", "test@server.de", "PASSWORD").getSession();
    Sender.sendEmail("test@server.de", "server@gmail.com", "Hello World", List.of(new TopDefault()), session);
}
```

### Mehr Methoden

Es gibt auch noch die Methoden:
```java
    Session session = new Sessions("false", "mail.server.de", "25", "mail.server.de", "test@server.de", "").getSession();
    Session session = new Sessions("mail.server.de", "25", "mail.server.de", "test@server.de", "")getSession();
```

Unterschied zwischen den ist, dass man beo den ganz oben alles Einstellen kann. Beim zweiten kann man noch weniger Einstellen.
Beim dritten ist es amwenigsten.

### Wie kann ich meine eigenen 'Components' schreiben?

```java
   public class TestComponent implements Component {

    @Override
    public String name() {
        return null;
    }

    @Override
    public String body() {
        // Hier kommt der Text rein
        return null;
    }

    @Override
    public String file() {
        // Falls es eine HTML Datei gibt in den resources Ordner und dann den Pfad angeben
        return null;
    }
} 
```

Beim implements Component werden automatisch `name()`, `body()` und `file()` generiert.

##### Mitgearbeitet

<a href="https://github.com/Optischa/Send-Email/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Optischa/Send-Email" alt="Contributors"/>
</a>
