package co.com.bancolombia.tasks;


import co.com.bancolombia.exceptions.ScreenPlayException;
import co.com.bancolombia.tasks.annotations.CATask;
import co.com.bancolombia.utils.Util;

import java.io.File;
import java.io.IOException;

@CATask(
        name = "installInitializr",
        shortCut = "rinst",
        description = "Install node Dependencies for ScreenPlay Architecture Initializr"
)
public class RunInitializr extends  AbstracScreenPlayArchitectureDefaultTask{

    @Override
    public void execute() throws IOException, ScreenPlayException {
        logger.lifecycle("ScreenPlay architecture plugin version: {}", Util.getVersionPlugin());

        File baseDir = builder.getProject().getRootDir();
        File initializrDir = new File(baseDir, "initializr");
        File nodeModules = new File(initializrDir, "node_modules");

        // Detectar comando npm según el SO
        String npmCmd = System.getProperty("os.name").toLowerCase().contains("win")
                ? "npm.cmd"
                : "npm";

        try {
            // 1. Instalar dependencias solo si no existen
            if (!nodeModules.exists()) {
                logger.lifecycle("Installing dependencies...");
                ProcessBuilder install = new ProcessBuilder(npmCmd, "install", "--production");
                install.directory(initializrDir);
                install.inheritIO();
                Process installProcess = install.start();
                int exitCode = installProcess.waitFor();
                if (exitCode != 0) {
                    throw new ScreenPlayException("npm install failed with exit code " + exitCode);
                }
            }
            logger.lifecycle("Dependencies installed successfully.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ScreenPlayException("Error while running npm install");
        }
    }

}
