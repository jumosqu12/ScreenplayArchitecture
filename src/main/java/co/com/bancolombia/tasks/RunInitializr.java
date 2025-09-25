package co.com.bancolombia.tasks;


import co.com.bancolombia.exceptions.ScreenPlayException;
import co.com.bancolombia.tasks.annotations.CATask;
import co.com.bancolombia.utils.Util;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

@CATask(
        name = "runInitializr",
        shortCut = "rini",
        description = "Execute ScreenPlay Architecture Initializr"
)
public class RunInitializr extends  AbstracScreenPlayArchitectureDefaultTask{

    @Override
    public void execute() throws IOException, ScreenPlayException {
        logger.lifecycle("ScreenPlay architecture plugin version: {}", Util.getVersionPlugin());
        File baseDir = builder.getProject().getRootDir(); // raíz del proyecto donde se ejecuta el plugin

        // Ejecutar Express
        File serverDir = new File(baseDir, "initializr/dist");
        ProcessBuilder express = new ProcessBuilder("node", "index.js");
        express.directory(serverDir);
        express.inheritIO(); // para ver los logs en la terminal
        Process process = express.start();

        logger.lifecycle("Initializr running: Express + React on  http://localhost:4000");
        logger.lifecycle("Keep this terminal open while using the project.");

        try {
            // Bloquea el hilo para que el proceso no muera
            process.waitFor();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ScreenPlayException("Error while running Express server");
        }
    }
}
