package Apresentacao;

import javax.swing.JOptionPane;

import Cliente.Cliente;
import Conta.Conta;
import Conta.ContaBonificada;
import Conta.ContaPoupanca;
import Excecoes.ClienteInvalidoException;
import Excecoes.ClienteJaCadastradoException;
import Excecoes.ContaInvalidaException;
import Excecoes.ContaJaCadastradaException;
import Excecoes.SaldoInsuficienteException;
import Excecoes.ValorInvalidoException;
import Repositorio.RepositorioCliente;
import Repositorio.RepositorioConta;

public class FachadaBanco {
	RepositorioConta repConta;
	RepositorioCliente repCliente;
	Cliente cliente;
	
	public FachadaBanco(){
		repCliente = new RepositorioCliente();
		repConta = new RepositorioConta();
	}
	
	public void cadastrarCliente(String cpf, String nome, String dataNasc)
			throws ClienteJaCadastradoException{
		
		if(repCliente.existeCliente(cpf)){
			cliente = new Cliente(cpf, nome, dataNasc);
			repCliente.cadastrarCliente(cliente);
		}else {
			throw new ClienteJaCadastradoException();
		}
	}
	
	public void imprimirCliente(){
		repCliente.imprimir();
	}
	
	public void alterarCliente(String cpf, String nome, String dataNasc)
	throws ClienteInvalidoException{
		if(!repCliente.existeCliente(cpf)){
			repCliente.alterarCliente(cpf, nome, dataNasc);
		}else {
			throw new ClienteInvalidoException();
		}
	}
	
	public void inserirConta(String cpf,double saldo) throws ValorInvalidoException, 
	ClienteInvalidoException, ContaJaCadastradaException{
		Cliente clienteTemp = repCliente.exiteCliente(cpf);
		if(clienteTemp.getNumConta()== 0){
			if(clienteTemp.getCpf().equals(cpf)){
				if(saldo>=0){
					Conta c = new Conta(clienteTemp,saldo);
					repConta.inserirConta(c);
				}else{
					throw new ValorInvalidoException();
				}
			}
		}else{
			throw new ContaJaCadastradaException();
		}
		
	}
	//Insere conta poupança no RepositórioConta
	public void inserirContaPoupanca(String cpf,double saldo) throws ValorInvalidoException, 
	ClienteInvalidoException, ContaJaCadastradaException{
		//metodo que verifica se cliente existe no diretório repositórioCliente e retorna o cliente cujo o cpf é passado.
		Cliente clienteTemp = repCliente.exiteCliente(cpf);
		
		if(clienteTemp.getNumConta()== 0){
			if(clienteTemp.getCpf().equals(cpf)){
				if(saldo>=100.00){
					Conta c = new ContaPoupanca(clienteTemp,saldo);
					repConta.inserirConta(c);
				}else{
					throw new ValorInvalidoException();
				}
			}
		}else{
			throw new ContaJaCadastradaException();
		}
		
	}
	
	public void inserirContaBonificada(String cpf,double saldo) throws ValorInvalidoException, 
	ClienteInvalidoException, ContaJaCadastradaException{
		Cliente clienteTemp = repCliente.exiteCliente(cpf);
		if(clienteTemp.getNumConta()== 0){
			if(clienteTemp.getCpf().equals(cpf)){
				if(saldo>=5.0){
					Conta c = new ContaBonificada(clienteTemp,saldo);
					repConta.inserirConta(c);
				}else{
					throw new ValorInvalidoException();
				}
			}
		}else{
			throw new ContaJaCadastradaException();
		}
		
	}
	
	public double consultaSaldo(String cpf) throws ClienteInvalidoException, ContaInvalidaException{
		Cliente titular = repCliente.exiteCliente(cpf);
		Conta c = repConta.buscarConta(titular.getNumConta());
		return c.getSaldo();
	}
	
	
	public void realizarSaque(String cpf, double valor) throws ClienteInvalidoException, 
	ContaInvalidaException, SaldoInsuficienteException{
		Cliente titular = repCliente.exiteCliente(cpf);
		Conta c = repConta.buscarConta(titular.getNumConta());
		if(c.getSaldo()>=valor){
			double saldoAtual = c.getSaldo();
			c.setSaldo((saldoAtual - valor));
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.");
		}else{
			throw new SaldoInsuficienteException();
		}
	}
	
	public void realizarDeposito(String cpf, double valor) throws ClienteInvalidoException, 
	ContaInvalidaException, ValorInvalidoException{
		Cliente titular = repCliente.exiteCliente(cpf);
		Conta c = repConta.buscarConta(titular.getNumConta());
		if(valor>0){
			double saldoAtual = c.getSaldo();
			c.setSaldo((saldoAtual + valor));
			JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso.");
		}else{
			throw new ValorInvalidoException();
		}
	}
	
	public void Transferencia(String cpfTitular, String cpfDestino, double valor) throws ClienteInvalidoException,
	ContaInvalidaException, SaldoInsuficienteException{
		Cliente titular = repCliente.exiteCliente(cpfTitular);
		Conta conta1 = repConta.buscarConta(titular.getNumConta());
		Cliente titular2 = repCliente.exiteCliente(cpfDestino);
		Conta conta2 = repConta.buscarConta(titular2.getNumConta());
		if(conta1.getSaldo()>=valor){
			conta1.setSaldo(conta1.getSaldo() - valor);
			conta2.setSaldo(conta2.getSaldo() + valor);
		}else{
			throw new SaldoInsuficienteException();
		}
		
	}
	
}
