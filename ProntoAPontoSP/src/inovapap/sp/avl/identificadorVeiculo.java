package inovapap.sp.avl;

import inovapap.sp.util.Parser;

public class identificadorVeiculo {

	private int nrIdentificador;
	private int veiculo;

	public identificadorVeiculo(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.nrIdentificador = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.veiculo = parse.intParse(txt);
		txt = parse.removeComma(txt);
	}

	public int getNrIdentificador() {
		return nrIdentificador;
	}

	public int getVeiculo() {
		return veiculo;
	}
}