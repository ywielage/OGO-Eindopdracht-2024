import javax.swing.JOptionPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint {
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	/** The main program */
	public static void main(String[] argv) {
		
		Style.createStyles();
		Presentation presentation = new Presentation();
		new SlideViewerFrame(JABVERSION, presentation);
		try {
				String presentationTitle = "New Presentation";
				ArrayList<Slide> slides = new ArrayList<>();
				Slide slide = new Slide();
				slide.setTitle("Slide 1");
				slide.append(1, "The Java prestentation tool");
				slide.append(2, "Copyright (c) 1996-2000: Ian Darwin");
				slide.append(2, "Copyright (c) 2000-now:");
				slide.append(2, "Gert Florijn and Sylvia Stuurman");
				slide.append(4, "Calling Jabberpoint without a filename");
				slide.append(4, "will show this presentation");
				slide.append(1, "Navigate:");
				slide.append(3, "Next slide: PgDn or Enter");
				slide.append(3, "Previous slide: PgUp or up-arrow");
				slide.append(3, "Quit: q or Q");
				slides.add(slide);

				Slide secondSlide = new Slide();
				secondSlide.setTitle("Slide 2");
				secondSlide.append(1, "Level 1");
				secondSlide.append(2, "Level 2");
				secondSlide.append(1, "Again level 1");
				secondSlide.append(1, "Level 1 has style number 1");
				secondSlide.append(2, "Level 2 has style number 2");
				secondSlide.append(3, "This is how level 3 looks like");
				secondSlide.append(4, "And this is level 4");
				slides.add(secondSlide);

				XMLAccessor xmlAccessor = new XMLAccessor();
				xmlAccessor.createNewPresentation(presentation, "", presentationTitle, slides);
			presentation.setSlideNumber(0);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
