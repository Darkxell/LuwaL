package display.states;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import ressources.Palette;
import ressources.Res;
import main.Main;
import management.leveldesign.LevelManager;
import management.line.CurrentLevelHolder;
import management.line.DisplayLine;
import display.CanvasStatesHolder;
import display.FullCanvasState;

public class LevelChooserState implements FullCanvasState {

    public static final int TYPE_CLASSIC = 0;
    public static final int TYPE_SET = 1;
    public static final int TYPE_SURVIVAL = 2; /*
					        * Destruction,Armagedon,Apocalypse
					        */;
    /** The type of level selected. */
    private int leveltype;
    /** The level number of the selected type. */
    private int levelnumber;

    @Override
    public void print(Graphics g) {
	DisplayLine.print(g);
	g.setFont(Res.MAIN_FONT_TALL);
	FontMetrics metrics = g.getFontMetrics();
	int width;
	char[] text;
	switch (this.leveltype) {
	case TYPE_CLASSIC:
	    text = "Classic".toCharArray();
	    width = metrics.stringWidth("Classic");
	    break;
	case TYPE_SET:
	    text = "Set".toCharArray();
	    width = metrics.stringWidth("Set");
	    break;
	case TYPE_SURVIVAL:
	    text = "Survival".toCharArray();
	    width = metrics.stringWidth("Survival");
	    break;
	default:
	    text = "Unknown".toCharArray();
	    width = metrics.stringWidth("Unknown");
	    break;
	}
	g.setColor(CurrentLevelHolder.LevelFontColor);
	g.drawChars(text, 0, text.length, (Main.frame.getWidth() / 2)
		- (width / 2), Main.frame.getHeight() / 2);
	// Starts to draw the level Name.
	g.setFont(Res.MAIN_FONT_SMALL);
	metrics = g.getFontMetrics();
	switch (leveltype) {
	case TYPE_CLASSIC:
	    Palette.setcurrentlevelcolors(levelnumber + 1);
	    switch (levelnumber) {
	    case 0:
		drawlevelname(g, "Level 1 : who needs tutorials?");
		break;
	    case 1:
		drawlevelname(g, "Level 2 : name");
		break;
	    case 2:
		drawlevelname(g, "Level 3 : name");
		break;
	    case 3:
		drawlevelname(g, "Level 4 : name");
		break;
	    case 4:
		drawlevelname(g, "Level 5 : name");
		break;

	    default:
		width = metrics.stringWidth("Unknown level");
		text = "Unknown level".toCharArray();
		break;
	    }
	    break;
	case TYPE_SET:
	    Palette.setcurrentlevelcolors(0);
	    switch (levelnumber) {
	    case 0:
		drawlevelname(g, "Level 1 : name");
		break;
	    case 1:
		drawlevelname(g, "Level 2 : name");
		break;
	    case 2:
		drawlevelname(g, "Level 3 : name");
		break;
	    default:
		drawlevelname(g, "unknown level");
		break;
	    }
	    break;
	case TYPE_SURVIVAL:
	    Palette.setcurrentlevelcolors(0);
	    switch (levelnumber) {
	    case 0:
		drawlevelname(g, "Destruction");
		break;
	    case 1:
		drawlevelname(g, "Armagedon");
		break;
	    case 2:
		drawlevelname(g, "Apocalypse");
		break;
	    default:
		width = metrics.stringWidth("Unknown level");
		text = "Unknown level".toCharArray();
		break;
	    }
	    break;
	}
    }

    @Override
    public void update() {
	CurrentLevelHolder.currentLevel = null;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	    DisplayLine.prepareRotativeDash();
	    Main.frame.getFullCanvas().state = CanvasStatesHolder.MENUSTATE;
	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT
		|| e.getKeyCode() == KeyEvent.VK_KP_RIGHT) {
	    DisplayLine.prepareRotativeDash();
	    if (this.levelnumber == getLevelAmmountInCurrentState() - 1)
		this.levelnumber = 0;
	    else
		this.levelnumber++;

	} else if (e.getKeyCode() == KeyEvent.VK_LEFT
		|| e.getKeyCode() == KeyEvent.VK_KP_LEFT) {
	    DisplayLine.prepareRotativeDash();
	    if (this.levelnumber == 0)
		this.levelnumber = getLevelAmmountInCurrentState() - 1;
	    else
		this.levelnumber--;
	} else if (e.getKeyCode() == KeyEvent.VK_DOWN
		|| e.getKeyCode() == KeyEvent.VK_KP_DOWN) {
	    DisplayLine.prepareRotativeDash();
	    if (this.leveltype == 2)
		this.leveltype = 0;
	    else
		this.leveltype++;
	    this.levelnumber = 0;
	} else if (e.getKeyCode() == KeyEvent.VK_UP
		|| e.getKeyCode() == KeyEvent.VK_KP_UP) {
	    DisplayLine.prepareRotativeDash();
	    if (this.leveltype == 0)
		this.leveltype = 1;
	    else
		this.leveltype--;
	    this.levelnumber = 0;
	} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	    if (LevelManager
		    .setCurrentLevelTo(this.leveltype, this.levelnumber))
		Main.frame.getFullCanvas().state = CanvasStatesHolder.LEVELSTATE;
	}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    /** draws the wanted level name at its place. */
    private void drawlevelname(Graphics g, String levelname) {
	FontMetrics metrics = g.getFontMetrics();
	int width = metrics.stringWidth(levelname);
	char[] text = levelname.toCharArray();
	g.drawChars(text, 0, text.length, (Main.frame.getWidth() / 2)
		- (width / 2), (int) (Main.frame.getHeight() / 1.6));
    }

    /** Gets the ammount of levels IDs using the current level type. */
    private int getLevelAmmountInCurrentState() {
	switch (leveltype) {
	case TYPE_CLASSIC:
	    return 5;
	case TYPE_SET:
	    return 3;
	case TYPE_SURVIVAL:
	    return 3;
	default:
	    return 0;
	}

    }

}
