package Ex39;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) throws IOException {
		Scanner ler = new Scanner(System.in);
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		
		int id, idade, opcao, idDest;
		double saldo, valorDeposito, valorTransf, valorSaque;
		String nome, agencia, numero;
		ContaBancaria conta;

		do {
			System.out.printf("\n===> Banco Macgyver <===\n\n");
			System.out.printf("1 - Criar cliente/conta\n"+
							  "2 - Depósito\n"+
							  "3 - Saque\n"+
							  "4 - Tranferência\n"+
							  "5 - Consultar saldo\n"+
							  "6 - Sair\n");
			System.out.printf("\nDigite a opção desejada: \n");
			opcao=ler.nextInt();
			if(opcao==1) {
				Cliente cliente = new Cliente();
				ContaBancaria ct = new ContaBancaria();
				id = listaClientes.size()+1;
				cliente.setId(id);
				
				System.out.printf("\nDigite o nome do cliente: ");
				nome=ler.next();
				cliente.setNome(nome);
				
				System.out.printf("Digite a idade do cliente: ");
				idade=ler.nextInt();
				cliente.setIdade(idade);
				
				System.out.printf("Digite a agência do conta: ");
				agencia=ler.next();
				ct.setAgencia(agencia);
				
				System.out.printf("Digite o número da conta: ");
				numero=ler.next();
				ct.setNumero(numero);
				conta=ct;
				
				cliente.setConta(conta);
				listaClientes.add(cliente);
				
				System.out.printf("Cliente cadastrado com sucesso!");
				System.in.read();
				
			}else if(opcao==2) {
				for(Cliente a: listaClientes) {
					System.out.printf("\nID: %d - NOME: %s "+
									  "\nAGENCIA: %s - NUMERO: %s\n",a.getId(),a.getNome().toUpperCase(),
							a.getConta().getAgencia(),a.getConta().getNumero());
				}
				System.out.printf("\nDigite o id da conta para depósito: ");
				id=ler.nextInt();
				
				System.out.printf("Digite o valor a ser depositado: ");
				valorDeposito=ler.nextDouble();
				
				Cliente cliente = listaClientes.get(id-1);
				cliente.getConta().Depositar(valorDeposito);
				
				System.out.printf("Valor depositado com sucesso!");
				System.in.read();
			}else if(opcao==3){
				for(Cliente a: listaClientes) {
					System.out.printf("\nID: %d - NOME: %s "+
									  "\nAGENCIA: %s - NUMERO: %s\n",a.getId(),a.getNome().toUpperCase(),
							a.getConta().getAgencia(),a.getConta().getNumero());
				}
				System.out.printf("\nDigite o id da conta para saque: ");
				id=ler.nextInt();
				Cliente cliente = listaClientes.get(id-1);
				
				System.out.printf("Digite o valor a ser sacado: ");
				valorSaque=ler.nextDouble();
				
				if(valorSaque>cliente.getConta().getSaldo()){
					System.out.printf("Saldo insuficiente!");
				}else{
				cliente.getConta().Sacar(valorSaque);
				
				System.out.printf("Valor sacado com sucesso!");
				System.in.read();
				}
			}else if(opcao==4) {
				for(Cliente a: listaClientes) {
					System.out.printf("\nID: %d - NOME: %s "+
									  "\nAGENCIA: %s - NUMERO: %s\n",a.getId(),a.getNome().toUpperCase(),
							a.getConta().getAgencia(),a.getConta().getNumero());
				}
				System.out.printf("\nDigite o id da sua conta: ");
				id=ler.nextInt();
				Cliente cliente = listaClientes.get(id-1);
				
				System.out.printf("Digite o valor a ser tranferido: ");
				valorTransf=ler.nextDouble();
				
				if(valorTransf>cliente.getConta().getSaldo()) {
					System.out.printf("Saldo insuficiente para transfêrencia!\n");
				}else {
					
				System.out.printf("Digite o id do destinatário: ");
				idDest=ler.nextInt();
				
				Cliente destinatario = listaClientes.get(idDest-1);
				cliente.getConta().Tranferir(valorTransf, destinatario);
				
				System.out.printf("Tranferência realizada com sucesso!\n");
				System.in.read();
				}
				
			}else if(opcao==5) {
				for(Cliente a: listaClientes) {
					System.out.printf("\nID: %d - NOME: %s "+
									  "\nAGENCIA: %s - NUMERO: %s\n",a.getId(),a.getNome().toUpperCase(),
							a.getConta().getAgencia(),a.getConta().getNumero());
				}
				System.out.printf("\nDigite o id da sua conta: ");
				id=ler.nextInt();
				Cliente cliente = listaClientes.get(id-1);
				
				System.out.printf("\nSaldo: R$%f\n",cliente.getConta().getSaldo());
				System.in.read();
			}
			
		}while(opcao!=6);
		ler.close();
	}

}
