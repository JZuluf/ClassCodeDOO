package co.edu.uco.ucobet.businesslogic.usecase;

public interface RuleWithoutFactory<T> {
	void execute(T data);
}
