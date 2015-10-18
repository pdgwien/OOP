package test;

import java.util.HashMap;

/**
*
* @author Mike
*/
public class OaschBaum
{
	private OaschJahr anfangsJahr;
	
	private float holzzuwachs;
	private float erntemenge;
	private float totholz;
	private float verwertung;
	private float verrottung;
	
	public OaschBaum(OaschJahr anfangsJahr, float holzzuwachs, float totholz, float erntemenge, float verwertung, float verrottung)
	{
		this.anfangsJahr = anfangsJahr;
		
		this.holzzuwachs = holzzuwachs;
		this.totholz = totholz;
		this.erntemenge = erntemenge;
		this.verwertung = verwertung;
		this.verrottung = verrottung;
	}
	
	public OaschBaum(float holzwald_beginn,
		float totholz_beginn,
		float ernte_beginn,
		float verwertung_beginn,
		float verrottung_beginn,
		float gebundenesCO2_beginn,
		float holzzuwachs,
		float totholz,
		float erntemenge,
		float verwertung,
		float verrottung)
	{
		this.anfangsJahr = new OaschJahr(0, holzwald_beginn, totholz_beginn, ernte_beginn, verwertung_beginn, verrottung_beginn, gebundenesCO2_beginn);
		
		this.holzzuwachs = holzzuwachs;
		this.totholz = totholz;
		this.erntemenge = erntemenge;
		this.verwertung = verwertung;
		this.verrottung = verrottung;
	}
	
	public HashMap<Integer, OaschJahr> getDaten(int jahre)
	{
		HashMap<Integer, OaschJahr> map = new HashMap<Integer, OaschJahr>();
		
		float holzwald_beginn = this.anfangsJahr.getHolzwald();
		float totholz_beginn = this.anfangsJahr.getTotholz();
		float ernte_beginn = this.anfangsJahr.getErnte();
		float verwertet_beginn = this.anfangsJahr.getVerwertet();
		float verrottet_beginn = this.anfangsJahr.getVerrottet();
		float gebundenesCO2_beginn = this.anfangsJahr.getGebundenesCO2();
		
		map.put(0, anfangsJahr);
		
		for(int i = 1; i <= jahre; i++)
		{
			holzwald_beginn += this.holzzuwachs - this.erntemenge - this.totholz;
			ernte_beginn += this.erntemenge;
			totholz_beginn += this.totholz;
			verwertet_beginn += ( this.verwertung * ernte_beginn ) / 100;
			verrottet_beginn += ( this.verrottung * totholz_beginn ) / 100;
			gebundenesCO2_beginn += (holzwald_beginn / 1000) - (totholz_beginn / 1000) - (ernte_beginn / 1000);
			
			map.put(i, new OaschJahr(i, holzwald_beginn, totholz_beginn, ernte_beginn, verwertet_beginn, verrottet_beginn, gebundenesCO2_beginn));
		}
		
		return map;
	}
}

class OaschJahr
{
	private int jahr;
	
	private float holzwald;
	private float totholz;
	private float ernte;
	private float verwertet;
	private float verrottet;
	private float gebundenesCO2;
	
	public OaschJahr(int jahr, float holzwald, float totholz, float ernte, float verwertet, float verrottet, float gebundenesCO2)
	{
		this.jahr = jahr;
		this.holzwald = holzwald;
		this.totholz = totholz;
		this.ernte = ernte;
		this.verwertet = verwertet;
		this.verrottet = verrottet;
		this.gebundenesCO2 = gebundenesCO2;
	}
	
	public int getJahr()
	{
		return this.jahr;
	}
	
	public float getHolzwald()
	{
		return this.holzwald;
	}
	
	public float getTotholz()
	{
		return this.totholz;
	}
	
	public float getErnte()
	{
		return this.ernte;
	}
	
	public float getVerwertet()
	{
		return this.verwertet;
	}
	
	public float getVerrottet()
	{
		return this.verrottet;
	}
	
	public float getGebundenesCO2()
	{
		return this.gebundenesCO2;
	}
	
	@Override
	public String toString()
	{
		return "Holzwald: "+this.holzwald+"\r\nTotholz: "+this.totholz+"\r\nErnte: "+this.ernte+"\r\nVerwertet: "+this.verwertet+"\r\nVerrottet: "+this.verrottet+"\r\nGebundenes CO�: "+this.getGebundenesCO2()+"\r\n\r\n";
	}
}