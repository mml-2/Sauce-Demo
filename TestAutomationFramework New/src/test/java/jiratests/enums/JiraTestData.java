package jiratests.enums;

public enum JiraTestData {
    USERNAME("ChangeMe"),
    PASSWORD("ChangeMe");

    JiraTestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }

    final String value;
}
