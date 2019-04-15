import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
/*
 * Klasa w której znajduje siê Main, uruchamiaj¹cy program
 */
public class Frame extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu menuAplikacja;
	private JMenuItem menuZamknij;
	private Tabela t1;
	private DanePacjenta d1;
	private Badanie b1;

	public Frame() {
		this.setSize(1440, 800);
		this.setResizable(false);
		this.setTitle("Rejestracja wyników badañ");
		this.setLayout(null);
		
		//Tworzenie paska Menu wraz z jego komponentami
		menuBar = new JMenuBar();
		menuBar.setSize(1440, 30);

		this.getContentPane().add(menuBar);

		menuAplikacja = new JMenu("Aplikacja Profil lipidowy oznaczany we krwi");
		menuAplikacja.setSize(1440, 10);
		menuBar.add(menuAplikacja);

		menuZamknij = new JMenuItem("Zamknij");
		menuAplikacja.add(menuZamknij);
		menuZamknij.addActionListener(this);
		menuZamknij.setAccelerator(KeyStroke.getKeyStroke("alt F4"));

		//tworzenie obiektów, które znajduj¹ siê w g³ównym oknie programu
		t1 = new Tabela(this);
		d1 = new DanePacjenta(this);
		b1 = new Badanie(this);

		//dodawanie do g³ównego okna programu paneli
		getContentPane().add(t1.getPaneltabela());

		getContentPane().add(d1.getpDanePacjenta());

		getContentPane().add(b1.getpBadanie());

	}

	//wskazanie klasie Frame metody addPacjent
	void addPacjent(Pacjent p) {
		t1.addPacjent(p);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override

			public void run() {
				Frame app = new Frame();
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				app.setVisible(true);

			}
		});
	}
	
	//ActionListener zamykaj¹cy okno g³ówne aplikacji
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
