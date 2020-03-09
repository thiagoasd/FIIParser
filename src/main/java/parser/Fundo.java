package parser;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name= "findFundos", query="from Fundo f")
public class Fundo implements Serializable{
	
	@Id
	String ticket;
	String nome;
	float dividendo;
	float cotacaoAtual;
	
	
	public Fundo(String ticket, String nome, float dividendo, float cotacaoAtual) {
		this.ticket = ticket;
		this.nome = nome;
		this.dividendo = dividendo;
		this.cotacaoAtual = cotacaoAtual;
	}


	public String getTicket() {
		return ticket;
	}


	public void setTicket(String ticket) {
		this.ticket = ticket;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getDividendo() {
		return dividendo;
	}


	public void setDividendo(float dividendo) {
		this.dividendo = dividendo;
	}


	public float getCotacaoAtual() {
		return cotacaoAtual;
	}


	public void setCotacaoAtual(float cotacaoAtual) {
		this.cotacaoAtual = cotacaoAtual;
	}
	
	
	

}
