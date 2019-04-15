import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * Klasa w której generowany jest panel Dane Pacjenta
 */

public class DanePacjenta implements ActionListener {
	protected JPanel pDanePacjenta;
	static JLabel lImie, lNazwisko, lPESEL, lP³eæ, lUbezpieczenie;
	static JTextField tfImie;
	static JTextField tfNazwisko;
	static JTextField tfPESEL;
	static JTextField tfHDL;
	static JTextField tfLDL;
	static JTextField tfTG;
	static JRadioButton rbKobieta, rbMê¿czyzna;
	static JButton bZapisz;
	static JButton bAnuluj;
	static JComboBox cbUbezpieczenie;
	static ButtonGroup bg;
	static ArrayList<Pacjent> lista;
	private String[] ubezpieczenie = { "Brak", "NFZ", "Prywatne" };
	private Frame frame;
	private int count = 0;

	// getter i setter dla panelu Dane Pacjenta
	public JPanel getpDanePacjenta() {
		return pDanePacjenta;
	}

	public void setpDanePacjenta(JPanel pDanePacjenta) {
		this.pDanePacjenta = pDanePacjenta;
	}

	public DanePacjenta(Frame frame) {
		this.frame = frame;

		// utworzenie, do której wpisywani s¹ pacjenci
		lista = new ArrayList<Pacjent>();

		// Panel DanePacjenta i jego komponenty
		pDanePacjenta = new JPanel();
		pDanePacjenta.setBackground(Color.GREEN);
		pDanePacjenta.setLayout(null);
		pDanePacjenta.setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
		pDanePacjenta.setBounds(0, 50, 400, 400);

		lImie = new JLabel("Imiê: ");
		pDanePacjenta.add(lImie);
		lImie.setBounds(10, 10, 100, 80);
		lImie.setEnabled(false);

		tfImie = new JTextField("");
		pDanePacjenta.add(tfImie);
		tfImie.setBounds(110, 35, 200, 30);
		tfImie.setEnabled(false);

		lNazwisko = new JLabel("Nazwisko: ");
		pDanePacjenta.add(lNazwisko);
		lNazwisko.setBounds(10, 60, 100, 80);
		lNazwisko.setEnabled(false);

		tfNazwisko = new JTextField("");
		pDanePacjenta.add(tfNazwisko);
		tfNazwisko.setBounds(110, 85, 200, 30);
		tfNazwisko.setEnabled(false);

		lPESEL = new JLabel("PESEL: ");
		pDanePacjenta.add(lPESEL);
		lPESEL.setBounds(10, 110, 100, 80);
		lPESEL.setEnabled(false);

		tfPESEL = new JTextField("");
		pDanePacjenta.add(tfPESEL);
		tfPESEL.setBounds(110, 135, 200, 30);
		tfPESEL.setEnabled(false);

		lP³eæ = new JLabel("P³eæ");
		pDanePacjenta.add(lP³eæ);
		lP³eæ.setBounds(10, 160, 100, 80);
		lP³eæ.setEnabled(false);

		bg = new ButtonGroup();
		rbKobieta = new JRadioButton();
		pDanePacjenta.add(rbKobieta);
		rbKobieta.setText("Kobieta");
		rbKobieta.setActionCommand("Kobieta");
		rbKobieta.setBounds(110, 185, 70, 30);
		rbKobieta.setEnabled(false);

		rbMê¿czyzna = new JRadioButton();
		pDanePacjenta.add(rbMê¿czyzna);
		rbMê¿czyzna.setText("Mê¿czyzna");
		rbMê¿czyzna.setActionCommand("Mê¿czyzna");
		rbMê¿czyzna.setBounds(200, 185, 90, 30);
		rbMê¿czyzna.setEnabled(false);

		bg.add(rbMê¿czyzna);
		bg.add(rbKobieta);

		lUbezpieczenie = new JLabel("Ubezpieczenie");
		pDanePacjenta.add(lUbezpieczenie);
		lUbezpieczenie.setBounds(10, 210, 100, 80);
		lUbezpieczenie.setEnabled(false);

		bZapisz = new JButton("Zapisz");
		pDanePacjenta.add(bZapisz);
		bZapisz.setBounds(10, 340, 75, 20);
		bZapisz.addActionListener(this);
		bZapisz.setEnabled(false);

		bAnuluj = new JButton("Anuluj");
		pDanePacjenta.add(bAnuluj);
		bAnuluj.setBounds(85, 340, 75, 20);
		bAnuluj.addActionListener(this);
		bAnuluj.setEnabled(false);

		cbUbezpieczenie = new JComboBox(ubezpieczenie);
		pDanePacjenta.add(cbUbezpieczenie);
		cbUbezpieczenie.setBounds(110, 242, 100, 20);
		cbUbezpieczenie.setSelectedIndex(-1);
		cbUbezpieczenie.setEnabled(false);

	}

