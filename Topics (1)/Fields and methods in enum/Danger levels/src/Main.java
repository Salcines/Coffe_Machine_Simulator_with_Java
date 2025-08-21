enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int level;

    DangerLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
}

class DangerLevels {
    public static void main(String[] args) {
        DangerLevel low = DangerLevel.LOW;
        DangerLevel high = DangerLevel.HIGH;

        System.out.println(low.getLevel() > high.getLevel());
    }
}