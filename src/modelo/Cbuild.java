/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author zeus
 */
public class Cbuild {
    public static final char comilla = 34;
    public static String getBuildxml(String proyecto) {
        String s = "";
        s += "  <?xml version=" + modelo.Cbuild.comilla + "1.0" + modelo.Cbuild.comilla + "encoding=" + modelo.Cbuild.comilla + "UTF-8" + modelo.Cbuild.comilla + "?> \n";
        s += "<!-- You may freely edit this file. See commented blocks below for -->\n";
        s += "<!-- some examples of how to customize the build. -->\n";
        s += "<!-- (If you delete it and reopen the project it will be recreated.) -->\n";
        s += "<!-- By default, only the Clean and Build commands use this build script. -->\n";
        s += "<!-- Commands such as Run, Debug, and Test only use this build script if -->\n";
        s += "<!-- the Compile on Save feature is turned off for the project. -->\n";
        s += "<!-- You can turn off the Compile on Save (or Deploy on Save) setting -->\n";
        s += "<!-- in the project's Project Properties dialog box.-->\n";
        s += "<project name=" + modelo.Cbuild.comilla + proyecto + modelo.Cbuild.comilla + " "
                + "default=" + modelo.Cbuild.comilla + "default" + modelo.Cbuild.comilla + "basedir=" + modelo.Cbuild.comilla + "." + modelo.Cbuild.comilla + ">\n";
        s += "<description>Builds, tests, and runs the project GCursos.</description>\n";
        s += " <import file=" + modelo.Cbuild.comilla + "nbproject/build-impl.xml" + modelo.Cbuild.comilla + "/>\n";
        s += "<!--\n";

        s += "There exist several targets which are by default empty and which can be \n";
        s += "used for execution of your tasks. These targets are usually executed \n";
        s += " before and after some main targets. They are: \n";

        s += "-pre-init:                 called before initialization of project properties\n";
        s += "-post-init:                called after initialization of project properties\n";
        s += "-pre-compile:              called before javac compilation\n";
        s += "-post-compile:             called after javac compilation\n";
        s += "-pre-compile-single:       called before javac compilation of single file\n";
        s += "-post-compile-single:      called after javac compilation of single file\n";
        s += "-pre-compile-test:         called before javac compilation of JUnit tests\n";
        s += "-post-compile-test:        called after javac compilation of JUnit tests\n";
        s += "-pre-compile-test-single:  called before javac compilation of single JUnit test\n";
        s += "-post-compile-test-single: called after javac compilation of single JUunit test\n";
        s += "-pre-jar:                  called before JAR building\n";
        s += "-post-jar:                 called after JAR building\n";
        s += "-post-clean:               called after cleaning build products\n";

        s += "(Targets beginning with '-' are not intended to be called on their own.)\n";

        s += "Example of inserting an obfuscator after compilation could look like this:\n";

        s += "<target name=" + modelo.Cbuild.comilla + "-post-compile" + modelo.Cbuild.comilla + ">\n";
        s += " <obfuscate> \n";
        s += " <fileset dir=" + modelo.Cbuild.comilla + "${build.classes.dir}" + modelo.Cbuild.comilla + "/>\n";
        s += " </obfuscate>\n";
        s += "</target>\n";

        s += "For list of available properties check the imported \n";
        s += "nbproject/build-impl.xml file. \n";

        s += "Another way to customize the build is by overriding existing main targets.\n";
        s += "The targets of interest are: \n";

        s += "-init-macrodef-javac:     defines macro for javac compilation\n";
        s += "-init-macrodef-junit:     defines macro for junit execution\n";
        s += "-init-macrodef-debug:     defines macro for class debugging\n";
        s += "-init-macrodef-java:      defines macro for class execution\n";
        s += "-do-jar:                  JAR building\n";
        s += "run:                      execution of project \n";
        s += "-javadoc-build:           Javadoc generation\n";
        s += "test-report:              JUnit report generation\n";

        s += "An example of overriding the target for project execution could look like this:\n";

        s += "<target name=" + modelo.Cbuild.comilla + "run" + modelo.Cbuild.comilla + " depends=" + proyecto + modelo.Cbuild.comilla + "-impl.jar" + modelo.Cbuild.comilla + ">\n";
        s += "    <exec dir=" + modelo.Cbuild.comilla + "bin" + modelo.Cbuild.comilla + " executable=" + modelo.Cbuild.comilla + "launcher.exe" + modelo.Cbuild.comilla + ">\n";
        s += "         <arg file=" + modelo.Cbuild.comilla + "${dist.jar}" + modelo.Cbuild.comilla + "/>\n";
        s += "     </exec>\n";
        s += " </target>\n";

        s += "Notice that the overridden target depends on the jar target and not only on \n";
        s += "the compile target as the regular run target does. Again, for a list of available \n";
        s += "properties which you can use, check the target you are overriding in the\n";
        s += "nbproject/build-impl.xml file. \n";

        s += "-->\n";
        s += "</project>\n";

        return s;
    }

