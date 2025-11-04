/**
 * Exceção lançada quando uma operação tenta inserir elementos
 * em uma estrutura de dados que já está cheia.
 *
 * @author Yuri Kevin Nascimento de Araujo
 * @version 1.0
 * @since 2025-11-03
 */
public class OverflowException extends RuntimeException {

	/**
	 * Construtor que cria uma exceção com a mensagem especificada.
	 *
	 * @param mensagem a mensagem de erro
	 */
	public OverflowException(String mensagem) {
        super(mensagem);
    }
}