import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Conta {
	
	public boolean clienteEsp = false;
	public int conta, saque ,saldo;
	/**
	 * 
	 * aqui é criado uma variavel booleana para verificar se o cliente é especial ou não 
	 * e as variaveis, contam saque e saldo que irão guardar as informações de conta, saque e saldo do
	 * cliente 
	 */
	@Given("^um cliente especial com saldo atual de -(\\d+) reais$")
	public void um_cliente_especial_com_saldo_atual_de_reais(int conta) throws Throwable {
	    if( this.clienteEsp == true) {
	    	this.conta = conta;
	    }else 
	    	throw new PendingException();
	    /**
		 * nessa etapa o programa ira verificar se o cliente é aspecial 
		 * 
		 */
	}
	@When("^for solicitado um saque no valor de (\\d+) reais$")
	public void for_solicitado_um_saque_no_valor_de_reais(int saque) throws Throwable {
		if (this.clienteEsp == true) {
			this.saque = saque;
		}else 
			/**aqui sera solicitado um saque de R$100,00 rais
			 * 
			 */
	    throw new PendingException();
	}


@Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int saldo) throws Throwable {
	    if (this.clienteEsp == true) {
	    	saldo = this.conta - (this.saque);
	    }else 
	    	throw new PendingException();
	    /**
	     * se o cliente for especial o saque podera ser feito mesmo que a conta dele esteja negativa 
	     * como uma especie de credito especial
	     */
	}

@Given("^um cliente comum com saldo de -(\\d+) reais$")
public void um_cliente_comum_com_saldo_de_reais(int conta) throws Throwable{
		if(this.clienteEsp == false) {
	    	this.conta = conta*-1;
	    }else 
	    	throw new PendingException();
		/**
		 * este caso é de um cliente comum com um saldo negativo diferente do cliente especial
		 * ele não recebe direito de um credito especial 
		 */
	}

@When("^solicitar um saque de (\\d+) reais$")
public void solicitar_um_saque_de_reais(int saque) throws Throwable {
		if (this.clienteEsp == false) {
			this.saque = saque;
		}else 
			
			throw new PendingException();
		/**
		 * aqui se repete a função onde o cliente solicita um saque de 200 reais com a conta no negativo
		 */
	}

@Then("^não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente$")
public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_Saldo_Insuficiente() throws Throwable {
		 if (this.conta > 0 && this.saque < this.conta && this.clienteEsp == false ) {
			 saldo = this.conta - (this.saque);
		 }else if (this.saque > this.conta) {
			 System.out.println("Saldo Insuficiente!!");
			 
			 /** Se o saque for maior do que o dinheiro na conta o sistema ira informar
			  * uma mensagem de saldo insuficiente. 
			  * 
			 */ 
	}else 
		throw new PendingException();
	}
}
