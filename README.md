# Algorithms and Data Structures (Java)

Clean and well-documented Java implementations for common algorithms and data-structure utilities.

## Included: Numeronym Converter

A numeronym shortens a word by replacing middle characters with their count.

Examples:
- `internationalization` → `i18n`
- `localization` → `l10n`

### Files

- `NumeronymConverter.java` — conversion logic + CLI usage
- `NumeronymConverterTest.java` — JUnit tests

## Build & Test

```bash
mvn test
```

## Run

```bash
mvn -q -DskipTests exec:java -Dexec.mainClass="com.raj.algorithms.strings.NumeronymConverter" -Dexec.args="internationalization and localization"
```

Or compile/run directly:

```bash
mvn -q -DskipTests compile
java -cp target/classes com.raj.algorithms.strings.NumeronymConverter "internationalization and localization"
```

## Next additions (suggested)

- Two Sum (hash map)
- Binary Search
- Linked List reversal
- Stack/Queue implementations
- Sliding Window patterns

## Added: Two Sum (Array + Hash Map)

- Location: `src/main/java/com/raj/algorithms/arrays/TwoSum.java`
- Test file: `src/test/java/com/raj/algorithms/arrays/TwoSumTest.java`
- Complexity: **O(n)** time, **O(n)** space

Example:
- Input: `nums = [2,7,11,15], target = 9`
- Output: `[0,1]`