    public static String getManifest() {
        String s = "Manifest-Version: 1.0\n";
        s += "X-COMMENT: Main-Class will be added automatically by build\n";

        return s;

    }

    public static String getBuildimplemet(String proyecto) {
        String s = "";

        s = "";

        return s;

    }

    public static String getProject_properties(String proyecto) {
        String s = "annotation.processing.enabled=true\n";
        s += "annotation.processing.enabled.in.editor=false\n";
        s += "annotation.processing.processors.list=\n";
        s += "annotation.processing.run.all.processors=true\n";
        s += "annotation.processing.source.output=${build.generated.sources.dir}/ap-source-output\n";
        s += "application.title=GCursos\n";
        s += "application.vendor=adminj\n";
        s += "build.classes.dir=${build.dir}/classes\n";
        s += "build.classes.excludes=**/*.java,**/*.form\n";
        s += "# This directory is removed when the project is cleaned:\n";
        s += "build.dir=build\n";
        s += "build.generated.dir=${build.dir}/generated\n";
        s += "build.generated.sources.dir=${build.dir}/generated-sources\n";
        s += "# Only compile against the classpath explicitly listed here:\n";
        s += "build.sysclasspath=ignore\n";
        s += "build.test.classes.dir=${build.dir}/test/classes\n";
        s += "build.test.results.dir=${build.dir}/test/results\n";
        s += "# Uncomment to specify the preferred debugger connection transport:\n";
        s += "#debug.transport=dt_socket\n";
        s += "debug.classpath=\n";
        s += "    ${run.classpath}\n";
        s += "debug.test.classpath=\n";
        s += "    ${run.test.classpath}\n";
        s += "# Files in build.classes.dir which should be excluded from distribution jar\n";
        s += "dist.archive.excludes=\n";
        s += "# This directory is removed when the project is cleaned:\n";
        s += "dist.dir=dist\n";
        s += "dist.jar=${dist.dir}/GCursos.jar\n";
        s += "dist.javadoc.dir=${dist.dir}/javadoc\n";
        s += "endorsed.classpath=\n";
        s += "excludes=\n";
        s += "file.reference.derbyclient.jar=/media/zeus/PEN 32GB/NetBeansProjects/utilidades/lib/derbyclient.jar\n";
        s += "includes=**\n";
        s += "jar.compress=false\n";
        s += "javac.classpath=\n";
        s += "    ${file.reference.derbyclient.jar}\n";
        s += "# Space-separated list of extra javac options\n";
        s += "javac.compilerargs=\n";
        s += "javac.deprecation=false\n";
        s += "javac.processorpath=\n";
        s += "    ${javac.classpath}\n";
        s += "javac.source=1.8\n";
        s += "javac.target=1.8\n";
        s += "javac.test.classpath=\n";
        s += "    ${javac.classpath}:\n";
        s += "    ${build.classes.dir}\n";
        s += "javac.test.processorpath=\n";
        s += "    ${javac.test.classpath}\n";
        s += "javadoc.additionalparam=\n";
        s += "javadoc.author=false\n";
        s += "javadoc.encoding=${source.encoding}\n";
        s += "javadoc.noindex=false\n";
        s += "javadoc.nonavbar=false\n";
        s += "javadoc.notree=false\n";
        s += "javadoc.private=false\n";
        s += "javadoc.splitindex=true\n";
        s += "javadoc.use=true\n";
        s += "javadoc.version=false\n";
        s += "javadoc.windowtitle=\n";
        s += "main.class=gcursos.GCursos\n";
        s += "manifest.file=manifest.mf\n";
        s += "meta.inf.dir=${src.dir}/META-INF\n";
        s += "mkdist.disabled=false\n";
        s += "platform.active=default_platform\n";
        s += "run.classpath=\n";
        s += "    ${javac.classpath}:\n";
        s += "    ${build.classes.dir}\n";
        s += "# Space-separated list of JVM arguments used when running the project.\n";
        s += "# You may also define separate properties like run-sys-prop.name=value instead of -Dname=value.\n";
        s += "# To set system properties for unit tests define test-sys-prop.name=value:\n";
        s += "run.jvmargs=\n";
        s += "run.test.classpath=\n";
        s += "    ${javac.test.classpath}:\n";
        s += "    ${build.test.classes.dir}\n";
        s += "source.encoding=UTF-8\n";
        s += "src.dir=src\n";
        s += "test.src.dir=test\n";
        String c= proyecto.charAt(0)+"";
        c=c.toUpperCase();
        s = s.replaceAll("gcursos.GCursos", proyecto + "." + c + proyecto.substring(1, proyecto.length()));
        s = s.replaceAll("GCursos", proyecto);        
        return s;
    }

}
