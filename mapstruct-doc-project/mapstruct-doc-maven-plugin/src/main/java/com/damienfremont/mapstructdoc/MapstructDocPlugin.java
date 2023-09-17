package com.damienfremont.mapstructdoc;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import static org.apache.maven.plugins.annotations.LifecyclePhase.PACKAGE;
import static org.apache.maven.plugins.annotations.ResolutionScope.COMPILE;

@Mojo(name = "mapstruct-doc",
      defaultPhase = PACKAGE,
      requiresDependencyResolution = COMPILE,
      threadSafe = true)
public class MapstructDocPlugin extends AbstractMojo {

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    // TODO
  }
}
