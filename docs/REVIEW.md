# Repository review — 2026-11-02

## Verified

All 18 modules compile in the root Maven reactor on OpenJDK 17. All 77 JUnit tests pass. Two selected console demonstrations (complex numbers and library records) complete. Assertions replace 18 formerly empty test methods; the review does not count empty placeholders as meaningful coverage.

## Changes

Added the root README and Maven reactor, configured original source layouts and standardized Java 17. Pinned JUnit/compiler/Surefire versions and removed duplicate floating dependencies.

Fixed the coffee-machine constructor using an uninitialized model. Corrected double bean consumption and negative resources in CoffeeMachine3, required power-on and validated loading/milk amounts. CoffeeMachine2 now counts waste in grams and rejects invalid milk inputs. Added resource regressions without rewriting the original expected drink-result tests.

MoneyEngine formats negative fractional results according to its internal amount and detects integer overflow in addition/subtraction/conversion. Nonfinite multipliers/divisors are rejected. Fraction normalizes denominator signs using widened intermediate values. Added tests for signs and zero. The money/string/complex-number placeholders now contain assertions.

Generated out/target/compiled files are removed from the current tree and ignored. Historical duplicated introductory modules are retained and identified in the README.

## Limits

Not every historical algorithm, file format or menu path has dedicated tests. Later coffee-machine models still simplify model-specific tank limits; Fraction arithmetic still uses int products for general operations, so very large inputs are outside the tested scope. MoneyEngine retains double-based scaling and its original internal whole-unit/cents representation. This review does not claim production-grade financial calculations.
