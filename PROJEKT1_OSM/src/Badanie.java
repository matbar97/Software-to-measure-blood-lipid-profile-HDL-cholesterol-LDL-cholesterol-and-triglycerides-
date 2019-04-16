import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

/*
 * Klasa w ktĂłrej generowany jest panel Badanie
 */
public class Badanie implements ActionListener {
	private JPanel pBadanie;
	private Frame frame;
	static JLabel lData;
	static JLabel lHDL;
	static JLabel lLDL;
	static JLabel lTG;
	static JTextField tfHDL;
	static JTextField tfLDL;
	static JTextField tfTG;
	static JSpinner sData;
	static SpinnerDateModel sdmData;
	static JButton bZapisz2, bAnuluj2;
	private java.util.Date date = java.util.Calendar.getInstance().getTime();

	// getter i setter dla panelu
	public JPanel getpBadanie() {
		return pBadanie;
	}

	public void setpBadanie(JPanel pBadanie) {
		this.pBadanie = pBadanie;
	}

	public Badanie(Frame frame) {
		this.frame = frame;

		// Panel Badanie i jego komponenty
		pBadanie = new JPanel();
		pBadanie.setBackground(Color.green);
		pBadanie.setLayout(null);
		pBadanie.setBorder(BorderFactory.createTitledBorder("Badanie"));
		pBadanie.setBounds(0, 455, 400, 295);

		lData = new JLabel("Data: ");
		pBadanie.add(lData);
		lData.setBounds(10, 10, 100, 80);
		lData.setEnabled(false);

		sdmData = new SpinnerDateModel();

		sData = new JSpinner(sdmData);
		pBadanie.add(sData);

		sData.setBounds(110, 35, 200, 30);
		sData.setEnabled(false);

		lHDL = new JLabel("HDL: ");
		pBadanie.add(lHDL);
		lHDL.setBounds(10, 60, 100, 80);
		lHDL.setEnabled(false);

		lLDL = new JLabel("LDL: ");
		pBadanie.add(lLDL);
		lLDL.setBounds(10, 110, 100, 80);
		lLDL.setEnabled(false);

		lTG = new JLabel("TG: ");
		pBadanie.add(lTG);
		lTG.setBounds(10, 160, 100, 80);
		lTG.setEnabled(false);

		tfHDL = new JTextField(null);
		pBadanie.add(tfHDL);
		tfHDL.setBounds(110, 85, 200, 30);
		tfHDL.setEnabled(false);

		tfLDL = new JTextField(null);
		pBadanie.add(tfLDL);
		tfLDL.setBounds(110, 135, 200, 30);
		tfLDL.setEnabled(false);

		tfTG = new JTextField(null);
		pBadanie.add(tfTG);
		tfTG.setBounds(110, 185, 200, 30);
		tfTG.setEnabled(false);

		bZapisz2 = new JButton("Zapisz");
		pBadanie.add(bZapisz2);
		bZapisz2.setBounds(10, 250, 75, 20);
		bZapisz2.addActionListener(this);
		bZapisz2.setEnabled(false);

		bAnuluj2 = new JButton("Anuluj");
		pBadanie.add(bAnuluj2);
		bAnuluj2.setBounds(85, 250, 75, 20);
		bAnuluj2.addActionListener(this);
		bAnuluj2.setEnabled(false);

	}

