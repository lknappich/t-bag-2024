# Cheatsheet für ein textbasiertes Adventure-Game in der Klasse "Game"

In der Welt der Programmierung und Spieleentwicklung ist es faszinierend, wie man mit Code eine eigene kleine Welt erschaffen kann. 
Ein textbasiertes Adventure-Game bietet eine fantastische Gelegenheit, in diese Welt einzutauchen. Mithilfe der Klasse "Game" lassen sich unterschiedliche Elemente wie Waffen, Tränke, Eingaben von Spielern und komplexe Spiellogiken umsetzen. 
Hier folgt ein ausführliches Cheatsheet, das dir die notwendigen Schritte erläutert:

### 1. Erstellen von Waffen:

In jedem Adventure-Game spielen Waffen eine zentrale Rolle. Sie sind die Tools, mit denen Spieler Gegner bekämpfen und Quests meistern.

#### Verfügbare Waffentypen:
- **SPELL**: Waffen für Zauberer und Magier, ideal für Angriffe aus der Ferne oder zur Unterstützung. Denke an Zauberstäbe und magische Bücher.
- **LONG_RANGE**: Diese Kategorie umfasst alle Fernkampfwaffen, die es dem Spieler ermöglichen, aus sicherer Entfernung Schaden zu verursachen. Beispiele hierfür sind Bogen und Armbrust.
- **SHORT_RANGE**: Nahkampfwaffen für direkte Konfrontationen. Schwert, Dolch und Axt sind hier typische Vertreter.

#### Beispiel für Waffenerstellung:

Um eine Waffe im Spiel zu erstellen, definieren wir zunächst den Namen der Waffe, den Typen, den minimalen und maximalen Schaden sowie kritischen Schaden und die Chance für einen kritischen Treffer.

```java
Weapon schwert = new Weapon("Schwert", WeaponType.SHORT_RANGE, 20, 30, 25, 0.1);
```
#### Die Parameter:
- **Name der Waffe**: "Schwert"
- **Typ der Waffe**: "SHORT_RANGE" (Nahkampf)
- **Minimale Schaden**: 20 (Die Untergrenze des Schadens, den die Waffe verursachen kann. Bei unserem Schwert sind das 20 Schadenspunkte.)
- **Maximaler Schaden**: 30 (Die Obergrenze des Schadens, also das maximale Schadenspotenzial der Waffe. Das Schwert kann bis zu 30 Schadenspunkte verursachen.)
- **Kritischer Schaden**: 25 (Zusätzlicher Schaden, der bei einem kritischen Treffer erfolgt. Unser Schwert fügt 25 zusätzliche Schadenspunkte bei einem kritischen Treffer zu.)
- **Kritische Trefferchance**: 10% (Die Wahrscheinlichkeit eines kritischen Treffers. Hier: 10% (0.1). Das bedeutet, jede zehnte Attacke hat die Chance, kritischen Schaden zu verursachen.)

Die Wahl und das Design der Waffen in deinem Spiel haben einen erheblichen Einfluss auf das Spielerlebnis und die Strategien, die die Spieler verfolgen können. 
Durch das Anbieten verschiedener Waffentypen mit einzigartigen Eigenschaften kannst du eine tiefe und engagierte Spielweise fördern, die Spieler motiviert, verschiedene Taktiken und Kombinationen zu erkunden.



### 2. Erstellen von Tränken (Potions):

Tränke sind ein wesentlicher Bestandteil vieler Adventure-Games. Sie bieten Spielern die Möglichkeit, ihre Gesundheit während oder nach Kämpfen wiederherzustellen, ihre Fähigkeiten temporär zu verbessern oder sich sogar von bestimmten Bedingungen zu heilen. Die richtige Nutzung von Tränken kann oft den Unterschied zwischen Sieg und Niederlage bedeuten.

Verfügbare Potion-Typen:
- **LARGE_POT**: Großer Trank für maximale Heilung.
- **MEDIUM_POT**: Mittlerer Trank für moderate Heilung.
- **SMALL_POT**: Kleiner Trank für geringe Heilung.

