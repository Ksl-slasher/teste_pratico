package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	private BigDecimal salario;
	private String funcao;
	
	public Funcionario(String nome, LocalDate dataNacimento, BigDecimal salario, String funcao) {
		super(nome, dataNacimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	
}
