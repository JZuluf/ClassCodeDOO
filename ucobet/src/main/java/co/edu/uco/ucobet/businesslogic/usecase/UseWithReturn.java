package co.edu.uco.ucobet.businesslogic.usecase;

public interface UseWithReturn <D, R>{

	R execute(D data);
	
}
