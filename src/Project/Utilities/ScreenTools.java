package Project.Utilities;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Screen;
public class ScreenTools {
    private static Screen screen = Screen.getPrimary();

    public static int getScreenHeight() {
        int height = (int) screen.getVisualBounds().getHeight();
        return height;
    }
    public static int getScreenWidth() {
        int width = (int) screen.getVisualBounds().getWidth();
        return width;
    }
}
