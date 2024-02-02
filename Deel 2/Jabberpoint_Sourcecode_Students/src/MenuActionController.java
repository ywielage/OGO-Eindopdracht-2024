import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuActionController {

    protected static final String TESTFILE = "testPresentation.xml";
    protected static final String SAVEFILE = "savedPresentation.xml";

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";
    protected static final String PAGENR = "Page number?";

    private Presentation presentation;
    private Frame parent;
    public MenuActionController(Presentation presentation, Frame parent){
        this.presentation = presentation;
        this.parent = parent;
    }
    public void loadPresentation() {
        try {
            presentation.clear();
            new XMLAccessor().loadFile(presentation, TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }

    public void clearPresentation() {
        presentation.clear();
        parent.repaint();
    }

    public void savePresentation() {
        try {
            new XMLAccessor().saveFile(presentation, SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void gotoPage() {
        String pageNumberStr = JOptionPane.showInputDialog((Object) PAGENR);
        try {
            int pageNumber = Integer.parseInt(pageNumberStr);
            presentation.setSlideNumber(pageNumber - 1);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public void showAboutBox(Frame parent) {
        JOptionPane.showMessageDialog(parent,
                "JabberPoint is a primitive slide-show program in Java(tm). It\n" +
                        "is freely copyable as long as you keep this notice and\n" +
                        "the splash screen intact.\n" +
                        "Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.\n" +
                        "Adapted by Gert Florijn (version 1.1) and " +
                        "Sylvia Stuurman (version 1.2 and higher) for the Open" +
                        "University of the Netherlands, 2002 -- now.\n" +
                        "Author's version available from http://www.darwinsys.com/",
                "About JabberPoint",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
