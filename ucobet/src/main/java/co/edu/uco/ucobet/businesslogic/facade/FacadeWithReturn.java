package co.edu.uco.ucobet.businesslogic.facade;

public interface FacadeWithReturn<T, R> {
	R execute (T data);
}
