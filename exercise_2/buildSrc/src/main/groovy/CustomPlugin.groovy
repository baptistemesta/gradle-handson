import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        def customTask = project.task("customTask"){
            doFirst{
                project.logger.quiet("Executing custom task on ${project.name}")
            }
        }
        project.tasks.getByName("build").dependsOn customTask
    }
}