	// metoda sprawdzajÄ…ca czy Ĺ‚aĹ„cuch znakĂłw to Integer
	public boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	// ObsĹ‚uga zdarzeĹ„
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == bZapisz2)
			if (tfHDL.getText().isEmpty() == true || tfLDL.getText().isEmpty() == true
					|| tfTG.getText().isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "Wprowadz wszystkie dane", "Blad zapisu",
						JOptionPane.ERROR_MESSAGE);
			} else if (isStringInt(tfHDL.getText()) == false || Integer.parseInt(tfHDL.getText()) >= 10000
					|| Integer.parseInt(tfHDL.getText()) < 0) {
				JOptionPane.showMessageDialog(null, "Wprowadz wartosc HDL z zakresu 0-10000", "Blad zapisu",
						JOptionPane.ERROR_MESSAGE);
			} else if (isStringInt(tfLDL.getText()) == false || Integer.parseInt(tfLDL.getText()) >= 10000
					|| Integer.parseInt(tfLDL.getText()) < 0) {
				JOptionPane.showMessageDialog(null, "Wprowadz wartosc sLDL z zakresu 0-10000", "Blad zapisu",
						JOptionPane.ERROR_MESSAGE);
			} else if (isStringInt(tfTG.getText()) == false || Integer.parseInt(tfTG.getText()) >= 10000
					|| Integer.parseInt(tfTG.getText()) < 0) {
				JOptionPane.showMessageDialog(null, "Wprowadz wartosc trojglicerydow z zakresu 0-10000", "Blad zapisu",
						JOptionPane.ERROR_MESSAGE);
			}

			else {
				int i = Tabela.tabela.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "Wybierz pacjenta, do ktorego chcesz przyspisac wynik",
							"Blad zapisu", JOptionPane.ERROR_MESSAGE);
				} else {
					DanePacjenta.lista.get(i).setHDL(Integer.parseInt(tfHDL.getText()));
					DanePacjenta.lista.get(i).setLDL(Integer.parseInt(tfLDL.getText()));
					DanePacjenta.lista.get(i).setTG(Integer.parseInt(tfTG.getText()));
					DanePacjenta.lista.get(i).setData(sdmData.getDate());
					sdmData.setValue(date);

					Tabela.tabela.setValueAt(true, i, 4);

					tfHDL.setText(null);
					tfLDL.setText(null);
					tfTG.setText(null);

					tfHDL.setEnabled(false);
					tfLDL.setEnabled(false);
					tfTG.setEnabled(false);

					lHDL.setEnabled(false);
					lLDL.setEnabled(false);
					lTG.setEnabled(false);

					DanePacjenta.tfImie.setText(null);
					DanePacjenta.tfNazwisko.setText(null);
					DanePacjenta.tfPESEL.setText(null);
					DanePacjenta.rbKobieta.setSelected(false);
					DanePacjenta.rbMezczyzna.setSelected(false);
					DanePacjenta.cbUbezpieczenie.setSelectedIndex(-1);
					DanePacjenta.tfImie.setEnabled(false);
					DanePacjenta.lImie.setEnabled(false);
					DanePacjenta.tfNazwisko.setEnabled(false);
					DanePacjenta.lNazwisko.setEnabled(false);
					DanePacjenta.rbMezczyzna.setEnabled(false);
					DanePacjenta.rbKobieta.setEnabled(false);
					DanePacjenta.tfPESEL.setEnabled(false);
					DanePacjenta.lPlec.setEnabled(false);
					DanePacjenta.lPESEL.setEnabled(false);
					DanePacjenta.cbUbezpieczenie.setEnabled(false);
					DanePacjenta.lUbezpieczenie.setEnabled(false);
					DanePacjenta.bZapisz.setEnabled(false);
					DanePacjenta.bAnuluj.setEnabled(false);
					sData.setEnabled(false);
					lData.setEnabled(false);
					Tabela.tabela.clearSelection();
					bZapisz2.setEnabled(false);
					bAnuluj2.setEnabled(false);
					Tabela.bDodaj.setEnabled(true);   
				}

			}

		if (source == bAnuluj2) {
			int i = Tabela.tabela.getSelectedRow();
			if (i == -1) {
				Tabela.tabela.clearSelection();
			} else {
				tfLDL.setEnabled(true);
				tfHDL.setEnabled(true);
				tfTG.setEnabled(true);
				tfLDL.setText(null);
				tfHDL.setText(null);
				tfTG.setText(null);

				Tabela.tabela.setValueAt(false, i, 4);
				DanePacjenta.lista.get(i).setHDL(0);
				DanePacjenta.lista.get(i).setLDL(0);
				DanePacjenta.lista.get(i).setTG(0);
			}
		}
	}
}