## prog1-project

### Objective

Create an Android application that can solve sudoku's.

### Anleitung

1. SudokuSolver.apk auf einem Android Smartphone installieren und öffnen.
   z.B. per Download von Github
   (http://github.com/raeffu/prog1-project/blob/master/SudokuSolver.apk?raw=true)
   oder per Dateiübertragung. Nach Download auf Smartphone das *.apk
   File öffnen und installieren.
2. Sudoku App starten.
3. Ein Sudoku wird angezeigt und kann mit klick auf "Solve" gelöst werden.

Es können auch andere Sudokus eingegeben werden (als Zeichenkette, siehe Beispielsudoku).

In diesem Projekt befinden sich nur die relevanten Dateien des Sourcecodes (insbesondere *SudokuSolver.java*).
Sprich alle Dateien die ich auch editiert habe, die restlichen Dateien sind generierte Dateien,
die die Android IDE erstellt hat.

Datei                             Beschreibung

SudokuSolver.java                 Klasse die das Sudoku löst.
MainActivity.java                 Wir ausgeführt sobald die App startet und
                                  zeigt Startbild an.
DisplayResultActivity.java        Zeigt das Resultat mit dem gelösten
                                  Sudoku an.

strings.xml                       XML-Datei mit verwendeten Texten und
                                  Sudoku Aufgaben.
activity_main.xml                 Layout des Startbildschirmes.
activity_display_result.xml       Layout für das Anzeigen des Resultats.
