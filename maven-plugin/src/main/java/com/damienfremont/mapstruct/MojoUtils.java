package com.damienfremont.mapstruct;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class MojoUtils {

  /**
   * https://stackoverflow.com/questions/49737706/access-project-classes-from-a-maven-plugin
   */
  public static ClassLoader getClassLoader(MavenProject project, AbstractMojo thiz, Log log) {
    try {
      List classpathElements = project.getCompileClasspathElements();
      classpathElements.add(project.getBuild().getOutputDirectory());
      classpathElements.add(project.getBuild().getTestOutputDirectory());
      URL urls[] = new URL[classpathElements.size()];
      for (int i = 0; i < classpathElements.size(); ++i) {
        urls[i] = new File((String) classpathElements.get(i)).toURL();
      }
      return new URLClassLoader(urls, thiz.getClass().getClassLoader());
    } catch (Exception e) {
      log.debug("Couldn't get the classloader.");
      return thiz.getClass().getClassLoader();
    }
  }
}
