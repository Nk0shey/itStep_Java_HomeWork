# Java Homework Lab

**Eighteen Java modules: algorithms, object models, file handling and unit tests.**

By [Nikita Kozchenko](https://github.com/Nk0shey) · Java 17 · Maven · JUnit 5

[Build](#build-and-run) · [Explore](#where-to-start) · [Verification](docs/REVIEW.md)

My IT STEP homework collection, organized by course module. The root Maven build compiles each folder independently, keeping repeated `Task01` classes isolated. Original exercise prompts remain in the source files.

## Where to start

- `HomeTask_07.1`: ranges, money, custom strings, complex numbers and library records.
- `HomeTask_07.2`: payroll/reporting variations.
- `HomeTask_07.3`: three coffee-machine models and resource-consumption tests.
- `HomeTask_08`: exception handling, number validation and triangles.
- `HomeTask_11`: file-based contact/task managers, calculator history and Game of Life.
- `HomeTask_15.Scrum`: financial, matrix and sales exercises.
- `HomeTask_16.jUnit`: fractions, calculator, number sets and number conversion.
- `HomeTask_02` through `HomeTask_06.2`: introductory conditions, loops, arrays, strings and methods.

The collection records learning progression. `HomeTask_03.1` and `HomeTask_03.2` contain repeated historical exercises and are retained rather than presented as distinct portfolio applications.

## Build and run

Requires a JDK 17+ and Maven 3.9+. From the repository root:

```sh
mvn test
```

This builds all 18 modules and runs the available JUnit suites. No database is required. Maven downloads test dependencies on the first run.

Run the complex-number demonstration:

```sh
java -cp HomeTask_07.1/target/classes Task05.ComplexNumberMain
```

Run the library-record demonstration:

```sh
java -cp HomeTask_07.1/target/classes Task06.LibraryMain
```

Test the coffee-machine module alone:

```sh
mvn -pl HomeTask_07.3 -am test
```

To run file-based tasks, use their module directory as the working directory when the code refers to relative filenames. They may write contact, task or history files; use a disposable working copy of the supplied data. Some examples require console input.

## Verification

Verified on Linux/OpenJDK 17: all 18 modules compile and **77 JUnit tests pass**. The previously empty money/string/complex-number tests now contain assertions. Additional regressions cover the coffee-machine constructor, single bean consumption, insufficient resources, power state and fraction signs. Two selected console demonstrations were also run.

The review repaired confirmed defects; it did not execute every possible menu path or validate every historical algorithm. Model-specific coffee tank limits remain simplified in later variants. See [review notes](docs/REVIEW.md) for exact scope.

The Maven configuration pins test/plugin versions and replaces duplicate floating `RELEASE` dependencies. Compiled outputs and IDE files are ignored. Teaching scaffolds may have separate authorship; no blanket license is assigned.