#### Beispiel für Potion-Erstellung:

Um einen Trank im Spiel zu erstellen, definieren wir zunächst seine Eigenschaften wie Name, Heilungsgröße und Typ. Hier ist ein Beispiel für die Erstellung eines großen Heiltranks:

```java
Potion großerTrank = new Potion("Großer Trank", 50, PotionsType.LARGE_POT);
```

- **Name des Tranks**: "Großer Trank"
- **Heilungsgröße**: 50 (Dies ist die Menge an Gesundheit, die der Trank dem Spieler zurückgibt. Der "Große Trank" stellt 50 Lebenspunkte wieder her, was in den meisten Spielen eine erhebliche Menge darstellt.)
- **Typ des Tranks**: "LARGE_POT" (Großer Trank)

Durch das Hinzufügen von Tränken zu deinem Spiel bietest du den Spielern strategische Möglichkeiten, ihre Ressourcen zu verwalten und Entscheidungen über deren Einsatz zu treffen. 
Es fördert die Exploration, da Spieler oft motiviert sind, nach neuen und mächtigeren Tränken zu suchen, um sich auf bevorstehende Herausforderungen vorzubereiten.

### 3. Erstellen von Gegnern:

Gegner oder Feinde sind das Herzstück eines jeden Adventure-Games. 
Sie stellen Herausforderungen dar, die Spieler überwinden müssen, sei es durch Strategie, Geschick oder Rohkraft. 
Gegner treiben die Handlung voran, schaffen Spannung und belohnen den Spieler bei einem Sieg oft mit Erfahrungspunkten, Gegenständen oder Fortschritt in der Geschichte. 
Die sorgfältige Gestaltung von Gegnern trägt erheblich zur Tiefe und Immersion des Spiels bei.

#### Gegner erstellen:

Um einen Gegner im Spiel zu erstellen, müssen bestimmte Eigenschaften definiert werden, die seine Rolle und Fähigkeiten im Spielkontext festlegen. 
Hier's ein Beispiel, wie du einen einfachen Gegner, einen Goblin, initialisieren kannst:

```java
Enemy goblin = new Enemy("Goblin", 100, schwert, 1);
```

- **Name des Gegners**: "Goblin"
- **HP des Gegners**: 100 (HP (Health Points oder Lebenspunkte) bestimmen die Widerstandsfähigkeit des Gegners gegenüber Angriffen. Je höher die HP, desto länger dauert es für den Spieler, den Gegner zu besiegen. Unser Goblin hat 100 HP, was ihn je nach Spielkontext zu einem leichten bis mittelschweren Gegner machen kann.)
- **Waffe des Gegners**: schwert (Variablenname der Waffe) --> (Die Ausrüstung des Gegners hat direkten Einfluss auf seine Kampfstärke. Im obigen Beispiel ist dem Goblin das "schwert" als Waffe zugewiesen. Die Wahl der Waffe definiert auch den Kampfstil des Gegners – in diesem Fall wird der Goblin in den Nahkampf gehen. Die Variable schwert muss vorher im Code als eine Waffe definiert worden sein.)
- **Anzahl Heiltränke**: 1 (Dies gibt an, wie viele Heiltränke der Gegner bei sich trägt. Tränke ermöglichen es Gegnern, sich im Kampf zu heilen, was Kämpfe unberechenbarer und dynamischer machen kann. Ein Goblin mit einem Heiltrank kann seine Taktik anpassen und im richtigen Moment heilen, um den Kampf zu seinen Gunsten zu wenden.)

