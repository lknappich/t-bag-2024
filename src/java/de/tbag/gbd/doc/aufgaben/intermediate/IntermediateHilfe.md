# Aufgaben für Fortgeschrittene in Java erklären (ohne Lösungen)

### 4. Einfacher Rechner

* **Verwende Datentypen:** Wähle geeignete Datentypen für die Zahlen (`int`, `double`, etc.)
* **Scanner für Eingabe:** Nutze den `Scanner` wie in Aufgabe 3 beschrieben.
* **Rechenoperationen:** Verwende die Operatoren `+`, `-`, `*`, `/` für die Berechnungen.

<details>
<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
System.out.println("Summe: " + (zahl1 + zahl2));
System.out.println("Differenz: " + (zahl1 - zahl2));
System.out.println("Produkt: " + (zahl1 * zahl2));
System.out.println("Quotient: " + ((double) zahl1 / zahl2)); // Für Dezimalergebnisse
```
</details>

### 5. Einfaches IF/ELSE

**Aufgabe A:**

* **Vergleiche mit `>`:** Nutze den Operator `>` zum Vergleichen der Zahl mit 10.
* **Bedingte Ausgabe:** Verwende `if` und `else` um Feedback auszugeben.

<details>
<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
var zahl = scanner.nextInt();

if (zahl > 1234) {
  System.out.println(zahl + " ist größer als 1234!");
} else {
  System.out.println(zahl + " ist kleiner oder gleich 1234.");
}
```
</details>

### 6. IF/ELSEIF/ELSE

* **Vergleiche mit `>`, `==`, `<`:** Nutze Operatoren zum Vergleichen mit 0.
* **Verkettete `if`/`else`-Bedingungen:** Verwende `if`/`else if`/`else` für die drei Fälle.

<details>
<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
var zahl = scanner.nextInt();

if (zahl > 0) {
  System.out.println(zahl + " ist größer als 0.");
} else if (zahl == 0) {
  System.out.println(zahl + " ist gleich 0.");
} else {
  System.out.println(zahl + " ist kleiner als 0.");
}
```
</details>

### 7. Einfache FOR-Schleife

* **Initialisiere Schleife:** `for (int i = 1; i <= 10; i++)`
* **Zählvariable `i`:** Durchläuft die Werte von 1 bis 10.
* **Ausgabe in der Schleife:** Nutze `System.out.println(i)` im Schleifenkörper.

<details>
<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
for (int i = 1; i <= 10; i++) {
  System.out.println(i);
}
```
</details>

### 8. Einfache WHILE-Schleife

* **Initialisiere Variable:** `int zahl = 0;`
* **Schleifenbedingung:** `while (zahl != 0)`
* **Abfrage in der Schleife:** Fordere Eingabe mit `scanner.nextInt()` an.
* **Bedingung prüfen:** Vergleiche `zahl` mit 0.
* **Schleifenende:** Setze `zahl = 0` um die Schleife zu beenden, wenn 0 eingegeben wird.


<details>

<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
var scanner = new Scanner(System.in);
int zahl = 0;

while (zahl != 0) {
  System.out.print("Zahl eingeben (0 zum Beenden): ");
  zahl = scanner.nextInt();
}

System.out.println("Schleife beendet.");
```

</details>

