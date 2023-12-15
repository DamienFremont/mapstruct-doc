/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct;

import com.damienfremont.mapstruct.parser.MapstructDocParser;
import com.damienfremont.mapstruct.file.CsvFileBuilder;
import com.damienfremont.mapstruct.model.MapperModel;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

import static com.damienfremont.mapstruct.MojoUtils.getClassLoader;
import static org.apache.maven.plugins.annotations.LifecyclePhase.INSTALL;

@Mojo(
        name = "generate",
        defaultPhase = INSTALL
//        requiresDependencyResolution = COMPILE_PLUS_RUNTIME
)
public class MapstructDocMojo extends AbstractMojo {

  // <configuration>
  @Parameter(defaultValue = "*")
  private String include;
  @Parameter(defaultValue = "${project.basedir}/target/mapstruct-doc/")
  private File outputDirectory;
  // </configuration>

  @Parameter(defaultValue = "${project}", required = true, readonly = true)
  private MavenProject project;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    try {
      Log logger = getLog();
      MapstructDocParser p = new MapstructDocParser();
      ClassLoader cl = getClassLoader(project, this, logger);

      Class<?> c0 = cl.loadClass(include); // TODO: dynamic

      for (MapperModel m : p.parse(c0)) {
        CsvFileBuilder.writeCsvFile(m, outputDirectory.toPath());
      }
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
