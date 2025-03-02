package Task01and02;

public class Range {

    private int start;
    private int end;

    public Range(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Начало диапазона не может быть больше конца");
        }
        this.start = start;
        this.end = end;
    }

    public int getLength() {
        return end - start;
    }


    public int getStart() {
        return start;
    }


    public int getEnd() {
        return end;
    }
}

