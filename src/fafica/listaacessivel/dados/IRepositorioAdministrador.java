package fafica.listaacessivel.dados;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Administrador;

public interface IRepositorioAdministrador {
	public void adicionarAdministrador(Administrador administrador) throws SQLException;
	public void alterarAdministrador(Administrador administrador) throws SQLException;
	public void excluirAdministrador(Administrador administrador) throws SQLException;
	public List<Administrador> listarAdministradores() throws SQLException;
	public Administrador pesquisarAdministrador(Administrador administrador) throws SQLException;
}
