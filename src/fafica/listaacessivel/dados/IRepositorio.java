package fafica.listaacessivel.dados;

import java.sql.SQLException;
import java.util.List;

public interface IRepositorio <T> {
	
	public void adicionar(T entidade) throws SQLException;
	public void alterar(T entidade) throws SQLException;
	public void excluir(T entidade) throws SQLException;
	public List<T> listar() throws SQLException;
	public T pesquisar(T entidade) throws SQLException;
	
}
