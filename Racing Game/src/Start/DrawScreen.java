package Start;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class DrawScreen extends BasicGame {

    public int playerPositionX;
    public int playerPositionY;
    public Image car1;
    public boolean moving;
    int[] lineSpeed;
    int[] lines;
    public int sideLineLeftPos;
    public int sideLineRightPos;
    Color skyColor;
    Color white;

    public DrawScreen()
    {
        super("Racing Game");
    }

    @Override
    public void init(GameContainer container) throws SlickException
    {
        System.out.println(container.getWidth() + ", " + container.getHeight());
        container.setMaximumLogicUpdateInterval(60);
        container.setTargetFrameRate(60);
        container.setAlwaysRender(true);
        container.setShowFPS(false);
        container.setVSync(true);


        car1 = new Image("C:\\Users\\238785\\IdeaProjects\\Racing Game\\Assets\\car1.png");
        car1.setFilter(Image.FILTER_NEAREST);

        car1 = car1.getScaledCopy(.5f);
        playerPositionX = (container.getWidth() - car1.getWidth()) / 2;
        playerPositionY = container.getHeight() - car1.getHeight();

        lines = new int[3];
        lineSpeed = new int[lines.length];
        for(int i = 0; i < lines.length; i++)
        {
            lines[i] = ((container.getHeight() + Background.getLineHeight()) / lines.length) * i * -1;
            lineSpeed[i] = 15;
        }
        moving = false;

        sideLineRightPos = 10;
        sideLineLeftPos = -30;

        skyColor = new Color(116, 225, 255);
        white = new Color(Color.white);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException
    {
        g.setColor(white);
        for(int i = 0; i < lines.length; i++)
        {
            g.fill(Background.drawLines(container, lines[i]));
        }
        g.fill(Background.sideLines(container, sideLineLeftPos, 0.45));
        g.fill(Background.sideLines(container, container.getWidth() + sideLineRightPos, -0.45));

        g.drawImage(car1, playerPositionX, playerPositionY);
        g.setColor(skyColor);
        g.fill(Background.sky(container));

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
        Input input = container.getInput();
        int speed = 50;
        float distance =  speed * ((float)delta / 100);

        //region Key Input
        if(input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D))
        {
            playerPositionX += distance;
            sideLineLeftPos -= distance;
            sideLineRightPos -= distance;
        }
        if(input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A))
        {
            playerPositionX -= distance;
            sideLineLeftPos += distance;
            sideLineRightPos += distance;
        }
        if(input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S))
        {
            // playerPositionY += distance;
        }
        if(input.isKeyDown(Input.KEY_UP) || input.isKeyDown((Input.KEY_W)))
        {
            //playerPositionY -= distance;
            //moving = true;
        }
        //endregion //

        for(int i = 0; i < lines.length; i++)
        {
            if(moving)
            {
                lines[i] += lineSpeed[i];
                if (lines[i] >= container.getHeight() + Background.getLineHeight())
                {
                    lines[i] = 0;
                    lineSpeed[i] = 15;
                }
            }
        }

        moving = false;
    }

   /*
    public static void main(String[] args)
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
    */
}
