package co.com.bancolombia.tasks;


import co.com.bancolombia.exceptions.ScreenPlayException;
import co.com.bancolombia.tasks.annotations.CATask;
import co.com.bancolombia.utils.Constants;
import co.com.bancolombia.utils.GitUtils;
import co.com.bancolombia.utils.Util;

import java.io.File;
import java.io.IOException;

@CATask(
        name = "initializr",
        shortCut = "ini",
        description = "Clona ScreenPlay Architecture Initializr"
)
public class CloneInitializr extends  AbstracScreenPlayArchitectureDefaultTask{

    @Override
    public void execute() throws IOException, ScreenPlayException {
        logger.lifecycle("ScreenPlay architecture plugin version: {}", Util.getVersionPlugin());
        File baseDir = builder.getProject().getRootDir(); // raíz del proyecto donde se ejecuta el plugin
        GitUtils.cloneRepository(Constants.SCREENPLAY_ARCHITECTURE_INITIALIZR, new File(baseDir, "initializr"));

    }
}
