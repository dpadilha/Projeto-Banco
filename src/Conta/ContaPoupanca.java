package Conta;

import Cliente.Cliente;

public class ContaPoupanca extends Conta{
	public  ContaPoupanca(Cliente titular, double saldo){
		super(titular, saldo);
	}
	
	public ContaPoupanca(){
		super();
	}
	
	public ContaPoupanca(int numConta){
		super(numConta);
	}
}

