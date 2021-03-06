/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jdk11.encoding.issue;

import java.nio.charset.Charset;

public class App {
    public static final String FILE_ENCODING_PROPERTY = "file.encoding";
    public static final String SUN_STDOUT_ENCODING_PROPERTY = "sun.stdout.encoding";
    public static final String SUN_STDERR_ENCODING_PROPERTY = "sun.stderr.encoding";
    public static final String SUN_JNU_ENCODING_PROPERTY = "sun.jnu.encoding";

    public static void main(String[] args) {
        System.out.println(String.format("defaultCharacterEncoding=%s", Charset.defaultCharset()));
        System.out.println(String.format("%s=%s", FILE_ENCODING_PROPERTY, System.getProperty(FILE_ENCODING_PROPERTY)));
        System.out.println(String.format("%s=%s", SUN_JNU_ENCODING_PROPERTY, System.getProperty(SUN_JNU_ENCODING_PROPERTY)));
        System.out.println(String.format("%s=%s", SUN_STDOUT_ENCODING_PROPERTY, System.getProperty(SUN_STDOUT_ENCODING_PROPERTY)));
        System.out.println(String.format("%s=%s", SUN_STDERR_ENCODING_PROPERTY, System.getProperty(SUN_STDERR_ENCODING_PROPERTY)));
        System.out.println("HäHö");
    }
}
