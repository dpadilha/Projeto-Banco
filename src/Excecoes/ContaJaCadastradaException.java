package Excecoes;

public class ContaJaCadastradaException extends Exception{
	public ContaJaCadastradaException(){
		super("Já existe conta cadastrada para este Cliente");
	}
}
