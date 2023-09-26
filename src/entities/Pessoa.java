package entities;

import java.time.LocalDate;

public class Pessoa {
	
	private String nome;
	private LocalDate dataNacimento;
	
	public Pessoa(String nome, LocalDate dataNacimento) {
		super();
		this.nome = nome;
		this.dataNacimento = dataNacimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(LocalDate dataNacimento) {
		this.dataNacimento = dataNacimento;
	}
	
	
	
	
}
