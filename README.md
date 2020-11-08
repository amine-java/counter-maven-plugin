# counter-maven-plugin

This plugin consists of 2 goals: 

> counter-profiles goal that will display the number of active profiles within your project. 
> counter-dependencies goal that will display the number of dependencies within your project.

If you'd like to use this plugin, here are the steps to follow: 

1- Download this project and then launch an mvn clean install 

2- In your favorite maven project, open the pom.xml and add the following: 



	<build>
		<plugins>
			<plugin>
				<groupId>com.mbh.plugin</groupId>
				<artifactId>counter-maven-plugin</artifactId>
				<version>0.0.1-SNAPSHOT</version>
				<executions>
					<execution>
						<goals>
							<goal>counter-profiles</goal>
							<goal>counter-dependencies</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<exludeGroupId>com.example</exludeGroupId>
				</configuration>
			</plugin>
		</plugins>
	</build>
  
The excludeGroupId is optional and can be ignored, this is used by the pluggin to ignore a specific group id in the counting dependencies process. 
  
3- Launch mvn compile and you should get messages regarding the number of dependencies within your project as well as the number of active profiles.
