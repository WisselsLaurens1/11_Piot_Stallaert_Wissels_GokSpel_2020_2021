package model.database;

public enum GamblerEnum {
    TEKSTBESTAND ("Tekstbestand", "model.database.GamblerDbTxt"),
    EXCELBESTAND ("Excelbestand", "model.database.GamblerDbXls");

    private final String omschrijving;
    private final String klasseNaam;

    GamblerEnum(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() { return omschrijving; }
    public String getKlasseNaam() { return klasseNaam; }
}
