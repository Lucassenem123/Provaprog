package prova;

import java.util.GregorianCalendar;
import java.util.Scanner;

class Idade {

	GregorianCalendar calendar = new GregorianCalendar();
	public int idade;
	public final int anoatual = calendar.get(GregorianCalendar.YEAR);
	public final int mesatual = calendar.get(GregorianCalendar.MONTH);
	public final int diaatual = calendar.get(GregorianCalendar.DAY_OF_MONTH);
	public int anoNasc;
	public int mesNsac;
	public int diaNasc;
	public char escolher;

	public Idade(int diaNasc, int mesNsac, int anoNasc) {
		this.diaNasc = diaNasc;
		this.mesNsac = mesNsac;
		this.anoNasc = anoNasc;
	}

	public void calculandoIdade() {

		if (this.diaNasc > 31 || this.mesNsac > 12 || this.diaatual > 31 || this.mesatual > 12) {
			System.out.println("Voc� digitou alguma data errada confira novamente!");
		} else if (this.mesNsac < this.mesatual) {
			this.idade = this.anoNasc - this.anoatual;
			System.out.println("Idade: " + this.idade + " anos");
		} else if (this.mesNsac > this.mesatual) {
			this.idade = this.anoatual - this.anoNasc - 1;
			System.out.println("Idade: " + this.idade + " anos");
		} else if (this.mesNsac == this.mesatual && this.diaNasc < this.diaatual) {
			this.idade = this.anoatual - this.anoNasc - 1;
			System.out.println("Idade: " + this.idade + " anos");
		} else if (this.mesNsac == this.mesatual && this.diaNasc > this.diaatual) {
			this.idade = this.anoatual - this.anoNasc;
		}
		;

	}

}

public class prova {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cont = 0;
		String nome;
		int categoria;
		String aposentado;
		double valorbeneficio = 0.0;
		double numfunc;
		int mesesdesempregado;
		String estado = "";
		int dia;
		int mes;
		int ano;
		int opcao;
		int empregadores;
		char escolher = 'N';
		double beneficioempregador;
		String nomecategoria = "";
		int mesesbeneficio = 0;
		
		String etapas = "";
		
		int contador = 0;
		int contadorbeneficiarios = 0;
		double totalconcedido = 0;

		int mesmaior = 0;
		int messegundo = 0;
		String nomemesmaior = "";
		String nomemessegundo = "";

		double maior = 0;
		String nomeMaior = "";
		double Smaior = 0;
		String nomeSegundoMaior = "";

