package exercise2;

public enum FueltypeEnum {
    SUPER(100, "high-power-super"),NORMAL(98, "boring normal"),DIESEL(95, "race diesel");

    private int octan;
    private String descript;

    FueltypeEnum(int octan, String descript){

        this.octan = octan;
        this.descript = descript;
    }

    public int getOctan() {
        return octan;
    }

    public String getDescript() {
        return descript;
    }
}
