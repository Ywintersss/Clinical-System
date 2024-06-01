package Project.Utilities;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Screen;
public class ScreenTools {
    private static Screen screen = Screen.getPrimary();

    public static int getScreenHeight() {
        int height = (int) screen.getVisualBounds().getHeight();
        System.out.println(height);
        return height;
    }
    public static int getScreenWidth() {
        int width = (int) screen.getVisualBounds().getWidth();
        System.out.println(width);
        return width;
    }
}
