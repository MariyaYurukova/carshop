package carshop.repository;

public interface GenericRepository<E, ID> {

    E save(E entity);


}