package Repositorio;

import java.util.ArrayList;

import Cliente.Cliente;
import Conta.Conta;
import Excecoes.ContaInvalidaException;

public class RepositorioConta {
	

	static ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public void inserirConta(Conta c){
		System.out.println(c);
		contas.add(c);
	}
	
	public Conta buscarConta(int numConta) throws ContaInvalidaException{
		for(Conta c:contas){
			if(c.getNumConta()==numConta){
				return c;
			}else{
				throw new ContaInvalidaException();
			}
		}
		throw new ContaInvalidaException();
	}

}
