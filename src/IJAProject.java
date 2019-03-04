import gui.Tab;
import controller.Notation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class IJAProject {
    public static void main(String args[]) {
        
        /*Initialize main frame*/
        JFrame frame= new JFrame("IJA Project");
        frame.setSize(1100,850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        Font font = new Font("Verdana", Font.PLAIN, 15);


        /*Initialize JTabbedPane*/
        JTabbedPane tabPane = new JTabbedPane();
        tabPane.setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, 20 ) );
        Tab tabs = new Tab(tabPane, frame, "Game1"); // implicitly one game


        /*Menu panel*/
        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        menuGame.setFont(font);
        JMenuItem newGame = new JMenuItem("New");
        newGame.setFont(font);
        menuGame.add(newGame);

        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tab(tabPane,frame, "Game" + (Tab.getNumOfTabs()+1));
            }
        });

        JMenuItem loadGame = new JMenuItem("Load");
        menuGame.add(loadGame);
        loadGame.setFont(font);

        loadGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Notation notationName = new Notation(tabPane, frame);
                notationName.parseNotation();
            }
        });

        JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.setFont(font);
        menuGame.add(exitGame);

        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu menuView = new JMenu("View");
        menuView.setFont(font);

        frame.setJMenuBar(menuBar);
        menuBar.add(menuGame);
        menuBar.add(menuView);
        frame.add(tabPane);

        frame.setVisible(true);

        /**
         * Move string:
         * if returned piece not Pawn -> To string
         * Before calling setPiece get dst cell and call toString (dst)
         */
        System.out.println();
    }
}
