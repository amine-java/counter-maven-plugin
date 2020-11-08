package com.mbh.plugin;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * <b>CounterDependenciesMojo</b> - goal <i>"counter-dependencies"</i> counts the number of dependencies within your project and displays it on the console 
 * 
 * @author m.boufatah
 *
 */
@Mojo(name = "counter-dependencies" , defaultPhase = LifecyclePhase.COMPILE)
public class CounterDependenciesMojo extends AbstractMojo {

	/** Maven Project injected automatically **/
	@Parameter(defaultValue = "${project}", required = true, readonly = true)
	private MavenProject project;
	
	/** Group id to be excluded from counting **/
	@Parameter(property = "excluding")
	private String excludeGroupId; 
	
	/**
	 * Execute Mojo
	 */
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		int size = 0 ;
		getLog().info("exludeGroupId is equal to: " + excludeGroupId);
		if (excludeGroupId != null && excludeGroupId.length() != 0 ) {
			getLog().info("Using a filter to exclude all dependencies with groupId starting by: " + excludeGroupId);
			for (Object object : project.getDependencies()) {
					Dependency dependency = (Dependency) object;
					if (!dependency.getGroupId().startsWith(excludeGroupId)) {
						size++;
					}
			}
		}else {
			getLog().info("Counter without filter");
			size = project.getDependencies().size();		
		}
		getLog().info("Your project has " + size + " dependencies");
	}

}
