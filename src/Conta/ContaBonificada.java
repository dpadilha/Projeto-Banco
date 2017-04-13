package Conta;

import Cliente.Cliente;

public class ContaBonificada extends Conta{
	public ContaBonificada(Cliente titular, double saldo){
		super(titular,saldo);
	}
	public ContaBonificada(int numConta){
		super(numConta);
	}
	public ContaBonificada(){
		super();
	}
	
}
