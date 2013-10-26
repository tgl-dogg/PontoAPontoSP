package inovapap.sp.avl;

import inovapap.sp.util.Parser;

public class linhaCodigo {

	private int linha;
	private int tipo;
	private int cd_linha;
	private int sentido;

	public linhaCodigo(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.linha = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.tipo = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.cd_linha = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.sentido = parse.intParse(txt);
		txt = parse.removeComma(txt);
	}

	public int getLinha() {
		return linha;
	}

	public int getTipo() {
		return tipo;
	}

	public int getCd_linha() {
		return cd_linha;
	}

	public int getSentido() {
		return sentido;
	}
}