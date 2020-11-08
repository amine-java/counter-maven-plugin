package com.mbh.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * <b>CounterProfilesMojo</b>: Goal <i>"counter-profiles"</i> counts the number of active profiles within your project and displays it on the console
 * @author m.boufatah
 *
 */
@Mojo(name = "counter-profiles" , defaultPhase = LifecyclePhase.COMPILE)
public class CounterProfilesMojo extends AbstractMojo {
	
	/** Maven Project injected automatically **/
	@Parameter(defaultValue = "${project}", required = true, readonly = true)
	MavenProject project;

	/**
	 * Execute Mojo
	 */
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("The project contains "  +  project.getActiveProfiles().size() + " active profiles");
	}

}
