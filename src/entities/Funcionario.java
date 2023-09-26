package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Funcionario extends Pessoa{
	
	private BigDecimal salario;
	private String funcao;
	
	public Funcionario(String nome, LocalDate dataNacimento, BigDecimal salario, String funcao) {
		super(nome, dataNacimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public BigDecimal salariosMinimos(BigDecimal salarioMinimo) {
		return salario.divide(salarioMinimo, RoundingMode.HALF_UP);
	}
	public void aumentoSalarial(BigDecimal tax) {

		BigDecimal aux = tax.divide(new BigDecimal("100.00"));
		tax = aux;
		aux = salario.multiply(tax);
		salario = salario.add(aux);
		
		
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

	@Override
	public String toString() {
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat decForm1 = new DecimalFormat();
		decForm1.applyPattern("###,###.00");
		return getNome() + ", " + getDataNacimento().format(dtf1) + ", R$" + decForm1.format(salario) + ", " + funcao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(funcao, other.funcao);
	}
	
	
}
