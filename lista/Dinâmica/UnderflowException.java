/**
 * Exceção lançada quando uma operação tenta acessar ou remover elementos
 * de uma estrutura de dados que está vazia.
 *
 * @author Yuri Kevin Nascimento de Araujo
 * @version 1.0
 * @since 2025-11-03
 */
public class UnderflowException extends RuntimeException {

	/**
	 * Construtor que cria uma exceção com a mensagem especificada.
	 *
	 * @param mensagem a mensagem de erro
	 */
	public UnderflowException(String mensagem) {
        super(mensagem);
    }
}