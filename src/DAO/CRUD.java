package DAO;

import java.util.List;


/**
 *
 * @author koke
 */
public interface CRUD {
    public List listar();
    public int add(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(int id);
}
