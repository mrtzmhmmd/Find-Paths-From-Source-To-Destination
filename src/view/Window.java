package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import bfs.BFS;
import dfs.DFS;
import readfile.ReadFile;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnDfs = new JButton("DFS");
		btnDfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadFile readingFromFile = new ReadFile("File.txt");
				int[][] arr = readingFromFile.readFileInArray();
				DFS dfs = new DFS(arr);
				dfs.printAllPaths(0, arr.length - 1);
			}
		});
		btnDfs.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnDfs);

		JButton btnBfs = new JButton("BFS");
		btnBfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadFile readingFromFile = new ReadFile("File.txt");
				int[][] arr = readingFromFile.readFileInArray();
				BFS bfs = new BFS(arr);
				bfs.bfs();
			}
		});
		btnBfs.setBounds(10, 45, 89, 23);
		frame.getContentPane().add(btnBfs);
	}
}