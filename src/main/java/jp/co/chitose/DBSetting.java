package jp.co.chitose;

public class DBSetting {
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "postgres";
    public static final String PASSWORD = "achieve";

    private DBSetting() {
        throw new AssertionError("Do not Instantiate");
    }
}
