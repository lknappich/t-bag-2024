# Aufgaben in Java Hilfe

### 1. "Hello, World!" ausgeben

- **Verwende die Klasse `System`:** Diese Klasse bietet Methoden zum Ausgeben von Text auf die Konsole.
- **Verwende die Methode `out.println`:** Diese Methode druckt den übergebenen Text auf die Konsole und fügt am Ende eine neue Zeile hinzu.

<details>
<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
System.out.println("some text");
```
</details>

### 2. Arbeiten mit Variablen

- **Deklariere Variablen:** Verwende die Datentypen`int` (Ganzzahlen), `String`(Text), `double`(Fließkommazahlen) gefolgt vom Variablennamen und Zuweisungsoperator (`=`).
- **Initialisiere Variablen:** Lege beim Deklarieren einen Wert fest.


<details>
<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
String text = "text";
int zahl = 25;
double fkz = 1.5;

System.out.println("Ein Text: " + text);
System.out.println("Eine Zahl: " + zahl);
System.out.println("Eine FKZ: " + fkz);
```
</details>

### 3. Eingabe und Ausgabe

- **Verwende die Klasse `Scanner`:** Diese Klasse ermöglicht die Eingabe von Daten vom Benutzer.
- **Erstelle ein `Scanner`-Objekt:** Initialisiere es mit `new Scanner(System.in)`.
- **Verwende die Methode `nextLine`:** Diese Methode liest eine Zeile Texteingabe vom Benutzer ein und speichert sie in einer Variable.


<details>
<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Gib einen Text ein ");
String text = scanner.nextLine();

System.out.println("Dein text ist: " + text + "!");
```
</details>
