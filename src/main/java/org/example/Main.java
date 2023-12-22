package org.example;

import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        var solution = new OrtizSolution();
        var solverConfig = new SolverConfig()
                .withSolutionClass(OrtizSolution.class)
                .withEntityClasses(Item.class)
                .withConstraintProviderClass(OrtizConstraintProvider.class)
                .withTerminationSpentLimit(Duration.ofSeconds(10));
        SolverFactory<OrtizSolution> solverFactory = SolverFactory.create(solverConfig);
        var solver = solverFactory.buildSolver();
        var sol = solver.solve(solution);

        System.out.println(sol.getScore());
    }
}