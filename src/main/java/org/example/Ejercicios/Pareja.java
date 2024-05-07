package org.example.Ejercicios;

public class Pareja<A> {

    private A primero;
    private A segundo;

    public Pareja(A primero, A segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public A getPrimero() {
        return primero;
    }

    public A getSegundo() {
        return segundo;
    }
}
