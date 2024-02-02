import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuInitializer {
    protected static final String ABOUT = "About";
    protected static final String EXIT = "Exit";
    protected static final String GOTO = "Go to";
    protected static final String NEW = "New";
    protected static final String NEXT = "Next";
    protected static final String OPEN = "Open";
    protected static final String PREV = "Prev";
    protected static final String SAVE = "Save";

    protected static final String FILE = "File";

    protected static final String HELP = "Help";

    protected static final String VIEW = "View";
    private MenuActionController menuActionController;
    private Presentation presentation;
    private Frame parent;

    private Menu fileMenu;
    private Menu viewMenu;
    private Menu helpMenu;

    public MenuInitializer(Presentation presentation, Frame parent){
        this.presentation = presentation;
        this.parent = parent;
        menuActionController = new MenuActionController(presentation, parent);

        fileMenu = createMenu(FILE, createFileMenuItems());
        viewMenu = createMenu(VIEW, createViewMenuItems());
        helpMenu = createMenu(HELP, createHelpMenuItems());
    }
    public Menu createMenu(String name, java.util.List<MenuItem> items) {
        Menu menu = new Menu(name);
        items.forEach(menu::add);
        return menu;
    }

    public java.util.List<MenuItem> createFileMenuItems() {
        java.util.List<MenuItem> items = new ArrayList<>();

        items.add(createMenuItem(OPEN, menuActionController::loadPresentation));
        items.add(createMenuItem(NEW, menuActionController::clearPresentation));
        items.add(createMenuItem(SAVE, menuActionController::savePresentation));
        items.add(createMenuItem(EXIT, () -> presentation.exit(0)));

        return items;
    }

    public java.util.List<MenuItem> createViewMenuItems() {
        java.util.List<MenuItem> items = new ArrayList<>();

        items.add(createMenuItem(NEXT, presentation::nextSlide));
        items.add(createMenuItem(PREV, presentation::prevSlide));
        items.add(createMenuItem(GOTO, menuActionController::gotoPage));

        return items;
    }

    public java.util.List<MenuItem> createHelpMenuItems() {
        List<MenuItem> items = new ArrayList<>();
        items.add(createMenuItem(ABOUT, () -> menuActionController.showAboutBox(parent)));
        return items;
    }

    public MenuItem createMenuItem(String name, Runnable action) {
        MenuItem menuItem = mkMenuItem(name);
        menuItem.addActionListener(e -> action.run());
        return menuItem;
    }
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }

    public Menu getFileMenu() {
        return fileMenu;
    }

    public Menu getViewMenu() {
        return viewMenu;
    }

    public Menu getHelpMenu() {
        return helpMenu;
    }
}
