# Contents and usage

Each exercise is independent. Do not compile all folders into one classpath: several use the same class names.

| Directory | Concepts |
|---|---|
| `bulls-and-cows` | Console game and game logic |
| `temperature-chart` | JavaFX chart interface |
| `animal-hierarchy` | Inheritance and polymorphism |
| `game-of-life` | Grid simulation and JavaFX |
| `hangman` | Word game with file-backed vocabulary |
| `trivia` | Quiz logic, text data, JavaFX |
| `generic-sets` | Generic collections and set operations |
| `bank-concurrency` | Shared account and transaction threads |
| `parallel-merge-sort` | Multiple threads merging sorted arrays |

Install JDK 17+ and Python 3 to run the added tests:

```sh
python tests/run_checks.py
```

Example console launch:

```sh
cd parallel-merge-sort
javac -d build Main.java MergeThread.java
java -cp build Main
```

JavaFX projects need a separately installed JavaFX SDK matching your JDK. From the individual exercise directory, compile with `javac --module-path PATH_TO_JAVAFX_LIB --add-modules javafx.controls,javafx.fxml -d build *.java`, copy the `fxml` directory into `build/fxml`, and launch its Application class with the same module flags. Keep text assets in the working directory expected by the source. GUI paths and interactions require manual verification.