		do {

			// Escolha da op��o no menu
			System.out.println("----------------------");
			System.out.println("---------Menu---------");
			System.out.println("1. Informar novo beneficiado\n" + "2. Encerrar programa");

			System.out.println("----------------------");
			opcao = sc.nextInt();

			// Verifica se a op��o � v�lida
			if (opcao > 2 || opcao < 1) {
				System.out.println("Op��o Inv�lida - informe uma op��o de (1-2)");
				escolher = 'N';
			} else {

				if (opcao == 2) {
					// Finaliza o programa
					escolher = 'S';
					break;
				}

				switch (opcao) {

				// Inicio Cadastro nome

				case 1: {

					System.out.println("Digite seu Nome");
					nome = sc.next();

					// Inicio Cadastro nome

					System.out.println("Digite o dia de nascimento do beneficiado");
					dia = sc.nextInt();
					while (dia > 31 || dia < 1) {
						System.out.println("Dia inv�lido - digite novamente");
						dia = sc.nextInt();
					}

					System.out.println("Digite o m�s de nascimento do beneficiado");
					mes = sc.nextInt();
					while (mes > 12 || mes < 1) {
						System.out.println("Mes inv�lido - digite novamente");
						mes = sc.nextInt();
					}

					System.out.println("Digite o ano de nascimento do beneficiado");
					ano = sc.nextInt();
					while (ano > 2021 || ano < 0) {
						System.out.println("Ano inv�lido - digite novamente");
						ano = sc.nextInt();
					}

					Idade i = new Idade(dia, mes, ano);
					i.calculandoIdade();
				

					if (i.idade < 18) {
						System.out.println("N�o pode receber o beneficio por ser menor de 18 anos");
					} else {
						
	
						contadorbeneficiarios++;
						// Inicio Categoria
						System.out.println("----------------------");
						System.out.println("Digite a categoria\n" + " 1 - Empregado \n" + " 2 - Empregador  \n"
								+ " 3 - Desempregado");
						categoria = sc.nextInt();

						int acrescimo = 0;
						int desc;

						// Fim Estado

						double beneficiomes;

						switch (categoria) {
						case 1:
							etapas = "";
							nomecategoria = "Empregado";
							etapas = etapas + "O benef�cio s� ser� concedido para maiores de 18 anos; ";
							

							System.out.println("Empregados receber�o entre R$1000 e R$1800");
							System.out.println("Digite o valor do beneficio");
							valorbeneficio = sc.nextDouble();

							while (valorbeneficio > 1800 || valorbeneficio < 1000) {
								System.out.println("Digite o valor v�lido");
								valorbeneficio = sc.nextDouble();
							}

							System.out.println("O beneficiario � aposentado?");
							aposentado = sc.next();
							if (aposentado.equalsIgnoreCase("Sim")) {
								System.out.println("Aposentado");

								// REGRA U
								System.out.printf("Ter� apenas 3 meses de beneficio R$%.2f%n", valorbeneficio);
								mesesbeneficio = 3;
								etapas = etapas + "O Benef�cio ser� de 3 meses para empregados; ";

								beneficiomes = valorbeneficio * 3;
								System.out.printf("Um total de 3 meses ser� retirado R$%.2f%n", beneficiomes);
							}

							// Inicio Estado
							System.out.println("Qual o seu UF?");
							estado = sc.next();

							if (estado.equalsIgnoreCase("PE")) {
								valorbeneficio = valorbeneficio + (valorbeneficio * 14 / 100);
								etapas = etapas + "Recebeu acrescimo de 14% por morar em PE; ";
							}

							else if (estado.equalsIgnoreCase("SP")) {
								valorbeneficio = valorbeneficio + (valorbeneficio * 10 / 100);
								etapas = etapas + "Recebeu acrescimo de 10% por morar em SP; ";
							}

							totalconcedido = totalconcedido + (valorbeneficio * mesesbeneficio);

							break;

						case 2:
							etapas = "";
							etapas = etapas + "O benef�cio s� ser� concedido para maiores de 18 anos; ";
							nomecategoria = "Empregador";
							
							System.out.println("MIN 2 MESES - MAX - 12 MESES BENEFICIOS");
							System.out.println("Digite o mes de beneficios");
							mesesbeneficio = sc.nextInt();

							while (mesesbeneficio > 12 || mesesbeneficio < 2) {
								System.out.println("Digite o valor v�lido");
								mesesbeneficio = sc.nextInt();
							}

							System.out.println("Quantos funcion�rios?");
							numfunc = sc.nextDouble();
							valorbeneficio = numfunc * 200;

							if (numfunc <= 50) {
								double acrescimofunc;
								acrescimofunc = valorbeneficio * 10 / 100;
								valorbeneficio = valorbeneficio + acrescimofunc;
								System.out.printf("O valor do beneficio ser� R$%.2f%n", valorbeneficio);
								etapas = etapas
										+ "Para empregadores que tenham at� 50 funcion�rios haver� um acr�scimo de 10% sobre o valor total; ";

							}

							// Inicio Estado
							System.out.println("Qual o seu UF?");
							estado = sc.next();

							if (estado.equalsIgnoreCase("PE")) {
								valorbeneficio = valorbeneficio + (valorbeneficio * 14 / 100);
								etapas = etapas + "Recebeu acrescimo de 14% por morar em PE; ";
							}

							else if (estado.equalsIgnoreCase("SP")) {
								valorbeneficio = valorbeneficio + (valorbeneficio * 10 / 100);
								etapas = etapas + "Recebeu acrescimo de 10% por morar em SP; ";

							}

							totalconcedido = totalconcedido + (valorbeneficio * mesesbeneficio);

							break;

						case 3:
							etapas = "";
							etapas = etapas + "O benef�cio s� ser� concedido para maiores de 18 anos; ";
							nomecategoria = "Desempregado";

							System.out.println("Digite o valor do beneficio");
							valorbeneficio = sc.nextDouble();
							while (valorbeneficio > 2300 || valorbeneficio < 1500) {
								System.out.println("Digite o valor v�lido");
								valorbeneficio = sc.nextDouble();
							}

							while (mesesbeneficio > 12 || mesesbeneficio < 2) {
								System.out.println("Digite o valor v�lido");
								mesesbeneficio = sc.nextInt();
							}

							System.out.println("Quantos meses est� desempregado?");
							mesesdesempregado = sc.nextInt();

							System.out.printf("Ter� apenas 6 meses de beneficio R$%.2f%n", valorbeneficio);
							mesesbeneficio = 6;
							etapas = etapas + "O benef�cio ser� de 6 meses para desempregado; ";

							beneficiomes = valorbeneficio * 6;
							System.out.printf("Um total de 6 meses ser� retirado R$%.2f%n", beneficiomes);

							// Inicio Estado
							System.out.println("Qual o seu UF?");
							estado = sc.next();

							if (estado.equalsIgnoreCase("PE")) {
								valorbeneficio = valorbeneficio + (valorbeneficio * 14 / 100);
								etapas = etapas + "Recebeu acrescimo de 14% por morar em PE; ";
							}

							else if (estado.equalsIgnoreCase("SP")) {
								valorbeneficio = valorbeneficio + (valorbeneficio * 10 / 100);
								etapas = etapas + "Recebeu acrescimo de 10% por morar em SP; ";
							}

							totalconcedido = totalconcedido + (valorbeneficio * mesesbeneficio);

							break;

						}
						System.out.println("----------------------");
						System.out.println("Nome completo: " + nome);
						System.out.println("Dia de nascimento: " + dia);
						System.out.println("Mes de nascimento: " + mes);
						System.out.println("Ano de nascimento: " + ano);
						System.out.println("Idade: " + i.idade);
						System.out.println("Estado: " + estado);
						System.out.println("Categoria: " + categoria + " - " + nomecategoria);
						System.out.println("Etapas Aplicadas: " + etapas);
						System.out.printf("Valor do beneficio: R$%.2f%n", valorbeneficio);
						System.out.println("----------------------");

						if (valorbeneficio > maior) {
							Smaior = maior;
							nomeSegundoMaior = nomeMaior;
							maior = valorbeneficio;
							nomeMaior = nome;

						} else if (valorbeneficio > Smaior) {
							Smaior = valorbeneficio;
							nomeSegundoMaior = nome;

						}

						if (mesesbeneficio > mesmaior) {
							nomemessegundo = nomemesmaior;
							messegundo = mesmaior;
							mesmaior = mesesbeneficio;
							nomemesmaior = nome;

						} else if (mesesbeneficio > messegundo) {
							messegundo = mesesbeneficio;
							nomemessegundo = nome;

						}

						contador++;

					}
				}
				}
			}

		} while (escolher == 'N');

		System.out.println("---------------------------------------------");
		System.out.println("Quantidade de us�rios cadastrados: " + contador);
		System.out.println("Total de benefici�rio " + contadorbeneficiarios);
		System.out.printf("O maior valor �: R$%.2f%n", maior);
		System.out.println("Nome do primeiro maior valor: " + nomeMaior);
		System.out.printf("O segundo maior �: R$%.2f%n", Smaior);
		System.out.println("Nome do segundo maior valor: " + nomeSegundoMaior);
		System.out.printf("Total de valor que ser� concedido R$%.2f%n", totalconcedido);
		System.out.println("O nome dos 2 benefici�rios que ir�o receber os benef�cios por mais tempo: " + nomemesmaior
				+ " - " + nomemessegundo);
		System.out.println("---------------------------------------------");
		sc.close();	

	}

}
