## Aufgaben für Experten in Java erklären (ohne Lösungen)

### 9. Array-Manipulation

- **Deklariere ein Array:** `int[] zahlen = new int[5];`
- **Befülle das Array:** Verwende eine Schleife oder einzelne Zuweisungen (`zahlen[0] = 1; zahlen[1] = 2; ...`).
- **Verdopple die Werte:** Nutze eine Schleife, um durch das Array zu iterieren und jeden Wert mit `* 2` zu multiplizieren.
- **Ausgabe:** Verwende `System.out.println(Arrays.toString(zahlen))` für beide Arrays.

<details>

<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
int[] zahlen = {1, 2, 3, 4, 5};

// Verdopple Werte
for (int i = 0; i < zahlen.length; i++) {
  zahlen[i] *= 2;
}

// Ausgabe
System.out.println("Ursprüngliches Array: " + Arrays.toString(zahlen));
System.out.println("Modifiziertes Array: " + Arrays.toString(zahlen));
```
</details>

### 10. String-Umkehr

- **Verwende `StringBuilder`:** Diese Klasse ist effizienter für die Zeichenkettenmanipulation.
- **Erstelle ein `StringBuilder`-Objekt:** `StringBuilder builder = new StringBuilder(eingabeString);`
- **Umkehre den String:** `builder.reverse();`
- **Konvertiere zurück in String:** `String umgekehrterString = builder.toString();`
- **Ausgabe:** `System.out.println("Umgekehrter String: " + umgekehrterString);`

<details>

<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
var scanner = new Scanner(System.in);
System.out.print("Text eingeben: ");
String eingabeString = scanner.nextLine();

StringBuilder builder = new StringBuilder(eingabeString);
String umgekehrterString = builder.reverse().toString();

System.out.println("Umgekehrter String: " + umgekehrterString);
```
</details>

### 11. Einfaches Spiel – Zahlenraten

- **Implementiere Zufallszahlengenerierung:** `int zufallszahl = (int) (Math.random() * 100) + 1;`
- **Initialisiere Schleife:** `while (erraten == false)`
- **Hole Benutzereingabe:** `System.out.print("Zahl eingeben (1-100): ");
  int tipp = scanner.nextInt();`
- **Vergleiche den Tipp:**
    - `tipp > zufallszahl`: "Zu hoch!"
    - `tipp < zufallszahl`: "Zu niedrig!"
    - `tipp == zufallszahl`: "Gratulation! Du hast die Zahl erraten!"
- **Beende die Schleife:** `erraten = true;`

<details>

<summary> Drücke mich wenn du nicht weiterkommst </summary>

```java
import java.util.Random;

public class Zahlenraten {

    public static void main(String[] args) {
        Random random = new Random();
        int zufallszahl = (int) (random.nextDouble() * 100) + 1;
        boolean erraten = false;

        Scanner scanner = new Scanner(System.in);

        while (!erraten) {
            System.out.print("Zahl eingeben (1-100): ");
            int tipp = scanner.nextInt();

            if (tipp > zufallszahl) {
                System.out.println("Zu hoch!");
            } else if (tipp < zufallszahl) {
                System.out.println("Zu niedrig!");
            } else {
                System.out.println("Gratulation! Du hast die Zahl erraten!");
                erraten = true;
            }
        }
    }
}
```
</details>