import java.awt.MenuBar;
import java.awt.Frame;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	private static final long serialVersionUID = 227L;

	private MenuInitializer menuInitializer;
	public MenuController(Frame frame, Presentation pres) {

		this.menuInitializer = new MenuInitializer(pres, frame);

		add(menuInitializer.getFileMenu());
		add(menuInitializer.getViewMenu());
		setHelpMenu(menuInitializer.getHelpMenu());
	}
}
