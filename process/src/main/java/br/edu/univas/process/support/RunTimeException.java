package br.edu.univas.process.support;

import org.springframework.core.NestedExceptionUtils;

public class RunTimeException {
	
	public static void main(String[] args) {
        try {
        } catch (RuntimeException e) {
            handleRuntimeException(e);
        }
    }

    private static void handleRuntimeException(RuntimeException e) {
        System.out.println("Um erro ocorreu durante a execução do projeto Maven.");
        System.out.println("Detalhes do erro:");
        System.out.println(NestedExceptionUtils.getRootCause(e));
    }

}
