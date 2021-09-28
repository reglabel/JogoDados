package rbcl.registro;

public interface BD {
	public abstract void salvar(Object o);
	public abstract void excluir(Object o);
	public abstract void listar();
}