Das Erstellen von Gegnern mit unterschiedlichen Fähigkeiten, Schwächen und Strategien bietet eine reiche Gameplay-Erfahrung. 
Es zwingt die Spieler, ihre Ansätze zu variieren und strategisch vorzugehen. 
Bei der Entwicklung von Gegnern ist es wichtig, deren Rolle im Spiel, ihre Platzierung in der Spielwelt und die von ihnen ausgehenden Herausforderungen zu berücksichtigen. 
Eine gut durchdachte Mischung aus verschiedenen Gegnertypen kann ein Spiel herausfordernd und gleichzeitig fair gestalten und so für spannende und abwechslungsreiche Spielstunden sorgen.


### 4. Textausgabe und Eingabe:

Die Interaktion mit dem Spieler ist ein Kernaspekt textbasierter Adventure-Games. 
Durch Textausgaben kann das Spiel Informationen, Beschreibungen und Wahlmöglichkeiten übermitteln, während es durch Eingabeaufforderungen Entscheidungen und Befehle vom Spieler entgegennimmt. 
Diese Kommunikation schafft eine Brücke zwischen Spieler und Spielwelt und ist entscheidend für die Immersion und Dynamik des Spielverlaufs.

#### Textausgabe:

Die Textausgabe dient dazu, dem Spieler Informationen zu präsentieren, sei es durch Erzählung, Dialoge mit NPCs (Non-Player Characters) oder Spielanweisungen. 
Dies fördert das Verständnis der Spielwelt und -story und leitet den Spieler durch das Abenteuer.

```java
game.show("Dies ist ein Beispieltext für die Ausgabe in der Konsole.");
```

In diesem Beispiel wird eine einfache Methode show verwendet, um einen Text in der Konsole oder einem anderen Ausgabemedium anzuzeigen. 
Die Methode könnte Teil eines größeren Frameworks oder einer Klasse sein, die für die grafische Darstellung und Benutzerinteraktion zuständig ist.
*Anwendung*: Der gezeigte Text könnte beispielsweise eine Beschreibung des aktuellen Ortes sein, an dem sich der Spieler befindet, Hinweise zu Rätseln geben oder die Worte eines NPCs wiedergeben.



#### Benutzereingabe:

Während die Textausgabe Informationen an den Spieler liefert, ermöglicht die Benutzereingabe dem Spieler, auf diese Informationen zu reagieren und Entscheidungen zu treffen, die den Verlauf des Spiels beeinflussen.

```java
spielerEingabe = game.ask("Bitte geben Sie eine Antwort ein:");
```
Durch eine solche Eingabeaufforderung wird der Spieler gebeten, Text über die Tastatur einzugeben. 
Diese Eingabe kann dann vom Spiel analysiert und verarbeitet werden, um entsprechende Aktionen auszuführen.

#### Eingabe auswerten:
Nachdem der Spieler eine Eingabe gemacht hat, muss das Spiel diese auswerten und die nächstfolgenden Aktionen bestimmen.
```java
if (spielerEingabe.equals("links")){
        // Führe Aktionen aus, wenn der Spieler "links" wählt
        } else if(spielerEingabe.equals("rechts")){
        // Führe Aktionen aus, wenn der Spieler "rechts" wählt
        } else{
        // Informiere den Spieler bei einer ungültigen Eingabe
        game.show("Ungültige Eingabe. Bitte wählen Sie 'links' oder 'rechts'.");
}
```

In diesem Beispiel fragt das Spiel nach einer Richtungsentscheidung. 
Abhängig von der Eingabe des Spielers ("links" oder "rechts") werden unterschiedliche Wege im Spielverlauf eingeschlagen. 
Bei einer ungültigen Eingabe wird der Spieler darauf hingewiesen und eventuell aufgefordert, die Eingabe zu wiederholen.

Das Wechselspiel zwischen Textausgabe und Eingabe bildet somit das Fundament für ein dialogorientiertes, interaktives Spielerlebnis. 
Es erlaubt den Spielern, aktiv in das Geschehen einzugreifen, ihre eigene Geschichte zu formen und ein tiefes Eintauchen in die Spielwelt zu erleben.

### 5. Pause einfügen:

