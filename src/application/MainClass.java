package application;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import entities.Funcionario;
import entities.Pessoa;

public class MainClass {

	public static void main(String[] args) {
		
		DecimalFormat decForm1 = new DecimalFormat("###,###.00");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		List<Funcionario> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		//1
		Funcionario f1 = new Funcionario("Maria", LocalDate.parse("18/10/2000", dtf1 ),new BigDecimal( "2009.44"), "Operador");
		Funcionario f2 = new Funcionario("João", LocalDate.parse("12/05/1990", dtf1 ),new BigDecimal( "2284.38"), "Operador");
		Funcionario f3 = new Funcionario("Caio", LocalDate.parse("02/05/1961", dtf1 ),new BigDecimal( "9836.14"), "Coordenador");
		Funcionario f4 = new Funcionario("Miguel", LocalDate.parse("14/10/1988", dtf1 ),new BigDecimal( "19119.88"), "Diretor");
		Funcionario f5 = new Funcionario("Alice", LocalDate.parse("05/01/1995", dtf1 ),new BigDecimal( "2234.68"), "Recepcionista");
		Funcionario f6 = new Funcionario("Heitor", LocalDate.parse("19/11/1999", dtf1 ),new BigDecimal( "1582.72"), "Operador");
		Funcionario f7 = new Funcionario("Arthur", LocalDate.parse("31/03/1993", dtf1 ),new BigDecimal( "4071.84"), "Contador");
		Funcionario f8 = new Funcionario("Laura", LocalDate.parse("08/07/1994", dtf1 ),new BigDecimal( "3017.45"), "Gerente");
		Funcionario f9 = new Funcionario("Heloísa", LocalDate.parse("24/05/2003", dtf1 ),new BigDecimal( "1606.85"), "Eletricista");
		Funcionario f10 = new Funcionario("Helena", LocalDate.parse("02/09/1996", dtf1 ),new BigDecimal( "2799.93"), "Gerente");
		
		list.add(f1);
		list.add(f2);
		list.add(f3);
		list.add(f4);
		list.add(f5);
		list.add(f6);
		list.add(f7);
		list.add(f8);
		list.add(f9);
		list.add(f10);
		
		int controle = 1;
		while(controle == 1) {
			System.out.println("Qual das opções gostaria de utilizar? ");
			System.out.println();
			System.out.println("1 - Mostrar funcionários(Nome - Nascimento - Salário - Função).");
			System.out.println("2 - Remoção de funcionário. ");
			System.out.println("3 - Aumento salarial. ");
			System.out.println("4 - Agrupar funcionários por função. ");
			System.out.println("5 - Mostar aniversariantes. ");
			System.out.println("6 - Mostrar funcionário mais velho. ");
			System.out.println("7 - Mostrar funcionários em ordem alfabética. ");
			System.out.println("8 - Mostrar as despesas totais com salários. ");
			System.out.println("9 - Mostrar quantos salários mínimos cada funcionário ganha. ");
			System.out.println("10 - sair");
			System.out.println();
			System.out.print("R: ");
			int resposta = sc.nextInt();
			switch(resposta) {
				
				case 1: 
					System.out.println();
					for(Funcionario Funcionarios: list) {
						System.out.println(Funcionarios.toString());
					}
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 2: 
					System.out.println();
					for(Funcionario Funcionarios: list) {
						System.out.println(Funcionarios.toString());
					}
					System.out.println();
					System.out.print("Qual funcionário deseja remover? ");
					String sample = sc.next();
					System.out.println();
					
					for(int i = 0; i<list.size(); i++ ) {
						Funcionario p = list.get(i);
						if(p.getNome().equals(sample)) {
							list.remove(i);
						}
					}
					for(Funcionario Funcionarios: list) {
						System.out.println(Funcionarios.toString());
					}
					System.out.println();
					System.out.println("Funcionario '"+sample+"' removido.");
					System.out.println();
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 3: 
					System.out.println();
					System.out.print("Qual a porcentagem de aumento? ");
					String p = sc.next();
					System.out.println();
					for(Funcionario Funcionarios: list) {
						Funcionarios.aumentoSalarial(new BigDecimal(p));
						System.out.println(Funcionarios.toString());
						
					}
					break;
					
				case 4:
					List<String> listaOperador = new ArrayList<>();
					List<String> listaCoordenador = new ArrayList<>();
					List<String> listaDiretor = new ArrayList<>();
					List<String> listaRecepcionista = new ArrayList<>();
					List<String> listaContador = new ArrayList<>();
					List<String> listaGerente = new ArrayList<>();
					List<String> listaEletricista = new ArrayList<>();
					
					for(Funcionario Funcionarios: list) {
						if(Funcionarios.getFuncao().equals("Operador")) {
							listaOperador.add(Funcionarios.getNome());
						}
						if(Funcionarios.getFuncao().equals("Coordenador")) {
							listaCoordenador.add(Funcionarios.getNome());
						}
						if(Funcionarios.getFuncao().equals("Diretor")) {
							listaDiretor.add(Funcionarios.getNome());
						}
						if(Funcionarios.getFuncao().equals("Recepcionista")) {
							listaRecepcionista.add(Funcionarios.getNome());
						}
						if(Funcionarios.getFuncao().equals("Contador")) {
							listaContador.add(Funcionarios.getNome());
						}
						if(Funcionarios.getFuncao().equals("Gerente")) {
							listaGerente.add(Funcionarios.getNome());
						}
						if(Funcionarios.getFuncao().equals("Eletricista")) {
							listaEletricista.add(Funcionarios.getNome());
						}
					}
					
					Map<String, List<String>> mapaNomes = new HashMap<String, List<String>>();
					for(Funcionario Funcionarios: list) {
						if(Funcionarios.getFuncao().equals("Operador")) {
							mapaNomes.put(Funcionarios.getFuncao(), listaOperador);
						}
						if(Funcionarios.getFuncao().equals("Coordenador")){
							mapaNomes.put(Funcionarios.getFuncao(), listaCoordenador);
						}
						if(Funcionarios.getFuncao().equals("Diretor")) {
							mapaNomes.put(Funcionarios.getFuncao(), listaDiretor);
						}
						if(Funcionarios.getFuncao().equals("Recepcionista")) {
							mapaNomes.put(Funcionarios.getFuncao(), listaRecepcionista);
						}
						if(Funcionarios.getFuncao().equals("Contador")) {
							mapaNomes.put(Funcionarios.getFuncao(), listaContador);
						}
						if(Funcionarios.getFuncao().equals("Gerente")) {
							mapaNomes.put(Funcionarios.getFuncao(), listaGerente);
						}
						if(Funcionarios.getFuncao().equals("Eletricista")) {
							mapaNomes.put(Funcionarios.getFuncao(), listaEletricista);
						}
					}
					System.out.println();
					System.out.println(mapaNomes);
					System.out.println();
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 5:
					System.out.println();
					System.out.println("1 - Mês 10 ou 12.");
					System.out.println("2 - Outro mês");
					System.out.println();
					int res = sc.nextInt();
					if(res == 1 ) {
						for(Funcionario Funcionarios: list) {
							int mes = Funcionarios.getDataNacimento().getMonthValue();
							if((mes == 10) || mes == 12) {
								System.out.println(Funcionarios.toString());
							}
						}
						System.out.println();
						sc.nextLine();
						sc.nextLine();
					}
					if(res == 2) {
						System.out.println();
						System.out.print("De qual mes deseja ver os aniversariantes? ");
						res = sc.nextInt();
						for(Funcionario Funcionarios: list) {
							int mes = Funcionarios.getDataNacimento().getMonthValue();
							if((mes == res)) {
								System.out.println(Funcionarios.toString());
							}
						}
						System.out.println();
					}
					else {
						break;
					}
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 6:
					int maisVelho = 0;
					for(int i = 0; i < list.size(); i++) {
						if(list.get(i).getDataNacimento().isBefore(list.get(maisVelho).getDataNacimento())  ) {
							maisVelho = i;
						}
						for(int ii = list.size(); ii >= 0; ii--) {
							if(list.get(i).getDataNacimento().isBefore(list.get(maisVelho).getDataNacimento())  ) {
								maisVelho = ii;
							}
						}
					}
					int now = LocalDate.now().getYear();
					System.out.println("Funcionário mais velho: " + list.get(maisVelho).getNome() + ", "+ (now - list.get(maisVelho).getDataNacimento().getYear()) + " anos. " );
					System.out.println();
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 7: 
					List<Funcionario> listCopia = new ArrayList<>();
					for(Funcionario Funcionarios: list) {
						listCopia.add(Funcionarios);
					}
					listCopia.sort(new Comparator<Pessoa>(){
						@Override
						public int compare(Pessoa o1, Pessoa o2) {
			                return o1.getNome().compareTo(o2.getNome());
			            }
					});
					for(Funcionario Funcionarios: listCopia) {
						System.out.println(Funcionarios.toString());
					}
					System.out.println();
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 8:
					BigDecimal total = new BigDecimal(0);
					for(Funcionario Funcionarios: list) {
						total = total.add(Funcionarios.getSalario());
					}
					System.out.println("Despesa total: R$"+decForm1.format(total));
					System.out.println();
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 9:
					for(Funcionario Funcionarios: list) {
						System.out.println("Nome: "+ Funcionarios.getNome()+", Quantidade de salarios minimos: "+decForm1.format(Funcionarios.salariosMinimos(new BigDecimal("1212.00"))));
					}
					sc.nextLine();
					sc.nextLine();
					break;
					
				case 10:
					System.out.println();
					System.out.println("Até a próxima então! ");
					System.out.println();
					controle = 0;
					break;
			}
		
		}
		
		sc.close();

	}

}
