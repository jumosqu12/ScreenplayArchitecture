/**
 * Copyright [2024] [Junior Mosquera Mosquera ]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.com.bancolombia.tasks;

import co.com.bancolombia.exceptions.ScreenPlayException;
import co.com.bancolombia.tasks.annotations.CATask;
import co.com.bancolombia.utils.Constants;
import co.com.bancolombia.utils.Constants.ProjectType;
import co.com.bancolombia.utils.Constants.Language;
import co.com.bancolombia.utils.Constants.BooleanOption;
import static co.com.bancolombia.utils.Constants.SERENITY_PROPERTIES;

import co.com.bancolombia.utils.FileUtil;
import co.com.bancolombia.utils.Util;
import org.gradle.api.tasks.options.Option;


import java.io.IOException;
import java.nio.file.Path;

@CATask(
        name = "screenPlayArchitecture",
        shortCut = "spa",
        description = "Scaffolding ScreenPlay architecture project"
)
public class GenerateArchitectureDefaultTask extends AbstracScreenPlayArchitectureDefaultTask{
    private String groupId = "co.com.example.test";
    private ProjectType type = ProjectType.UX;
    private String projectName = "Screenplay_architecture";
    private String principalPackage = "screen";
    private BooleanOption force = BooleanOption.FALSE;
    private Language language = Language.JAVA;
    private int javaVersion = Constants.Java17;

    @Option(option = "groupId", description = "Set group id to use in the project")
    public void setgroupId(String groupId) { this.groupId = groupId; }

    @Option(option = "principalPackage", description = "Set name principal package on project")
    public void principalPackage(String principalPackage) { this.principalPackage = principalPackage; }

    @Option(option = "type", description = "Set project type to implement")
    public void setType(ProjectType type) { this.type = type; }

    @Option(option = "projectName", description = "Set project name, by default is ScreenPlayArchitecture")
    public void name(String projectName) { this.projectName = projectName; }

    @Option(option = "language", description = "Set code language project, by default is Java")
    public void language(Language language) { this.language = language; }

    @Option(option = "javaVersion", description = "Set Java version")
    public void javaVersion(String javaVersion) { this.javaVersion = Integer.parseInt(javaVersion); }

    @Option(option = "force", description = "Force regenerates all files")
    public void setForce(BooleanOption force) {
        this.force = force;
    }


    @Override
    public void execute() throws IOException, ScreenPlayException {
        logger.lifecycle("ScreenPlay architecture plugin version: {}" , Util.getVersionPlugin());
        logger.lifecycle("Project Name: {}" , projectName);
        logger.lifecycle("Group id: {}" , groupId);
        logger.lifecycle("Principal Package: {}" , principalPackage);
        logger.lifecycle("Project type: {}" , type);
        logger.lifecycle("Java Version: {}" , javaVersion);
        builder.addGroupId(groupId);
        builder.addParam("projectName", projectName);
        builder.addParam("principalPackage", principalPackage);
        builder.addParam("language", language.name().toLowerCase());
        builder.addParam("libreryToUse", type.equals(ProjectType.UX) ?
                Constants.SERENITY_UX_LIBRARY:Constants.SERENITY_REST_LIBRARY);
        builder.addParam("webDriverV", type.equals(ProjectType.UX) ? Constants.SERENITY_WEBDRIVER_VERSION:"");
        builder.addParam("webDriverLibrary", type.equals(ProjectType.UX) ? Constants.SERENITY_WEBDRIVER:"");
        builder.addParam("javaVersion", javaVersion);
        builder.addParam("java11", javaVersion == Constants.Java17);
        builder.addParam("remoteRepository", Constants.BANCOLOMBIA_REPOSITORIES);
        builder.addParam("serenityV", Constants.SERENITY_VERSION);
        builder.addParam("cucumberV",Constants.SERENITY_CUCUMBER_VERSION);
        builder.addParam("junitV", Constants.JUNIT);
        builder.addParam("hamcrestV", Constants.HAMCREST);
        builder.addParam("versionLoom", Constants.LOMBOK_VERSION);
        builder.addParam("screenArchitectureV", Util.getVersionPlugin());
        builder.addParam("methodUserInterface", type.equals(ProjectType.UX) ? Constants.METHODUI:"");

        boolean exists = FileUtil.exists(builder.getProject().getProjectDir().getPath(), SERENITY_PROPERTIES);
        if (exists && force == BooleanOption.FALSE){
            logger.lifecycle("Another project was found in the same directory, rewriting build.gradle, gradle.properties and setting.gradle files ");
            builder.setupFromTemplate("structure/restructure", Constants.DEFINITION_FILE);
        }else{
            builder.setupFromTemplate("structure", Constants.DEFINITION_FILE);
        }
        if (type.equals(ProjectType.UX)) {
            builder.setupFromTemplate("structure", "definition_extra.json");
        }
        builder.persist();
    }

}
