package co.com.bancolombia.utils;

import java.util.List;
import java.util.Map;

public class Constants {

    public static final String PLUGIN_TASK_GROUP = "ScreenPlay Architecture";
    public static final String DEFINITION_FILE = "definition.json";
    public static final String APP_SERVICE = "app-service";

    public enum BooleanOption {
        TRUE,
        FALSE
    }

    public enum Language {
        JAVA,
        KOTLIN
    }

    public static final int Java17 = 17;

    public enum ProjectType {
        REST,
        UX
    }

    public static final String SCREENPLAY_ARCHITECTURE_INITIALIZR = "https://github.com/jumosqu12/screenplay_initializr.git";
    public static final String PLUGIN_VERSION = "2.0.0";
    public static final String BUILD_GRADLE = "./build.gradle";
    public static final String CRITICAL_ROOT_NAME = "rutacritica";
    public static final String GRADLE_PROPERTIES = "/gradle.properties";
    public static final String SETTINGS_GRADLE = "/settings.gradle";
    public static final String SERENITY_PROPERTIES = "./serenity.properties";
    public static final String BANCOLOMBIA_REPOSITORIES = "https://artifactory.apps.bancolombia.com/maven-bancolombia/";
    public static final String SERENITY_VERSION = "4.1.0";
    public static final String SERENITY_REST_LIBRARY = "net.serenity-bdd:serenity-screenplay-rest:$rootProject.ext.serenityVersion";
    public static final String SERENITY_UX_LIBRARY = "net.serenity-bdd:serenity-screenplay-webdriver:$rootProject.ext.serenityWebVersion";
    public static final Map<String, String> DATA_BASE_LIBRARY = Map.of(
            "mysql", "//MySQL library\n" +
                    "    implementation group: 'com.mysql', name: 'mysql-connector-j', version: '8.4.0'\n" +
                    "    //Additional library",
            "as400", "//AS400 library\n" +
                    "    implementation group: 'net.sf.jt400', name: 'jt400', version: '20.0.6'\n " +
                    "    //Additional library",
            "postgresql", "//postgresql library\n" +
                    "    implementation group: 'org.postgresql', name: 'postgresql', version: '42.7.3'\n" +
                    "    //Additional library",
            "oracle", "//Oracle library\n" +
                    "    implementation group: 'com.oracle.database.jdbc', name: 'ojdbc8', version: '23.2.0.0'\n" +
                    "    //Additional library",
            "sqlserver","//Sql Server library\n" +
                    "    implementation group: 'com.microsoft.sqlserver', name: 'mssql-jdbc', version: '12.7.0'\n" +
                    "    //Additional library");
    public static final Map<String, String> PARAM_CONFIG = Map.of(
            "mysql", "PASSMSQL",
            "as400", "PASSAS400",
            "postgresql", "PASSPSQL",
            "oracle", "PASSORACLE",
            "sqlserver","PASSSQLS");
    public static final String SERENITY_CUCUMBER_VERSION = "4.1.0";
    public static final String SERENITY_WEBDRIVER_VERSION = "serenityWebVersion = '4.1.0'";
    public static final String SERENITY_WEBDRIVER = "testImplementation(\"io.github.bonigarcia:webdrivermanager:5.4.1\")";
    public static final String LOMBOK_VERSION = "1.18.22";
    public static final String JUNIT = "4.13.2";
    public static final String HAMCREST = "1.3";
    public static final List<String> INTERACTIONS = List.of(new String[]{"POST", "GET", "PUT", "OPTIONS", "PATCH", "GENERIC"});
    public static final List<String> LANGUAGE = List.of(new String[]{"EN", "ES"});
    public static final List<String> TASKS = List.of(new String[]{"UX", "REST"});
    public static final List<String> SCENARIOS = List.of(new String[]{"Scenario", "Escenario", "Esquema del escenario", "Scenario Outline"});
    public static final List<String> STEPS = List.of(new String[]{"Dado", "Given"});
    public static final List<String> DATABASE = List.of(new String[]{"mysql", "postgresql", "oracle", "sqlserver", "as400"});
    public static final String SETTING_SYSTEM_CONFIG = "systemProperty 'PARAM', System.getProperty('PARAM')\n" +
            "    // System configs";
    public static final String METHODUI = "@Given(\"This method is responsible for parameterizing the instantiation of chromedriver\")" +
            "    public void thisMethodIsResponsibleForParameterizingTheInstantiationOfChromedriver() { " +
            "        OnStage.theActorInTheSpotlight().wasAbleTo(Open.browserOn().thePageNamed(\"pages.swaglabsUrl\"));" +
            "    }";




}
