package rs2;

import java.net.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
//import javax.swing.plaf.metal.MetalLookAndFeel;
//import java.util.Arrays;
//import java.io.File;
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;

public class SwingUI extends Client implements ActionListener {

    /**
	 *
	 */
	private static final long serialVersionUID = -6669540533506671428L;
	//private static JMenuItem menuItem;
	private JFrame frame;

	public SwingUI(String args[]) {
		super();
		try {
			Signlink.startpriv(InetAddress.getByName(server));
			initUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void initUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			frame = new JFrame("Clienthax 317 rs2.Client haxerownsmopar@hotmail.co.uk");
			frame.setLayout(new BorderLayout());
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel gamePanel = new JPanel();

			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(this);
			gamePanel.setPreferredSize(new Dimension(765, 503));

			initMenubar();
			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			frame.pack();

			frame.setVisible(true); // can see the rs2.Client
			frame.setResizable(false); // resizeable frame

			init();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}


	    public void displayWorldSelect() {
	      try {
	       String s = JOptionPane.showInputDialog(this, "New IP:");

	       if (s == null) {
	       } else if (s.equalsIgnoreCase("")) {
	        } else {
	         server = s;
	        }
	      }
	      catch (Exception e) {
	     }
	   }

	    public void displayPaypal() {
	      try {
	       String s = JOptionPane.showInputDialog(this, "Pease donate paypal clienthax@gmail.com, msn haxerownsmopar@hotmail.co.uk");

	       if (s == null) {
	       } else if (s.equalsIgnoreCase("")) {
	        } else {
	        }
	      }
	      catch (Exception e) {
	     }
	   }

	public void initMenubar() {
			JMenu fileMenu = new JMenu("File");
			String[] mainButtons = new String[] { "317", "PI", "Forums","IP", "-", "Exit" };
			for (String name : mainButtons) {
				JMenuItem menuItem = new JMenuItem(name);
				if (name.equalsIgnoreCase("-")) {
					fileMenu.addSeparator();
				} else if(name.equalsIgnoreCase("Forums")) {
					JMenu forumsMenu = new JMenu("Forums");
					fileMenu.add(forumsMenu);
					JMenuItem runeServer = new JMenuItem("Rune-Server");
					runeServer.addActionListener(this);
					forumsMenu.add(runeServer);
				} else if(name.equalsIgnoreCase("IP")) {
					JMenu IPmenu = new JMenu("IP");
					fileMenu.add(IPmenu);
					JMenuItem changeIP = new JMenuItem("change ip");
					changeIP.addActionListener(this);
					IPmenu.add(changeIP);
				} else if(name.equalsIgnoreCase("317")) {
					JMenu menu317 = new JMenu("317 Mode");
					fileMenu.add(menu317);
					JMenuItem playerFix317 = new JMenuItem("Player Bit Fix (enable 317 mode)");
					playerFix317.addActionListener(this);
					menu317.add(playerFix317);
				} else if(name.equalsIgnoreCase("PI")) {
					JMenu menuPI = new JMenu("PI Mode");
					fileMenu.add(menuPI);
					JMenuItem playerFixPI = new JMenuItem("Player Bit Fix (enable PI mode)");
					playerFixPI.addActionListener(this);
					menuPI.add(playerFixPI);
				} else {
					menuItem.addActionListener(this);
					fileMenu.add(menuItem);
				}
				
			}

			//displayPaypal();

			JMenuBar menuBar = new JMenuBar();
			JMenuBar jmenubar = new JMenuBar();

			frame.add(jmenubar);
			menuBar.add(fileMenu);
			frame.getContentPane().add(menuBar, BorderLayout.NORTH);
	}

	public URL getCodeBase() {
		try {
			return new URL("http://" + server + "/cache");
		} catch (Exception e) {
			return super.getCodeBase();
		}
	}
	
	public int getPlayerBitAmmount()
	{System.out.println("lol nigga "+playerBitAmmount);
		return playerBitAmmount;
	}

	public URL getDocumentBase() {
		return getCodeBase();
	}

	public void loadError(String s) {
		System.out.println("loadError: " + s);
	}

	public String getParameter(String key) {
			return "";
	}

	private static void openURL(String url) {
		Desktop d = Desktop.getDesktop();
		try {
			d.browse(new URI(url));
		} catch (Exception e) {
		}
	}

	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		try {
			if (cmd != null) {
				if (cmd.equalsIgnoreCase("exit")) {
					System.exit(0);
				} else if (cmd.equalsIgnoreCase("Rune-Server")) {
					openURL("http://www.rune-server.org/forums.php");
				} else if (cmd.equalsIgnoreCase("change ip")) {
					displayWorldSelect();
				} else if (cmd.equalsIgnoreCase("Player Bit Fix (enable 317 mode)")) {
					playerBitAmmount = 12;
				}else if (cmd.equalsIgnoreCase("Player Bit Fix (enable PI mode)")) {
					playerBitAmmount = 14;
				}

			}
		} catch (Exception e) {
		}
	}
}
