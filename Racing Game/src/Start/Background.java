package Start;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.w3c.dom.css.Rect;

/**
 * Created by 238785 on 2/6/2017.
 */
public class Background
{
    static int lineWidth = 8;
    static int lineHeight = 100;
    public static void background()
    {

    }
    public static Shape drawLines(GameContainer container, int linePos)
    {
        Polygon roadLines = new Polygon();
        roadLines.addPoint((container.getWidth()/2) - (lineWidth / 2), linePos - lineHeight);
        roadLines.addPoint((container.getWidth()/2) + (lineWidth / 2), linePos - lineHeight);
        roadLines.addPoint((container.getWidth()/2) + (lineWidth / 2) + 1, linePos);
        roadLines.addPoint((container.getWidth()/2) - (lineWidth / 2) - 1, linePos);
        return roadLines;
    }
    public static int getLineHeight()
    {
        return lineHeight;
    }
    public static int getLineWidth()
    {
        return lineWidth;
    }
    public static Shape sideLines(GameContainer container, int xPos, double angle)
    {
        if(angle < -1.57 || angle > 1.57)
            throw new IllegalArgumentException(angle + " is out of range");

        Polygon sideLines = new Polygon();
        sideLines.addPoint(0 + xPos,container.getHeight());
        sideLines.addPoint((int)((container.getHeight() * Math.tan(angle)) + xPos),container.getHeight() / 2);
        sideLines.addPoint((int)((container.getHeight() * Math.tan(angle)) + xPos + 20), container.getHeight() / 2);
        sideLines.addPoint(20 + xPos, container.getHeight());
        return sideLines;
    }
    public static Rectangle sky(GameContainer container)
    {
        Rectangle background = new Rectangle(0, 0, container.getWidth(), container.getHeight() / 2);
        return background;
    }

}
