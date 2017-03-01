package Start;

import org.newdawn.slick.*;

public class Main
{


    public static void main(final String[] args)
    {
        try
        {
            AppGameContainer game = new AppGameContainer(new DrawScreen());
            game.setDisplayMode(800, 600, false);
            game.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
}
