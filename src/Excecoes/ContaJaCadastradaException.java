package Excecoes;

public class ContaJaCadastradaException extends Exception{
	public ContaJaCadastradaException(){
		super("J� existe conta cadastrada para este Cliente");
	}
}
