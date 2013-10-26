package inovapap.sp.avl;

import inovapap.sp.util.Parser;

public class Linha {
	private String linha;
	private int tipo;
	private int cdLinha;
	private int sentido;

	public Linha(String line) {
		String txt = line;
		Parser parse = new Parser();

		this.linha = parse.stringParse(txt);
		txt = parse.removeComma(txt);

		this.tipo = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.cdLinha = parse.intParse(txt);
		txt = parse.removeComma(txt);

		this.sentido = parse.intParse(txt);
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCdLinha() {
		return cdLinha;
	}

	public void setCdLinha(int cdLinha) {
		this.cdLinha = cdLinha;
	}

	public int getSentido() {
		return sentido;
	}

	public void setSentido(int sentido) {
		this.sentido = sentido;
	}
}