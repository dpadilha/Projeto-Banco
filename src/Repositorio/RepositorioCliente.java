package Repositorio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Cliente.Cliente;
import Excecoes.ClienteInvalidoException;


public class RepositorioCliente {
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public void cadastrarCliente(Cliente cliente){
		clientes.add(cliente);
	}
	
	public static boolean existeCliente(String cpf){
		boolean f = true;
		for(Cliente c : clientes){
			if(cpf.equals(c.getCpf())){
				f = false;
				
				return f;
			}
		}
		return f;
	}
	
	public Cliente exiteCliente(String cpf) throws ClienteInvalidoException{
		for(Cliente c:clientes){
			if(cpf.equals(c.getCpf())){
				return c;
			}
		}
		throw new ClienteInvalidoException();
	}
	
	public void imprimir(){
		for(Cliente c: clientes){
			JOptionPane.showConfirmDialog(null, "Cliente...\nCPF: " + c.getCpf()
					+ "\nNome: " + c.getNome() 
					+ "\nData de Nasc.: " + c.getDataNasc());
		}
	}
	
	public void alterarCliente(String cpf, String nome, String dataNasc){
		
		for(Cliente c : clientes){
			if(cpf.equals(c.getCpf())){
				c.setNome(nome);
				c.setDataNasc(dataNasc);
			}
		}
		
	}
	
	
	
}
