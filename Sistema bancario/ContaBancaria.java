package Ex39;

public class ContaBancaria {
	private String agencia;
	private String numero;
	private double saldo;
	
	public String getAgencia(){
		return this.agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia=agencia;
	}
	public String getNumero() {
		return this.numero;
	}
	public void setNumero(String numero) {
		this.numero=numero;
	}
	public double getSaldo() {
		return this.saldo;
	}
	ContaBancaria(){
		
	}
	ContaBancaria(String agencia, String numero, double saldo){
		this.agencia=agencia;
		this.numero=numero;
		this.saldo=saldo;
	}
	public void Depositar(double valorDeposito) {
		this.saldo=this.saldo+valorDeposito;
	}
	public void Sacar(double valorSaque) {
		this.saldo=this.saldo-valorSaque;
	}
	public void Tranferir(double valorTransf, Cliente destinatario) {
		this.saldo=this.saldo-valorTransf;
		destinatario.getConta().Depositar(valorTransf);
	}
	public double ConsultarSaldo(){
		return this.saldo;
	}
}
