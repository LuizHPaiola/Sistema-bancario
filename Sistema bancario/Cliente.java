package Ex39;

public class Cliente {
	private int id;
	private String nome;
	private int idade;
	private ContaBancaria conta;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public int getIdade() {
		return this.idade;
	}
	public void setIdade(int idade) {
		this.idade=idade;
	}
	public ContaBancaria getConta() {
		return this.conta;
	}
	public void setConta(ContaBancaria conta) {
		this.conta=conta;
	}
	public Cliente() {
		
	}
	public Cliente(int id, String nome, int idade, ContaBancaria conta) {
		this.id=id;
		this.nome=nome;
		this.idade=idade;
		this.conta=conta;
	}
		
}	
