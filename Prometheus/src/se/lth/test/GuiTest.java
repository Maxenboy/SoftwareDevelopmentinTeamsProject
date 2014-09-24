package se.lth.test;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lth.GUI.FinishSelectionButton;
import se.lth.GUI.RegisterButton;
import se.lth.GUI.StartSelectionButton;
import se.lth.GUI.TimeSelectionButton;
import se.lth.GUI.Window;
import abbot.finder.BasicFinder;
import abbot.finder.ComponentNotFoundException;
import abbot.finder.Matcher;
import abbot.finder.MultipleComponentsFoundException;
import abbot.finder.matchers.WindowMatcher;
import abbot.tester.ComponentTester;
import abbot.tester.Robot;

public class GuiTest extends TestCase {
	File startFile, finishFile, resultFile;
	ComponentTester tester;
	BasicFinder finder;
	JTextArea textarea;
	JButton registerbutton;
	Robot robot;
	Window window;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		Window window = new Window();
		window.setName("GuiTest");
		robot = new Robot();
		tester = ComponentTester.getTester(window);
		finder = new BasicFinder();
		try {
			textarea = (JTextArea) finder.find(window, new Matcher() {
				public boolean matches(Component c) {
					return c instanceof JTextArea;

				}
			});
		} catch (ComponentNotFoundException e) {
			e.printStackTrace();
		} catch (MultipleComponentsFoundException e) {
			e.printStackTrace();
		}

		try {
			registerbutton = (RegisterButton) finder.find(window,
					new WindowMatcher("GuiTest") {
						public boolean matches(Component c) {
							return c instanceof JButton;

						}
					});
		} catch (ComponentNotFoundException e) {
			e.printStackTrace();
		} catch (MultipleComponentsFoundException e) {
			e.printStackTrace();
		}
		// tester.waitForFrameShowing("Program");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		finder = null;
		tester = null;
		textarea = null;
		registerbutton = null;
		robot = null;
		
		startFile = new File("start.txt");
		finishFile = new File("finish.txt");
		resultFile = new File("result.txt");
		startFile.delete();
		finishFile.delete();
		resultFile.delete();
	}

	@Test
	public void testTextArea() {
		textarea.setEditable(true);
		tester = ComponentTester.getTester(textarea);
		tester.actionFocus(textarea);
		tester.actionKeyString("hejsan");
		assertEquals("hejsan", textarea.getText());
		textarea.setEditable(false);
	}

	@Test
	public void testRegisterButton() {
		tester = ComponentTester.getTester(registerbutton);
		tester.actionClick(registerbutton);
		assertTrue(textarea.getText() != null);
	}

	@Test
	public void testEnterRegistration() {
		JTextField field = null;
		try {
			field = (JTextField) finder.find(window, new Matcher() {
				public boolean matches(Component c) {
					return c instanceof JTextField;

				}
			});
		} catch (ComponentNotFoundException e) {
			e.printStackTrace();
		} catch (MultipleComponentsFoundException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		assertEquals("", field.getText());
		assertTrue(textarea.getText() != null);
	}

	@Test
	public void testStartSelectionButton() {
		TimeSelectionButton timebutton = null;
		try {
			timebutton = (TimeSelectionButton) finder.find(window,
					new Matcher() {
						public boolean matches(Component c) {
							return c instanceof StartSelectionButton;
						}
					});
		} catch (ComponentNotFoundException e) {
			e.printStackTrace();
		} catch (MultipleComponentsFoundException e) {
			e.printStackTrace();
		}
		tester = ComponentTester.getTester(timebutton);
		tester.actionClick(timebutton);
		tester = ComponentTester.getTester(registerbutton);
		tester.actionClick(registerbutton);
		String s = textarea.getText();
		assertTrue(s.contains("start.txt"));

	}

	@Test
	public void testFinishSelectionButton() {
		TimeSelectionButton timebutton = null;
		try {
			timebutton = (TimeSelectionButton) finder.find(window,
					new Matcher() {
						public boolean matches(Component c) {
							return c instanceof FinishSelectionButton;
						}
					});
		} catch (ComponentNotFoundException e) {
			e.printStackTrace();
		} catch (MultipleComponentsFoundException e) {
			e.printStackTrace();
		}
		tester = ComponentTester.getTester(timebutton);
		tester.actionClick(timebutton);
		tester = ComponentTester.getTester(registerbutton);
		tester.actionClick(registerbutton);
		String s = textarea.getText();
		assertTrue(s.contains("finish.txt"));

	}

}
