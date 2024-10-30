package co.edu.uco.ucobet.businesslogic.adapter;

import java.util.List;

public interface Adapter<D, T> {
	D adaptSource(T data);
	
	T adaptTarget(D data);
	
	List<T> adaptTarget(List<D> data);
}
