package inovapap.sp.avl;

import inovapap.sp.util.Parser;

public class Veiculo {
	private int nrIdentificador;
	private int veiculo;

	public Veiculo(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.setNrIdentificador(parse.intParse(txt));
		txt = parse.removeComma(txt);

		this.setVeiculo(parse.intParse(txt));
	}

	public int getNrIdentificador() {
		return nrIdentificador;
	}

	public void setNrIdentificador(int nrIdentificador) {
		this.nrIdentificador = nrIdentificador;
	}

	public int getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(int veiculo) {
		this.veiculo = veiculo;
	}
}