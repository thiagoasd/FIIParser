package parser;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cotacao {

	@Id
	String nome;
	float valor;
	float dividendo;
	float yield;

	public Cotacao(String nome, float valor, float dividendo) {
		this.nome = nome;
		this.valor = valor;
		this.dividendo = dividendo;
		yield = dividendo / valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String toString() {

		return nome + " | " + valor;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.nome);

	}

	@Override
	public boolean equals(Object cotacao) {
		if (cotacao.getClass() == getClass()) {
			return (this.nome.compareTo(((Cotacao) cotacao).getNome()) == 0);
		} else {
			return false;
		}
	}

}