	// metoda sprawdzaj¹ca czy ³añcuch znaków to Integer
	public boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	// Obs³uga zdarzeñ
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object source = e.getSource();

		if (source == bAnuluj) {
			tfImie.setText(null);
			tfNazwisko.setText(null);
			tfPESEL.setText(null);
			rbKobieta.setSelected(false);
			rbMê¿czyzna.setSelected(false);
			cbUbezpieczenie.setSelectedIndex(-1);
		}

		if (source == bZapisz) {

			// pêtla, która sprawdza, ile liczb zawiera wpisany pesel, mozna to zrobic w
			// metodzie pacjent ale mi nie pyklo
			if (tfImie.getText().isEmpty() == true || tfNazwisko.getText().isEmpty() == true
					|| tfPESEL.getText().isEmpty() == true || bg.getSelection() == null
					|| cbUbezpieczenie.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Wprowadz wszystkie dane", "B³¹d zapisu",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (DanePacjenta.tfPESEL.getText().length() != 11) {
				JOptionPane.showMessageDialog(null, "Wprowadz poprawny numer PESEL", "B³¹d zapisu",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (!DanePacjenta.tfImie.getText().matches("^[a-zA-Z]+$")
					|| !DanePacjenta.tfNazwisko.getText().matches("^[a-zA-Z]+$")) {
				JOptionPane.showMessageDialog(null, "Podaj prawid³owe Imiê i Nazwisko", "B³¹d zapisu",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			else {
				Pacjent p1 = new Pacjent(tfImie.getText(), tfNazwisko.getText(), tfPESEL.getText().toString(),
						bg.getSelection().getActionCommand(), cbUbezpieczenie.getSelectedItem().toString(), null, null,
						null, null);

				frame.addPacjent(p1);
				tfImie.setText(null);
				tfNazwisko.setText(null);
				tfPESEL.setText(null);
				bg.clearSelection();
				cbUbezpieczenie.setSelectedIndex(-1);
			}

			Tabela.bUsuñ.setEnabled(true);
			Tabela.bDodaj.setEnabled(true);
			tfImie.setEnabled(false);
			lImie.setEnabled(false);
			tfNazwisko.setEnabled(false);
			lNazwisko.setEnabled(false);
			rbMê¿czyzna.setEnabled(false);
			rbKobieta.setEnabled(false);
			tfPESEL.setEnabled(false);
			lP³eæ.setEnabled(false);
			lPESEL.setEnabled(false);
			cbUbezpieczenie.setEnabled(false);
			lUbezpieczenie.setEnabled(false);
			bZapisz.setEnabled(false);
			bAnuluj.setEnabled(false);
			Badanie.tfLDL.setEnabled(true);
			Badanie.lLDL.setEnabled(true);
			Badanie.tfHDL.setEnabled(true);
			Badanie.lHDL.setEnabled(true);
			Badanie.tfTG.setEnabled(true);
			Badanie.lTG.setEnabled(true);
			Badanie.bZapisz2.setEnabled(true);
			Badanie.bAnuluj2.setEnabled(true);
			Badanie.lData.setEnabled(true);
			Badanie.sData.setEnabled(true);
		}
	}
}