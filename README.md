# counter-maven-plugin

This plugin consists of 2 goals: 

> counter-profiles goal that will display the number of active profiles within your project and counter-dependencies goal that will display the number of dependencies within your project.

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
					<excludeGroupId>com.example</excludeGroupId>
				</configuration>
			</plugin>
		</plugins>
	</build>
  
The excludeGroupId is optional and can be ignored, this is used by the plugin to ignore a specific group-id in the counting-dependencies process. 
  
3- Launch mvn compile and you should get messages regarding the number of dependencies within your project as well as the number of active profiles.

Both goals are bound to the compile phase by default, however, it's possible to change that by defining a phase in the execution element present in the pom.xml. We can also bind one goal to a phase and the other to another one, here's an example: 



	<build>
		<plugins>
			<plugin>
				<groupId>com.mbh.plugin</groupId>
				<artifactId>counter-maven-plugin</artifactId>
				<version>0.0.1-SNAPSHOT</version>
				<executions>
					<execution>
						<id>execution-counter-profiles</id>
						<phase>test</phase>
						<goals>
							<goal>counter-profiles</goal>
						</goals>
					</execution>
					<execution>
						<id>execution-counter-dependencies</id>
						<phase>compile</phase>
						<goals>
							<goal>counter-dependencies</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<excludeGroupId>fr.mbh</excludeGroupId>
				</configuration>
			</plugin>
		</plugins>
	</build>