In textbasierten Adventure-Games ist es oft wichtig, die Erzählgeschwindigkeit zu kontrollieren, um Spannung zu erzeugen, wichtige Ereignisse hervorzuheben oder dem Spieler einfach Zeit zum Lesen und Nachdenken zu geben. 
Das Einfügen von Pausen an strategischen Punkten innerhalb des Spiels kann die Spielerfahrung deutlich verbessern, indem es dem Spiel einen natürlicheren, dynamischeren Rhythmus verleiht.
#### Implementierung einer Pause:

Pausen im Spiel können durch eine einfache Zeile Code eingefügt werden, die das Spiel anweist, die Ausführung für eine bestimmte Zeitspanne zu unterbrechen. 
Hier ist ein Beispiel, wie eine solche Pause in das Spiel integriert werden kann:

```java
game.wait(2);
```
Diese Zeile bewirkt, dass das Spiel für 2 Sekunden angehalten wird. Die Methode wait ist dabei ein Teil der Spielengine oder des Spiel-Frameworks, das das Adventure-Game steuert. 
Der Parameter (hier 2) gibt die Dauer der Pause in Sekunden an.

Einsatzmöglichkeiten und Effekte von Pausen:

    Spannungsaufbau: Vor einem wichtigen Kampf oder einer Schlüsselszene kann eine kurze Pause eingefügt werden, um die Spannung zu steigern und den Spieler emotional auf das bevorstehende Ereignis vorzubereiten.
    Geschichten erzählen: Bei der Enthüllung wichtiger Handlungselemente oder Wendepunkte in der Erzählung kann eine Pause dazu beitragen, dass die Information besser aufgenommen und verarbeitet wird.
    Rhythmus und Flow: Pausen können helfen, den Rhythmus des Spiels zu steuern und einen natürlichen Flow zu schaffen. Sie erlauben dem Spieler, das bisher Geschehene zu verarbeiten, bevor neue Informationen oder Herausforderungen präsentiert werden.
    Emotionale Momente hervorheben: Pausen können genutzt werden, um emotionale oder dramatische Momente im Spiel zu unterstreichen, indem sie dem Spieler Zeit geben, die Situation vollständig zu erfassen und darauf zu reagieren.

Es ist wichtig, Pausen überlegt und dosiert einzusetzen, um die Unterbrechungen für den Spieler nicht störend oder unnötig wirken zu lassen. 
Eine gut platzierte Pause kann jedoch maßgeblich zur Atmosphäre, zum Spielrhythmus und zur Gesamtwirkung der Spielgeschichte beitragen. 
Durch den bewussten Einsatz von Pausen lässt sich das Spielerlebnis auf subtile Weise bereichern und vertiefen, was letztendlich ein eindringlicheres und emotional wirksameres Adventure-Game schafft.

### 6. IF/ELSE-Logik im Adventure-Game:

Die IF/ELSE-Logik ist ein grundlegendes Konzept der Programmierung, das entscheidend für die Entwicklung interaktiver und reaktiver Anwendungen ist – einschließlich textbasierter Adventure-Games. 
Diese Struktur ermöglicht es dem Spiel, auf die Eingaben und Entscheidungen des Spielers zu reagieren und entsprechend unterschiedliche Handlungswege oder Ausgänge zu präsentieren. 
Der Einsatz von IF/ELSE-Logik trägt erheblich zur Vielfalt und Tiefe des Spielerlebnisses bei.

#### Beispiel der IF/ELSE-Logik:

Betrachten wir ein einfaches Szenario, um zu verstehen, wie IF/ELSE-Logik in einem Spiel funktioniert:

```java
game.show("Sie sehen zwei Türen. Möchten Sie die linke Tür öffnen? (Ja/Nein)");
String eingabe = game.ask("");

if (spielerEingabe.equalsIgnoreCase("Ja")) {
    game.show("Die linke Tür öffnet sich.");
} else if (spielerEingabe.equalsIgnoreCase("Nein")) {
    game.show("Sie entscheiden sich, die linke Tür nicht zu öffnen.");
} else {
    game.show("Ungültige Eingabe. Bitte nur 'Ja' oder 'Nein' eingeben.");
}
```

