package Apresentacao;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Excecoes.ClienteInvalidoException;
import Excecoes.ClienteJaCadastradoException;

public class Banco {
	
	public static void main(String[] args) {
		
		FachadaBanco fachada = new FachadaBanco();
		
		int opcao = 0;
		
		while(opcao != 14){
			
			try {
				
				opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Cliente\n "
						+ "2 - Listar Clientes\n "
						+ "3 - Atualizar Dados de Clientes\n "
						+ "4 = Abrir Conta Corrente\n "
						+ "5 - Abrir Conta Poupança\n "
						+ "6 - Abrir Conta Bonificada\n "
						+ "7 - Consultar Saldo\n "
						+ "8 - Realizar Saque\n "
						+ "9 - Realizar deposito\n "
						+ "10 - Realizar Tranferencia\n "
						+ "11 - Reder Juros\n "
						+ "12 - Reder Bonus\n "
						+ "13 - Encerar Conta\n "
						+ "14 - Finalizar Sistema"));
								
				switch (opcao) {
				case 1:
					
					JOptionPane.showConfirmDialog(null, "Para cadastrar um cliente informe:"
							+ "\n CPF, NOME, e DATA DE NASCIMENTO");
					
					String cpf = JOptionPane.showInputDialog("Digite o cpf do Cliente");
					String nome = JOptionPane.showInputDialog("Digite o nome do Cliente");
					String dataNasc = JOptionPane.showInputDialog("Digite a data de nascimento do Cliente");
					
					try {
						fachada.cadastrarCliente(cpf, nome, dataNasc);
						JOptionPane.showConfirmDialog(null, "Cliente Cadastro.");
						
					} catch (ClienteJaCadastradoException e) {
						
						JOptionPane.showConfirmDialog(null, e.getMessage());
					}
					
					break;
					
				case 2:
					
					fachada.imprimirCliente();
					break;
				case 3:
					
					String cpf3 = JOptionPane.showInputDialog("Digite o cpf do Cliente");
					String nome3 = JOptionPane.showInputDialog("Digite o nome do Cliente");
					String dataNasc3 = JOptionPane.showInputDialog("Digite a data de nascimento do Cliente");

					try {
						fachada.alterarCliente(cpf3, nome3, dataNasc3);
						JOptionPane.showConfirmDialog(null, "Cliente Alterado");
					
					} catch (ClienteInvalidoException e) {
						JOptionPane.showConfirmDialog(null, e.getMessage());
					}
					break;
				case 4:
					String cpf4 = JOptionPane.showInputDialog("Digite o cpf do cliente: ");
					double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: "));
					try{
						fachada.inserirConta(cpf4, valor);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 5:
					String cpf45 = JOptionPane.showInputDialog("Digite o cpf do cliente: ");
					double valor5 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: "));
					try{
						fachada.inserirContaPoupanca(cpf45, valor5);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 6:
					String cpf6 = JOptionPane.showInputDialog("Digite o cpf do cliente: ");
					double valor6 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: "));
					try{
						fachada.inserirContaBonificada(cpf6, valor6);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				case 7:
					try{
						String cpf7 =JOptionPane.showInputDialog("Digite o cpf do titular da conta: ");
						double saldo = fachada.consultaSaldo(cpf7);
						JOptionPane.showMessageDialog(null, "Saldo da conta é: "+saldo);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 8:
					String cpf8 =JOptionPane.showInputDialog("Digite o cpf do titular da conta: ");
					double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque"));
					try{
						fachada.realizarSaque(cpf8, valorSaque);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 9:
					String cpf9 =JOptionPane.showInputDialog("Digite o cpf do titular da conta: ");
					double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do deposito"));
					try{
						fachada.realizarDeposito(cpf9, valorDeposito);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 10:
					try{
						String cpfT =JOptionPane.showInputDialog("Digite o cpf do titular da conta: ");
						String cpfR =JOptionPane.showInputDialog("Digite o cpf do titular da conta: ");
						double valorTransf = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do deposito"));
						fachada.Transferencia(cpfT, cpfR, valorTransf);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
					break;
					
				default:
					break;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
