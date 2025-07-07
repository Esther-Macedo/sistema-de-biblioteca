package interfaces;

public interface ISubject {
    public void registrarObservadores(IObservadorReserva observador);
    public void removerObservadores(IObservadorReserva observador);

    public void notificarObservadores();
}