In diesem Beispiel steht der Spieler vor einer Wahl zwischen zwei Türen. Das Spiel präsentiert dem Spieler eine Frage und wartet auf die Eingabe. Basierend auf der Antwort des Spielers (`spielerEingabe`) führt das Spiel unterschiedliche Aktionen durch:

- **Wenn (`if`) der Spieler "Ja" antwortet:** Das Spiel erkennt, dass der Spieler die linke Tür öffnen möchte und führt entsprechende Aktionen aus. Hier wird einfach eine Nachricht angezeigt, dass die linke Tür sich öffnet.
- **Sonst wenn (`else if`) der Spieler "Nein" sagt:** In diesem Fall entscheidet sich der Spieler gegen das Öffnen der Tür. Das Spiel reagiert darauf, indem es eine Nachricht anzeigt, die besagt, dass die Tür unberührt bleibt.
- **Sonst (`else`):** Falls der Spieler eine Eingabe macht, die weder "Ja" noch "Nein" entspricht, informiert das Spiel den Spieler über die ungültige Eingabe und fordert dazu auf, eine gültige Antwort zu geben.

*Warum ist dies wichtig?*

Die Fähigkeit des Spiels, auf die Entscheidungen des Spielers zu reagieren, ist entscheidend für die Schaffung eines interaktiven und immersiven Erlebnisses. 
Die IF/ELSE-Logik erlaubt es dem Spiel, Verzweigungen in der Handlung zu erstellen, Rätsel zu gestalten und dem Spieler das Gefühl zu geben, tatsächlich Einfluss auf die Spielwelt zu nehmen.

Das Beispiel ist einfach gehalten, zeigt jedoch deutlich, wie die IF/ELSE-Struktur genutzt werden kann, um die Spiellogik zu steuern und eine Vielzahl von Spielererlebnissen zu kreieren. 
Durch den kreativen Einsatz von IF/ELSE-Logik und die Verzweigung von Szenarien können Spieleentwickler komplexe und fesselnde Abenteuer entwerfen, in denen jede Entscheidung des Spielers zählt und das Spielgeschehen beeinflusst.


### 7. Kämpfe simulieren
Kämpfe sind oft der Höhepunkt eines Abenteuers in einem textbasierten Spiel, wo Strategie, Vorbereitung und ein Quäntchen Glück über Sieg oder Niederlage entscheiden. Das Kampfsystem ermöglicht es Spielern, ihre Stärken zu nutzen, sich Herausforderungen zu stellen und Belohnungen für ihre Erfolge zu ernten.

#### Einen Kampf initiieren

Kämpfe können ganz einfach gestartet werden mit:

```java
combat.engageInCombat(player, goblin);
```

- **Spieler**: player (hier immer player eintragen -> da player unser Spielerobjekt ist)
- **Enemy** : goblin (hier einen der zuvor erstellten Gegner eintragen)


#### Der Kampfablauf in der `Combat` Klasse ist dynamisch und vielseitig. Er umfasst:

- **Start**: Der Kampf wird mit einer Einführung des Gegners eingeleitet.
- **Spieleraktionen**: Dem Spieler stehen Optionen wie Angriff, Heilung und Flucht zur Verfügung.
- **Angriff**: Bei der Wahl zu attackieren, wählt der Spieler aus verfügbaren Waffen und berechnet den Schaden.
- **Heilung**: Entscheidet sich der Spieler zur Heilung, werden verfügbare Tränke genutzt, um die Gesundheit zu verbessern.
- **Gegneraktionen**: Je nach Gesundheitsstatus und Ressourcen attackiert der Gegner, heilt sich oder erwägt die Flucht.
- **Abschluss**: Der Kampf endet, sobald die Gesundheit eines Kombattanten auf null fällt oder der Spieler flieht. Siege führen zu Belohnungen.


