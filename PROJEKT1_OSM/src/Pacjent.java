import java.util.Date;

/*
 * Klasa Pacjent
 */
public class Pacjent {

	private String mImie, mNazwisko, mPESEL, Plec, Ubezpieczenie;
	private int HDL, LDL, TG;
	private Date data;

	// konstruktory
	public Pacjent() {

	}

	public Pacjent(String mImie, String mNazwisko, String mPESEL, String Plec, String Ubezpieczenie, String HDL,
			String LDL, String TG, Date data) {
		super();
		this.mImie = mImie;
		this.mNazwisko = mNazwisko;
		this.mPESEL = mPESEL;
		this.Plec = Plec;
		this.Ubezpieczenie = Ubezpieczenie;
		this.HDL = 0;
		this.LDL = 0;
		this.TG = 0;
		this.data = Badanie.sdmData.getDate();
	}

	// gettery i settery
	public int getHDL() {
		return HDL;
	}

	public void setHDL(int hDL) {
		HDL = hDL;
	}

	public int getLDL() {
		return LDL;
	}

	public void setLDL(int lDL) {
		LDL = lDL;
	}

	public int getTG() {
		return TG;
	}

	public void setTG(int tG) {
		TG = tG;
	}

	public String getPlec() {
		return Plec;
	}

	public void setPlec(String plec) {
		Plec = plec;
	}

	public String getmImie() {
		return mImie;
	}

	public void setmImie(String mImie) {
		this.mImie = mImie;
	}

	public String getmNazwisko() {
		return mNazwisko;
	}

	public void setmNazwisko(String mNazwisko) {
		this.mNazwisko = mNazwisko;
	}

	public String getmPESEL() {
		return mPESEL;
	}

	public void setmPESEL(String mPESEL) {
		this.mPESEL = mPESEL;
	}

	public String getUbezpieczenie() {
		return Ubezpieczenie;
	}

	public void setUbezpieczenie(String ubezpieczenie) {
		Ubezpieczenie = ubezpieczenie;
	}

	// metody
	// metoda porĂłwnujÄ…ca pesele PacjentĂłw
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		Pacjent other = (Pacjent) obj;
		if (this.mPESEL == null) {
			if (other.mPESEL != null)
				return (false);
		} else if (!this.mPESEL.equals(other.mPESEL))
			return (false);
		return (true);
	}


	@Override
	public String toString() {
		return "Pacjent [mImie=" + mImie + ", mNazwisko=" + mNazwisko + ", mPESEL=" + mPESEL + ", Plec=" + Plec
				+ ", Ubezpieczenie=" + Ubezpieczenie + "" + "Data" + data + "]";
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}