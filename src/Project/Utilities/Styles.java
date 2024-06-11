package Project.Utilities;



public class Styles {
    public static String primaryColour = "#D4F0F7;;";
    public static String secondaryColour = "#fa8fb1;";
    public static String tertiaryColour = "#da8ee7;";
    public static String black = "#000000;";
    public static String white = "#FFFFFF;";
    public static String fontWeightTitle = "-fx-font-weight: bold;";
    public static String fontFamily = "-fx-font-family: 'Verdana';";
    public static String justifyCenter = "-fx-alignment: center;";
    public static String backgroundColour(String colour) {
        return "-fx-background-color: " + colour + ";";
    }
    public static String padding(int padding) {
        return "-fx-padding: " + padding + "px;";
    }

    public static String padding(int top, int right, int bottom, int left) {
        return "-fx-padding: " + top + "px " + right + "px " + bottom + "px " + left + "px;";
    }

    public static String fontSize(int fontSize) {
        return "-fx-font-size: " + fontSize + "px;";
    }

    public static String borderWidth(int borderWidth) {
        return "-fx-border-width: " + borderWidth + "px;";
    }

    public static String borderStyle(String borderStyle) {
        return "-fx-border-style: " + borderStyle + ";";
    }

    public static String borderRadius(int borderRadius) {
        return "-fx-border-radius: " + borderRadius + "px;";
    }
}