Der Kampf verläuft in einem Schleifensystem, bei dem abwechselnd der Spieler und der Gegner Aktionen ausführen, bis der Kampf abgeschlossen ist. 
Entscheidungen des Spielers und des Computers werden basierend auf der eingegebenen Wahl und den jeweiligen Strategien getroffen. 
Das Kampfsystem bietet eine dynamische Erfahrung, in der jedes Gefecht einzigartig ist, abhängig von den gewählten Aktionen, dem Zufallselement bei Angriffen und Heilungen, und den individuellen Strategien der Beteiligten.

Die Konzeption und Entwicklung eines gut abgestimmten Kampfsystems ist entscheidend für die Spielerbindung und das Spielerlebnis in einem textbasierten Adventure-Game. 
Es bietet Tiefe, Strategie und Spannung, macht Kämpfe zu einer zentralen Erfahrung, auf die Spieler hinfiebern.


### 8. Shop im Adventure-Game

In einem Adventure-Game bietet ein integrierter Shop den Spielern die Möglichkeit, Gegenstände wie Waffen, Tränke oder Ausrüstung zu kaufen, zu verkaufen und zu verbessern. 
Ein gut durchdachter Shop kann das Spielerlebnis erweitern, indem er strategische Entscheidungen über Ressourcenverwaltung und Charakterentwicklung ermöglicht.

#### Definition und Erstellung eines Shops

Um einen funktionierenden Shop im Spiel zu implementieren, beginnt man typischerweise mit der Definition des Shop-Objekts und dessen grundlegenden Funktionen, wie das Hinzufügen von Items und das Initialisieren des Shops mit einem Namen.

**Beispiel:**

```java
shop.addItem(item2);
shop.newShop("test");
```

Im ersten Schritt wird ein Item dem Shop hinzugefügt. `item2` ist dabei ein zuvor definiertes Objekt, das die zu verkaufenden Gegenstände repräsentiert. 
Das könnte zum Beispiel eine spezielle Waffe oder ein starker Trank sein.

Im zweiten Schritt wird der Shop selbst initialisiert, hier mit dem Namen "test". 
Dies legt den Grundstein für einen funktionalen Shop innerhalb des Spiels.

#### Ein Item dem Shop hinzufügen

Um den Shop mit Inventar zu füllen, wird die Methode `addItem()` verwendet. 
Diese Methode nimmt üblicherweise ein Objekt entgegen, das das Item repräsentiert. 
Jedes Item sollte definierbare Eigenschaften wie Name, Preis und Typ (Waffe, Trank etc.) haben.

**Beispiel:**

```java
shop.addItem(item1);
```

In diesem Beispiel wird das bereits definierte Objekt `item1` dem Shop hinzugefügt. 
Es könnte sich dabei um eine seltene Waffe oder einen Heiltrank handeln, den der Spieler kaufen kann.

#### Einen Namen für den Shop festlegen

Die Methode `newShop()` dient der Initialisierung des Shops und kann zusätzlich dazu verwendet werden, den Shop mit einem Namen zu versehen.

**Beispiel:**

```java
shop.newShop("Abenteurer-Basar");
```

Hier wird der Shop mit dem Namen "Abenteurer-Basar" eröffnet. 
Dieser Name kann im Spiel angezeigt werden, wenn der Spieler den Laden betritt, und trägt zur Atmosphäre und Immersion bei.

Ein gut gestalteter Shop im Adventure-Game fördert die Spielerinteraktion, indem er eine zusätzliche Ebene an strategischen Entscheidungen einbringt. 
Spieler können wählen, wie sie ihre Ressourcen ausgeben oder verwalten, was Ausrüstung und Vorräte für die vor ihnen liegenden Herausforderungen angeht. 
Durch die Implementierung von Verkaufs-, Kauf- und Tauschoptionen im Shop können Entwickler das Wirtschaftssystem des Spiels bereichern und den Spielern eine tiefere Verbindung zur Spielwelt ermöglichen.


