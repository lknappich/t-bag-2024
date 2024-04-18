### Cheatsheet für ein textbasiertes Adventure-Game in der Klasse "Game"

In einem textbasierten Adventure-Game in der Klasse "Game" können verschiedene Elemente wie Waffen, Tränke, Eingaben und Spiellogik verwendet werden. Hier ist ein umfassendes Cheatsheet, das die Schritte detailliert beschreibt:

### 1. Erstellen von Waffen:

Verfügbare Waffentypen:
- **SPELL**: Magische Waffen für Zauber.
- **LONG_RANGE**: Fernkampfwaffen wie Bogen oder Armbrust.
- **SHORT_RANGE**: Nahkampfwaffen wie Schwert oder Dolch.

#### Waffen erstellen:
```java
Weapon schwert = new Weapon("Schwert", WeaponType.SHORT_RANGE, 20, 30, 25, 0.1);
```

- **Name der Waffe**: "Schwert"
- **Typ der Waffe**: "SHORT_RANGE" (Nahkampf)
- **Minimale Schaden**: 20
- **Maximaler Schaden**: 30
- **Kritischer Schaden**: 25
- **Kritische Trefferchance**: 10%

### 2. Erstellen von Tränken (Potions):

Verfügbare Potion-Typen:
- **LARGE_POT**: Großer Trank für maximale Heilung.
- **MEDIUM_POT**: Mittlerer Trank für moderate Heilung.
- **SMALL_POT**: Kleiner Trank für geringe Heilung.

#### Potion erstellen:
```java
Potion großerTrank = new Potion("Großer Trank", 50, PotionsType.LARGE_POT);
```

- **Name des Tranks**: "Großer Trank"
- **Heilungsgröße**: 50
- **Typ des Tranks**: "LARGE_POT" (Großer Trank)

### 3. Textausgabe und Eingabe:

#### Textausgabe:
```java
game.show("Dies ist ein Beispieltext für die Ausgabe in der Konsole.");
```

- Text wird in der Konsole angezeigt.


#### Benutzereingabe:
```java
String eingabe = game.ask("Bitte geben Sie eine Antwort ein:");
```
Allerdings müssen wir nun noch abfragen, welche eingabe der User gemacht hat.
```java
        if (direction.equals("links")){
        //mach hier was wenn links
        } else if(direction.equals("rechts")){
        //mach was wenn rechts
        } else{
    //Falsche eingabe
        }
```


- Der Benutzer wird aufgefordert, eine Eingabe zu machen, die in der Variablen `eingabe` gespeichert wird.

### 4. Pause einfügen:

Eine Pause von 2 Sekunden einfügen:
```java
game.wait(2);
```

- Das Spiel wird für 2 Sekunden pausiert.

### 5. IF/ELSE-Logik im Adventure-Game:

#### Beispiel der IF/ELSE-Logik:
```java
game.show("Sie sehen zwei Türen. Möchten Sie die linke Tür öffnen? (Ja/Nein)");
String eingabe = game.ask("");

if (eingabe.equalsIgnoreCase("Ja")) {
    game.show("Die linke Tür öffnet sich.");
} else if (eingabe.equalsIgnoreCase("Nein")) {
    game.show("Sie entscheiden sich, die linke Tür nicht zu öffnen.");
} else {
    game.show("Ungültige Eingabe. Bitte nur 'Ja' oder 'Nein' eingeben.");
}
```
### 6. Shop im Adventrue-Game

### Beispiel für die divinition und erstellung eines Shops

```java
shop.addItem(item2);
shop.newShop("test");
```

### füge ein item dem shop hinzu

```java
shop.addItem();
```

### füge ein namen des shops ein

```java
shop.newShop("");
```



- Der Spieler trifft eine Entscheidung aufgrund der Eingabe.
- Durch die IF/ELSE-Struktur werden entsprechende Aktionen ausgeführt.
- Es wird eine Fehlermeldung angezeigt, wenn die Eingabe ungültig ist.

### Mit diesem umfangreichen Cheatsheet erhalten Anfänger eine detaillierte Anleitung, wie sie Elemente wie Waffen, Tränke, Textausgaben, Eingaben und IF/ELSE-Logik in einem textbasierten Adventure-Game in der Klasse "Game" implementieren können.