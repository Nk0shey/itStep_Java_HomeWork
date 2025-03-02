package Task03;

public class MoneyEngine {
    private long hryvnias;
    private byte kopecks;

    public MoneyEngine(long hryvnias, byte kopecks) {
        if (kopecks < 0 || kopecks >= 100) {
            throw new IllegalArgumentException("Копійки мають бути в діапазоні від 0 до 99");
        }
        this.hryvnias = hryvnias;
        this.kopecks = kopecks;
    }

    public MoneyEngine add(MoneyEngine other) {
        long totalKopecks = this.toKopecks() + other.toKopecks();
        return fromKopecks(totalKopecks);
    }

    public MoneyEngine subtract(MoneyEngine other) {
        long totalKopecks = this.toKopecks() - other.toKopecks();
        return fromKopecks(totalKopecks);
    }

    public MoneyEngine multiply(double multiplier) {
        long totalKopecks = Math.round(this.toKopecks() * multiplier);
        return fromKopecks(totalKopecks);
    }

    public MoneyEngine divide(double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе");
        }
        long totalKopecks = Math.round(this.toKopecks() / divisor);
        return fromKopecks(totalKopecks);
    }

    public boolean isGreaterThan(MoneyEngine other) {
        return this.toKopecks() > other.toKopecks();
    }

    public boolean isEqualTo(MoneyEngine other) {
        return this.toKopecks() == other.toKopecks();
    }

    @Override
    public String toString() {
        return hryvnias + "," + (kopecks < 10 ? "0" : "") + kopecks;
    }

    private long toKopecks() {
        return hryvnias * 100 + kopecks;
    }

    private static MoneyEngine fromKopecks(long totalKopecks) {
        long hryvnias = totalKopecks / 100;
        byte kopecks = (byte) Math.abs(totalKopecks % 100);

        if (totalKopecks < 0 && kopecks != 0) {
            hryvnias -= 1;
            kopecks = (byte) (100 - kopecks);
        }

        return new MoneyEngine(hryvnias, kopecks);
    }
}

