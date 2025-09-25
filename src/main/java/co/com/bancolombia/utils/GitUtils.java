package co.com.bancolombia.utils;



import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.io.IOException;

public class GitUtils {

    public static void cloneRepository(String repoUrl, File destination) {
        try {
            if (destination.exists() && new File(destination, ".git").exists()) {
                System.out.println("Actualizando repo en " + destination.getAbsolutePath());
                try (Git git = Git.open(destination)) {
                    git.pull().call();
                }
                System.out.println("Repo actualizado.");
            } else {
                System.out.println("Clonando repo " + repoUrl + " en " + destination.getAbsolutePath());
                Git.cloneRepository()
                        .setURI(repoUrl)
                        .setDirectory(destination)
                        .call();
                System.out.println("Repo clonado correctamente.");
            }
        } catch (GitAPIException | IOException e) {
            throw new RuntimeException("Error al clonar/actualizar " + repoUrl, e);
        }
    }
}
